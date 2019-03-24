package com.example.hackathon;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final TextView login = findViewById(R.id.textView);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(SignUpActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        final Button signUp = findViewById(R.id.login);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username = findViewById(R.id.user_name);
                EditText password = findViewById(R.id.user_password);
                EditText email = findViewById(R.id.user_email);
                EditText passC = findViewById(R.id.user_Cpassword);
                String tempUsername = username.getText().toString();
                String tempPassword = password.getText().toString();
                String tempEmail = email.getText().toString();
                String tempPassC = passC.getText().toString();
                if(tempPassword.equals("") || tempUsername.equals("") || tempEmail.equals("") || tempPassC.equals("")){
                    Context context = getApplicationContext();
                    CharSequence text = "Invalid input please try again";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else if(!UserManager.emailAvailable(tempEmail)){
                    Context context = getApplicationContext();
                    CharSequence text = "Email already taken";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else if(!UserManager.usernameAvailable(tempUsername)){
                    Context context = getApplicationContext();
                    CharSequence text = "Username already taken";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    UserManager.addUserAccount(new User(tempUsername, tempPassword, tempEmail));
                    Context context = getApplicationContext();
                    CharSequence text = "Account successfully created";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    Intent intent = new Intent(SignUpActivity.this, MapsActivity2.class);
                    startActivity(intent);
                }

            }
        });
    }



}
