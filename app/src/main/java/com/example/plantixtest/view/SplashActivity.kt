package com.example.plantixtest.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Window
import com.example.plantixtest.R

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()
        setDelayonSplash()
    }

    fun setDelayonSplash(){
        Thread(Runnable {
            Handler(Looper.getMainLooper()).postDelayed({
                openMainScreen()
            }, 3000)
        }).start()
    }

    fun openMainScreen(){
        val vIntent = Intent(this, MainActivity::class.java)
        startActivity(vIntent)
        finish()
    }
}