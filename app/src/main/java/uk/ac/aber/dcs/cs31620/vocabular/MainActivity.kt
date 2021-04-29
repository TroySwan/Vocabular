/**
 * Main Activity class, single activity application.
 * @author Troy Wenham
 * @version 1
 */
package uk.ac.aber.dcs.cs31620.vocabular

import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import uk.ac.aber.dcs.cs31620.vocabular.databinding.ActivityMainBinding
import uk.ac.aber.dcs.cs31620.vocabular.datasource.VocabularRepository

class MainActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityMainBinding
    private var preferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_dictionary, R.id.navigation_tests
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        preferences = getSharedPreferences("uk.ac.aber.dcs.cs31620.vocabular", MODE_PRIVATE);
    }

    override fun onOptionsItemSelected(item: MenuItem) : Boolean {
        return if(item.itemId == android.R.id.home) {
            findNavController(R.id.nav_host_fragment).navigateUp()
            val bottomNavView: BottomNavigationView = findViewById(R.id.nav_view)
            bottomNavView.isVisible = true
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }
    override fun onResume() {
        super.onResume()
        if(preferences!!.getBoolean("firstrun", true)) {
            navigateToChangeLanguages()
        }
    }

    override fun onBackPressed() {
        val isFirstStartUp : Boolean = preferences!!.getBoolean("firstrun",true)
        if (!isFirstStartUp) {
            super.onBackPressed()
            val bottomNavView: BottomNavigationView = findViewById(R.id.nav_view)
            bottomNavView.isVisible = true
        }

    }

    fun navigateToChangeLanguages() {
        val navController = findNavController(R.id.nav_host_fragment)
        navController.navigate(R.id.navigation_startup)
    }

    fun hideActionBarAndDisableBack() {
        supportActionBar!!.hide()
        preferences!!.edit().putBoolean("firstrun", true).apply()
    }

    fun showActionBar() {
        supportActionBar!!.show()
    }

    fun declareFirstRunOver() {
        preferences!!.edit().putBoolean("firstrun", false).apply()
        supportActionBar!!.show()
        var navBar  : BottomNavigationView = findViewById(R.id.nav_view)
        navBar.isVisible = true
    }

}