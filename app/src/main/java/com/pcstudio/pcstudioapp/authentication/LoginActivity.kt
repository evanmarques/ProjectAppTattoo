package com.pcstudio.pcstudioapp.authentication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton // Importação necessária
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pcstudio.pcstudioapp.HomeActivity
import com.pcstudio.pcstudioapp.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // --- Referências aos componentes ---
        val buttonBack = findViewById<ImageButton>(R.id.button_back_login)
        val editTextEmail = findViewById<EditText>(R.id.edit_text_email)
        val editTextPassword = findViewById<EditText>(R.id.edit_text_password)
        val buttonLogin = findViewById<Button>(R.id.button_login)
        val textViewRegisterLink = findViewById<TextView>(R.id.text_view_register_link)

        // --- Configuração dos Listeners ---

        // AÇÃO DO BOTÃO VOLTAR
        buttonBack.setOnClickListener {
            finish() // Fecha a tela atual e volta para a anterior (MainActivity)
        }

        // AÇÃO DO BOTÃO ENTRAR
        buttonLogin.setOnClickListener {
            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                Toast.makeText(this, "Login efetuado com sucesso (simulado)!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            }
        }

        // AÇÃO DO LINK DE CADASTRO
        textViewRegisterLink.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}