package com.example.adbsaquarema.UI

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.adbsaquarema.Listenners.AuthListeners
import com.example.adbsaquarema.R
import com.example.adbsaquarema.ViewModel.AuthViewModel
import com.example.adbsaquarema.databinding.ActivityForgotPasswordBinding
import com.example.adbsaquarema.databinding.ActivityLoginScreenBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForgotPassword : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPasswordBinding
    private val viewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnForgotPassword.setOnClickListener {

            val emailPass = binding.edtForgotPassword.text.toString()

            viewModel.forgotPassword(emailPass, object : AuthListeners {
                override fun onSuccess(mensage: String, screen: String) {

                    Toast.makeText(applicationContext, mensage, Toast.LENGTH_LONG).show()

                }

                override fun onFailure(error: String) {

                    Toast.makeText(applicationContext, error, Toast.LENGTH_LONG).show()
                }
            })
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