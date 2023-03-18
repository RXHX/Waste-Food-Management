package com.example.foodwaste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        databaseHelper=new DatabaseHelper(this);
        EditText username=findViewById(R.id.edTxtUserName);
        EditText password=findViewById(R.id.edTxtPassword);
        Button btnLogin=findViewById(R.id.btnLogin);
        Button btnForgot=findViewById(R.id.btnForgot);
        Button btnSignCust=findViewById(R.id.btnSignCust);
        Button btnSignManager=findViewById(R.id.btnSignManager);

        btnSignCust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,CustomerRegistration.class));
            }
        });
        btnSignManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,ManagerRegistration.class));
            }
        });


    }
}