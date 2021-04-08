package com.example.mycoroutines01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*
import java.util.concurrent.DelayQueue

class CoroutineScopeBlockingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        runBlocking {
            launch {
                delay(200)
                println("Vaibhav in launch 01")
            }
            coroutineScope {//This blocks calls below
                delay(500)
                println("Vaibhav in coroutinescope")
            }
            launch {
                delay(100)
                println("Vaibhav in launch 02")
            }

        }

        println("Vaibhav after run blocking")
    }
}