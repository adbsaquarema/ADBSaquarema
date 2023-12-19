package com.example.adbsaquarema.Data

data class Users(
    val name: String = "",
    val email: String = "",
    val telephone: String = "",
    val Voluntário: Boolean = false,
    val Visitante: Boolean = false,
    val Membro: Boolean = false
) {
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "name" to name,
            "email" to email,
            "telephone" to telephone,
            "Membro" to Membro,
            "Visitante" to Visitante,
            "Voluntário" to Voluntário,

        )
    }
}