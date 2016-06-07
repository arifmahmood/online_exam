package com.example.graviton.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Questions extends AppCompatActivity implements Runnable{
    String [] question = new String[100];
    String [] optionA = new String[100];
    String [] optionB = new String[100];
    String [] optionC = new String[100];
    String [] optionD = new String[100];
    String [] correct = new String[100];
    String teache,exam,subject,server_data;
    TextView qtn;
    Button a,b,c,d;
    int count = 0;
    int number = 0;
    AlertDialog alertDialog;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        initialize();
        server_data = SignUpBackground.requestedString;
        alertDialog = new AlertDialog.Builder(Questions.this).create();
        alertDialog.setTitle("From question");
        alertDialog.setMessage(server_data);
        alertDialog.show();
        onClicker();
    }

    public void initialize(){
        a = (Button)findViewById(R.id.ansA);
        b = (Button)findViewById(R.id.ansB);
        c = (Button)findViewById(R.id.ansC);
        d = (Button)findViewById(R.id.ansD);
        qtn = (TextView)findViewById(R.id.ansSheet);
        subject = SubjectChoiceStudent.subjectStudent;
        teache = "moon";
        exam = "first";
        String method = "fetch_question";
        SignUpBackground signUpBackground = new SignUpBackground(Questions.this);
        signUpBackground.execute(method,subject,teache,exam);
        Thread thread = new Thread(Questions.this);
        thread.start();
        try{
            thread.sleep(4000);
        }
        catch (Exception e){

        }

    }
    public void onClicker(){
        a.setOnClickListener(answera);
        b.setOnClickListener(answerb);
        c.setOnClickListener(answerc);
        d.setOnClickListener(answerd);
    }
    View.OnClickListener answera = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
    View.OnClickListener answerb = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
    View.OnClickListener answerc = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
    View.OnClickListener answerd = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    public void run(){

    }
}
