package com.loudknees.squpper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import java.util.Random;


public class SqupperActivity extends Activity {

    int counter;
    int pushupTotal;
    int squatTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squpper);

        counter = 0;    //maybe change it so that it doesn't always start with even = push-ups
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

    /**
     * Creates a random number from 1 - 13 inclusive
     * @return random number as type String
     * Adds number to running total for each exercise
     */
    public String getNumber(){
        String stringReturnNumber;
        Random rand = new Random();
        int randomIndex = (rand.nextInt(13)) + 1;

        subTotal(randomIndex);

        stringReturnNumber = Integer.toString(randomIndex);
        return stringReturnNumber;
    }

    /**
     * calls getNumber to get random number
     * displays random number in TextView "textViewReps"
     */
    public void setReps(){
        TextView reps = (TextView) findViewById(R.id.textViewReps);
        reps.setText(getNumber());
    }

    /**
     * Change the name of the exercise in an alternating fashion
     * When counter is even, exercise name will be displayed in TextView as "push-up"
     * When counter is odd, exercise name will be displayed in TextView as "Squat"
     */
    public void setExercise(){
        TextView exerciseNames = (TextView)findViewById(R.id.textViewExerciseName);
        if(counter % 2 == 0) {
            exerciseNames.setText(R.string.exercise_name_pushup);
        }else{
            exerciseNames.setText(R.string.exercise_name_squat);
        }
        counter++;
    }

    public void subTotal(int i){
        if(counter % 2 == 0){
            pushupTotal = pushupTotal + i;
        } else {
            squatTotal = squatTotal + i;
        }
    }

    /**
     * Method initiated by button press from Button "nextButton"
     * calls two methods "setReps()" and "setExercise()"
     * changes two TextViews each time
     * @param view
     */
    public void nextSet(View view){
        setReps();
        setExercise();
        //maybe create limit on how high counter can go
    }

    public void finish(View view){
        Intent intent = new Intent(this, ResultsActivity.class);
        startActivity(intent);
    }

}
