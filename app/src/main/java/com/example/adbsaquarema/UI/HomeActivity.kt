package com.example.adbsaquarema.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adbsaquarema.R
import com.example.adbsaquarema.databinding.ActivityHomeBinding
import com.example.adbsaquarema.databinding.ActivityLoginScreenBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.backTv.setOnClickListener {

            startSelectionActivity()



        }




    }

    private fun startSelectionActivity() {

        val intent = Intent(this, SelectionScreen::class.java)
        startActivity(intent)


    }

}