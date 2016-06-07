package com.example.graviton.myapplication;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONObject;

public class AvailableExamList extends AppCompatActivity implements Runnable{
    String jsonData;
    AlertDialog alertDialog;
    public static String teacher_name,exam_name;
    Button exam1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_exam_list);
        String method = "text";
        SignUpBackground signUpBackground = new SignUpBackground(AvailableExamList.this);
        signUpBackground.execute(method);
        Thread t = new Thread(AvailableExamList.this);
        t.start();
        try {
            t.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jsonData = SignUpBackground.requestedString;
        //initialize(jsonData);
        String name = "";
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                name = name+jsonObject.getString("name");
            }
        }catch (Exception e){

        }
        initialize(name);
        onCliker();
    }
    public void initialize(String data){
        exam1 = (Button)findViewById(R.id.exam1);
        alertDialog = new AlertDialog.Builder(AvailableExamList.this).create();
        alertDialog.setTitle("Json Data");
        alertDialog.setMessage(data);
        alertDialog.show();
    }

    public void onCliker(){
        exam1.setOnClickListener(e1);
    }

    View.OnClickListener e1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(AvailableExamList.this,Questions.class);
            startActivity(intent);
        }
    };
    public void run(){

    }
}
