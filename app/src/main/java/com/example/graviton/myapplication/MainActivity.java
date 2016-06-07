package com.example.graviton.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements Runnable{
    public Button signUp;
    public Button adminLogin;
    public Button login;
    public EditText userName;
    public EditText passWord;
    public RelativeLayout parent;
    public void idFinder(){
        signUp = (Button)findViewById(R.id.sighUp);
        login = (Button)findViewById(R.id.login);
        userName = (EditText)findViewById(R.id.username);
        passWord = (EditText)findViewById(R.id.password);
        parent = (RelativeLayout)findViewById(R.id.parent);
        adminLogin = (Button)findViewById(R.id.adminLogin);
    }
    public void onClicker(){
        signUp.setOnClickListener(signClick);
        login.setOnClickListener(logClick);
        adminLogin.setOnClickListener(adminlog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idFinder();
        onClicker();
    }

    public View.OnClickListener adminlog = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String username = userName.getText().toString();
            String password = passWord.getText().toString();
            String method = "admin_login";
            SignUpBackground signUpBackground = new SignUpBackground(MainActivity.this);
            signUpBackground.execute(method,username,password);
            Thread t = new Thread(MainActivity.this);
            t.start();
            try {
                t.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(signUpBackground.adminLog.equals("yes")){
                Intent intent = new Intent(MainActivity.this,TeacherOption.class);
                startActivity(intent);
            }
        }
    };

    public View.OnClickListener signClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,SignUp.class);
            startActivity(intent);
        }
    };
    public View.OnClickListener logClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String username = userName.getText().toString();
            String password = passWord.getText().toString();
            String method = "login";
            SignUpBackground signUpBackground = new SignUpBackground(MainActivity.this);
            signUpBackground.execute(method,username,password);
            Thread t= new Thread(MainActivity.this);
            t.start();
            try {
                t.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(signUpBackground.studentLog.equals("yes")){
                Intent intent = new Intent(MainActivity.this,StudentOption.class);
                startActivity(intent);
            }
        }
    };

    public void run(){

    }
}
