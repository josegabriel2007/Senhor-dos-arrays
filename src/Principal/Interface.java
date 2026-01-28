package Principal;

import Cenarios.*;
import javax.swing.*;
import java.awt.*;

public class Interface extends JFrame {

    JPanel painel = new JPanel();
    public int valorCenario = 3;

    public Interface(){
        setTitle("Senhor dos Arrays");
        setSize(1000,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        //telaInicial menu = new telaInicial(this);
        //escolha menuEscolha = new escolha(this, "src/Cenarios/elfo.png","src/Cenarios/guerreiro.png","src/Cenarios/barbaro.png");

        switch (valorCenario){
            case 1: TelaInicial menu = new TelaInicial(this);
                break;
            case 2: Escolha menuEscolha = new Escolha(this, "src/Cenarios/elfo.png","src/Cenarios/guerreiro.png","src/Cenarios/barbaro.png");
                break;
            case 3: //Batalha bat1 = new Batalha(this);
                Dialogo dig1 =  new Dialogo(this);
                //SwingUtilities.invokeLater(() -> new BarraVida());
                break;
        }
    }
}
