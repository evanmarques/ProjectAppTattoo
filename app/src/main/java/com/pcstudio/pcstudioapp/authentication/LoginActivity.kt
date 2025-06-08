package com.pcstudio.pcstudioapp.authentication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pcstudio.pcstudioapp.R
import com.pcstudio.pcstudioapp.HomeActivity // <--- ADICIONE ESTA LINHA!

/**
 * @class LoginActivity
 * ...
 */

/**
 * Activity responsável pela tela de Login do aplicativo PC Studio.
 * Gerencia a interface do usuário de login, interage com os campos de entrada,
 * e lida com as ações dos botões "Entrar" e "Criar Conta".
 */

class LoginActivity : AppCompatActivity() {

    // =====================================================================
    // Método onCreate: Chamado quando a Activity é criada pela primeira vez.
    // É o ponto principal onde você inicializa o layout da sua UI
    // e configura os componentes.
    // =====================================================================

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Chama a implementação da superclasse (AppCompatActivity)
        setContentView(R.layout.activity_login) // Associa o layout XML (activity_login.xml) a esta Activity.
        // Isso "infla" o layout, criando as Views na memória.

        // =====================================================================
        // Referenciando os Componentes da UI do Layout XML (activity_login.xml)
        // Usamos 'findViewById<TipoDeView>(R.id.id_do_componente)' para obter
        // uma referência programática para os elementos que definimos no XML.
        // =====================================================================

        val editTextEmail = findViewById<EditText>(R.id.edit_text_email)         // Campo de texto para o email
        val editTextPassword = findViewById<EditText>(R.id.edit_text_password)   // Campo de texto para a senha
        val buttonLogin = findViewById<Button>(R.id.button_login)                // Botão "Entrar"
        val buttonRegister = findViewById<Button>(R.id.button_register)          // Botão "Criar Conta"
        val textViewForgotPassword = findViewById<TextView>(R.id.text_view_forgot_password) // Link "Esqueceu a senha?"



        // =====================================================================
        // Configurando Click Listeners (Ouvintes de Clique) para os Botões
        // Um click listener é um pedaço de código que será executado
        // quando o usuário tocar (clicar) em um determinado componente da UI.
        // =====================================================================

        // Listener para o Botão "Entrar"
        //buttonLogin.setOnClickListener {
        // Obter o texto digitado nos campos de email e senha
        //val email = editTextEmail.text.toString().trim() // .toString() converte para String, .trim() remove espaços em branco
        //val password = editTextPassword.text.toString().trim()

        // Simulação BÁSICA de validação e lógica de login
        // ATENÇÃO: Esta é apenas uma SIMULAÇÃO para fins de desenvolvimento.
        // A lógica de autenticação REAL com um backend (Firebase, API REST, etc.)
        // será implementada em etapas futuras e será MUITO mais robusta.
        //if (email.isNotEmpty() && password.isNotEmpty()) {
        // Por enquanto, apenas exibe uma mensagem de sucesso
        //Toast.makeText(this, "Login efetuado com sucesso (simulado)!", Toast.LENGTH_SHORT).show()
        // Futuramente, aqui você navegará para a tela principal (HomeActivity)
        // val intent = Intent(this, HomeActivity::class.java)
        // startActivity(intent)
        // finish() // Fecha a tela de login para que o usuário não possa voltar a ela pressionando o botão "Voltar"
        //} else {
        // Exibe uma mensagem de erro se os campos estiverem vazios
        //Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
        //}
        //}

        buttonLogin.setOnClickListener {
            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                Toast.makeText(this, "Login efetuado com sucesso (simulado)!", Toast.LENGTH_SHORT).show()

                // =========================================================
                // NAVEGAR PARA A HOMEACTIVITY APÓS LOGIN BEM-SUCEDIDO
                // =========================================================
                val intent = Intent(this, HomeActivity::class.java) // Cria uma Intent para HomeActivity
                startActivity(intent) // Inicia a HomeActivity
                finish() // Fecha a LoginActivity para que o usuário não possa voltar a ela com o botão Voltar
            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            }
        }

        // Listener para o Botão "Criar Conta"
        buttonRegister.setOnClickListener {
            // Cria um Intent para navegar da LoginActivity para a RegisterActivity.
            // Um Intent é uma "intenção" de realizar uma operação, neste caso, iniciar uma nova tela.
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent) // Inicia a RegisterActivity
            // Não usamos finish() aqui porque o usuário pode querer voltar para a tela de login
            // se ele desistir do cadastro.
        }

        // Listener para o Link "Esqueceu a senha?"
        textViewForgotPassword.setOnClickListener {
            // Por enquanto, apenas exibe uma mensagem indicando que a funcionalidade está em desenvolvimento.
            // Futuramente, aqui você navegará para uma tela de recuperação de senha.
            Toast.makeText(this, "Funcionalidade de recuperação de senha em desenvolvimento.", Toast.LENGTH_SHORT).show()
            // val intent = Intent(this, ForgotPasswordActivity::class.java)
            // startActivity(intent)
        }
    }
}