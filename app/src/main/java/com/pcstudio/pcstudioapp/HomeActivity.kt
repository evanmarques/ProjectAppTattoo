package com.pcstudio.pcstudioapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pcstudio.pcstudioapp.fragments.HomeFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottomNav = findViewById(R.id.bottom_navigation)

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_bottom_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.nav_bottom_artists -> {
                    Toast.makeText(this, "Tela de Artistas em breve", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_bottom_appointments -> {
                    Toast.makeText(this, "Tela de Agenda em breve", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_bottom_profile -> {
                    Toast.makeText(this, "Tela de Perfil em breve", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        if (savedInstanceState == null) {
            bottomNav.selectedItemId = R.id.nav_bottom_home
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
    }
}