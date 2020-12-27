package com.sowroom.app.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.sowroom.app.R
import com.sowroom.app.databinding.ActivityMainBinding
import com.sowroom.app.ui.auth.AuthActivity
import com.sowroom.app.ui.auth.sowroomAuth

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        init()
    }

    private fun init() {
        binding.buttomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> navigate(R.id.homeFragment)
                R.id.ic_book -> navigate(R.id.bookFragment)
                R.id.ic_favorite -> navigate(R.id.favoriteFragment)
                R.id.ic_profile -> navigate(R.id.profileFragment)
                else -> false
            }
        }
    }

    private fun navigate(id: Int): Boolean {
        findNavController(R.id.navHost).navigate(id)
        return true
    }
}