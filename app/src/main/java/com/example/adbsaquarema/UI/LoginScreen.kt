package com.example.adbsaquarema.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adbsaquarema.R
import com.example.adbsaquarema.databinding.ActivityLoginScreenBinding
import com.example.adbsaquarema.databinding.ActivityMainBinding

class LoginScreen : AppCompatActivity() {

    private lateinit var binding: ActivityLoginScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}