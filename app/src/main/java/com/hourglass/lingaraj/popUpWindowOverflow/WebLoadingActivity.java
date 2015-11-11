package com.hourglass.lingaraj.popUpWindowOverflow;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.hourglass.lingaraj.dropdownmenu.R;

/**
 * Created by lingaraj on 11/11/15.
 */
public class WebLoadingActivity extends AppCompatActivity {
    WebView webView;
    String url;
    ProgressDialog progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webloadingactivity);
        webView=(WebView)findViewById(R.id.webview);
        Bundle extras=getIntent().getExtras();
        url=extras.getString("loadingPage");

        WebSettings webSettings=webView.getSettings();
        //to set JavaScript enabled in webView you have to get it settings to Websettings.
        webSettings.setJavaScriptEnabled(true);
        //set JavaScriptEnabled to true, so that the url you are about to load in webView will load.
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        //set scrollbar to webview.
        progressBar = ProgressDialog.show(WebLoadingActivity.this, "", "Loading...",
                true);
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            public void onPageFinished(WebView view, String url) {
                if (progressBar.isShowing()) {
                    progressBar.dismiss();
                }
            }

            public void onReceivedError(WebView view, int errorCode,
                                        String description, String failingUrl) {
                AlertDialog alert = new AlertDialog.Builder(WebLoadingActivity.this)
                        .create();
                alert.setTitle("No connection");
                alert.setIcon(R.drawable.facebook);
                alert.setCancelable(false);
                alert.setMessage("No connection");
                alert.setButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });
                alert.show();
            }
        });
        webView.loadUrl(url);


    }

}
