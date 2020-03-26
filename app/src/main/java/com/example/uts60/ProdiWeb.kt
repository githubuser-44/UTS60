package com.example.uts60

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.net.URL

class ProdiWeb : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_web)

        val webView = findViewById<WebView>(R.id.webView)

        var intentdaridetail = intent

        if (intentdaridetail.hasExtra(Intent.ACTION_VIEW)) {
            var partWeb = intentdaridetail.getStringExtra(Intent.ACTION_VIEW)
            webView.settings.javaScriptEnabled = true

            webView.webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView, url: String) {
                    view.loadUrl("javascript:alert('Berhasil memuat website')")
                }
            }

            webView.webChromeClient = object : WebChromeClient() {
                override fun onJsAlert(
                    view: WebView,
                    url: String,
                    message: String,
                    result: JsResult
                ): Boolean {
                    Toast.makeText(this@ProdiWeb, message, Toast.LENGTH_LONG).show()
                    result.confirm()
                    return true
                }
            }

            webView.loadUrl(partWeb)
        }

    }
}