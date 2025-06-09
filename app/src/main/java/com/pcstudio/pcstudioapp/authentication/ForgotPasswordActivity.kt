package com.pcstudio.pcstudioapp.authentication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pcstudio.pcstudioapp.R

class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        val buttonBack = findViewById<ImageButton>(R.id.button_back_forgot)
        val buttonSend = findViewById<Button>(R.id.button_send_recovery)

        buttonBack.setOnClickListener {
            finish()
        }

        buttonSend.setOnClickListener {
            // A lógica real (com Firebase, etc.) viria aqui.
            // Por enquanto, apenas simulamos.
            Toast.makeText(this, "Link de recuperação enviado (simulado)!", Toast.LENGTH_LONG).show()
            finish() // Fecha a tela após a ação
        }
    }
}