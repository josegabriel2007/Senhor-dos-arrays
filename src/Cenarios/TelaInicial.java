package Cenarios;

import Principal.Interface;
import javax.swing.*;
import java.awt.*;

public class TelaInicial extends JPanel {

    public JButton iniciar;
    public JButton ajuda;

    public TelaInicial() {

        // O PRÓPRIO painel é o container principal
        setLayout(new BorderLayout());
        setBackground(new Color(94, 67, 117));

        // =======================
        // ÁREA NORTE (Título)
        // =======================
        JLabel nome = new JLabel("Senhor dos Arrays", SwingConstants.CENTER);
        nome.setFont(new Font(Font.SERIF, Font.BOLD, 50));
        nome.setForeground(Color.WHITE);

        JPanel areaNorte = new JPanel(new BorderLayout());
        areaNorte.setOpaque(false);
        areaNorte.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
        areaNorte.add(nome, BorderLayout.CENTER);

        add(areaNorte, BorderLayout.NORTH);

        // =======================
        // ÁREA CENTRAL (Botões)
        // =======================
        JPanel centro = new JPanel(new GridBagLayout());
        centro.setOpaque(false);

        JPanel botoes = new JPanel(new GridLayout(2, 1, 0, 10));
        botoes.setOpaque(false);
        botoes.setPreferredSize(new Dimension(200, 120));

        iniciar = new JButton("Iniciar");
        ajuda = new JButton("Ajuda");

        estilizarBotao(iniciar);
        estilizarBotao(ajuda);

        botoes.add(iniciar);
        botoes.add(ajuda);

        centro.add(botoes);
        add(centro, BorderLayout.CENTER);
    }

    private void estilizarBotao(JButton botao) {
        botao.setBackground(new Color(202, 137, 95));
        botao.setFont(new Font("Arial", Font.BOLD, 20));
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
    }
}