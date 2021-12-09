package com.example.gadsag19educationquiz.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.core.content.ContextCompat
import com.example.gadsag19educationquiz.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*Set Status bar Color*/
        val window: Window = this.window
        val background = ContextCompat.getDrawable(
            this,
            R.drawable.toolbar_background
        )
//        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = this.resources.getColor(android.R.color.transparent)
//        window.setBackgroundDrawable(background)
    }
}