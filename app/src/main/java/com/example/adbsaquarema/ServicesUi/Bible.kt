package com.example.adbsaquarema.ServicesUi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adbsaquarema.R
import com.example.adbsaquarema.databinding.ActivityBibleBinding

class Bible : AppCompatActivity() {

    private lateinit var binding: ActivityBibleBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBibleBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}