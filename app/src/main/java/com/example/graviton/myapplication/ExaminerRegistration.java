package com.example.graviton.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class ExaminerRegistration extends AppCompatActivity implements Runnable{
    public EditText adminFullName,adminUsername,adminPassword,adminEmail,adminPin;
    public Button adminCreate,adminReset,adminHomeFromReg;
    RelativeLayout adminRegParent;
    public String uName,uPass,uEmail,uFullName,pin;

    void initialize(){
        adminCreate = (Button)findViewById(R.id.adminCreateAccount);
        adminReset = (Button)findViewById(R.id.adminReset);
        adminHomeFromReg = (Button)findViewById(R.id.adminHomeFromReg);
        adminFullName = (EditText)findViewById(R.id.adminFullName);
        adminUsername = (EditText)findViewById(R.id.adminUsername);
        adminPassword = (EditText)findViewById(R.id.adminUsername);
        adminEmail = (EditText)findViewById(R.id.adminEmail);
        adminPin = (EditText)findViewById(R.id.adminPin);
        adminRegParent = (RelativeLayout)findViewById(R.id.adminRegParent);
    }

    void clickEvents(){
        adminCreate.setOnClickListener(createAdmin);
        adminHomeFromReg.setOnClickListener(goHome);
        adminReset.setOnClickListener(resetAdmin);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examiner_registration);
        initialize();
        clickEvents();
    }

    public View.OnClickListener createAdmin = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            uName = adminUsername.getText().toString();
            uPass = adminPassword.getText().toString();
            uFullName = adminFullName.getText().toString();
            uEmail = adminEmail.getText().toString();
            pin = adminPin.getText().toString();
            String method = "admin_register";
            SignUpBackground signUpBackground = new SignUpBackground(ExaminerRegistration.this);
            signUpBackground.execute(method,uName,uPass,uFullName,uEmail,pin);
        }
    };

    public View.OnClickListener goHome = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(ExaminerRegistration.this,MainActivity.class);
            startActivity(intent);
        }
    };

    public View.OnClickListener resetAdmin = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            adminFullName.setText("");
            adminPassword.setText("");
            adminUsername.setText("");
            adminEmail.setText("");
            adminPin.setText("");
        }
    };

    public void run(){

    }
}
