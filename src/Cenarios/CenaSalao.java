package Cenarios;

import Criaturas.Inimigos;
import Criaturas.Mago;

public class CenaSalao extends Cenas{
    Inimigos inimigo = new Mago();

    public String getTitulo(){
        return "SALÃO DO REI";
    }
    public String getTransicao(){
        return "Explorando o castelo, você achou o salão do rei, mas parece que o rei não está...";
    }
    public String getFundo(){
        return "Cenarios/Imagens/salao.jpg";
    }
    public String getDialogo1(){
        return "Aparentemente você achou a mente por trás desse ataque, um mago com o rei de refém, ele parece ter algo a te contar, o que deseja fazer?";
    }
    public String getDialogo2(){
        return "Ele te viu curioso e resolveu te contar a verdade, você descobriu que esse rei é um tirano que fez muitas crueldades e o mago é apenas uma vitíma que decidiu vingar a todos que sofreram por causa dele. Você se pergunta se ele é apenas um mentiroso, você quer acreditar?";
    }
    public Inimigos getInimigo(){
        return inimigo;
    }
}
