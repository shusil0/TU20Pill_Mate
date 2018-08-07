package com.example.user.tu20pill_mate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class get_started extends AppCompatActivity {


    public void remindMe(View v) {
        switchToNotification();
    }

    public void switchToNotification() {
        Intent i = new Intent(this, alarm_main.class);
        startActivity(i);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);
    }
}
