package com.example.adbsaquarema.Authentication

import android.widget.CheckBox
import com.example.adbsaquarema.Listenners.AuthListeners
import com.example.adbsaquarema.UI.ForgotPassword
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class Auth @Inject constructor() {

    private val auth = FirebaseAuth.getInstance()
    private val firestore = FirebaseFirestore.getInstance()

    fun createUser(
        email: String,
        name: String,
        phone: String,
        password: String,
        member: String,
        volunter:String,
        visited: String,
        privacy: CheckBox,
        listeners: AuthListeners
    ) {

        if (email.isEmpty() || name.isEmpty() || phone.isEmpty() || password.isEmpty() || member.isEmpty() || volunter.isEmpty() || visited.isEmpty()) {


            listeners.onFailure("Erro ao Cadastrar Usuário.")


        }else if(privacy.isChecked){

            auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{

                if (it.isSuccessful){

                    var id = FirebaseAuth.getInstance().currentUser?.uid.toString()
                    val userMap = hashMapOf(
                        "email" to email,
                        "nome" to name,
                        "telefone" to phone,
                        "membro" to member,
                        "voluntário" to volunter,
                        "visitante" to visited
                    )

                    firestore.collection("Users").document(id).set(userMap)
                        .addOnCompleteListener {

                            listeners.onSuccess("Sucesso ao Cadastrar Usuário.","HomeActivit")

                        }.addOnFailureListener{

                            listeners.onFailure("Server Error.")

                        }
                }
            }.addOnFailureListener {

                val errorMessage = when (it) {
                    is FirebaseAuthWeakPasswordException -> "Digite uma senha com pelo menos 6 caracteres."
                    is FirebaseAuthInvalidCredentialsException -> "Digite um email válido."
                    is FirebaseAuthUserCollisionException -> "Este email já está em uso."
                    is FirebaseNetworkException -> "Sem conexão com a internet."
                    else -> "Erro ao cadastrar usuário."
                }
                listeners.onFailure(errorMessage)
            }
        }else{

            listeners.onFailure("Aceite os termos de privacidade.")

        }
    }

    fun loginUser(email: String, password: String, listeners: AuthListeners){

        if(email.isEmpty() || password.isEmpty()){


            listeners.onFailure("Preencha todos os campos.")

        }else{

            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener{

                listeners.onSuccess("Login Efetuado com Sucesso.", "HomeActivity")

            }.addOnFailureListener {

                val errorMessage = when (it) {
                    is FirebaseAuthInvalidCredentialsException -> "Senha inválida."
                    is FirebaseAuthInvalidUserException -> "E-mail inválido."
                    is FirebaseNetworkException -> "Sem conexão com a internet."
                    else -> "Erro de servidor."
                }

                listeners.onFailure(errorMessage)

            }
        }
    }

    fun forgotPassword(password: String, listeners: AuthListeners){

        auth.sendPasswordResetEmail(password).addOnCompleteListener {

            listeners.onSuccess("Verifique seu E-mail", "LoginScreen")

        }.addOnFailureListener{

            listeners.onFailure("Server Error.")

        }
    }
}






// high Order funcion