package Cenarios;

import Criaturas.Inimigos;
import Criaturas.Personagens;
import Principal.Interface;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Batalha{

    public int BarraInimigo = 250;
    public int BarraPersonagem = 250;

    private Personagens heroi;
    private Inimigos inimigo;

    class Painelvida extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int larguraPainel = getWidth();
            int alturaPainel = getHeight();
            int yPos = alturaPainel - 30;
            int xInimigo = larguraPainel - 280;

            g2d.setStroke(new BasicStroke(2.0f));

            g2d.setColor(Color.BLACK);
            g2d.drawRect(30, yPos, 252, 25);
            g2d.setColor(Color.RED);
            g2d.fillRect(32, yPos + 1, BarraPersonagem, 23);

            g2d.setColor(Color.BLACK);
            g2d.drawRect(xInimigo, yPos, 252, 25);
            g2d.setColor(Color.RED);
            g2d.fillRect(xInimigo + 1, yPos + 1, BarraInimigo, 23);
        }
    }

    public Batalha(Interface tela, Personagens heroiSelecionado, Inimigos inimigoSelecionado){

        this.heroi = heroiSelecionado;
        this.inimigo = inimigoSelecionado;

        ImagemFundo fundo = new ImagemFundo("src/Cenarios/Imagens/floresta.png");
        fundo.setLayout(new BorderLayout());
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
        JPanel areaPersonagem = new JPanel(new GridBagLayout());
        areaPersonagem.setPreferredSize(new Dimension(500,400));
        areaPersonagem.setOpaque(false);
        ImageIcon PersonagemIcon = new ImageIcon(heroi.getIcon());
        Image ImagemPersonagem = PersonagemIcon.getImage();
        Image PersonagemRedimensionado = ImagemPersonagem.getScaledInstance(175, 263, Image.SCALE_SMOOTH);
        JLabel Personagem = new JLabel(new ImageIcon(PersonagemRedimensionado));
        Personagem.setBorder(BorderFactory.createEmptyBorder(180, 50, 100, 50));
        areaPersonagem.add(Personagem);
        areaCentro.add(areaPersonagem, BorderLayout.WEST);

        JPanel areaInimigo = new JPanel(new GridBagLayout());
        areaInimigo.setPreferredSize(new Dimension(500,400));
        areaInimigo.setOpaque(false);
        ImageIcon InimigoIcon = new ImageIcon(inimigo.getIcon());
        Image ImagemInimigo = InimigoIcon.getImage();
        Image InimigoRedimensionado = ImagemInimigo.getScaledInstance(175, 263, Image.SCALE_SMOOTH);
        JLabel Inimigo = new JLabel(new ImageIcon(InimigoRedimensionado));
        Inimigo.setBorder(BorderFactory.createEmptyBorder(180, 50, 100, 50));
        areaInimigo.add(Inimigo);
        areaCentro.add(areaInimigo, BorderLayout.EAST);

        //AREA SUL
        JPanel areaSul = new JPanel(new GridBagLayout());
        areaSul.setPreferredSize(new Dimension(1000,150));
        areaSul.setBackground(new Color(92, 71, 66));
        JPanel botoes = new JPanel(new GridLayout(1,2,50,0));
        botoes.setPreferredSize(new Dimension(400,50));
        botoes.setOpaque(false);
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
                if (BarraInimigo > 0) {
                    BarraInimigo = BarraInimigo - ((inimigo.getVida() * heroi.getAtaque()) / 1000);
                    painel.repaint();
                }
                Timer timer = new Timer(1000, e1 -> {
                    if (BarraPersonagem > 0) {
                        BarraPersonagem = BarraPersonagem - ((heroi.getVida() * inimigo.getAtaque()) / 1000);
                        painel.repaint();
                    }
                    ((Timer)e1.getSource()).stop();
                });
                timer.setRepeats(false);
                timer.start();

            }
        });

        botao2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (BarraPersonagem > 0 && BarraPersonagem < 250) {
                    BarraPersonagem = BarraPersonagem + heroi.pocao(100);
                    painel.repaint();
                    if(BarraPersonagem > 250){
                        BarraPersonagem = BarraPersonagem - (BarraPersonagem - 250);
                    }
                }
                Timer timer = new Timer(1000, e1 -> {
                    if (BarraPersonagem > 0) {
                        BarraPersonagem = BarraPersonagem - ((heroi.getVida() * inimigo.getAtaque()) / 1000);
                        painel.repaint();
                    }
                    ((Timer)e1.getSource()).stop();
                });
                timer.setRepeats(false);
                timer.start();

            }
        });

        fundo.add(areaNorte, BorderLayout.NORTH);
        fundo.add(areaCentro, BorderLayout.CENTER);
        fundo.add(areaSul, BorderLayout.SOUTH);
        tela.add(fundo);
    }
}