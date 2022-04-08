package com.kr.otpver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class verifyenterotptwo extends AppCompatActivity {

    EditText inputnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifyenterotptwo);
        Button verifyButton = findViewById(R.id.buttongetotp);
        inputnumber = findViewById(R.id.textmobile);

        verifyButton.setOnClickListener(v -> {
            if (inputnumber.getText().toString().trim().equalsIgnoreCase("6354")){
                Toast.makeText(verifyenterotptwo.this, "OTP Verified! Welcome!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),mainhub.class);
                startActivity(intent);
            }
            else if (!inputnumber.getText().toString().trim().isEmpty() && !inputnumber.getText().toString().trim().equalsIgnoreCase("9999")){
                Toast.makeText(verifyenterotptwo.this, "OTP Failed! Please try again!", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(verifyenterotptwo.this, "please enter the OTP", Toast.LENGTH_SHORT).show();
            }
        });


    }
}