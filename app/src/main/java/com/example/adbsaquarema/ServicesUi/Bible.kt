package com.example.adbsaquarema.ServicesUi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adbsaquarema.R
import com.example.adbsaquarema.databinding.ActivityBibleBinding
import java.io.FileInputStream
import java.io.InputStream
import java.util.Properties

class Bible : AppCompatActivity() {

    private lateinit var binding: ActivityBibleBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBibleBinding.inflate(layoutInflater)
        setContentView(binding.root)





 // PARA OBTER A API KEY È SÒ UTILIZAR ESSE CÒDIGO.
       /* val properties = Properties()
        val inputStream: InputStream = FileInputStream("local.properties")
        properties.load(inputStream)

// Obtenha a chave de API
        val apiKey = properties.getProperty("API_KEY")*/







    }
}