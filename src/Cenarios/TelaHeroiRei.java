package Cenarios;

import Criaturas.Dragao;
import Criaturas.Inimigos;

public class TelaHeroiRei  extends Cenas{
    Inimigos inimigo = new Dragao();

    public String getTitulo(){
        return "PARABÉNS, VOCÊ SALVOU A FAMILIA REAL!";
    }
    public String getTransicao(){
        return "Logo depois de derrotar o mago e o dragão, o rei veio até você, agora a família real é grata a você \"o Herói\". Mas e o povo? Será que você fez as escolhas certas?";
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