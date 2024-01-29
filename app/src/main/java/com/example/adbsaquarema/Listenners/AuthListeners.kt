package com.example.adbsaquarema.Listenners

interface AuthListeners {

    fun onSuccess(mensage: String, screen: String)
    fun onFailure(error: String)


}