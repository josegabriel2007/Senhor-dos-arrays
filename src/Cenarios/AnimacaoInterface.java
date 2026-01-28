package Cenarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.ArrayList;

public class AnimacaoInterface extends JFrame {

    // Variáveis de estado
    private ArrayList<Image> imagens;
    private int indiceAtual = 0;
    private Timer timer;

    public AnimacaoInterface() {
        // 1. Configuração da Janela
        setTitle("Animação de Personagem");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a tela

        // 2. Carregamento das Imagens
        imagens = new ArrayList<>();
        try {
            imagens.add(ImageIO.read(new File("/home/aluno/Downloads/guerreiro1.jpg"))) ;
            imagens.add(ImageIO.read(new File("/home/aluno/Downloads/guerreiro2.png"))) ;
            imagens.add(ImageIO.read(new File("/home/aluno/Downloads/guerreiro3.png"))) ;
            imagens.add(ImageIO.read(new File("/home/aluno/Downloads/guerreiro4.png"))) ;
        } catch (IOException e) {
            System.out.println("Erro ao carregar: " + e.getMessage());
        }

        // 3. O Painel que desenha a imagem (A "Tela de Cinema")
        JPanel painelDesenho = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Só desenha se tiver imagens na lista
                if (!imagens.isEmpty()) {
                    Image imgAtual = imagens.get(indiceAtual);
                    g.drawImage(imgAtual, 10,10 ,500,500, this);
                }
            }
        };
        add(painelDesenho);

        // 4. O Timer (O "Motor" da animação)
        timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Avança para o próximo quadro
                indiceAtual++;
                // Se chegou no fim, volta para o 0 (loop)
                if (indiceAtual >= imagens.size()) {
                    indiceAtual = 0;
                }
                // Manda o painel se redesenhar com a nova imagem
                painelDesenho.repaint();
            }
        });
        timer.start();
        System.out.println(imagens.size());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AnimacaoInterface().setVisible(true);

        });
    }
}