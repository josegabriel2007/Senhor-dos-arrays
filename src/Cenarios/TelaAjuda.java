package Cenarios;

import javax.swing.*;
import java.awt.*;

public class TelaAjuda extends JPanel {

    public JButton voltar;

    public TelaAjuda(){
        setLayout(new BorderLayout());
        setBackground(new Color(94, 67, 117));


        JPanel areaNorte = new JPanel(new GridBagLayout());
        areaNorte.setOpaque(false);
        JLabel titulo = new JLabel("AJUDA");
        titulo.setFont(new Font(Font.SERIF, 0,70));
        titulo.setForeground(Color.white);
        areaNorte.add(titulo);

        JPanel areaCentral = new JPanel(new GridLayout(1,3,50,0));
        areaCentral.setPreferredSize(new Dimension(1000,780));
        areaCentral.setBorder(BorderFactory.createEmptyBorder(50,100,10,100));
        JTextArea texto1 = new JTextArea("CLASSES: \nELFOS não tem muita força física, no entanto são uma raça com muita vitalidade, então naturalmente eles tem mais pontos de vida e poucos pontos de ataque. \nGUERREIROS são bem equilibrados devido ao seu treinamento, os pontos de vida e ataque são um perfeito meio termo. \nBARBAROS agem sem pensar mas naturalmente tem mais força física, mas o seu descuido impede ele de defender bem os ataques, eles tem mais pontos de ataque e menos pontos de vida.");
        texto1.setForeground(Color.white);
        texto1.setFont(new Font("ARIAL", Font.BOLD,26));
        texto1.setLineWrap(true);
        texto1.setEditable(false);
        texto1.setWrapStyleWord(true);
        texto1.setOpaque(false);
        JTextArea texto2 = new JTextArea("ESCOLHAS: \nCuidado com suas escolhas, elas te levarão para caminhos diferentes ou podem acabar com sua aventura. Lembre-se o final mudará a depender do que escolher, então pense antes de agir.");
        texto2.setForeground(Color.white);
        texto2.setFont(new Font("ARIAL", Font.BOLD,30));
        texto2.setLineWrap(true);
        texto2.setEditable(false);
        texto2.setWrapStyleWord(true);
        texto2.setOpaque(false);
        JTextArea texto3 = new JTextArea("DICAS: \nEscolha sua classe de acordo como queira jogar.\nNÃO CONVERSE COM GOBLINS! \nLeia as descrições de cada situação. \nNão fique atacando sem parar, dê uma pausa e se cure quando necessário. \nNão saia atacando todo mundo ou conversando com todos. \nExistem quatro finais possíveis, jogue e descubra-os.");
        texto3.setForeground(Color.white);
        texto3.setFont(new Font("ARIAL", Font.BOLD,30));
        texto3.setLineWrap(true);
        texto3.setEditable(false);
        texto3.setWrapStyleWord(true);
        texto3.setOpaque(false);
        areaCentral.add(texto1);
        areaCentral.add(texto2);
        areaCentral.add(texto3);
        areaCentral.setOpaque(false);

        JPanel areaSul = new JPanel(new GridBagLayout());
        areaSul.setOpaque(false);
        areaSul.setPreferredSize(new Dimension(1500,70));
        areaSul.setBorder(BorderFactory.createEmptyBorder(0,0,30,0));
        voltar = new JButton("VOLTAR");
        voltar.setFont(new Font("Arial", Font.BOLD, 20));
        voltar.setBackground(new Color(201, 193, 159));
        voltar.setPreferredSize(new Dimension(150,40));
        areaSul.add(voltar);

        add(areaNorte, BorderLayout.NORTH);
        add(areaCentral, BorderLayout.CENTER);
        add(areaSul, BorderLayout.SOUTH);
    }
}
