package com.pcstudio.pcstudioapp.fragments

// Importações necessárias para Fragments e manipulação de layouts.
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pcstudio.pcstudioapp.R

/**
 * @class HomeFragment
 * @brief Um Fragment que representa a tela de "Início" do aplicativo.
 *
 * Esta classe é responsável por carregar e gerenciar a interface do usuário
 * da tela principal, que inclui a busca e, futuramente, a lista de estúdios.
 * Ela herda de 'androidx.fragment.app.Fragment', que é a classe base para todos os Fragments.
 */
class HomeFragment : Fragment() {

    /**
     * @brief Método chamado pelo Android para criar a view (aparência) do Fragment.
     *
     * Este é um dos métodos mais importantes do ciclo de vida de um Fragment.
     * É aqui que nós pegamos nosso arquivo de layout XML (fragment_home.xml)
     * e o transformamos em objetos visuais na tela.
     *
     * @param inflater O objeto usado para "inflar" (criar) o layout a partir do XML.
     * @param container O layout "pai" onde este Fragment será inserido (no nosso caso, o FrameLayout da HomeActivity).
     * @param savedInstanceState Dados salvos de uma instância anterior, se houver.
     * @return A View raiz do layout do nosso Fragment.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // O método 'inflater.inflate()' faz a mágica de ler o XML e criar a interface.
        // - R.layout.fragment_home: O ID do nosso arquivo de layout.
        // - container: Onde a view deve ser inserida.
        // - false: Indica que o processo de inflar não deve anexar a view ao 'container' ainda; o sistema fará isso.
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}