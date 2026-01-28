package Cenarios;

import Principal.Interface;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Dialogo{

    public JPanel areaNorte;
    public JPanel areaCentro;
    public JPanel areaSul;

    public Dialogo(Interface tela){

        JPanel fundo = new JPanel(new BorderLayout());
        ImageIcon background = new ImageIcon("src/Cenarios/Imagens/floresta.png");
        Image imagem1 = background.getImage();
        Image imagemRedimensionada1 = imagem1.getScaledInstance(1000, 600, Image.SCALE_SMOOTH);
        ImageIcon ifinal = new ImageIcon(imagemRedimensionada1);
        JLabel labelteste = new JLabel(ifinal);
        fundo.add(labelteste, BorderLayout.LINE_START);

        //AREA NORTE
        JPanel areaNorte = new JPanel(new BorderLayout());

        //AREA CENTRAL
        JPanel areaCentro = new JPanel(new BorderLayout());
        areaCentro.setOpaque(false);
        JPanel areaPersonagem = new JPanel(new BorderLayout());
        areaCentro.add(areaPersonagem, BorderLayout.WEST);
        JPanel areaInimigo = new JPanel(new BorderLayout());
        areaCentro.add(areaInimigo, BorderLayout.EAST);

        //AREA SUL
        JPanel areaSul = new JPanel(new BorderLayout());
        areaSul.setOpaque(false);
        areaSul.setPreferredSize(new Dimension(1000,150));
        JTextArea zonaTexto = new JTextArea("haslclweuibhlasuhcjb");
        zonaTexto.setFont(new Font(Font.SERIF, 0,30));
        zonaTexto.setForeground(Color.white);
        zonaTexto.setBackground(new Color(41, 47, 54));
        JPanel botoes = new JPanel(new GridLayout(2,1));
        botoes.setPreferredSize(new Dimension(200,0));
        JButton botao1 = new JButton("CONVERSAR");
        JButton botao2 = new JButton("ATACAR");
        botao1.setFont(new Font("SERIF",Font.BOLD,20));
        botao1.setBackground(new Color(201, 193, 159));
        botao1.setForeground(Color.black);
        botao1.setFocusPainted(false);
        botao2.setFont(new Font("SERIF",Font.BOLD,20));
        botao2.setBackground(new Color(201, 193, 159));
        botao2.setForeground(Color.black);
        botao2.setFocusPainted(false);
        botoes.add(botao1);
        botoes.add(botao2);
        areaSul.add(zonaTexto, BorderLayout.CENTER);
        areaSul.add(botoes, BorderLayout.EAST);

        botao2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        fundo.add(areaNorte, BorderLayout.NORTH);
        fundo.add(areaCentro, BorderLayout.CENTER);
        fundo.add(areaSul, BorderLayout.SOUTH);
        tela.add(fundo);

        }
    }