package com.pcstudio.pcstudioapp.authentication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton // Importação necessária
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pcstudio.pcstudioapp.R

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // --- Referências aos componentes ---
        val buttonBack = findViewById<ImageButton>(R.id.button_back_register)
        val editTextFullName = findViewById<EditText>(R.id.edit_text_full_name)
        val editTextRegisterEmail = findViewById<EditText>(R.id.edit_text_register_email)
        val editTextRegisterPassword = findViewById<EditText>(R.id.edit_text_register_password)
        val editTextConfirmPassword = findViewById<EditText>(R.id.edit_text_confirm_password)
        val buttonRegisterAccount = findViewById<Button>(R.id.button_register_account)
        val textViewAlreadyHaveAccount = findViewById<TextView>(R.id.text_view_already_have_account)

        // --- Configuração dos Listeners ---

        // AÇÃO DO BOTÃO VOLTAR
        buttonBack.setOnClickListener {
            finish() // Fecha a tela atual e volta para a anterior
        }

        // AÇÃO DO BOTÃO REGISTRAR CONTA
        buttonRegisterAccount.setOnClickListener {
            val fullName = editTextFullName.text.toString().trim()
            val email = editTextRegisterEmail.text.toString().trim()
            val password = editTextRegisterPassword.text.toString().trim()
            val confirmPassword = editTextConfirmPassword.text.toString().trim()

            if (fullName.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
                if (password == confirmPassword) {
                    Toast.makeText(this, "Cadastro efetuado com sucesso!", Toast.LENGTH_LONG).show()

                    // =====================================================================
                    // NAVEGAÇÃO AUTOMÁTICA PARA A TELA DE LOGIN APÓS CADASTRO
                    // 1. Cria a intenção de ir para a LoginActivity.
                    // 2. Adiciona flags para limpar a pilha de navegação e criar uma nova tarefa.
                    //    Isso impede que o usuário volte para a tela de cadastro ao apertar "voltar" no login.
                    // 3. Inicia a tela de login.
                    // =====================================================================
                    val intent = Intent(this, LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)

                } else {
                    Toast.makeText(this, "As senhas não coincidem.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            }
        }

        // AÇÃO DO LINK "JÁ TEM CONTA?"
        textViewAlreadyHaveAccount.setOnClickListener {
            // Simplesmente fecha esta tela para retornar à de Login que já está aberta por baixo.
            finish()
        }
    }
}