package com.example.user.tu20pill_mate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class get_started extends AppCompatActivity {


    public void remindMe(View v) {
        switchToNotification();
    }

    public void medInfo(View v) {
        switchToMedInfo();
    }

    public void switchToNotification() {
        Intent i = new Intent(this, alarm_main.class);
        startActivity(i);
    }

    public void switchToMedInfo() {
        Intent intent = new Intent(this, drugInfo.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);
    }
}
