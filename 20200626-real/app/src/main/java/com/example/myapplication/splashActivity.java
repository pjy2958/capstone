package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class splashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        startActivity(new Intent(this,StartActivity.class));
        finish();
        overridePendingTransition(R.anim.not_move_activity,R.anim.rightout_activity);
    }
}
