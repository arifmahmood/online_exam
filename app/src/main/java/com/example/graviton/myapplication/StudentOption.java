package com.example.graviton.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentOption extends AppCompatActivity {
    Button availableExam,record;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_option);
        initialize();
        onClicker();
    }

    public void initialize(){
        record = (Button)findViewById(R.id.studentStatistics);
        availableExam = (Button)findViewById(R.id.availableExam);
    }

    public void onClicker(){
        record.setOnClickListener(studentStatistic);
        availableExam.setOnClickListener(available);
    }

    View.OnClickListener studentStatistic = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            record.setText("Clicked");
        }
    };

    View.OnClickListener available = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(StudentOption.this,SubjectChoiceStudent.class);
            startActivity(intent);
        }
    };
}
