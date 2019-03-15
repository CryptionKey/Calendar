package com.example.recyclerview.View;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.recyclerview.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calendrier(View view){

        //Create an Intent to start the second activity
        Intent randomIntent = new Intent(this, SecondActivity.class);

        //Start the new activity
        startActivity(randomIntent);
    }

    @SuppressLint("SetTextI18n")
    public void chabbat(View view){
        //Get the Text view
        /***  TextView showCountTextView = findViewById(R.id.textView);

         //Get the value of the text view
         String countString = showCountTextView.getText().toString();

         //Convert value to a number and increment it
         int count = Integer.parseInt(countString);
         count++;

         //Display the value in the text view
         showCountTextView.setText(Integer.toString(count));**/
        Toast myToast = Toast.makeText(this, "Hello Count",Toast.LENGTH_SHORT);
        myToast.show();
    }


    public void createur(View view){
        Toast mon_nom = Toast.makeText(this, "Daniel Elgrably",Toast.LENGTH_SHORT);
        mon_nom.show();
    }
}
