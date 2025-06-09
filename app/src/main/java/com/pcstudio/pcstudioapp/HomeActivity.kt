package com.pcstudio.pcstudioapp

// Importações de componentes do Android
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
// Importação da classe base 'Fragment' do AndroidX, necessária para nossa função loadFragment.
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
// Importação da nossa classe HomeFragment, que criamos na pasta 'fragments'.
import com.pcstudio.pcstudioapp.fragments.HomeFragment

/**
 * @class HomeActivity
 * @brief Versão final da Activity principal, agora responsável por gerenciar e exibir Fragments.
 */
class HomeActivity : AppCompatActivity() {

    // Declaração da variável para a nossa barra de navegação inferior.
    private lateinit var bottomNav: BottomNavigationView

    /**
     * @brief Método chamado pelo Android quando a Activity é criada.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Vincula esta classe ao seu layout, que contém o contêiner de Fragment e a barra de navegação.
        setContentView(R.layout.activity_home)

        // Encontra a BottomNavigationView no layout pelo seu ID.
        bottomNav = findViewById(R.id.bottom_navigation)

        // Configura o "ouvinte" de cliques para a barra de navegação.
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                // Caso o item "Início" seja clicado...
                R.id.nav_bottom_home -> {
                    // ...agora chamamos nossa nova função para carregar o HomeFragment na tela.
                    loadFragment(HomeFragment())
                    true // Retorna true para indicar que o clique foi tratado.
                }
                R.id.nav_bottom_artists -> {
                    // As outras seções ainda não têm Fragments, então mantemos a mensagem.
                    Toast.makeText(this, "Tela de Artistas em breve", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_bottom_appointments -> {
                    Toast.makeText(this, "Tela de Agenda em breve", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_bottom_profile -> {
                    Toast.makeText(this, "Tela de Perfil em breve", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        // --- Carregamento do Fragment Inicial ---
        // A condição 'if (savedInstanceState == null)' é uma boa prática. Ela garante que
        // o Fragment inicial só seja carregado na primeira vez que a Activity é criada,
        // evitando recarregamentos desnecessários (ex: ao girar a tela).
        if (savedInstanceState == null) {
            // Define o item "Início" como o selecionado por padrão na barra de navegação
            // e carrega o HomeFragment para ser a primeira coisa que o usuário vê.
            bottomNav.selectedItemId = R.id.nav_bottom_home
        }
    }

    /**
     * @brief Função auxiliar, privada e reutilizável para carregar um Fragment no contêiner.
     *
     * Criamos esta função para não repetir o mesmo código para cada item do menu.
     * Ela recebe um Fragment como parâmetro e o insere no nosso 'fragment_container'.
     *
     * @param fragment A instância do Fragment que queremos exibir (ex: HomeFragment()).
     */
    private fun loadFragment(fragment: Fragment) {
        // 'supportFragmentManager' é o gerenciador de Fragments nativo do Android.
        // 'beginTransaction()' inicia uma "transação", que é uma série de operações a serem executadas.
        supportFragmentManager.beginTransaction().apply {
            // A operação 'replace' é a mais comum. Ela remove qualquer fragmento que esteja
            // atualmente no contêiner e adiciona o novo que foi passado como parâmetro.
            // - R.id.fragment_container: O ID do nosso FrameLayout no arquivo activity_home.xml.
            // - fragment: A instância do Fragment a ser exibida.
            replace(R.id.fragment_container, fragment)

            // 'commit()' finaliza a transação e efetivamente aplica a mudança na tela.
            commit()
        }
    }
}