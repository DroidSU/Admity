package com.brixham.admity.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.brixham.admity.R

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


            // This is used to hide the status bar and make
            // the splash screen as a full screen activity.
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
                val backgroundimage: ImageView = findViewById(R.id.splashimage)
                val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.animslide)
                backgroundimage.startAnimation(slideAnimation)

            // we used the postDelayed(Runnable, time) method
            // to send a message with a delayed time.
            Handler().postDelayed({
                val intent = Intent(this, LoginScreen::class.java)
                startActivity(intent)
                finish()
            }, 1500) // 3000 is the delayed time in milliseconds.
        }
    }
