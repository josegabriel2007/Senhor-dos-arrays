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
        areaNorte.setBackground(new Color(94, 67, 117));
        areaNorte.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
        JLabel nome = new JLabel("Senhor dos Arrays", SwingConstants.CENTER);
        nome.setFont(new Font(Font.SERIF, 0,50));
        nome.setForeground(Color.white);
        areaNorte.add(nome);
        add(areaNorte, BorderLayout.NORTH);

        //Botões Iniciais
        JPanel central = new JPanel(new GridBagLayout());
        central.setOpaque(false);

        JPanel botoesIniciais = new JPanel(new GridLayout(2,1,0,5));
        botoesIniciais.setOpaque(false);
        botoesIniciais.setPreferredSize(new Dimension(150,200));
        iniciar = new JButton("Iniciar");
        ajuda = new JButton("Ajuda");
        iniciar.setBackground(new Color(202, 137, 95));
        iniciar.setFont(new Font("Arial", Font.BOLD, 20));
        iniciar.setForeground(Color.white);
        iniciar.setFocusPainted(false);
        ajuda.setBackground(new Color(202, 137, 95));
        ajuda.setFont(new Font("Arial", Font.BOLD, 20));
        ajuda.setForeground(Color.white);
        ajuda.setFocusPainted(false);

        botoesIniciais.add(iniciar);
        botoesIniciais.add(ajuda);

        central.add(botoesIniciais);
        add(central, BorderLayout.CENTER);
    }
}