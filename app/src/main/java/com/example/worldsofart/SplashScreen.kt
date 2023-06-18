package com.example.worldsofart

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class SplashScreen : AppCompatActivity() {

    private val splashTimeOut: Long = 2600

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        val logoView = findViewById<ImageView>(R.id.iconApp)
        val fadeAnimationIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        logoView.startAnimation(fadeAnimationIn)

        Handler().postDelayed({
            // Kode ini akan dijalankan setelah waktu penundaan selesai
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, splashTimeOut)
    }
}