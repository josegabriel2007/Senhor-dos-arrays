package Cenarios;

import Criaturas.Dragao;
import Criaturas.Inimigos;

public class TelaDerrota extends Cenas{
    Inimigos inimigo = new Dragao();

    public String getTitulo(){
        return "VOCÊ PERDEU!";
    }
    public String getTransicao(){
        return "\n\n\n               Volte para o inicio do jogo.";
    }
    public String getFundo(){
        return "";
    }
    public String getDialogo1(){
        return "";
    }
    public String getDialogo2(){
        return "";
    }
    public Inimigos getInimigo(){
        return inimigo;
    }
}
