package com.example.adbsaquarema.ServicesUi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adbsaquarema.R
import com.example.adbsaquarema.databinding.ActivityMinisteryBinding

class Ministery : AppCompatActivity() {

    private lateinit var binding: ActivityMinisteryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding = ActivityMinisteryBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}