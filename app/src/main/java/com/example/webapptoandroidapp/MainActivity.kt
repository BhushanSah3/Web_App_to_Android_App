package com.example.webapptoandroidapp

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.webapptoandroidapp.ui.theme.WebAppToAndroidAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WebAppToAndroidAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                    Mobapp(
                        Modifier
                            .fillMaxSize()
                            .padding(90.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun Mobapp(modifier: Modifier = Modifier) {
    AndroidView(factory = { context ->
        WebView(context).apply {
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient() // this to open link in same app
        }
    }, update = {
         it.loadUrl("https://youtube.com/")
       // it.loadUrl("https://www.neatroots.com/")
    })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WebAppToAndroidAppTheme {
        Mobapp()
    }
}