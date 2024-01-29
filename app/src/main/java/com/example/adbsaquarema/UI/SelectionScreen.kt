package com.example.adbsaquarema.UI




import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adbsaquarema.databinding.SelectionScreenBinding

class SelectionScreen : AppCompatActivity() {
    private lateinit var binding: SelectionScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SelectionScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSingUp.setOnClickListener {


            startSingUpActivity()
           


        }


        binding.btnSingIn.setOnClickListener {


            startSingInActivity()

        }

        binding.acssesnotlogin.setOnClickListener {

            startHomeActivity()


        }


    }


    private fun startSingUpActivity() {

        val intent = Intent(this, SingUpScreen::class.java)
        startActivity(intent)


    }

    private fun startSingInActivity() {

        val intent = Intent(this, LoginScreen::class.java)
        startActivity(intent)


    }

    private fun startHomeActivity() {

        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)


    }


}
