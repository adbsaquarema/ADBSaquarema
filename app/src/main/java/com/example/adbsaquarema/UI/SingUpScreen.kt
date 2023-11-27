package com.example.adbsaquarema.UI

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.adbsaquarema.Data.Users
import com.example.adbsaquarema.databinding.ActivitySingUpScreenBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.firestore.FirebaseFirestore

class SingUpScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySingUpScreenBinding
    private val auth = FirebaseAuth.getInstance()
    private val firestore = FirebaseFirestore.getInstance()
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingUpScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FirebaseApp.initializeApp(this)

        binding.btnCreateAcount.setOnClickListener { view ->
            val email = binding.edtEmailloginSingUp.text.toString()
            val name = binding.edtNameSingUp.text.toString()
            val telephone = binding.edtTelephoneSingup.text.toString()
            val password = binding.edtPasswordSingup.text.toString()
            val chackMember = binding.chackboxSingUpMember.isChecked
            val chackVisited = binding.chackboxSingUpVisited.isChecked
            val chackVolunter = binding.chackboxSingUpVolunter.isChecked

            binding.progressBar.visibility = View.VISIBLE

            if (name.isEmpty() || email.isEmpty() || telephone.isEmpty() || password.isEmpty() ||
                (!chackMember && !chackVisited && !chackVolunter)
            ) {
                // Validação de campos vazios ou CheckBoxes não marcados
                showSnackbar(view, "Preencha todos os campos e selecione uma opção.")
                binding.progressBar.visibility = View.GONE
            } else if (!email.matches(emailPattern.toRegex())) {
                // Validação do formato de email
                showSnackbar(view, "Insira um email válido.")
                binding.progressBar.visibility = View.GONE
            } else if (telephone.length != 11) {
                // Validação do comprimento do número de telefone
                showSnackbar(view, "Insira um número de telefone válido.")
                binding.progressBar.visibility = View.GONE
            } else if (password.length < 6) {
                // Validação da senha com menos de 6 caracteres
                showSnackbar(view, "A senha deve ter pelo menos 6 caracteres.")
                binding.progressBar.visibility = View.GONE
            } else {
                // Verifique se o chackboxnextscreen está marcado
                if (binding.chackboxnextscreen.isChecked) {
                    createUserAndNavigateToNextScreen(
                        view,
                        email,
                        password,
                        name,
                        telephone,
                        chackMember,
                        chackVisited,
                        chackVolunter
                    )
                } else {
                    showSnackbar(view, "Aceite os termos e condições do app.")
                    binding.progressBar.visibility = View.GONE
                }
            }
        }

        // Configurar um OnClickListener para o chackboxnextscreen
        binding.chackboxnextscreen.setOnClickListener {
            // Nada a fazer aqui, a lógica é tratada no OnClickListener do botão
        }
    }

    private fun createUserAndNavigateToNextScreen(
        view: View,
        email: String,
        password: String,
        name: String,
        telephone: String,
        chackMember: Boolean,
        chackVisited: Boolean,
        chackVolunter: Boolean
    ) {
        // Criação de usuário no Firebase Authentication
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Criação de um objeto User com os dados do usuário
                val user = Users(
                    name = name,
                    email = email,
                    telephone = telephone,
                   Membro = chackMember,
                   Visitante = chackVisited,
                    Voluntário = chackVolunter
                )

                // Salvar o usuário no Firestore
                val userId = auth.currentUser?.uid
                if (userId != null) {
                    firestore.collection("Users")
                        .document(userId)
                        .set(user.toMap())
                        .addOnSuccessListener {
                            // Navegar para a próxima tela apenas se os dados foram salvos com sucesso
                            val intent = Intent(this, LoginScreen::class.java)
                            startActivity(intent)
                            finish() // Opcional: fecha a tela atual
                        }
                        .addOnFailureListener { e ->
                            Log.e("db", "Erro ao salvar usuário no Firestore: ${e.message}", e)

                            showSnackbar(
                                view,
                                "Erro ao cadastrar usuário, tente novamente: ${e.message}"
                            )
                            binding.progressBar.visibility = View.GONE
                        }
                }
            } else {
                // Tratar erros de criação de usuário
                handleAuthError(view, task.exception)
                binding.progressBar.visibility = View.GONE
            }
        }
    }

    private fun showSnackbar(view: View, message: String) {
        val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
        val backgroundColor = Color.parseColor("#FF0000")
        snackbar.setBackgroundTint(backgroundColor)
        snackbar.show()
    }

    private fun handleAuthError(view: View, exception: Exception?) {
        val errorMessage = when (exception) {
            is FirebaseAuthWeakPasswordException -> "Digite uma senha com pelo menos 6 caracteres."
            is FirebaseAuthInvalidCredentialsException -> "Digite um email válido."
            is FirebaseAuthUserCollisionException -> "Este email já está em uso."
            is FirebaseNetworkException -> "Sem conexão com a internet."
            else -> "Erro ao cadastrar usuário."
        }
        showSnackbar(view, errorMessage)
    }
}
