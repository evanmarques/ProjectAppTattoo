package com.pcstudio.pcstudioapp

// Importações de componentes do Android
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
// Importação da classe base 'Fragment' do AndroidX
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
// Importação dos nossos dois Fragments que já foram criados
import com.pcstudio.pcstudioapp.fragments.ArtistsFragment
import com.pcstudio.pcstudioapp.fragments.HomeFragment

/**
 * @class HomeActivity
 * @brief Activity principal que gerencia a navegação e a exibição dos Fragments.
 */
class HomeActivity : AppCompatActivity() {

    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottomNav = findViewById(R.id.bottom_navigation)

        // Configura o "ouvinte" de cliques para a barra de navegação.
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                // Caso o item "Início" seja clicado...
                R.id.nav_bottom_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                // --- ALTERAÇÃO AQUI ---
                // Caso o item "Artistas" seja clicado...
                R.id.nav_bottom_artists -> {
                    // ...agora carregamos o nosso novo ArtistsFragment.
                    // A mensagem Toast foi substituída.
                    loadFragment(ArtistsFragment())
                    true
                }
                // ---------------------
                R.id.nav_bottom_appointments -> {
                    // Mantemos a mensagem temporária para as seções ainda não criadas.
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

        // Garante que o HomeFragment seja carregado como tela padrão ao abrir o app
        if (savedInstanceState == null) {
            bottomNav.selectedItemId = R.id.nav_bottom_home
        }
    }

    /**
     * @brief Função auxiliar para carregar um Fragment no contêiner da tela.
     * @param fragment O Fragment que desejamos exibir.
     */
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
    }
}