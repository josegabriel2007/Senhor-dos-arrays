package Cenarios;

import Principal.Interface;
import javax.swing.*;
import java.awt.*;

public class Escolha {

    private JPanel botoesClasses;

    public Escolha(Interface tela, String elfoIMG, String guerreiroIMG, String barbaroIMG){

    JPanel fundo = new JPanel(new BorderLayout());
    fundo.setBackground(new Color(94, 67, 117));
    JLabel textoEscolha = new JLabel("ESCOLHA SUA CLASSE:", SwingConstants.CENTER);
    textoEscolha.setFont(new Font(Font.SERIF, 0,50));
    textoEscolha.setForeground(Color.white);
    textoEscolha.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
    fundo.add(textoEscolha, BorderLayout.NORTH);

    botoesClasses = new JPanel(new GridLayout(1,3,20,0));
    botoesClasses.setOpaque(false);
    botoesClasses.setPreferredSize(new Dimension(550,220));
    botoesClasses.setBorder(BorderFactory.createEmptyBorder(50, 200, 130, 200));

    //Adicionando os botoes e as imagens
    JButton elfo = new JButton("ELFO");
    elfo.setFont(new Font(Font.SERIF, 1,20));
    elfo.setBackground(new Color(201, 213, 181));
    elfo.setFocusPainted(false);
    elfo.setVerticalTextPosition(SwingConstants.BOTTOM);
    elfo.setHorizontalTextPosition(SwingConstants.CENTER);
    ImageIcon elfoIcon = new ImageIcon("src/Cenarios/Imagens/elfo.png");
    Image imagem1 = elfoIcon.getImage();
    Image imagemRedimensionada1 = imagem1.getScaledInstance(120, 180, Image.SCALE_SMOOTH);
    elfo.setIcon(new ImageIcon(imagemRedimensionada1));

    JButton guerreiro = new JButton("GUERREIRO");
    guerreiro.setFont(new Font(Font.SERIF, 1,20));
    guerreiro.setBackground(new Color(201, 213, 181));
    guerreiro.setFocusPainted(false);
    guerreiro.setVerticalTextPosition(SwingConstants.BOTTOM);
    guerreiro.setHorizontalTextPosition(SwingConstants.CENTER);
    ImageIcon guerreiroIcon = new ImageIcon("src/Cenarios/Imagens/guerreiro.png");
    Image imagem2 = guerreiroIcon.getImage();
    Image imagemRedimensionada2 = imagem2.getScaledInstance(120, 180, Image.SCALE_SMOOTH);
    guerreiro.setIcon(new ImageIcon(imagemRedimensionada2));

    JButton barbaro = new JButton("BARBARO");
    barbaro.setFont(new Font(Font.SERIF, 1,20));
    barbaro.setBackground(new Color(201, 213, 181));
    barbaro.setFocusPainted(false);
    barbaro.setVerticalTextPosition(SwingConstants.BOTTOM);
    barbaro.setHorizontalTextPosition(SwingConstants.CENTER);
    ImageIcon barbaroIcon = new ImageIcon("src/Cenarios/Imagens/barbaro.png");
    Image imagem3 = barbaroIcon.getImage();
    Image imagemRedimensionada3 = imagem3.getScaledInstance(120, 180, Image.SCALE_SMOOTH);
    barbaro.setIcon(new ImageIcon(imagemRedimensionada3));

    botoesClasses.add(elfo);
    botoesClasses.add(guerreiro);
    botoesClasses.add(barbaro);

    fundo.add(botoesClasses, BorderLayout.CENTER);
    tela.add(fundo);
    }
}
