package com.kentonyx.notificationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.kentonyx.notificationapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            toggle = ActionBarDrawerToggle(this@MainActivity,dlActionbar,R.string.open,R.string.close)
            dlActionbar.addDrawerListener(toggle)
            toggle.syncState()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            nvMenu.setNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.settings->{Toast.makeText(this@MainActivity,"Settings",Toast.LENGTH_SHORT).show()}
                    R.id.termsAndConditions->{Toast.makeText(this@MainActivity,"Terms and Conditions",Toast.LENGTH_SHORT).show()}
                    R.id.dataPolicy->{Toast.makeText(this@MainActivity,"Data Policy",Toast.LENGTH_SHORT).show()}
                    R.id.logOut->{Toast.makeText(this@MainActivity,"Log out",Toast.LENGTH_SHORT).show()}
                }
                true
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            true
        }
        return super.onOptionsItemSelected(item)
    }
}