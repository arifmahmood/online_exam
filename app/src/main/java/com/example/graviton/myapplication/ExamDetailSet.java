package com.example.graviton.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ExamDetailSet extends AppCompatActivity implements Runnable{
    public EditText examName,numOfQuestions,setTime;
    public Button examGenerator,refresh;
    public static String  nameOfExam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_detail_set);
        initializer();
        onClicker();
    }

    public void initializer(){
        examName = (EditText)findViewById(R.id.setExamName);
        numOfQuestions = (EditText)findViewById(R.id.setNumOfQuestions);
        setTime = (EditText)findViewById(R.id.setTime);
        examGenerator = (Button)findViewById(R.id.setExam);
        refresh = (Button)findViewById(R.id.resetExam);
    }

    public void onClicker(){
        examGenerator.setOnClickListener(generate);
        refresh.setOnClickListener(fresh);
    }

    View.OnClickListener generate = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String name = examName.getText().toString();
            String num_of_question = numOfQuestions.getText().toString();
            String time = setTime.getText().toString();
            String method = "examDetailSet";
            String subject = SubjectForTeachers.subject;
            String teacherName = SignUpBackground.teacherName;
            SignUpBackground signUpBackground = new SignUpBackground(ExamDetailSet.this);
            signUpBackground.execute(method,subject,teacherName,name,num_of_question,time);
            nameOfExam = name;
            Thread t = new Thread(ExamDetailSet.this);
            t.start();
            try {
                t.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(SignUpBackground.isExam.equals("yes")) {
                Intent intent = new Intent(ExamDetailSet.this,AddQuestion.class);
                startActivity(intent);
            }
        }
    };

    View.OnClickListener fresh = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            examName.setText("");
            numOfQuestions.setText("");
            setTime.setText("");
        }
    };

    public void run(){

    }
}
