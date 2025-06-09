package com.pcstudio.pcstudioapp.fragments

// Importações de classes do Android que nosso Fragment precisa para funcionar.
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pcstudio.pcstudioapp.R

/**
 * @class HomeFragment
 * @brief A classe que controla a lógica da tela (Fragment) de Início.
 *
 * Esta classe herda de 'androidx.fragment.app.Fragment'. Isso significa que ela
 * é um componente de interface reutilizável com seu próprio ciclo de vida,
 * destinado a ser hospedado dentro de uma Activity (a nossa HomeActivity).
 */
class HomeFragment : Fragment() {

    /**
     * @brief Método fundamental do ciclo de vida de um Fragment.
     *
     * O sistema Android chama este método quando chega a hora do Fragment desenhar
     * sua interface pela primeira vez. Nossa única responsabilidade aqui é criar
     * e retornar a View (a aparência) do nosso Fragment.
     *
     * @param inflater Um objeto que sabe como "inflar" (ou seja, ler um arquivo XML e
     * criar os objetos de View correspondentes na memória).
     * @param container O layout "pai" no qual a interface deste Fragment será inserida.
     * No nosso caso, é o FrameLayout 'fragment_container' da HomeActivity.
     * @param savedInstanceState Se o Fragment estiver sendo recriado a partir de um
     * estado salvo anteriormente, este Bundle contém os dados.
     * @return A View raiz da interface do Fragment, que será exibida na tela.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // A linha mais importante:
        // inflater.inflate() é o método que faz o trabalho de criar a View.
        // - R.layout.fragment_home: É o ID do nosso arquivo de layout que criamos no passo anterior.
        // - container: É o ViewGroup onde este layout será inserido.
        // - false: Um parâmetro técnico que diz ao inflater para não anexar a view ao
        //          container ainda (a transação de fragment fará isso).
        // O resultado (a View criada) é retornado para que o sistema possa exibi-la.
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}