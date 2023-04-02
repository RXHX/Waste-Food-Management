package com.example.foodwaste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CustomerRegistration extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_registration);
        databaseHelper=new DatabaseHelper(this);
        Button btnSubmit=findViewById(R.id.btnSubmit);
        EditText uName=findViewById(R.id.edTxtUserNameManager);
        EditText pass=findViewById(R.id.edTxtPasswordManager);
        EditText fullName=findViewById(R.id.edTxtFullNameManager);
        EditText date=findViewById(R.id.edTxtRestaurantName);
        EditText phoneNum = findViewById(R.id.editTextPhone);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            boolean isInserted,isInsertedProfile;
            @Override
            public void onClick(View view) {
                isInserted = databaseHelper.addDataCustomerReg(uName.getText().toString(),
                        pass.getText().toString(),
                        fullName.getText().toString(),
                        date.getText().toString(),
                        phoneNum.getText().toString()
                        );

                isInsertedProfile = databaseHelper.addDataProfile(uName.getText().toString());

                if(isInserted){
                    Toast.makeText(CustomerRegistration.this,"data added",Toast.LENGTH_LONG).show();
                    databaseHelper.addLogin(uName.getText().toString(),
                            pass.getText().toString(),"Customer");
                    uName.setText("");
                    pass.setText("");
                    fullName.setText("");
                    date.setText("");
                    phoneNum.setText("");

                    startActivity(new Intent(CustomerRegistration.this,Login.class));


                }
                else{
                    Toast.makeText(CustomerRegistration.this,"data not added",Toast.LENGTH_LONG).show();
                }
            }
        });





    }
}