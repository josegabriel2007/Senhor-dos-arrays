package Cenarios;

import Criaturas.Soldado;
import Criaturas.Inimigos;

public class CenaCorredor extends Cenas{

    Inimigos inimigo = new Soldado();

    public String getTitulo(){
        return "CORREDOR DO CASTELO";
    }
    public String getTransicao(){
        return "Explorando o castelo em busca do mago, você percebe que todos os servos e soldados do rei foram aprisionados... não, espere! há alguém pelos corredores aparentemente desnorteado.";
    }
    public String getFundo(){
        return "Cenarios/Imagens/corredor.jpg";
    }
    public String getDialogo1(){
        return "Você encontrou um soldado! Ele não compreende o que está acontecendo, provavelmente foi algum tipo de magia... o que desejas fazer?";
    }
    public String getDialogo2(){
        return "Você explicou que o rei está em perigo e que veio para ajuda-lo, o soldado entendeu a situação, mas não está em condições de lutar, então ele te dá o anel, mágico! \n(Você ganhou um bônus de 10 pontos de ataque)";
    }
    public Inimigos getInimigo(){
        return inimigo;
    }
}
