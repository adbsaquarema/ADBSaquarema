package com.example.adbsaquarema.ServicesUi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adbsaquarema.R
import com.example.adbsaquarema.UI.HomeActivity
import com.example.adbsaquarema.databinding.ActivityHome2Binding

class Home2 : AppCompatActivity() {

    private lateinit var binding: ActivityHome2Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHome2Binding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.ArrowUp.setOnClickListener{

            startNextScreenActivity()

        }










    }
    private fun startNextScreenActivity() {

        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)


    }

}