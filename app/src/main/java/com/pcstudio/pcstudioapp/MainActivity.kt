package com.pcstudio.pcstudioapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.pcstudio.pcstudioapp.authentication.BusinessRegisterActivity // IMPORTAR
import com.pcstudio.pcstudioapp.authentication.LoginActivity
import com.pcstudio.pcstudioapp.authentication.RegisterActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val btnLogin: Button = findViewById(R.id.btn_login_welcome)
        val btnRegister: Button = findViewById(R.id.btn_register_welcome)
        val tvStudioContact: TextView = findViewById(R.id.tv_studio_contact)

        btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        // AÇÃO DO LINK "CADASTRE SEU NEGÓCIO"
        tvStudioContact.setOnClickListener {
            // Abre a nova tela de cadastro de negócio
            val intent = Intent(this, BusinessRegisterActivity::class.java)
            startActivity(intent)
        }
    }
}