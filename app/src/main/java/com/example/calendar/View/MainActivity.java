package com.example.calendar.View;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.calendar.R;

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

        Animatoo.animateDiagonal(this);
    }


    @SuppressLint("SetTextI18n")
    public void chabbat(View view){
        //Create an Intent to start the second activity
        Intent randomIntent = new Intent(this, ThirdActivity.class);

        //Start the new activity
        startActivity(randomIntent);

        Animatoo.animateDiagonal(this);
    }


    public void createur(View view){
        Toast mon_nom = Toast.makeText(this, "Daniel Elgrably",Toast.LENGTH_SHORT);
        mon_nom.show();

    }
}
