package com.example.user.tu20pill_mate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebBackForwardList;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MedInfo extends AppCompatActivity {

    WebView webview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_info);

        webview = (WebView) findViewById(R.id.webMed);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webview.setWebViewClient(new WebViewClient());

        webview.loadUrl("https://medbroadcast.com/drug");


    }
}
