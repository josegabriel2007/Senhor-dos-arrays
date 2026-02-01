package Cenarios;

import Criaturas.Dragao;
import Criaturas.Inimigos;

public class TelaHeroiProprio extends Cenas{
    Inimigos inimigo = new Dragao();

    public String getTitulo(){
        return "PARABÉNS, VOCÊ SE SALVOU!";
    }
    public String getTransicao(){
        return "Você não está nem aí para ninguém. Saqueou toda a fortuna do castelo. Você foi o herói de si mesmo. Bem, a comida não se põe na mesa sozinha, o dinheiro tem que vir de algum lugar, afinal aventureiros como você não tem salário. Mas... no fim será que você fez a escolha mais correta?";
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
