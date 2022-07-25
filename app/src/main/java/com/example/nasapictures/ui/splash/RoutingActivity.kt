package com.example.nasapictures.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nasapictures.R
import com.example.nasapictures.ui.home.MainActivity
import kotlinx.coroutines.*

class RoutingActivity : AppCompatActivity() {
    private lateinit var mSplashJob: Job

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        mSplashJob = GlobalScope.launch {
            delay(3000)
            startActivity(Intent(this@RoutingActivity, MainActivity::class.java))
            finish()
        }
    }

    override fun onStop() {
        super.onStop()
        mSplashJob.cancel()
    }
}