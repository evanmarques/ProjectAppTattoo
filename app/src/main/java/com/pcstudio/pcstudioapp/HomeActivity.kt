package com.pcstudio.pcstudioapp

// Importações de componentes do Android que vamos usar.
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * @class HomeActivity
 * @brief Activity principal do app que agora usa uma BottomNavigationView para a navegação.
 *
 * Esta tela serve como o contêiner principal e gerencia a navegação
 * entre as seções de Início, Artistas, Agenda e Perfil, que serão implementadas
 * como Fragments no futuro.
 */
class HomeActivity : AppCompatActivity() {

    // Declaração da variável para a nossa barra de navegação inferior.
    // 'private' significa que só pode ser acessada dentro desta classe.
    // 'lateinit var' significa que prometemos inicializá-la depois (no onCreate).
    private lateinit var bottomNav: BottomNavigationView

    /**
     * @brief Método chamado pelo Android quando a Activity é criada pela primeira vez.
     * É aqui que toda a configuração inicial da tela acontece.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        // super.onCreate() é uma chamada obrigatória ao construtor da classe pai (AppCompatActivity).
        super.onCreate(savedInstanceState)
        // setContentView() infla (desenha) o nosso layout XML na tela, tornando-o visível.
        setContentView(R.layout.activity_home)

        // --- Conectando o Código com o Layout ---
        // Usamos findViewById para encontrar a nossa BottomNavigationView que definimos no XML
        // através do seu ID e atribuímos à nossa variável 'bottomNav'.
        bottomNav = findViewById(R.id.bottom_navigation)

        // --- Configurando o Listener de Cliques ---
        // setOnItemSelectedListener é um "ouvinte" que fica esperando o usuário clicar em um item da barra.
        // O bloco de código a seguir { ... } é executado sempre que um clique acontece.
        // 'item' é o item específico que foi clicado.
        bottomNav.setOnItemSelectedListener { item ->
            // A estrutura 'when' (similar ao switch) verifica o ID do item clicado.
            when (item.itemId) {
                // Caso o ID seja o do item 'Início' que definimos no menu XML...
                R.id.nav_bottom_home -> {
                    // Por enquanto, mostramos uma mensagem temporária na tela.
                    // Futuramente, aqui trocaremos o Fragment no 'fragment_container'.
                    Toast.makeText(this, "Início Clicado", Toast.LENGTH_SHORT).show()
                    // É obrigatório retornar 'true' para indicar ao sistema que o clique foi tratado.
                    true
                }
                R.id.nav_bottom_artists -> {
                    Toast.makeText(this, "Artistas Clicado", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_bottom_appointments -> {
                    Toast.makeText(this, "Agenda Clicada", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_bottom_profile -> {
                    Toast.makeText(this, "Perfil Clicado", Toast.LENGTH_SHORT).show()
                    true
                }
                // 'else' é o caso padrão, se nenhum ID conhecido for clicado.
                else -> false
            }
        }

        // --- Definindo o Item Padrão ---
        // Esta condição 'if' garante que o código só será executado na primeira vez que a tela é criada.
        // Se a tela for recriada (ex: ao girar o celular), o item que já estava selecionado será mantido.
        if (savedInstanceState == null) {
            // Define o item "Início" como o selecionado por padrão ao abrir o aplicativo.
            bottomNav.selectedItemId = R.id.nav_bottom_home
        }
    }
}