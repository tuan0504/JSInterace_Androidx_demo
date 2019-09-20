package com.minhazulhaque.apps.webview_activity

import android.content.Context
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webview = this.findViewById(R.id.webView) as WebView
        webview.settings.javaScriptEnabled = true
        webview.loadUrl("file:///android_res/raw/index.html")
        webview.addJavascriptInterface(JSInterface(this), "JSInterface")
    }

    inner class JSInterface internal constructor(internal var mContext: Context) {

        @JavascriptInterface
        fun toastMe(text: String) {
            Toast.makeText(mContext, text, Toast.LENGTH_SHORT).show()
        }
    }
}