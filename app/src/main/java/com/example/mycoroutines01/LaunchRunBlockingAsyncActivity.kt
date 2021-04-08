package com.example.mycoroutines01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*
import java.util.concurrent.DelayQueue

class LaunchRunBlockingAsyncActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch{
            println("Vaibhav Launch 01")
            delay(1000)
            println("Vaibhav Launch 02")
        }

        runBlocking {//This blocks calls below
            println("Vaibhav Run B 01")
            delay(1000)
            println("Vaibhav Run B 02")
        }

        GlobalScope.async{
            println("Vaibhav Async 01")
            delay(1000)
            println("Vaibhav Async 02")
        }
    }
}