package com.example.adbsaquarema.ServicesUi

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adbsaquarema.R
import com.example.adbsaquarema.UI.LoginScreen
import com.example.adbsaquarema.databinding.ActivitySettingsBinding

class Settings : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.tvsair.setOnClickListener {


            startLoginActivity()

        }


    }

    private fun startLoginActivity() {

        val intent = Intent(this, LoginScreen::class.java)
        startActivity(intent)


    }


}