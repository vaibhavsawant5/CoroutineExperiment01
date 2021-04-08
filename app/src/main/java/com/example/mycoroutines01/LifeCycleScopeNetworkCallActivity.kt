package com.example.mycoroutines01

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.BufferedInputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class LifeCycleScopeNetworkCallActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val job =
            lifecycleScope.launch(Dispatchers.IO) {//Skipping Dispatchers.IO gives NetworkOnMainThreadException
                val url = URL("https://jsonplaceholder.typicode.com/todos/1")
                val urlConnection = url.openConnection() as HttpURLConnection
                try {
                    val inStream: InputStream = BufferedInputStream(urlConnection.inputStream)
                    val byteArray = inStream.readBytes()
                    val str = String(byteArray).replace("\n", "", false)
                    println("VAIBHAV IN MY VIEW MODEL init() $str")
                } finally {
                    urlConnection.disconnect()
                }
            }
    }
}