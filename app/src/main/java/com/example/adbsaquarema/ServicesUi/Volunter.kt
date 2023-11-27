package com.example.adbsaquarema.ServicesUi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adbsaquarema.R
import com.example.adbsaquarema.databinding.ActivityVolunterBinding

class Volunter : AppCompatActivity() {

    private lateinit var binding: ActivityVolunterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVolunterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}