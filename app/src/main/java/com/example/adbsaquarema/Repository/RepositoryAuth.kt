package com.example.adbsaquarema.Repository

import android.widget.CheckBox
import com.example.adbsaquarema.Authentication.Auth
import com.example.adbsaquarema.Listenners.AuthListeners
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class RepositoryAuth @Inject constructor(private val auth: Auth) {

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

        auth.createUser(
            email = email,
            name = name,
            phone = phone,
            password = password,
            member = member,
            volunter = volunter,
            visited = visited,
            privacy = privacy,
            listeners = listeners
        )
    }

    fun loginUser(email: String, password: String, listeners: AuthListeners){

        auth.loginUser(email, password, listeners)

    }


    fun forgotPassword(password: String, listeners: AuthListeners){

        auth.forgotPassword(password, listeners)

    }




}