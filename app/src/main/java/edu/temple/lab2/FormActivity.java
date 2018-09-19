package edu.temple.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity {

    EditText textName;
    EditText textEmail;
    EditText textPassword;
    EditText textPasswordConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        setTitle("SignUpForm");

        textName = findViewById(R.id.textName);
        textEmail = findViewById(R.id.textEmail);
        textPassword = findViewById(R.id.textPassword);
        textPasswordConfirm = findViewById(R.id.textPasswordConfirm);

    }
}
