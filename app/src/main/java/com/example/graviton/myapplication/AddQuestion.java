package com.example.graviton.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddQuestion extends AppCompatActivity {
    EditText question,optionA,optionB,optionC,optionD,correcOption;
    Button addQuestion,resetQuestion;
    int qCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);
        initialize();
        onClicker();
    }

    public void initialize(){
        resetQuestion = (Button)findViewById(R.id.resetQuestion);
        addQuestion = (Button)findViewById(R.id.addQue);
        question = (EditText)findViewById(R.id.question);
        optionA = (EditText)findViewById(R.id.optionA);
        optionB = (EditText)findViewById(R.id.optionB);
        optionC = (EditText)findViewById(R.id.optionC);
        optionD = (EditText)findViewById(R.id.optionD);
        correcOption = (EditText)findViewById(R.id.correctAns);
    }

    public void onClicker(){
        addQuestion.setOnClickListener(add);
        resetQuestion.setOnClickListener(reset);
    }

    View.OnClickListener add = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String ques = question.getText().toString();
            String a = optionA.getText().toString();
            String b = optionB.getText().toString();
            String c = optionC.getText().toString();
            String d = optionD.getText().toString();
            String correct = correcOption.getText().toString();
            String teacher = SignUpBackground.teacherName;
            String subject = SubjectForTeachers.subject;
            String method = "add_question";
            String exam = ExamDetailSet.nameOfExam;
            SignUpBackground signUpBackground = new SignUpBackground(AddQuestion.this);
            signUpBackground.execute(method,subject,teacher,exam,ques,a,b,c,d,correct);
            question.setText("");
            optionD.setText("");
            optionB.setText("");
            optionC.setText("");
            optionA.setText("");
            correcOption.setText("");
            qCount++;
        }
    };

    View.OnClickListener reset = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            question.setText("");
            optionD.setText("");
            optionB.setText("");
            optionC.setText("");
            optionA.setText("");
            correcOption.setText("");
        }
    };
}
