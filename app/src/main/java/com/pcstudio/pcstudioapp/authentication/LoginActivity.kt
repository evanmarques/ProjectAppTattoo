package com.pcstudio.pcstudioapp.authentication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pcstudio.pcstudioapp.HomeActivity
import com.pcstudio.pcstudioapp.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val buttonBack = findViewById<ImageButton>(R.id.button_back_login)
        val editTextEmail = findViewById<EditText>(R.id.edit_text_email)
        val editTextPassword = findViewById<EditText>(R.id.edit_text_password)
        val buttonLogin = findViewById<Button>(R.id.button_login)
        val textViewRegisterLink = findViewById<TextView>(R.id.text_view_register_link)
        val textViewForgotPassword = findViewById<TextView>(R.id.text_view_forgot_password)

        buttonBack.setOnClickListener {
            finish() // Ação de voltar
        }

        buttonLogin.setOnClickListener {
            // Lógica de login (simulada)
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        textViewRegisterLink.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        // AÇÃO DO BOTÃO "ESQUECI A SENHA"
        textViewForgotPassword.setOnClickListener {
            // Inicia a nova tela de recuperação de senha
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }
    }
}