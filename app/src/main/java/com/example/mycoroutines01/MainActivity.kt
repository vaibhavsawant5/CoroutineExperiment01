package com.example.mycoroutines01

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout
import java.io.BufferedInputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    private lateinit var myViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        val job01 = lifecycleScope.launch {
            withTimeout(5000) {
                while (true) {
                    println("Vaibhav in Main Activity 01")
                    delay(1000)
                }
            }
        }

        val job02 = lifecycleScope.launch {
            withTimeout(5000) {
                while (true) {
                    println("Vaibhav in Main Activity 02")
                    delay(1000)
                }
            }
        }

//        val job03 =
            lifecycleScope.launch(Dispatchers.IO) {//Skipping Dispatchers.IO gives NetworkOnMainThreadException
                while (true) {
                    val url = URL("https://jsonplaceholder.typicode.com/todos/1")
                    val urlConnection = url.openConnection() as HttpURLConnection
                    try {
                        val inStream: InputStream = BufferedInputStream(urlConnection.inputStream)
                        val byteArray = inStream.readBytes()
                        val str = String(byteArray).replace("\n", "", false)
                        println("VAIBHAV IN MY VIEW MODEL init() $str")
                        delay(1000)
                    } catch (ex: Exception) {
//                        ex.printStackTrace()
                    } finally {
                        urlConnection.disconnect()
                    }
                }
            }
    }
}
