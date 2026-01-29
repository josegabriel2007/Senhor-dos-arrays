package Cenarios;

import Criaturas.Inimigos;
import Criaturas.Mago;

public class CenaPrisao extends Cenas{

    Inimigos inimigo = new Mago();

    public String getFundo(){
        return "src/Cenarios/Imagens/prison-background.png";
    }
    public String getDialogo1(){
        return "Entrando no castelo, você parou em uma prisão e encontrou um mago furioso, o que deseja fazer?";
    }
    public String getDialogo2(){
        return "Ele não queria conversa e te atacou";
    }
    public Inimigos getInimigo(){
        return inimigo;
    }
}