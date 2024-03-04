package com.example.adbsaquarema.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.adbsaquarema.Data.Services
import com.example.adbsaquarema.R
import com.example.adbsaquarema.ServicesUi.ADBSocial
import com.example.adbsaquarema.ServicesUi.Account
import com.example.adbsaquarema.ServicesUi.Bible
import com.example.adbsaquarema.ServicesUi.Calendar
import com.example.adbsaquarema.ServicesUi.Church
import com.example.adbsaquarema.ServicesUi.Donation
import com.example.adbsaquarema.ServicesUi.Groups
import com.example.adbsaquarema.ServicesUi.Home2
import com.example.adbsaquarema.ServicesUi.Ministery
import com.example.adbsaquarema.ServicesUi.Settings
import com.example.adbsaquarema.ServicesUi.Volunter
import com.example.adbsaquarema.ServicesUi.WhatsApp
import com.example.adbsaquarema.databinding.ActivityHomeBinding
import com.example.adbsaquarema.databinding.ActivityLoginScreenBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var Adapter: ServicesAdapter
    private val ListServices: MutableList<Services> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val RvServices = binding.rvServices
        RvServices.layoutManager = GridLayoutManager(
            this, 3
        )
        Adapter = ServicesAdapter(this, ListServices, object : ServicesAdapter.OnItemClick {
            override fun OnItemClicked(Service: Services) {


                val intent = when (Service.id) {

                    1 -> Intent(this@HomeActivity, Church::class.java)
                    2 -> Intent(this@HomeActivity, Ministery::class.java)
                    3 -> Intent(this@HomeActivity, Bible::class.java)
                    4 -> Intent(this@HomeActivity, WhatsApp::class.java)
                    5 -> Intent(this@HomeActivity, Groups::class.java)
                    6 -> Intent(this@HomeActivity, Calendar::class.java)
                    7 -> Intent(this@HomeActivity, Volunter::class.java)
                    8 -> Intent(this@HomeActivity, ADBSocial::class.java)
                    9 -> Intent(this@HomeActivity, Donation::class.java)

                    else -> null

                }

                startActivity(intent)

            }
        }
        )
        RvServices.setHasFixedSize(true)
        RvServices.adapter = Adapter
        getServices()








//teste123
        binding.Count.setOnClickListener {

            startAcountActivity()

        }
        binding.settings.setOnClickListener {

            startSettingsActivity()

        }
        binding.ArrowDown.setOnClickListener {

            startNextScreenActivity()

        }

    }

    private fun startSettingsActivity() {

        val intent = Intent(this, Settings::class.java)
        startActivity(intent)


    }

    private fun startAcountActivity() {

        val intent = Intent(this, Account::class.java)
        startActivity(intent)


    }

    private fun startNextScreenActivity() {

        val intent = Intent(this, Home2::class.java)
        startActivity(intent)


    }


    fun getServices() {

        val service1 = Services(1, R.drawable.baseline_church_24, "   A Igreja")
        ListServices.add(service1)

        val service2 = Services(2, R.drawable.baseline_local_fire_department_24, "Ministérios")
        ListServices.add(service2)

        val service3 = Services(3, R.drawable.biblia, "     Bíblia")
        ListServices.add(service3)

        val service4 = Services(4, R.drawable.wpp, "Whatsapp")
        ListServices.add(service4)

        val service5 = Services(5, R.drawable.groups, "     Grupos")
        ListServices.add(service5)

        val service6 = Services(6, R.drawable.baseline_calendar_month_24, "Calendário")
        ListServices.add(service6)

        val service7 = Services(7, R.drawable.serigreja, "Voluntários")
        ListServices.add(service7)

        val service8 = Services(8, R.drawable.abraco, "ADB Social")
        ListServices.add(service8)

        val service9 = Services(9, R.drawable.doacao, "  Doação")
        ListServices.add(service9)
    }

}