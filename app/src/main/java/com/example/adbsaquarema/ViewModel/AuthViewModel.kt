package com.example.adbsaquarema.ViewModel

import android.widget.CheckBox
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adbsaquarema.Listenners.AuthListeners
import com.example.adbsaquarema.Repository.RepositoryAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AuthViewModel @Inject constructor(private val repositoryAuth: RepositoryAuth) : ViewModel() {


    fun createUser(
        email: String,
        name: String,
        phone: String,
        password: String,
        member:String,
        volunter:String,
        visited: String,
        privacy: CheckBox,
        listeners: AuthListeners
    ) {

        viewModelScope.launch {

            repositoryAuth.createUser(email, name, phone, password, member, volunter, visited, privacy, listeners)

        }
    }

    fun loginUser(email: String, password: String, listeners: AuthListeners){

        viewModelScope.launch {

            repositoryAuth.loginUser(email, password, listeners)

        }
    }

    fun forgotPassword(password: String, listeners: AuthListeners){

        viewModelScope.launch {

            repositoryAuth.forgotPassword(password, listeners)

        }
    }
}