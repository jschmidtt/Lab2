package edu.temple.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    EditText textName;
    EditText textEmail;
    EditText textPassword;
    EditText textPasswordConfirm;
    Button buttonSave;

    final private int REQUEST_CODE_NAME_DISPLAY = 934;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        setTitle("SignUpForm");

        //SetupFindViews
        textName = findViewById(R.id.textName);
        textEmail = findViewById(R.id.textEmail);
        textPassword = findViewById(R.id.textPassword);
        textPasswordConfirm = findViewById(R.id.textPasswordConfirm);
        buttonSave = findViewById(R.id.buttonSave);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean start = true;

                String name, email, password, passwordConfirm;

                //get the strings from the textEdits
                name = textName.getText().toString();
                email =  textEmail.getText().toString();
                password = textPassword.getText().toString();
                passwordConfirm = textPasswordConfirm.getText().toString();

                //check to see if any fields are empty
                if (name.isEmpty() || email.isEmpty() || password.isEmpty() || passwordConfirm.isEmpty()) {
                    Toast empty = Toast.makeText(getApplicationContext(), "All fields must be entered.", Toast.LENGTH_LONG);
                    empty.show();
                    start = false;
                }
                //Check to see if the passwords match or not
                if (!password.equals(passwordConfirm) || !passwordConfirm.equals(password)) {
                    Toast passwordMismatch = Toast.makeText(getApplicationContext(), "Passwords do not match!", Toast.LENGTH_LONG);
                    passwordMismatch.show();
                    start = false;
                }

                //Launch DisplayActivity if all good
                if (start){
                    //Make Intent
                    Intent startActivityIntent = new Intent(FormActivity.this, DisplayActivity.class);
                    //Send name with this start
                    startActivityIntent.putExtra(DisplayActivity.DATA_KEY, name);
                    startActivity(startActivityIntent);
                }

            }
        });
    }
}
