package Cenarios;

import javax.swing.*;
import java.awt.*;

public class TelaTextos extends JPanel {

    public String textoTitulo;
    public String textoTransicao;
    public JButton avancar;

    private Cenas cena;
    public TelaTextos(Cenas cena){
        this.cena = cena;

        setLayout(new BorderLayout());
        setBackground(Color.black);

        JLabel titulo = new JLabel(cena.getTitulo() , SwingConstants.CENTER);
        titulo.setForeground(Color.white);
        titulo.setFont(new Font(Font.SERIF, 0,65));
        titulo.setBorder(BorderFactory.createEmptyBorder(60,0,0,0));
        add(titulo, BorderLayout.NORTH);

        JTextArea transicao = new JTextArea(cena.getTransicao());
        transicao.setForeground(Color.white);
        transicao.setOpaque(false);
        transicao.setFont(new Font(Font.SERIF, 0,35));
        transicao.setLineWrap(true);
        transicao.setEditable(false);
        transicao.setWrapStyleWord(true);
        transicao.setBorder(BorderFactory.createEmptyBorder(150,400,0,400));
        add(transicao, BorderLayout.CENTER);

        avancar = new JButton("AVANÇAR");
        avancar.setFocusPainted(false);
        avancar.setFont(new Font("Arial", Font.BOLD, 30));
        avancar.setBackground(new Color(255, 244, 208));
        avancar.setPreferredSize(new Dimension(1500,50));
        add(avancar, BorderLayout.SOUTH);
    }
}
