package com.example.adbsaquarema.UI

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import com.example.adbsaquarema.databinding.ActivityLoginScreenBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException

class LoginScreen : AppCompatActivity() {

    private lateinit var binding: ActivityLoginScreenBinding
    private val auth = FirebaseAuth.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val keepLoggedInCheckBox: CheckBox = binding.chackbox




        binding.btnToEnter.setOnClickListener { view ->
            val email = binding.edtEmaillogin.text.toString()
            val password = binding.edtLoginPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                val snackbar =
                    Snackbar.make(view, "Preencha todos os campos", Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            } else {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { autentic ->
                        if (autentic.isSuccessful) {
                            if (keepLoggedInCheckBox.isChecked) {

                                auth.currentUser?.getIdToken(true)

                            }
                            startHomeActivity()
                        }
                    }
                    .addOnFailureListener { exception ->
                        val errorMessage = when (exception) {
                            is FirebaseAuthInvalidCredentialsException -> "Senha inválida."
                            is FirebaseAuthInvalidUserException -> "E-mail inválido."
                            is FirebaseNetworkException -> "Sem conexão com a internet."
                            else -> "Erro de servidor."
                        }
                        val snackbar =
                            Snackbar.make(view, errorMessage, Snackbar.LENGTH_SHORT)
                        snackbar.setBackgroundTint(Color.RED)
                        snackbar.show()
                    }
            }
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



