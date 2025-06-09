package com.pcstudio.pcstudioapp.authentication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pcstudio.pcstudioapp.R

class BusinessRegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_business_register)

        val buttonBack = findViewById<ImageButton>(R.id.button_back_business)
        val buttonSend = findViewById<Button>(R.id.button_send_business_request)

        buttonBack.setOnClickListener {
            finish()
        }

        buttonSend.setOnClickListener {
            // A lógica real (enviar para um banco de dados, API, etc.) viria aqui.
            Toast.makeText(this, "Solicitação enviada! Entraremos em contato.", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}