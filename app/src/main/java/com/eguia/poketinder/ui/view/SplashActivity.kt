package com.eguia.poketinder.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler
import android.os.Looper
import com.eguia.poketinder.data.SharedPreferenceUtil


class SplashActivity : AppCompatActivity() {

    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(this)
        }

        Handler(Looper.getMainLooper()).postDelayed(
            {
                val isIntroAvailable = sharedPreferenceUtil.getIntroShow()
                if (!isIntroAvailable) {
                    startActivity(Intent(this, OnboardingActivity::class.java))
                } else {
                    startActivity(Intent(this, LoginActivity::class.java))
                }
                finish()
            },
            3000
        )

    }
}