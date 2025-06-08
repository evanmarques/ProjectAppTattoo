package com.pcstudio.pcstudioapp.authentication

import android.content.Intent // Para iniciar novas Activities (navegação)
import android.os.Bundle // Para gerenciar o estado da Activity
import android.widget.Button // Para referenciar e manipular botões
import android.widget.EditText // Para referenciar e manipular campos de texto
import android.widget.TextView // Para referenciar e manipular textos
import android.widget.Toast // Para exibir mensagens curtas (pop-up)
import androidx.appcompat.app.AppCompatActivity // Classe base para Activity compatível
import com.pcstudio.pcstudioapp.R // Importa a classe R para acessar IDs dos recursos do layout

/**
 * @class RegisterActivity
 * @brief Activity responsável pela tela de Registro de Nova Conta do aplicativo PC Studio.
 *
 * Esta Activity permite que novos usuários insiram seus dados (nome, email, senha)
 * para criar uma nova conta no sistema. Ela também oferece uma opção para
 * retornar à tela de login.
 *
 * @extends AppCompatActivity
 */
class RegisterActivity : AppCompatActivity() {

    /**
     * @brief Método chamado quando a Activity é criada pela primeira vez.
     *
     * Este método é o ponto de inicialização para a tela de registro.
     * Ele carrega o layout XML correspondente e configura os listeners
     * para as interações do usuário.
     *
     * @param savedInstanceState Um objeto Bundle contendo o estado anteriormente salvo da Activity.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Chama a implementação da superclasse.

        // =====================================================================
        // CARREGAMENTO DO LAYOUT XML
        // Define o layout XML (activity_register.xml) que será exibido por esta Activity.
        // ESSA LINHA É A SOLUÇÃO PARA A TELA EM BRANCO!
        // =====================================================================
        setContentView(R.layout.activity_register)

        // =====================================================================
        // INICIALIZAÇÃO DE VIEWS - Referenciando Componentes do Layout
        // Encontra os elementos da UI definidos no XML (activity_register.xml)
        // usando seus IDs e armazena referências a eles.
        // =====================================================================
        val editTextFullName = findViewById<EditText>(R.id.edit_text_full_name)
        val editTextRegisterEmail = findViewById<EditText>(R.id.edit_text_register_email)
        val editTextRegisterPassword = findViewById<EditText>(R.id.edit_text_register_password)
        val editTextConfirmPassword = findViewById<EditText>(R.id.edit_text_confirm_password)
        val buttonRegisterAccount = findViewById<Button>(R.id.button_register_account)
        val textViewAlreadyHaveAccount = findViewById<TextView>(R.id.text_view_already_have_account)

        // =====================================================================
        // CONFIGURAÇÃO DE LISTENERS - Respostas a Interações do Usuário
        // Define o que acontece quando o usuário interage com os elementos da UI.
        // =====================================================================

        /**
         * @brief Configura o listener de clique para o Botão "Registrar".
         *
         * Quando o botão "Registrar" é clicado:
         * 1. Pega o texto digitado em todos os campos de registro.
         * 2. Realiza uma validação básica (campos não vazios e senhas coincidentes).
         * 3. Exibe uma mensagem de sucesso ou erro (simulada).
         * (No futuro, aqui será integrada a lógica de registro de usuário com um backend).
         */
        buttonRegisterAccount.setOnClickListener {
            val fullName = editTextFullName.text.toString().trim()
            val email = editTextRegisterEmail.text.toString().trim()
            val password = editTextRegisterPassword.text.toString().trim()
            val confirmPassword = editTextConfirmPassword.text.toString().trim()

            // Validação básica simulada
            if (fullName.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
                if (password == confirmPassword) {
                    Toast.makeText(this, "Cadastro efetuado com sucesso (simulado)!", Toast.LENGTH_LONG).show()
                    // Futuramente: Enviar dados para autenticação e navegar para tela principal/login
                    // val intent = Intent(this, LoginActivity::class.java) // Ou HomeActivity, dependendo do fluxo
                    // startActivity(intent)
                    // finish() // Fecha a tela de registro após o cadastro
                } else {
                    Toast.makeText(this, "As senhas não coincidem.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            }
        }

        /**
         * @brief Configura o listener de clique para o link "Já tem uma conta? Faça login".
         *
         * Quando este link é clicado:
         * 1. Navega de volta para a LoginActivity.
         * 2. Finaliza a RegisterActivity para que ela não fique na pilha de volta.
         */
        textViewAlreadyHaveAccount.setOnClickListener {
            // Ao invés de criar uma nova Intent para LoginActivity,
            // simplesmente chama finish() para fechar esta Activity e
            // retornar para a Activity anterior na pilha (que é a LoginActivity).
            finish()
        }
    }
}