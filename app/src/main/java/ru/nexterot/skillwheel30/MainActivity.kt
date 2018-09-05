package ru.nexterot.skillwheel30

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import android.view.View
import android.widget.Toast
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService


enum class FlipperID {
    MAIN, BARBARIAN, DEMONLORD, KNIGHT, NECROMANCER, RANGER, RUNEMAGE, WARLOCK, WIZARD,
}

class Hero (val name: String)

class MyFirebaseInstanceIDService : FirebaseInstanceIdService() {
    override fun onTokenRefresh() {
        // Get updated InstanceID token.
        val refreshedToken = FirebaseInstanceId.getInstance().getToken()
        println("Refreshed token: " + refreshedToken)
        // eFN4M5YzgDA:APA91bGxfh1cqjoGsU7xlWs_mA2IQjJ33NUMC34ijoZkkoxQmmqlpbySPZbUZ0PRRInlL5srfMfJbuMxdXWJ1btDzduHSauSrybAvduUw71gCIRwe4gXiJn2RslUeIwFvXRkdTfg6kHX

    }
}

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    val heroes = arrayOf("None", "Crag", "Argat", "Garuna", "Goshak", "Shak-karukat", "Haggesh", "Telsek", "Kigan")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val barbarianSpinnerAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, heroes);
        barbarianSpinner.adapter = barbarianSpinnerAdapter

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        // for token
        val klass = MyFirebaseInstanceIDService()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_barbarian -> {
                flipper.setDisplayedChild(FlipperID.BARBARIAN.ordinal)
            }
            R.id.nav_demonlord -> {
                flipper.setDisplayedChild(FlipperID.DEMONLORD.ordinal)
            }
            R.id.nav_knight -> {
                flipper.setDisplayedChild(FlipperID.KNIGHT.ordinal)
            }
            R.id.nav_necromancer -> {
                flipper.setDisplayedChild(FlipperID.NECROMANCER.ordinal)
            }
            R.id.nav_ranger -> {
                flipper.setDisplayedChild(FlipperID.RANGER.ordinal)
            }
            R.id.nav_runemage -> {
                flipper.setDisplayedChild(FlipperID.RUNEMAGE.ordinal)
            }
            R.id.nav_warlock -> {
                flipper.setDisplayedChild(FlipperID.WARLOCK.ordinal)
            }
            R.id.nav_wizard -> {
                flipper.setDisplayedChild(FlipperID.WIZARD.ordinal)
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
