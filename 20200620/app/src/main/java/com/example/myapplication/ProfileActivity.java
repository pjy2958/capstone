package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private TextView tv_id, tv_pass, tv_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tv_id=findViewById(R.id.tv_iid);
        tv_pass=findViewById(R.id.tv_pw);
        tv_name=findViewById(R.id.tv_name);

        Intent intent = getIntent();

        String userID = intent.getStringExtra("userID");
        String userPass = intent.getStringExtra("userPass");
        String userName = intent.getStringExtra("userName");

        tv_id.setText(userID);
        tv_pass.setText(userPass);
        tv_name.setText(userName);

    }
}
