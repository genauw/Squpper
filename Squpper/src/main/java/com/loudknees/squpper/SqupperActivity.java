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
    int currentNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squpper);

        counter = 0;    //maybe change it so that it doesn't always start with even = push-ups
        pushupTotal = 0;
        squatTotal = 0;

        getNumber();
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
     * Sets "currentNumber" variable to the number
     */
    public void getNumber(){
        Random rand = new Random();
        currentNumber = (rand.nextInt(13)) + 1;
    }

    /**
     * calls getNumber to get random number
     * displays random number in TextView "textViewReps"
     */
    public void setReps(){
        String currentNumberString = Integer.toString(currentNumber);
        TextView reps = (TextView) findViewById(R.id.textViewReps);
        reps.setText(currentNumberString);
    }

    /**
     * Change the name of the exercise in an alternating fashion
     * When counter is even, exercise name will be displayed in TextView as "push-up"
     * When counter is odd, exercise name will be displayed in TextView as "Squat"
     */
    public void setExercise(){
        TextView exerciseNames = (TextView)findViewById(R.id.textViewExerciseName);
        if(exerciseChecker()) {
            exerciseNames.setText(R.string.exercise_name_pushup);
        }else{
            exerciseNames.setText(R.string.exercise_name_squat);
        }
        counter++;
    }

    /**
     * calculates subtotal for the current exercise
     */
    public void subTotal(){
        if(exerciseChecker()){
            pushupTotal = pushupTotal + currentNumber;
        } else {
            squatTotal = squatTotal + currentNumber;
        }
    }

    /**
     * uses counter variable to check which current exercise
     * if even, exercise is push-ups
     * if odd, squats
     * @return
     */
    public boolean exerciseChecker(){
        if (counter % 2 == 0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Method initiated by button press from Button "nextButton"
     * Calculates subtotal for correct exercise if exercise has been "completed"
     * Gets new random number for next exercise
     * changes the two TextViews for next set
     * @param view
     */
    public void nextSet(View view){
        subTotal();
        getNumber();
        setReps();
        setExercise();
        //maybe create limit on how high counter can go
    }

    /**
     * When user is finished this button is pressed to show results of session on ResultsActivity
     * Carries forward subtotals
     * @param view
     */
    public void finish(View view){
        Intent intent = new Intent(this, ResultsActivity.class);
        startActivity(intent);
        //Need to send the two subtotals with intent to display results.
    }

}
