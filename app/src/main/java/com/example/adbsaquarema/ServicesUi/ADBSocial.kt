package com.example.adbsaquarema.ServicesUi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adbsaquarema.R
import com.example.adbsaquarema.databinding.ActivityAdbsocialBinding

class ADBSocial : AppCompatActivity() {

    private lateinit var binding: ActivityAdbsocialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdbsocialBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}