package com.pcstudio.pcstudioapp.authentication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pcstudio.pcstudioapp.R

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // O layout activity_register.xml precisa ter o ImageButton com id button_back_register
        setContentView(R.layout.activity_register)

        val buttonBack = findViewById<ImageButton>(R.id.button_back_register)
        val buttonRegisterAccount = findViewById<Button>(R.id.button_register_account)
        val textViewAlreadyHaveAccount = findViewById<TextView>(R.id.text_view_already_have_account)

        buttonBack.setOnClickListener {
            finish() // Ação de voltar
        }

        // AÇÃO DO BOTÃO "REGISTRAR"
        buttonRegisterAccount.setOnClickListener {
            // Simulação de validação
            Toast.makeText(this, "Cadastro efetuado com sucesso!", Toast.LENGTH_LONG).show()

            // REDIRECIONAMENTO PARA A TELA DE LOGIN
            val intent = Intent(this, LoginActivity::class.java)
            // Limpa a pilha de navegação para o usuário não voltar para a tela de cadastro
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        textViewAlreadyHaveAccount.setOnClickListener {
            finish() // Volta para a tela de login
        }
    }
}