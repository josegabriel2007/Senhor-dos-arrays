package Cenarios;

import Principal.Interface;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Batalha{

    public JPanel areaNorte;
    public JPanel areaCentro;
    public JPanel areaSul;
    private JPanel Painelvida;
    private int ataque = 200;

    class Painelvida extends JPanel {
        // Exemplo de variáveis (caso não estejam definidas fora)
        //int ataque = 50;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Anti-aliasing para ficar mais bonito (opcional)
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // --- Cálculos Dinâmicos ---
            int larguraPainel = getWidth();
            int alturaPainel = getHeight();

            // Vamos posicionar a barra 50px acima do fim da tela
            int yPos = alturaPainel - 60;

            // Posição X do inimigo (lado direito - margem - largura da barra)
            int xInimigo = larguraPainel - 300;

            // --- BARRA DO JOGADOR (Esquerda) ---
            g2d.setStroke(new BasicStroke(2.0f));
            g2d.setColor(Color.BLACK);
            g2d.drawRect(10, yPos, 200, 25); // Contorno

            g2d.setColor(Color.RED);
            // Ajuste: x+1 e y+1 para não desenhar em cima da borda preta
            // Ajuste: Altura-2 e Largura-2 para caber dentro
            g2d.fillRect(11, yPos + 1, ataque, 23);

            // --- BARRA DO INIMIGO (Direita) ---
            g2d.setColor(Color.BLACK);
            g2d.drawRect(xInimigo, yPos, 200, 25); // Contorno

            g2d.setColor(Color.RED);
            g2d.fillRect(xInimigo + 1, yPos + 1, ataque, 23);
        }
    }

    public Batalha(Interface tela){

        ImagemFundo fundo = new ImagemFundo("src/Cenarios/Imagens/floresta.png");
        fundo.setLayout(new GridLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 50, 0);

        //AREA NORTE
        JPanel areaNorte = new JPanel(new BorderLayout());
        areaNorte.setPreferredSize(new Dimension(1000,50));
        areaNorte.setOpaque(false);
        Painelvida painel = new Painelvida();
        painel.setOpaque(false);
        areaNorte.add(painel, BorderLayout.CENTER);

        //AREA CENTRAL
        JPanel areaCentro = new JPanel(new BorderLayout());
        areaCentro.setOpaque(false);
        JPanel areaPersonagem = new JPanel(new BorderLayout());
        areaCentro.add(areaPersonagem, BorderLayout.WEST);
        JPanel areaInimigo = new JPanel(new BorderLayout());
        areaCentro.add(areaInimigo, BorderLayout.EAST);

        //AREA SUL
        JPanel areaSul = new JPanel(new GridBagLayout());
        areaSul.setOpaque(false);
        areaSul.setPreferredSize(new Dimension(1000,150));
        JPanel botoes = new JPanel(new GridLayout(1,2,50,0));
        botoes.setPreferredSize(new Dimension(400,50));
        JButton botao1 = new JButton("ATACAR");
        JButton botao2 = new JButton("CURAR");
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
        areaSul.add(botoes);

        botao1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (ataque > 0) {
                    ataque -= 5;
                    painel.repaint();
                }
            }
        });

        fundo.add(areaNorte, BorderLayout.NORTH);
        fundo.add(areaCentro, BorderLayout.CENTER);
        fundo.add(areaSul, BorderLayout.SOUTH);
        tela.add(fundo);

    }




}