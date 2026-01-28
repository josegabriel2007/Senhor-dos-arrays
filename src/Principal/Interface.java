package Principal;

import Cenarios.*;
import Criaturas.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface extends JFrame {
    Personagens você;
    Inimigos rival;
    JPanel painel = new JPanel();
    public int valorCenario = 0;
    public boolean terminou = false;

    public Interface() {
        setTitle("Senhor dos Arrays");
        setSize(1000,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        trocarTela();
    }

    public void trocarTela() {
        getContentPane().removeAll();

        if (valorCenario == 0) {
            TelaInicial menu = new TelaInicial(this);

            menu.iniciar.addActionListener(e -> {
                valorCenario = 1;
                trocarTela();
            });

            add(menu);
        }

        else if (valorCenario == 1) {
            Escolha menuEscolha = new Escolha(
                    this,
                    "src/Cenarios/elfo.png",
                    "src/Cenarios/guerreiro.png",
                    "src/Cenarios/barbaro.png"
            );

            menuEscolha.elfo.addActionListener(e -> {
                você = new Elfo("Elfo");
                valorCenario = 2;
                trocarTela();
            });

            menuEscolha.guerreiro.addActionListener(e -> {
                você = new Guerreiro("Guerreiro");
                valorCenario = 2;
                trocarTela();
            });

            menuEscolha.barbaro.addActionListener(e -> {
                você = new Barbaro("Barbaro");
                valorCenario = 2;
                trocarTela();
            });

            add(menuEscolha);
        }

        revalidate();
        repaint();
    }


}
