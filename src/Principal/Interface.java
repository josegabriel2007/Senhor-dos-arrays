package Principal;

import Cenarios.*;
import Cenarios.CenaPrisao;
import Criaturas.*;

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

        Personagens você = new Barbaro("nome");
        Cenas floresta = new CenaFloresta();
        Cenas castelo =  new CenaCastelo();
        Cenas prisao =  new CenaPrisao();
        Cenas terraco =  new CenaTerraco();

        switch (valorCenario){
            case 1: TelaInicial menu = new TelaInicial(this);
                break;
            case 2: Escolha menuEscolha = new Escolha(this, "src/Cenarios/elfo.png","src/Cenarios/guerreiro.png","src/Cenarios/barbaro.png");
                break;
            case 3: Batalha bat1 = new Batalha(this,terraco,você);
                break;
            case 4: Dialogo dig1 =  new Dialogo(this, floresta, você);
                break;
            case 5: Dialogo dig2 =  new Dialogo(this, castelo, você);
                break;
            case 6: Dialogo dig3 =  new Dialogo(this, prisao, você);
                break;
            case 7: Dialogo dig4 =  new Dialogo(this, terraco, você);
        }
    }
}
