package com.example.user.tu20pill_mate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class drugInfo extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_info);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drugs();
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                medbroadcast();
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webmd();
            }
        });


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dailymed();
            }
        });


        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rxlist();
            }
        });


    }

    public void drugs() {
        Intent intent = new Intent(getApplicationContext(), drugs.class);
        startActivity(intent);

    }

    public void webmd() {
        Intent intent = new Intent(getApplicationContext(), webmd.class);
        startActivity(intent);

    }


    public void medbroadcast() {
        Intent intent = new Intent(getApplicationContext(), medbroadcast.class);
        startActivity(intent);

    }

    public void rxlist() {
        Intent intent = new Intent(getApplicationContext(), rxlist.class);
        startActivity(intent);

    }

    public void dailymed() {
        Intent intent = new Intent(getApplicationContext(), dailymed.class);
        startActivity(intent);

    }


}
