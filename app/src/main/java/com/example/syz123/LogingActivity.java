package com.example.syz123;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LogingActivity extends AppCompatActivity {


    private EditText getEt_pwd,getEt_username;


    private Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loging);
        button=findViewById(R.id.bt_login);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = getEt_username.getText().toString();
                final String pwd = getEt_pwd.getText().toString();
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        String url="https://baidu.com";

                        OkHttpClient httpClient = new OkHttpClient();
                        FormBody body = new FormBody.Builder()
                                .add("uname", username)
                                .add("password", pwd).build();
                        Request request = new Request
                                .Builder()
                                .url(url)
                                .post(body)
                                .build();
                        try {
                            Response response = httpClient.newCall(request).execute();
                            Log.d("Response", response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }.start();
            }
        });


}}