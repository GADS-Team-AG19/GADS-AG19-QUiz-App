package com.example.gadsag19educationquiz.ui

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toolbar
import androidx.navigation.NavController
import com.example.gadsag19educationquiz.R
import com.example.gadsag19educationquiz.databinding.ActivityDashboardBinding
import com.example.gadsag19educationquiz.util.Constants
import com.example.gadsag19educationquiz.util.SessionManager
import com.example.gadsag19educationquiz.util.logOut
import com.google.firebase.auth.FirebaseAuth

class DashboardActivity : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager
    lateinit var pref: SharedPreferences
    private lateinit var listener: NavController.OnDestinationChangedListener
    lateinit var toolbar:androidx.appcompat.widget.Toolbar


    lateinit var binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = application.getSharedPreferences(Constants.TOKEN, Context.MODE_PRIVATE)
        sessionManager = SessionManager(pref)
        toolbar = binding.dashboardActivityToolbar

        setSupportActionBar(toolbar)
        title = ""

        onDestinationChangedListener()


    }

    //inflates menu item
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater: MenuInflater = menuInflater
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    //handles onclick functionality of menu items
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout -> {
                FirebaseAuth.getInstance().signOut()
                logOut(sessionManager)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    //Set Up Navigation Change Listener
    private fun onDestinationChangedListener() {
        listener =
            NavController.OnDestinationChangedListener { controller, destination, arguments ->
                if (destination.getId() == R.id.card_info_activity_appBarLayout) {
                    toolbar.visibility = View.GONE
                }
            }
    }

}
