package com.pro.helpbot;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import  android.webkit.WebChromeClient;

public class MainActivity extends Activity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = (WebView) findViewById(R.id.activity_main_webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
        mWebView.setWebChromeClient(new WebChromeClient());

        webSettings.setAllowFileAccess(true);
        webSettings.setAllowFileAccessFromFileURLs(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setLoadsImagesAutomatically(true);

        mWebView.loadUrl("http://192.168.26.33/helpbot/"); //Enter your website here

        mWebView.setWebViewClient(new MyAppWebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                //hide loading image
                findViewById(R.id.imageLoading1).setVisibility(View.GONE);
                //show webview
                findViewById(R.id.activity_main_webview).setVisibility(View.VISIBLE);
            }});


    }
}
