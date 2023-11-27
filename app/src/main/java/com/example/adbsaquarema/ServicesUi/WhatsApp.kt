package com.example.adbsaquarema.ServicesUi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adbsaquarema.R
import com.example.adbsaquarema.databinding.ActivityWhatsAppBinding

class WhatsApp : AppCompatActivity() {

    private lateinit var binding: ActivityWhatsAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityWhatsAppBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}