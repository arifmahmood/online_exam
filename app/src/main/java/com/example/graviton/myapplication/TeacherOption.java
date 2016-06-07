package com.example.graviton.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TeacherOption extends AppCompatActivity {
    Button logout,generateExam,viewState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_option);
        initializer();
        onClicker();
    }

    public void initializer(){
        logout = (Button)findViewById(R.id.logout);
        generateExam = (Button)findViewById(R.id.generatExam);
        viewState = (Button)findViewById(R.id.viewStat);
    }

    public void onClicker(){
        logout.setOnClickListener(adminLogout);
        generateExam.setOnClickListener(exam);
        viewState.setOnClickListener(adminViewStat);
    }

    View.OnClickListener adminLogout = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //logout.setText(MainActivity.teacherName);
        }
    };

    View.OnClickListener exam = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(TeacherOption.this,SubjectForTeachers.class);
            startActivity(intent);
        }
    };
    View.OnClickListener adminViewStat = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(TeacherOption.this,MainActivity.class);
            startActivity(intent);
        }
    };


}
