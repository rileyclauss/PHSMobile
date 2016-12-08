package com.phsapp.phsapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.widget.*;
import android.webkit.*;


public class newsActivity extends AppCompatActivity {
    final pl.droidsonroids.gif.GifTextView loading = (pl.droidsonroids.gif.GifTextView) findViewById(R.id.load);
    final WebView myWebView = (WebView) findViewById(R.id.webview1);
    final TextView ltext = (TextView) findViewById(R.id.textView);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_club);
        myWebView.setVisibility(View.VISIBLE);
        loading.setVisibility(View.INVISIBLE);
        ltext.setVisibility(View.INVISIBLE);
        WebSettings websettings = myWebView.getSettings();
        websettings.setJavaScriptEnabled(true);
        myWebView.getSettings().setJavaScriptEnabled(true);
        super.onCreate(savedInstanceState);
        myWebView.loadUrl("https://penn.phmschools.org/news");
        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                    Context context = getApplicationContext();
                    CharSequence text = "Meme!";
                    int duration = Toast.LENGTH_SHORT;
                    final Toast toast = Toast.makeText(context, text, duration);
                    loading.setVisibility(View.INVISIBLE);
                    ltext.setVisibility(View.INVISIBLE);
                    myWebView.setVisibility(View.VISIBLE);
                    toast.show();
                    Intent intent = new Intent(view.getContext(), MainActivity.class);
                    startActivity(intent);
                    super.onReceivedError(view, request, error);
            }
            public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                loading.setVisibility(View.INVISIBLE);
                ltext.setVisibility(View.INVISIBLE);
                myWebView.setVisibility(View.VISIBLE);
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);
                super.onReceivedHttpError(view, request, errorResponse);
            }
            public void onPageFinished(WebView view, String url) {
                loading.setVisibility(View.INVISIBLE);
                ltext.setVisibility(View.INVISIBLE);
                myWebView.loadUrl("javascript:(function() { " +
                        "var head = document.getElementsByTagName('header')[0];"
                        + "head.parentNode.removeChild(head);"+
                        "})()");
                myWebView.loadUrl("javascript:(function() { " +
                        "var head = document.getElementsByTagName('footer')[0];"
                        + "head.parentNode.removeChild(head);"+
                        "})()");
                myWebView.loadUrl("javascript:(function() { " +
                        "var head = document.getElementsByClassName('l-region l-region--content-right')[0];"
                        + "head.parentNode.removeChild(head);"+
                        "})()");
                myWebView.setVisibility(View.VISIBLE);
                super.onPageFinished(view, url);
            }
            public void onUnhandledKeyEvent(WebView view, KeyEvent event){
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);
                super.onUnhandledKeyEvent(view, event);
            }
        });
    }
}






