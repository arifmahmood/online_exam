package com.example.graviton.myapplication;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class SignUp extends AppCompatActivity {
    public Button homeFromReg;
    public Button reset;
    public Button createAccount;
    public Button adminSignUp;
    public EditText regUsername;
    public EditText regPassword;
    public EditText email;
    public EditText fullName;
    public RelativeLayout regParent;
    public String uName,uPass,uEmail,uFullName;
    private void initialize(){
        homeFromReg = (Button)findViewById(R.id.homeFromReg);
        reset = (Button)findViewById(R.id.reset);
        createAccount = (Button)findViewById(R.id.adminCreateAccount);
        adminSignUp = (Button)findViewById(R.id.adminSignUp);
        regPassword = (EditText)findViewById(R.id.adminPassword);
        regUsername = (EditText)findViewById(R.id.adminUsername);
        email = (EditText)findViewById(R.id.adminEmail);
        fullName = (EditText)findViewById(R.id.adminFullName);
        regParent = (RelativeLayout)findViewById(R.id.regParent);
    }

    private void clickEvent(){
        homeFromReg.setOnClickListener(goHome);
        reset.setOnClickListener(resetAll);
        createAccount.setOnClickListener(submitreg);
        adminSignUp.setOnClickListener(adminwork);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initialize();
        clickEvent();
    }

    public View.OnClickListener goHome = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(SignUp.this, MainActivity.class);
            startActivity(intent);
        }
    };

    public View.OnClickListener resetAll = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            regPassword.setText("");
            regUsername.setText("");
            email.setText("");
            fullName.setText("");
        }
    };

    public View.OnClickListener submitreg = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            uName = regUsername.getText().toString();
            uPass = regPassword.getText().toString();
            uFullName = fullName.getText().toString();
            uEmail = email.getText().toString();
            String method = "register";
            SignUpBackground signUpBackground = new SignUpBackground(SignUp.this);
            signUpBackground.execute(method,uName,uPass,uFullName,uEmail);
        }
    };

    public View.OnClickListener adminwork = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(SignUp.this,ExaminerRegistration.class);
            startActivity(intent);
        }
    };
}
