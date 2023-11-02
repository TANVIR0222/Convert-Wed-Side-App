package com.example.covertwebsiteintoandroidapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebViewClient
import com.example.covertwebsiteintoandroidapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding :ActivityMainBinding
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        // web side url
        binding.webView.loadUrl("https://www.aljazeera.com/tag/television/")
        // all java script allow
        binding.webView.settings.javaScriptEnabled=true
        // not chrome only app
        binding.webView.webViewClient= WebViewClient()
    }
    //Navigate web page history - chrome
    // back history
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        // Check whether the key event is the Back button and if there's history.
        if (keyCode == KeyEvent.KEYCODE_BACK && binding.webView.canGoBack()) {
            binding.webView.goBack()
            return true
        }
        // If it isn't the Back button or there isn't web page history, bubble up to
        // the default system behavior. Probably exit the activity.
        return super.onKeyDown(keyCode, event)
    }
}