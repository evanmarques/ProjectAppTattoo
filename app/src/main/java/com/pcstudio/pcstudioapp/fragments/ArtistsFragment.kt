package com.pcstudio.pcstudioapp.fragments

// Importações de classes do Android que nosso Fragment precisa para funcionar.
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pcstudio.pcstudioapp.R

/**
 * @class ArtistsFragment
 * @brief A classe que controla a lógica da tela (Fragment) de Artistas.
 *
 * Esta classe herda de 'androidx.fragment.app.Fragment' e será responsável
 * por exibir a lista de artistas e estúdios disponíveis.
 */
class ArtistsFragment : Fragment() {

    /**
     * @brief Método chamado pelo Android para o Fragment desenhar sua interface.
     *
     * A função deste método é "inflar" (criar) a aparência do Fragment a partir
     * do nosso arquivo de layout XML 'fragment_artists.xml'.
     *
     * @return A View raiz da interface do Fragment.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Usa o inflater para criar a view a partir do nosso novo layout.
        return inflater.inflate(R.layout.fragment_artists, container, false)
    }
}