package Principal;

import Cenarios.*;
import javax.swing.*;
import java.awt.*;

public class Interface extends JFrame {

    JPanel painel = new JPanel();

    public Interface(){
        setTitle("Senhor dos Arrays");
        setSize(1000,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        //telaInicial menu = new telaInicial(this);
        escolha menuEscolha = new escolha(this, "src/Cenarios/elfo.png","src/Cenarios/guerreiro.png","src/Cenarios/barbaro.png");

    }
}
