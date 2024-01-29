package com.example.adbsaquarema.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.adbsaquarema.Listenners.AuthListeners
import com.example.adbsaquarema.ViewModel.AuthViewModel
import com.example.adbsaquarema.databinding.ActivityLoginScreenBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginScreen : AppCompatActivity() {

    private lateinit var binding: ActivityLoginScreenBinding
    private val viewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnToEnter.setOnClickListener { view ->
            val email = binding.edtEmaillogin.text.toString()
            val password = binding.edtLoginPassword.text.toString()

            viewModel.loginUser(email, password, object : AuthListeners {
                override fun onSuccess(mensage: String, screen: String) {

                    Toast.makeText(applicationContext, mensage, Toast.LENGTH_SHORT).show()
                    binding.progressBar.visibility = View.VISIBLE
                    startHomeActivity()


                }

                override fun onFailure(error: String) {

                    Toast.makeText(applicationContext, error, Toast.LENGTH_SHORT).show()

                }
            })


        }

        binding.tvEsqueciasenha.setOnClickListener {

            startForgotPasswordActivity()

        }
    }

    private fun startForgotPasswordActivity() {
        val intent = Intent(this, ForgotPassword::class.java)
        startActivity(intent)
    }

    private fun startHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}



