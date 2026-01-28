package Cenarios;

import javax.swing.*;
import java.awt.*;

public class ImagemFundo extends JPanel {

    private Image imagem;

    public ImagemFundo (String caminhoImagem) {
        this.imagem = new ImageIcon(caminhoImagem).getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(imagem ,0,0,getWidth(),getHeight(),this);
    }
}