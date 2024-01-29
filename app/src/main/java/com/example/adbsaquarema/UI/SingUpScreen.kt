package com.example.adbsaquarema.UI

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.adbsaquarema.Listenners.AuthListeners
import com.example.adbsaquarema.ViewModel.AuthViewModel
import com.example.adbsaquarema.databinding.ActivitySingUpScreenBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseApp
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers

@AndroidEntryPoint
class SingUpScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySingUpScreenBinding
    private val viewModel: AuthViewModel by viewModels()


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
            val chackMember = binding.chackboxSingUpMember.isChecked.toString()
            val chackVisited = binding.chackboxSingUpVisited.isChecked.toString()
            val chackVolunter = binding.chackboxSingUpVolunter.isChecked.toString()
            val chackNextScreen = binding.chackboxnextscreen

            viewModel.createUser(
                email,
                name,
                telephone,
                password,
                chackMember,
                chackVolunter,
                chackVisited,
                chackNextScreen,
                object : AuthListeners {
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

        binding.chackboxnextscreen.setOnClickListener {

        //    AlertDialogDeleteTask()

        }
    }

    private fun startHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    fun AlertDialogDeleteTask() {
        val alertDialog = AlertDialog.Builder(applicationContext)
        alertDialog.setTitle(
            "Política de Privacidade ADB Saquarema.\n" +
                    "\n" +
                    "Coleta de Informações:\n" +
                    "Coletamos informações necessárias para melhorar sua experiência no aplicativo.\n" +
                    "Uso de Informações:\n" +
                    "Utilizamos seus dados para personalizar o serviço e processar transações.\n" +
                    "Compartilhamento:\n" +
                    "Não compartilhamos suas informações com terceiros, exceto quando necessário.\n" +
                    "Segurança:\n" +
                    "Implementamos medidas para proteger suas informações contra acesso não autorizado.\n" +
                    "Acesso e Controle:\n" +
                    "Você pode acessar, corrigir ou excluir suas informações nas configurações do aplicativo.\n" +
                    "Cookies:\n" +
                    "Usamos cookies para melhorar a funcionalidade; você pode gerenciar as configurações.\n" +
                    "Notificações:\n" +
                    "Notificaremos sobre mudanças na política de privacidade.\n" +
                    "Idade Mínima:\n" +
                    "O aplicativo é destinado a usuários com mais de [idade mínima].\n" +
                    "Contato:\n" +
                    "Para dúvidas, entre em contato em [e-mail de contato].\n" +
                    "Última atualização: 22/01/2024"
        )
            .setMessage("Aceita termos e condições?")
        alertDialog.setPositiveButton("Sim") { _, _ ->

        }
        alertDialog.setNegativeButton("Não") { _, _ -> }
        alertDialog.show()
    }
}