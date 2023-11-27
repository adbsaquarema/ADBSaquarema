package com.example.adbsaquarema.ServicesUi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adbsaquarema.R
import com.example.adbsaquarema.databinding.ActivityChurchBinding

class Church : AppCompatActivity() {

    private lateinit var binding: ActivityChurchBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChurchBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}