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
    //Valores da "vida", "static" pois nosso personagem não recupera vida nas mudanças de cenário
    public double BarraInimigo = 100;
    public static double BarraPersonagem = 100;

    public JButton botaoAtacar;
    public JButton botaoCurar;
    public Personagens heroi;
    private Inimigos inimigo;
    private Cenas cena;

    //Classe criada para desenhar as barras de vida
    class Painelvida extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int larguraPainel = getWidth();
            int alturaPainel = getHeight();
            int yPos = alturaPainel - 30;
            int xInimigo = larguraPainel - 500;

            g2d.setStroke(new BasicStroke(3.0f));
            //Barra de vida do Personagem
            g2d.setColor(Color.BLACK);
            g2d.drawRect(100, yPos, 402, 25);
            g2d.setColor(Color.RED);
            g2d.fillRect(102, yPos + 1, (int)Math.round(BarraPersonagem * 4), 23);
            //Barra de vida do Inimigo
            g2d.setColor(Color.BLACK);
            g2d.drawRect(xInimigo, yPos, 402, 25);
            g2d.setColor(Color.RED);
            g2d.fillRect(xInimigo + 1, yPos + 1, (int)Math.round(BarraInimigo * 4), 23);

            g.setFont(new Font("SansSerif", Font.BOLD, 20));
            String textoHeroi = (int)Math.round((BarraPersonagem * heroi.getVida())/100) + " / " + heroi.getVidaMaxima();
            g.setColor(Color.WHITE);
            g.drawString(textoHeroi, 250, yPos + 20);
            String textoInimigo = (int)Math.round((BarraInimigo * inimigo.getVida())/100) + " / " + inimigo.getVidaMaxima();
            g.setColor(Color.WHITE);
            g.drawString(textoInimigo, larguraPainel - 350, yPos + 20);
        }
    }

    public Batalha(Interface tela, Cenas cenaAtual, Personagens heroiSelecionado){
        //Iniciando as classes
        this.heroi = heroiSelecionado;
        this.cena = cenaAtual;
        inimigo = cenaAtual.getInimigo();

        //Classe para colocar imagens no fundo
        ImagemFundo fundo = new ImagemFundo(cenaAtual.getFundo());
        fundo.setLayout(new BorderLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 50, 0);

        //AREA NORTE
        JPanel areaNorte = new JPanel(new BorderLayout());
        areaNorte.setPreferredSize(new Dimension(1500,75));
        areaNorte.setOpaque(false);
        Painelvida painel = new Painelvida();
        painel.setOpaque(false);
        areaNorte.add(painel, BorderLayout.CENTER);

        //AREA CENTRAL
        JPanel areaCentro = new JPanel(new BorderLayout());
        areaCentro.setOpaque(false);
        //Area do Personagem (dentro da area central)
        JPanel areaPersonagem = new JPanel(new GridBagLayout());
        areaPersonagem.setPreferredSize(new Dimension(750,600));
        areaPersonagem.setOpaque(false);
        ImageIcon PersonagemIcon = new ImageIcon(heroi.getIcon());
        Image ImagemPersonagem = PersonagemIcon.getImage();
        Image PersonagemRedimensionado = ImagemPersonagem.getScaledInstance(220, 330, Image.SCALE_SMOOTH);
        JLabel Personagem = new JLabel(new ImageIcon(PersonagemRedimensionado));
        Personagem.setBorder(BorderFactory.createEmptyBorder(280,0,0,0));
        areaPersonagem.add(Personagem);
        areaCentro.add(areaPersonagem, BorderLayout.WEST);
        //Area do Inimigo (dentro da area central)
        JPanel areaInimigo = new JPanel(new GridBagLayout());
        areaInimigo.setPreferredSize(new Dimension(750,600));
        areaInimigo.setOpaque(false);
        ImageIcon InimigoIcon = new ImageIcon(inimigo.getIcon());
        Image ImagemInimigo = InimigoIcon.getImage();
        Image InimigoRedimensionado = ImagemInimigo.getScaledInstance(220, 330, Image.SCALE_SMOOTH);
        JLabel Inimigo = new JLabel(new ImageIcon(InimigoRedimensionado));
        Inimigo.setBorder(BorderFactory.createEmptyBorder(280,0,0,0));
        areaInimigo.add(Inimigo);
        areaCentro.add(areaInimigo, BorderLayout.EAST);

        //AREA SUL
        JPanel areaSul = new JPanel(new GridBagLayout());
        areaSul.setPreferredSize(new Dimension(1500,225));
        areaSul.setBackground(new Color(92, 71, 66));
        //Botoes de atacar e curar (dentro da area sul)
        JPanel botoes = new JPanel(new GridLayout(1,2,75,0));
        botoes.setPreferredSize(new Dimension(750,75));
        botoes.setOpaque(false);
        botaoAtacar = new JButton("ATACAR:"+ (int)heroi.getAtaque()+"pts");
        botaoCurar = new JButton("CURAR: +30%");
        botaoAtacar.setFont(new Font("SERIF",Font.BOLD,30));
        botaoAtacar.setBackground(new Color(201, 193, 159));
        botaoAtacar.setForeground(Color.black);
        botaoAtacar.setFocusPainted(false);
        botaoCurar.setFont(new Font("SERIF",Font.BOLD,30));
        botaoCurar.setBackground(new Color(201, 193, 159));
        botaoCurar.setForeground(Color.black);
        botaoCurar.setFocusPainted(false);
        botoes.add(botaoAtacar);
        botoes.add(botaoCurar);
        areaSul.add(botoes);

        //Sistema do botão Atacar durante a batalha
        botaoAtacar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Sistema para a vida não diminuir quando chegar a 0
                if (BarraInimigo > 0) {
                    BarraInimigo = BarraInimigo - (100/(inimigo.getVida()/heroi.getAtaque()));
                    painel.repaint();
                }
                if (BarraInimigo < 0) {
                    BarraInimigo = 0;
                }
                // Temporizador com o delay de tomar dano
                Timer temporizador = new Timer(500, e1 -> {
                    if (BarraPersonagem > 0) {
                        BarraPersonagem = BarraPersonagem - (100/(heroi.getVida()/inimigo.getAtaque()));
                        painel.repaint();
                    }
                    if (BarraPersonagem < 0) {
                        BarraPersonagem = 0;
                    }

                    Inimigo.setBorder(BorderFactory.createEmptyBorder(280,0,0,0));
                    ((Timer)e1.getSource()).stop();
                });
                temporizador.setRepeats(false);
                temporizador.start();

                // Temporizador para disabilitar os botoes na batalha (para evitar ficar floodando)
                botaoAtacar.setEnabled(false);
                botaoCurar.setEnabled(false);
                Timer desabilitar = new Timer(500, e1 -> {
                    botaoAtacar.setEnabled(true);
                    botaoCurar.setEnabled(true);
                    ((Timer)e1.getSource()).stop();
                });
                desabilitar.setRepeats(false);
                desabilitar.start();

                //animação simples
                Personagem.setBorder(BorderFactory.createEmptyBorder(280,200,0,0));
                Timer temporizador1 = new Timer(150, e1 -> {
                    Personagem.setBorder(BorderFactory.createEmptyBorder(280,0,0,0));
                    ((Timer)e1.getSource()).stop();
                });
                temporizador1.setRepeats(false);
                temporizador1.start();

                Timer temporizador2 = new Timer(350, e1 -> {
                    Inimigo.setBorder(BorderFactory.createEmptyBorder(280,0,0,200));
                    ((Timer)e1.getSource()).stop();
                });
                temporizador2.setRepeats(false);
                temporizador2.start();
            }
        });
        //Ação do botão de curar que
        botaoCurar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (BarraPersonagem > 0 && BarraPersonagem < 100) {
                    BarraPersonagem = BarraPersonagem + heroi.pocao(30);
                    painel.repaint();
                    if(BarraPersonagem > 100){
                        BarraPersonagem = BarraPersonagem - (BarraPersonagem - 100);
                    }
                }
                if (BarraPersonagem < 0) {
                    BarraPersonagem = 0;
                }
                Timer timer = new Timer(500, e1 -> {
                    if (BarraPersonagem > 0) {
                        BarraPersonagem = BarraPersonagem - (100/(heroi.getVida()/inimigo.getAtaque()));
                        painel.repaint();
                    }
                    Inimigo.setBorder(BorderFactory.createEmptyBorder(280,0,0,0));
                    ((Timer)e1.getSource()).stop();
                });
                timer.setRepeats(false);
                timer.start();

                // Temporizador para disabilitar os botoes na batalha (para evitar ficar floodando)
                botaoAtacar.setEnabled(false);
                botaoCurar.setEnabled(false);
                Timer desabilitar = new Timer(500, e1 -> {
                    botaoAtacar.setEnabled(true);
                    botaoCurar.setEnabled(true);
                    ((Timer)e1.getSource()).stop();
                });
                desabilitar.setRepeats(false);
                desabilitar.start();


                Personagem.setBorder(BorderFactory.createEmptyBorder(250,0,0,0));
                Timer temporizador1 = new Timer(100, e1 -> {
                    Personagem.setBorder(BorderFactory.createEmptyBorder(280,0,0,0));
                    ((Timer)e1.getSource()).stop();
                });
                temporizador1.setRepeats(false);
                temporizador1.start();

                Timer temporizador2 = new Timer(350, e1 -> {
                    Inimigo.setBorder(BorderFactory.createEmptyBorder(280,0,0,200));
                    ((Timer)e1.getSource()).stop();
                });
                temporizador2.setRepeats(false);
                temporizador2.start();
            }
        });

        fundo.add(areaNorte, BorderLayout.NORTH);
        fundo.add(areaCentro, BorderLayout.CENTER);
        fundo.add(areaSul, BorderLayout.SOUTH);
        tela.add(fundo);
    }
}