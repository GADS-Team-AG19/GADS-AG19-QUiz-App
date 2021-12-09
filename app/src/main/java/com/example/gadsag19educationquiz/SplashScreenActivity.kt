package com.example.gadsag19educationquiz

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gadsag19educationquiz.ui.DashboardActivity
import com.example.gadsag19educationquiz.ui.MainActivity
import com.example.gadsag19educationquiz.util.Constants
import com.example.gadsag19educationquiz.util.SessionManager
import kotlinx.coroutines.*

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager
    lateinit var pref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        pref = application.getSharedPreferences(Constants.TOKEN, Context.MODE_PRIVATE)

        sessionManager = SessionManager(pref)


        /*Move to the home page after showing splash screen for X milliseconds*/
        GlobalScope.launch {
            delay(1000L)
            withContext(Dispatchers.Main) {

                val pref = sessionManager.loadFromSharedPref(Constants.TOKEN)
                /*Use finish to disable the page when back button is pressed from homePage*/
                if (pref.isEmpty()) {
                    val intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else if (pref.isNotEmpty()) {
                    val intent =
                        Intent(this@SplashScreenActivity, DashboardActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}