package Cenarios;

import Principal.Interface;
import javax.swing.*;
import java.awt.*;

public class TelaInicial extends JPanel {
    public JButton iniciar;
    public JButton ajuda;

    public TelaInicial(){
        setLayout(new BorderLayout());
        setBackground(new Color(94, 67, 117));

        //Area norte para o nome do jogo
        JPanel areaNorte = new JPanel(new BorderLayout());
        areaNorte.setOpaque(false);
        areaNorte.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
        JLabel nome = new JLabel("Senhor dos Arrays:", SwingConstants.CENTER);
        nome.setFont(new Font(Font.SERIF, 0,60));
        nome.setForeground(Color.white);
        JLabel nome1 = new JLabel("A ultima compilação", SwingConstants.CENTER);
        nome1.setFont(new Font(Font.SERIF, 0,35));
        nome1.setForeground(Color.white);
        areaNorte.add(nome, BorderLayout.NORTH);
        areaNorte.add(nome1, BorderLayout.SOUTH);
        add(areaNorte, BorderLayout.NORTH);

        //Botões Iniciais
        JPanel central = new JPanel(new GridBagLayout());
        central.setOpaque(false);

        JPanel botoesIniciais = new JPanel(new GridLayout(2,1,0,5));
        botoesIniciais.setOpaque(false);
        botoesIniciais.setPreferredSize(new Dimension(200,250));
        iniciar = new JButton("Iniciar");
        ajuda = new JButton("Ajuda");
        iniciar.setBackground(new Color(201, 193, 159));
        iniciar.setFont(new Font("Arial", Font.BOLD, 20));
        iniciar.setForeground(Color.black);
        iniciar.setFocusPainted(false);
        ajuda.setBackground(new Color(201, 193, 159));
        ajuda.setFont(new Font("Arial", Font.BOLD, 20));
        ajuda.setForeground(Color.black);
        ajuda.setFocusPainted(false);

        botoesIniciais.add(iniciar);
        botoesIniciais.add(ajuda);

        central.add(botoesIniciais);
        add(central, BorderLayout.CENTER);
    }
}