package com.loudknees.squpper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class ResultsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent intent = getIntent();
        String pushupMessage = intent.getStringExtra(SqupperActivity.PUSHUP_MESSAGE);
        String squatMessage = intent.getStringExtra(SqupperActivity.SQUAT_MESSAGE);
        TextView pushups = (TextView) findViewById(R.id.pushup_result);
        TextView squats = (TextView) findViewById(R.id.squat_result);
        squats.setText(squatMessage);
        pushups.setText(pushupMessage);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.results, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void restart(View view){
        Intent intent = new Intent(this, SqupperActivity.class);
        startActivity(intent);
    }

}
