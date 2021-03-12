package com.brixham.admity.views

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.brixham.admity.R
import com.brixham.admity.utilities.Constants

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        startAnimation()

        Handler().postDelayed({
            if(getLoggedInStatus()){
                val intent = Intent(this, DashBoard::class.java)
                startActivity(intent)
                finish()
            }
            else{
                val intent = Intent(this, DashBoard::class.java)
                startActivity(intent)
                finish()
            }
        }, 1500) // 3000 is the delayed time in milliseconds.
    }

    private fun getLoggedInStatus() : Boolean {
        val isLoggedIn: Boolean
        val sharedPreferences : SharedPreferences = this.getSharedPreferences(Constants.SHARED_PREF_FILE_NAME, MODE_PRIVATE)
        isLoggedIn = sharedPreferences.getBoolean(Constants.SHARED_PREFS_IS_LOGGED_IN, false)

        return isLoggedIn
    }

    private fun startAnimation() {
        val imageViewBackground: ImageView = findViewById(R.id.splashimage)
        val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.animslide)
        imageViewBackground.startAnimation(slideAnimation)
    }
}
