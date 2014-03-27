package com.loudknees.squpper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


public class SqupperActivity extends Activity {

    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squpper);

        //get information sent with initial intent
        //Intent intent = getIntent();

        setReps();
        setExercise();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.squpper, menu);
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

    public String getNumber(){
        String stringReturnNumber;

        //int[] list = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        Random rand = new Random();
        int randomIndex = (rand.nextInt(13)) + 1;
        stringReturnNumber = Integer.toString(randomIndex);

        return stringReturnNumber;
    }

    public void setReps(){
        TextView reps = (TextView) findViewById(R.id.textViewReps);
        reps.setText(getNumber());
    }

    public void setExercise(){
        TextView exerciseNames = (TextView)findViewById(R.id.textViewExerciseName);
        exerciseNames.setText(R.string.exercise_name_squat);
    }

    public void changeExercise(){
        TextView exerciseNames = (TextView)findViewById(R.id.textViewExerciseName);
        if(counter % 2 ==0) {
            exerciseNames.setText(R.string.exercise_name_pushup);
        }else{
            exerciseNames.setText(R.string.exercise_name_squat);
        }
        counter++;
    }

    public void nextSet(View view){
        setReps();
        changeExercise();
    }

}
