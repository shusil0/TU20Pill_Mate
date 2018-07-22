package com.example.user.tu20pill_mate;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Slide_activity extends AppCompatActivity implements View.OnClickListener {


    private ViewPager viewPager;
    private slide myadapter;
    Button getStart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_activity);

        getStart = (Button) findViewById(R.id.getStarted);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        myadapter = new slide(this);
        viewPager.setAdapter(myadapter);

    }

    public void startPage() {
        Intent i = new Intent(this, Logins.class);
        startActivity(i);
    }

    public void letsStart(View v) {
        if (v.getId() == R.id.getStarted) {
            startPage();
        }

    }

    @Override
    public void onClick(View view) {

    }
}
