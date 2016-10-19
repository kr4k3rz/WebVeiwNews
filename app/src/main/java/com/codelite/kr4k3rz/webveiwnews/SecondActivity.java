package com.codelite.kr4k3rz.webveiwnews;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SecondActivity extends AppCompatActivity {
    WebView webView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String newspaper = getIntent().getStringExtra("NEWSPAPER");
        webView = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true);  //enables the JavaScript for webpage

        progressDialog = new ProgressDialog(this); //displays the ProgressDialog
        progressDialog.setMessage("Loading");  //sets the message on ProgressDialog
        webView.setWebViewClient(new CustomWebViewClient(progressDialog));  //override the WebViewClient to force open inside our WbView
        webView.loadUrl("http://" + newspaper.toLowerCase() + ".com");  //loads the specified URL
    }

    private class CustomWebViewClient extends WebViewClient {
        private ProgressDialog progressDialog;

        CustomWebViewClient(ProgressDialog progressDialog) {
            this.progressDialog = progressDialog;
            progressDialog.show();
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            if (progressDialog.isShowing())
                progressDialog.cancel();
        }
    }   /*class for overloading the WebViewClient*/


}