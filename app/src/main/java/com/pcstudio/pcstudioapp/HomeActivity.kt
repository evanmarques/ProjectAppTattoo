package com.pcstudio.pcstudioapp

// Importação extra para a classe Fragment
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pcstudio.pcstudioapp.fragments.HomeFragment // Importa nosso novo Fragment

class HomeActivity : AppCompatActivity() {

    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottomNav = findViewById(R.id.bottom_navigation)

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                // Caso o ID seja o do item 'Início'...
                R.id.nav_bottom_home -> {
                    // Agora, em vez de um Toast, chamamos nossa nova função para carregar o HomeFragment.
                    loadFragment(HomeFragment())
                    true
                }
                R.id.nav_bottom_artists -> {
                    Toast.makeText(this, "Artistas Clicado", Toast.LENGTH_SHORT).show()
                    // Futuramente, aqui será: loadFragment(ArtistsFragment())
                    true
                }
                R.id.nav_bottom_appointments -> {
                    Toast.makeText(this, "Agenda Clicada", Toast.LENGTH_SHORT).show()
                    // Futuramente, aqui será: loadFragment(AppointmentsFragment())
                    true
                }
                R.id.nav_bottom_profile -> {
                    Toast.makeText(this, "Perfil Clicado", Toast.LENGTH_SHORT).show()
                    // Futuramente, aqui será: loadFragment(ProfileFragment())
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
     * @brief Função reutilizável para carregar um Fragment no contêiner da tela.
     *
     * @param fragment O Fragment que desejamos exibir.
     */
    private fun loadFragment(fragment: Fragment) {
        // supportFragmentManager é o gerenciador de Fragments da Activity.
        supportFragmentManager.beginTransaction().apply {
            // 'replace' remove qualquer fragment que esteja no contêiner e adiciona o novo.
            // - R.id.fragment_container: O ID do nosso FrameLayout no activity_home.xml.
            // - fragment: A instância do fragment a ser exibido (ex: HomeFragment).
            replace(R.id.fragment_container, fragment)
            // 'commit' finaliza a transação e aplica as mudanças na tela.
            commit()
        }
    }
}