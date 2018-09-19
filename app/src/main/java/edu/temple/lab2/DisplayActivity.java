package edu.temple.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    final static public String DATA_KEY = "data_key";
    TextView textViewName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        setTitle("Display Form");

        //Grab the intent that started this and get info with it
        Intent intent = getIntent();
        String name = intent.getStringExtra(DATA_KEY);
        //Check for empty name but should not happen since this activity
        //Will not launch without a name entered in FormActivity
        if(name.isEmpty()){
            name = "Default";
        }

        //Set up and display welcome message
        textViewName = findViewById(R.id.textViewName);
        textViewName.setText("Welcome, " + name + " to the SignUpForm app!");
    }
}
