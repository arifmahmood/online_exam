package com.example.graviton.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;


public class SignUpBackground extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;
    public String studentReg = "no";
    public String studentLog = "no";
    public String adminLog = "no";
    public String adminReg = "no";
    public static String studentName,teacherName;
    public static String currentCreatingExam;
    public static String isExam = "no";
    public static String requestedString = "";


    SignUpBackground(Context context){
        this.context = context;
    }
    @Override

    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");
    }
    @Override
    protected String doInBackground(String... params) {
        String method = params[0];
        if(method.equals("fetch_question")){
            if(true) return "here";
            alertDialog.setTitle("Fetch");

            String subject = params[1];
            String teacher = params[2];
            String exam = params[3];
            String json_url = "http://hsconlineexam.netau.net/fetch_question.php";
            try{
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data = URLEncoder.encode("subject","UTF-8") + "=" + URLEncoder.encode(subject,"UTF-8")+"&" +
                        URLEncoder.encode("exam","UTF-8") + "=" + URLEncoder.encode(exam,"UTF-8")+"&" +
                        URLEncoder.encode("teacher","UTF-8") + "=" + URLEncoder.encode(teacher,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();


                httpURLConnection.setDoInput(true);
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                String json;
                int i =  0;
                StringBuilder stringBuilder = new StringBuilder();
                while((json = bufferedReader.readLine()) != null){
                    i++;
                    if(true)stringBuilder.append(json+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                String info = stringBuilder.toString();
                info = info.substring(0,info.indexOf('<'));
                requestedString = info;
                httpURLConnection.disconnect();
                return "c";
            }catch (Exception e){
                return  "failed....  "+e.toString();
            }
        }
        if(method.equals("test")){
            alertDialog.setTitle("Test");
            String json_url = "http://hsconlineexam.netau.net/jason.php";
            try{
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setDoInput(true);
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String json;
                int i =  0;
                StringBuilder stringBuilder = new StringBuilder();
                while((json = bufferedReader.readLine()) != null){
                    i++;
                    if(true)stringBuilder.append(json+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                String info = stringBuilder.toString();
                info = info.substring(0,info.indexOf('<'));
                requestedString = info;
                httpURLConnection.disconnect();
                return "c";
            }catch (Exception e){
                return  "failed";
            }
        }
        if(method.equals("add_question")){
            String add_url = "http://hsconlineexam.netau.net/add_question.php";
            //signUpBackground.execute(method,subject,teacher,exam,ques,a,b,c,d,correct);
            String subject = params[1];
            String teacher =  params[2];
            String name = params[3];
            String ques = params[4];
            String a = params[5];
            String b = params[6];
            String c = params[7];
            String d = params[8];
            String cor = params[9];
            try {
                URL url = new URL(add_url);
                HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
                httpUrlConnection.setRequestMethod("POST");
                httpUrlConnection.setDoOutput(true);
                OutputStream os = httpUrlConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data = URLEncoder.encode("SubjectName", "UTF-8") + "=" + URLEncoder.encode(subject, "UTF-8") + "&" +
                        URLEncoder.encode("TeacherName", "UTF-8") + "=" + URLEncoder.encode(teacher, "UTF-8") + "&" +
                        URLEncoder.encode("ExamName", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                        URLEncoder.encode("Question", "UTF-8") + "=" + URLEncoder.encode(ques, "UTF-8") + "&" +
                        URLEncoder.encode("OptionB", "UTF-8") + "=" + URLEncoder.encode(b, "UTF-8") + "&" +
                        URLEncoder.encode("OptionC", "UTF-8") + "=" + URLEncoder.encode(c, "UTF-8") + "&" +
                        URLEncoder.encode("OptionD", "UTF-8") + "=" + URLEncoder.encode(d, "UTF-8") + "&" +
                        URLEncoder.encode("CorrectOption", "UTF-8") + "=" + URLEncoder.encode(cor, "UTF-8") + "&" +
                        URLEncoder.encode("OptionA", "UTF-8") + "=" + URLEncoder.encode(a, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();

                InputStream inputStream = httpUrlConnection.getInputStream();
                inputStream.close();
                httpUrlConnection.disconnect();
                return "question successfully added";
            }
            catch (Exception e){
                return "error adding question";
            }
        }
        if(method.equals("examDetailSet")){
            alertDialog.setTitle("Message About Exam For Admin");
            String reg_url = "http://hsconlineexam.netau.net/exam_info.php";
            String subject = params[1];
            String teacher =  params[2];
            String name = params[3];
            String num_of_ques = params[4];
            String time = params[5];
            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
                httpUrlConnection.setRequestMethod("POST");
                httpUrlConnection.setDoOutput(true);
                OutputStream os = httpUrlConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data = URLEncoder.encode("SubjectName", "UTF-8") + "=" + URLEncoder.encode(subject, "UTF-8") + "&" +
                        URLEncoder.encode("TeacherName", "UTF-8") + "=" + URLEncoder.encode(teacher, "UTF-8") + "&" +
                        URLEncoder.encode("ExamName", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                        URLEncoder.encode("Question", "UTF-8") + "=" + URLEncoder.encode(time, "UTF-8") + "&" +
                        URLEncoder.encode("OptionA", "UTF-8") + "=" + URLEncoder.encode(teacher, "UTF-8") + "&" +
                        URLEncoder.encode("OptionB", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                        URLEncoder.encode("OptionC", "UTF-8") + "=" + URLEncoder.encode(time, "UTF-8") + "&" +
                        URLEncoder.encode("OptionD", "UTF-8") + "=" + URLEncoder.encode(teacher, "UTF-8") + "&" +
                        URLEncoder.encode("CorrectOption", "UTF-8") + "=" + URLEncoder.encode(num_of_ques, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();

                InputStream inputStream = httpUrlConnection.getInputStream();
                inputStream.close();
                httpUrlConnection.disconnect();
                currentCreatingExam = name;
                isExam = "yes";
                return "Exam Created Successfully";
            }
            catch (Exception e){
                return "Exam Not Added";
            }
        }
        if(method.equals("register")){
            alertDialog.setTitle("Student Registration Message");
            String reg_url = "http://hsconlineexam.netau.net/student_registration.php";
            String user_name = params[1];
            String user_pass =  params[2];
            String user_fullName = params[3];
            String user_email = params[4];
            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
                httpUrlConnection.setRequestMethod("POST");
                httpUrlConnection.setDoOutput(true);
                OutputStream os = httpUrlConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data = URLEncoder.encode("UserName", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") + "&" +
                        URLEncoder.encode("UserPass", "UTF-8") + "=" + URLEncoder.encode(user_pass, "UTF-8") + "&" +
                        URLEncoder.encode("UserFullName", "UTF-8") + "=" + URLEncoder.encode(user_fullName, "UTF-8") + "&" +
                        URLEncoder.encode("UserEmail", "UTF-8") + "=" + URLEncoder.encode(user_email, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();

                InputStream inputStream = httpUrlConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String json;
                int i =  0;
                StringBuilder stringBuilder = new StringBuilder();
                while((json = bufferedReader.readLine()) != null){
                    i++;
                    if(i == 3)stringBuilder.append(json+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpUrlConnection.disconnect();
                String info = stringBuilder.toString();
                if(info.charAt(1) == 'n'){
                    return "username exists try another username";
                }
                else{
                    studentReg = "yes";
                    studentLog = "yes";
                    studentName = user_name;
                    return "registration successfull";
                }
            }
            catch (Exception e){
                return "Please Try Again";
            }

        }

        if(method.equals("login")){
            alertDialog.setTitle("Student Login Message");
            String json_url = "http://hsconlineexam.netau.net/student_login.php";
            String username = params[1];
            String password = params[2];

            try{
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                String data = URLEncoder.encode("UserName","UTF-8") + "=" + URLEncoder.encode(username,"UTF-8")+"&" +
                        URLEncoder.encode("UserPass","UTF-8") + "=" + URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String json;
                int i =  0;
                StringBuilder stringBuilder = new StringBuilder();
                while((json = bufferedReader.readLine()) != null){
                    i++;
                    if(i == 3)stringBuilder.append(json+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                String info = stringBuilder.toString();
                if(info.charAt(1) == 'y'){
                    studentLog = "yes";
                    studentName = username;
                    return "Login Successful";
                }
                else{
                    return "Invalid Login";
                }
            }catch (Exception e){

                return "please try again";
            }
        }

        if(method.equals("admin_register")) {
            alertDialog.setTitle("Admin Registration Message");
            String reg_url = "http://hsconlineexam.netau.net/admin_register.php";
            String user_name = params[1];
            String user_pass = params[2];
            String user_fullName = params[3];
            String user_email = params[4];
            String user_pin = params[5];
            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
                httpUrlConnection.setRequestMethod("POST");
                httpUrlConnection.setDoOutput(true);
                OutputStream os = httpUrlConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data = URLEncoder.encode("UserName", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") + "&" +
                        URLEncoder.encode("UserPass", "UTF-8") + "=" + URLEncoder.encode(user_pass, "UTF-8") + "&" +
                        URLEncoder.encode("UserFullName", "UTF-8") + "=" + URLEncoder.encode(user_fullName, "UTF-8") + "&" +
                        URLEncoder.encode("UserEmail", "UTF-8") + "=" + URLEncoder.encode(user_email, "UTF-8") + "&"+
                        URLEncoder.encode("UserPin","UTF-8")  + "=" + URLEncoder.encode(user_pin,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();

                InputStream inputStream = httpUrlConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String json;
                int i = 0;
                StringBuilder stringBuilder = new StringBuilder();
                while ((json = bufferedReader.readLine()) != null) {
                    i++;
                    if (i == 3) stringBuilder.append(json + "\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpUrlConnection.disconnect();
                String info = stringBuilder.toString();
                if (info.charAt(1) == 'n') {
                    return "Invalid Pin";
                }
                else if(info.charAt(1) == 'o'){
                    return "Username Exists Try Different Username";
                }
                else if(info.charAt(1) == 'y'){
                    adminReg = "yes";
                    adminLog = "yes";
                    teacherName = user_name;
                    return "Admin registered";
                }
            } catch (Exception e) {
                return "please try again";
            }
        }

        if(method.equals("admin_login")){
            alertDialog.setTitle("Admin Login Message");
            String json_url = "http://hsconlineexam.netau.net/admin_login.php";
            String username = params[1];
            String password = params[2];
            try{
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                String data = URLEncoder.encode("UserName","UTF-8") + "=" + URLEncoder.encode(username,"UTF-8")+"&" +
                        URLEncoder.encode("UserPass","UTF-8") + "=" + URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String json;
                int i =  0;

                StringBuilder stringBuilder = new StringBuilder();
                while((json = bufferedReader.readLine()) != null){
                    i++;
                    if(i==3)stringBuilder.append(json+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                String info = stringBuilder.toString();
                //if(true)return info;
                if(info.charAt(1) == 'y'){
                    adminLog = "yes";
                    teacherName = username;
                    return "Login Successful";
                }
                else{
                    return "Invalid Login";
                }
            }catch (Exception e){
                return "please try again";
            }
        }
        return  "login success";
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        if(result.equals("question successfully added")){
            Toast.makeText(context,result,Toast.LENGTH_LONG).show();
        }
        //if(result.equals("test")){

        //}
        else if(result.equals("c")){

        }
        else {
            alertDialog.setMessage(result);
            alertDialog.show();
        }
    }
}
