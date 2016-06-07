package com.example.graviton.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SubjectChoiceStudent extends AppCompatActivity {
    Button physics,chemistry,math;
    public static String subjectStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_choice_student);
        initialize();
        onClicker();
    }
    public void initialize(){
        physics = (Button)findViewById(R.id.physicsForStudent);
        chemistry = (Button)findViewById(R.id.chemistryForStudent);
        math = (Button)findViewById(R.id.mathForStudent);
    }

    public void onClicker(){
        physics.setOnClickListener(pClick);
        math.setOnClickListener(mClick);
        chemistry.setOnClickListener(cClick);
    }

    View.OnClickListener pClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            subjectStudent = "physics";
            Intent intent = new Intent(SubjectChoiceStudent.this,AvailableExamList.class);
            startActivity(intent);
        }
    };
    View.OnClickListener cClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            subjectStudent = "chemistry";
            Intent intent = new Intent(SubjectChoiceStudent.this,AvailableExamList.class);
            startActivity(intent);
        }
    };
    View.OnClickListener mClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            subjectStudent = "math";
            Intent intent = new Intent(SubjectChoiceStudent.this,AvailableExamList.class);
            startActivity(intent);
        }
    };
}
