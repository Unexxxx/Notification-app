package com.kentonyx.notificationapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    lateinit var drawer: DrawerLayout
    lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val imageNavMenu: ImageView = toolbar.findViewById(R.id.ivMenu)
        val ivAddReminder: ImageView = findViewById(R.id.ivAddReminder)

        imageNavMenu.setOnClickListener{
            drawer.openDrawer(GravityCompat.START)
        }

        ivAddReminder.setOnClickListener{
            val intent = Intent(this@MainActivity,ReminderActivity::class.java)
            startActivity(intent)
        }

        drawer = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.nvMenu)
        navigationView.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings -> {
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
            }
        }
        drawer.closeDrawers()
        return true
    }
}




