package com.example.adbsaquarema.UI

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adbsaquarema.R
import com.example.adbsaquarema.databinding.ActivityForgotPasswordBinding
import com.example.adbsaquarema.databinding.ActivityLoginScreenBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class ForgotPassword : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPasswordBinding
    private val auth = FirebaseAuth.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnForgotPassword.setOnClickListener {


            val emailPass = binding.edtForgotPassword.text.toString()

            auth.sendPasswordResetEmail(emailPass)
                .addOnCompleteListener { void ->

                    val color = Color.parseColor("#FF03DAC5")
                    val snackbar =
                        Snackbar.make(it, "Verifique seu E-mail", Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(color)
                    snackbar.show()


                }.addOnFailureListener { void ->


                    val snackbar =
                        Snackbar.make(it, "Server Error.", Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.RED)
                    snackbar.show()


                }


        }





        binding.tvBackLogin1.setOnClickListener {

            startLoginActivity()

        }
   binding.tvBackLogin2.setOnClickListener {

            startLoginActivity()

        }


    }

    private fun startLoginActivity() {

        val intent = Intent(this, LoginScreen::class.java)
        startActivity(intent)


    }

}