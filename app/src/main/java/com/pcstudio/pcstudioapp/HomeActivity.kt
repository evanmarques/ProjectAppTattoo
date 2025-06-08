package com.pcstudio.pcstudioapp

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem // Importe para lidar com cliques de menu
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle // Para o botão do menu lateral
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout // Para a classe DrawerLayout
import androidx.appcompat.widget.Toolbar // Para a Toolbar

import com.google.android.material.navigation.NavigationView // Para o menu lateral

/**
 * @class HomeActivity
 * @brief Activity principal do aplicativo PC Studio com navegação lateral (Drawer Layout).
 *
 * Esta Activity exibe a tela principal do aplicativo e incorpora um DrawerLayout
 * para gerenciar a navegação entre diferentes seções (Home, Portfólio, Agendamentos, etc.).
 *
 * @extends AppCompatActivity
 */
class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout // Referência ao DrawerLayout
    private lateinit var navigationView: NavigationView // Referência ao NavigationView
    private lateinit var toolbar: Toolbar // Referência à Toolbar

    /**
     * @brief Método chamado quando a HomeActivity é criada pela primeira vez.
     *
     * Configura o layout visual da tela principal, inicializa o DrawerLayout,
     * a Toolbar e os listeners de navegação.
     *
     * @param savedInstanceState Um objeto Bundle contendo o estado anteriormente salvo da Activity.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        // Remove a barra de título padrão para usar a Toolbar personalizada.
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)

        super.onCreate(savedInstanceState)
        // Define o layout XML para esta Activity.
        setContentView(R.layout.activity_home)

        // Inicializa as Views do layout
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)
        toolbar = findViewById(R.id.toolbar)

        // Configura a Toolbar como a ActionBar da Activity
        setSupportActionBar(toolbar)

        // Configura o ActionBarDrawerToggle para sincronizar o estado do drawer
        // e exibir o ícone de "hamburguer" na Toolbar.
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open, // String para acessibilidade ao abrir
            R.string.navigation_drawer_close // String para acessibilidade ao fechar
        )
        drawerLayout.addDrawerListener(toggle) // Adiciona o listener para o drawer
        toggle.syncState() // Sincroniza o estado inicial do toggle

        // Define o listener para os itens do menu de navegação
        navigationView.setNavigationItemSelectedListener(this)

        // No futuro, a lógica para exibir o conteúdo principal do app será adicionada aqui.
        // Ex: carregar dados do usuário, exibir lista de tatuadores, etc.
    }

    /**
     * @brief Callback para quando um item no NavigationView é selecionado.
     *
     * @param item O MenuItem que foi selecionado.
     * @return true se o item foi tratado, false caso contrário.
     */
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Fecha o drawer quando um item é clicado
        drawerLayout.closeDrawers()

        when (item.itemId) {
            R.id.nav_home -> {
                Toast.makeText(this, "Você está no Home", Toast.LENGTH_SHORT).show()
                // Lógica para exibir a tela Home (se for diferente do conteúdo padrão)
                return true
            }
            R.id.nav_portfolio -> {
                Toast.makeText(this, "Abrir Portfólio", Toast.LENGTH_SHORT).show()
                // Lógica para abrir a tela de Portfólio
                return true
            }
            R.id.nav_appointments -> {
                Toast.makeText(this, "Abrir Agendamentos", Toast.LENGTH_SHORT).show()
                // Lógica para abrir a tela de Agendamentos
                return true
            }
            R.id.nav_artists -> {
                Toast.makeText(this, "Castro de pessoas", Toast.LENGTH_SHORT).show()
                // Lógica para abrir a tela de Artistas
                return true
            }
            R.id.nav_logout -> {
                // Lógica para deslogar o usuário e voltar para a tela de login
                Toast.makeText(this, "Saindo...", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, com.pcstudio.pcstudioapp.authentication.LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK // Limpa a pilha de Activities
                startActivity(intent)
                finish()
                return true
            }
            else -> return false
        }
    }

    /**
     * @brief Trata o evento de pressionar o botão "Voltar".
     *
     * Se o drawer estiver aberto, o botão Voltar o fecha.
     * Caso contrário, comporta-se como o botão Voltar padrão (fecha a Activity).
     */
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(navigationView)) {
            drawerLayout.closeDrawer(navigationView)
        } else {
            super.onBackPressed()
        }
    }
}