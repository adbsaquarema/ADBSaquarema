package com.example.adbsaquarema.ServicesUi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adbsaquarema.R
import com.example.adbsaquarema.databinding.ActivityAccountBinding
import io.grpc.android.BuildConfig
import java.io.FileInputStream
import java.io.InputStream
import java.util.Properties

class Account : AppCompatActivity() {

    private lateinit var binding: ActivityAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    binding= ActivityAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)




    }
}