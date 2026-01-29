package Cenarios;

import Criaturas.Inimigos;
import Criaturas.Personagens;
import Principal.Interface;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Dialogo{

    private Personagens heroi;
    private Inimigos inimigo;
    private Cenas cena;

    public Dialogo(Interface tela, Cenas cenaAtual, Personagens heroiSelecionado){

        this.heroi = heroiSelecionado;
        this.cena = cenaAtual;
        inimigo = cenaAtual.getInimigo();

        ImagemFundo fundo = new ImagemFundo(cenaAtual.getFundo());
        fundo.setLayout(new BorderLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 50, 0);

        //AREA NORTE
        JPanel areaNorte = new JPanel(new BorderLayout());
        areaNorte.setOpaque(false);
        areaNorte.setPreferredSize(new Dimension(1000,50));

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
        JPanel areaSul = new JPanel(new BorderLayout());
        areaSul.setOpaque(false);
        areaSul.setPreferredSize(new Dimension(1000,150));
        JTextArea zonaTexto = new JTextArea(cenaAtual.getDialogo1());
        zonaTexto.setEditable(false);
        zonaTexto.setLineWrap(true);
        zonaTexto.setWrapStyleWord(true);
        zonaTexto.setFont(new Font(Font.SERIF, 0,25));
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

        botao1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                zonaTexto.setText(cenaAtual.getDialogo2());
            }
        });

        fundo.add(areaNorte, BorderLayout.NORTH);
        fundo.add(areaCentro, BorderLayout.CENTER);
        fundo.add(areaSul, BorderLayout.SOUTH);
        tela.add(fundo);

        }
    }