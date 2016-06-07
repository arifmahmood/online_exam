package com.example.graviton.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SubjectForTeachers extends AppCompatActivity {
    public Button physics,chemistry,math;
    public static String subject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_for_teachers);
        initalize();
        onClicker();
    }

    public void initalize(){
        physics = (Button)findViewById(R.id.teacherPhysics);
        chemistry = (Button)findViewById(R.id.teacherChemistry);
        math = (Button)findViewById(R.id.teacherMath);
    }
    public void onClicker(){
        physics.setOnClickListener(physicsClick);
        chemistry.setOnClickListener(chemistryClick);
        math.setOnClickListener(mathClick);
    }

    View.OnClickListener physicsClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            subject = "physics";
            Intent intent = new Intent(SubjectForTeachers.this,ExamDetailSet.class);
            startActivity(intent);
        }
    };
    View.OnClickListener mathClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            subject = "math";
            Intent intent = new Intent(SubjectForTeachers.this,ExamDetailSet.class);
            startActivity(intent);
        }
    };
    View.OnClickListener chemistryClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            subject = "chemistry";
            Intent intent = new Intent(SubjectForTeachers.this,ExamDetailSet.class);
            startActivity(intent);
        }
    };
}
