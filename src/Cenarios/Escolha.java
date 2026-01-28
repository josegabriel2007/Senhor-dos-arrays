package Cenarios;

import javax.swing.*;
import java.awt.*;

public class Escolha extends JPanel {

    public JButton elfo;
    public JButton guerreiro;
    public JButton barbaro;

    public Escolha() {

        // Painel raiz
        setLayout(new BorderLayout());
        setBackground(new Color(94, 67, 117));

        // =======================
        // TÍTULO (NORTE)
        // =======================
        JLabel textoEscolha = new JLabel("ESCOLHA SUA CLASSE:", SwingConstants.CENTER);
        textoEscolha.setFont(new Font(Font.SERIF, Font.BOLD, 50));
        textoEscolha.setForeground(Color.WHITE);
        textoEscolha.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));

        add(textoEscolha, BorderLayout.NORTH);

        // =======================
        // CENTRO (BOTÕES)
        // =======================
        JPanel centro = new JPanel(new GridBagLayout());
        centro.setOpaque(false);

        JPanel botoesClasses = new JPanel(new GridLayout(1, 3, 20, 0));
        botoesClasses.setOpaque(false);
        botoesClasses.setPreferredSize(new Dimension(550, 220));

        botoesClasses.add(criarBotaoClasse("ELFO", "src/Cenarios/Imagens/elfo.png"));
        botoesClasses.add(criarBotaoClasse("GUERREIRO", "src/Cenarios/Imagens/guerreiro.png"));
        botoesClasses.add(criarBotaoClasse("BARBARO", "src/Cenarios/Imagens/barbaro.png"));

        centro.add(botoesClasses);
        add(centro, BorderLayout.CENTER);
    }

    // =======================
    // MÉTODO AUXILIAR
    // =======================
    private JButton criarBotaoClasse(String nome, String caminhoImagem) {
        JButton botao = new JButton(nome);

        botao.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        botao.setBackground(new Color(201, 213, 181));
        botao.setFocusPainted(false);
        botao.setVerticalTextPosition(SwingConstants.BOTTOM);
        botao.setHorizontalTextPosition(SwingConstants.CENTER);

        ImageIcon icon = new ImageIcon(caminhoImagem);
        Image img = icon.getImage().getScaledInstance(120, 180, Image.SCALE_SMOOTH);
        botao.setIcon(new ImageIcon(img));

        // Referências públicas (pra listeners externos)
        switch (nome) {
            case "ELFO" -> elfo = botao;
            case "GUERREIRO" -> guerreiro = botao;
            case "BARBARO" -> barbaro = botao;
        }

        return botao;
    }
}