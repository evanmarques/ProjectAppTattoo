package com.pcstudio.pcstudioapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.pcstudio.pcstudioapp.authentication.LoginActivity
import com.pcstudio.pcstudioapp.authentication.RegisterActivity
// Certifique-se de que R está corretamente importado, geralmente não precisa de import explícito se estiver no mesmo pacote.
// import com.pcstudio.pcstudioapp.R

/**
 * MainActivity: A Activity principal do aplicativo.
 * Esta tela serve como a porta de entrada para os usuários,
 * oferecendo opções para Login (Entrar) ou Registro (Cadastrar).
 * Também inclui uma opção para Studios interessados em listar seus negócios.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Define o layout da atividade principal para a tela de boas-vindas
        setContentView(R.layout.activity_main)

        // Esconde a barra de ação (ActionBar) para ter uma tela cheia mais limpa
        supportActionBar?.hide()

        // Referencia os elementos de UI do layout
        val btnLogin: Button = findViewById(R.id.btn_login_welcome)
        val btnRegister: Button = findViewById(R.id.btn_register_welcome)
        val tvStudioContact: TextView = findViewById(R.id.tv_studio_contact)

        // Configura o listener de clique para o botão "Entrar"
        btnLogin.setOnClickListener {
            // Ao clicar, inicia a LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        // Configura o listener de clique para o botão "Cadastrar"
        btnRegister.setOnClickListener {
            // Ao clicar, inicia a RegisterActivity
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        // Configura o listener de clique para o texto "É um Studio? Cadastre seu Negócio"
        tvStudioContact.setOnClickListener {
            // Esta seção pode ser expandida no futuro para uma Activity de contato específica.
            // Por enquanto, abre um cliente de e-mail para que o estúdio possa enviar uma mensagem.
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                // Define o URI do e-mail para quem o estúdio deve entrar em contato
                data = android.net.Uri.parse("mailto:contato@pcstudio.com.br") // Altere para o seu e-mail de contato
                // Assunto pré-definido para o e-mail
                putExtra(Intent.EXTRA_SUBJECT, "Interesse em Cadastrar Studio no App PC Studio")
                // Corpo pré-definido para o e-mail
                putExtra(Intent.EXTRA_TEXT, "Olá, gostaria de mais informações sobre como cadastrar meu estúdio de tatuagem no seu aplicativo.")
            }
            // Verifica se há um aplicativo que pode lidar com esta Intent de e-mail
            if (emailIntent.resolveActivity(packageManager) != null) {
                startActivity(emailIntent)
            } else {
                // Se não houver um aplicativo de e-mail, informa o usuário
                // Toast.makeText(this, "Nenhum aplicativo de e-mail encontrado.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}