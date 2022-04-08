package com.kr.otpver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class entermobilenumberone extends AppCompatActivity {
    EditText enternumber;
    Button getotpbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entermobilenumberone);

        enternumber = findViewById(R.id.input_mobile_number);
        getotpbutton = findViewById(R.id.buttongetotp);

        getotpbutton.setOnClickListener(v -> {
            if (!enternumber.getText().toString().trim().isEmpty()){
                if ((enternumber.getText().toString().trim()).length()==10){
                    Intent intent = new Intent(getApplicationContext(),verifyenterotptwo.class);
                    intent.putExtra("mobile", enternumber.getText().toString());
                    startActivity(intent);
                }else{
                    Toast.makeText(entermobilenumberone.this,"Please enter a valid Phone Number", Toast.LENGTH_LONG).show();
                }
            }else{
                Toast.makeText(entermobilenumberone.this, "Phone Number cannot be blank!", Toast.LENGTH_LONG).show();
            }
        });
    }
}