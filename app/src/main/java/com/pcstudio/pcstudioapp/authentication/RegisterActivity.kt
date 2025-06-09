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
        setContentView(R.layout.activity_register)

        // --- Referências aos componentes do layout ---
        val buttonBack = findViewById<ImageButton>(R.id.button_back_register)
        val buttonRegisterAccount = findViewById<Button>(R.id.button_register_account)
        val textViewAlreadyHaveAccount = findViewById<TextView>(R.id.text_view_already_have_account)

        // --- Lógica de Cliques ---

        // Lógica para o novo botão de seta para voltar
        buttonBack.setOnClickListener {
            finish() // Fecha a tela de cadastro e volta para a de login
        }

        // Lógica para o botão principal de registro
        buttonRegisterAccount.setOnClickListener {
            // Lógica de validação aqui...
            Toast.makeText(this, "Cadastro efetuado com sucesso!", Toast.LENGTH_LONG).show()
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        // Lógica para o link de texto "Já tem uma conta?"
        textViewAlreadyHaveAccount.setOnClickListener {
            finish() // Também fecha a tela e volta para a de login
        }
    }
}