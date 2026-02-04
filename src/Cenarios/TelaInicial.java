package Cenarios;

import Principal.Interface;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class TelaInicial extends JPanel {
    public JButton iniciar;
    public JButton ajuda;

    private Image imagemFundo;

    public TelaInicial(){

        String linkInternet = "https://i.postimg.cc/W1L0jB75/359d79441230ad4e75259e1d7cc28612.png";
        String caminhoLocal = "Cenarios/Imagens/fundoInicio.png";
        //try e catch, que tenta pegar a imagem de fundo da internet, caso falhe ele pega a dos arquivos
        try {
            System.out.println("Tentando baixar imagem da internet...");
            URL url = new URL(linkInternet);
            imagemFundo = ImageIO.read(url);
            System.out.println("Sucesso! Imagem carregada da internet.");
        } catch (IOException e) {
            System.out.println("Erro na internet: " + e.getMessage());
            System.out.println("Carregando imagem local de backup...");

            imagemFundo = new ImageIcon(caminhoLocal).getImage();
        }
        setLayout(new BorderLayout());


        //Area norte para o nome do jogo
        JPanel areaNorte = new JPanel(new BorderLayout());
        areaNorte.setOpaque(false);
        areaNorte.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
        JLabel nome = new JLabel("Senhor dos Arrays:", SwingConstants.CENTER);
        nome.setFont(new Font(Font.SERIF, 0,70));
        nome.setForeground(Color.black);
        JLabel nome1 = new JLabel("A ultima compilação", SwingConstants.CENTER);
        nome1.setFont(new Font(Font.SERIF, 0,45));
        nome1.setForeground(Color.black);
        areaNorte.add(nome, BorderLayout.NORTH);
        areaNorte.add(nome1, BorderLayout.SOUTH);
        add(areaNorte, BorderLayout.NORTH);

        //Botões Iniciais
        JPanel central = new JPanel(new GridBagLayout());
        central.setOpaque(false);

        JPanel botoesIniciais = new JPanel(new GridLayout(2,1,0,5));
        botoesIniciais.setOpaque(false);
        botoesIniciais.setPreferredSize(new Dimension(200,250));
        iniciar = new JButton("INICIAR");
        ajuda = new JButton("AJUDA");
        iniciar.setBackground(new Color(86, 78, 88));
        iniciar.setFont(new Font("Arial", Font.BOLD, 30));
        iniciar.setForeground(Color.white);
        iniciar.setFocusPainted(false);
        ajuda.setBackground(new Color(86, 78, 88));
        ajuda.setFont(new Font("Arial", Font.BOLD, 30));
        ajuda.setForeground(Color.white);
        ajuda.setFocusPainted(false);

        botoesIniciais.add(iniciar);
        botoesIniciais.add(ajuda);

        central.add(botoesIniciais);
        add(central, BorderLayout.CENTER);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Limpa o painel
        Graphics2D g2d = (Graphics2D) g;

        if (imagemFundo != null) {
            g2d.drawImage(imagemFundo, 0, 0, getWidth(), getHeight(), this);
        }
    }
}