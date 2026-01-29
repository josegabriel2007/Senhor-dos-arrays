package Cenarios;

import Criaturas.Goblin;
import Criaturas.Inimigos;

public class CenaFloresta extends Cenas{

    Inimigos inimigo = new Goblin();

    public String getFundo(){
        return "src/Cenarios/Imagens/floresta.png";
    }
    public String getDialogo1(){
        return "Você entrou em uma floresta e acabou encontrando um goblin, ele parece impaciente, o que deseja fazer?";
    }
    public String getDialogo2(){
        return "Ele não te entendeu, ficou furioso e acabou te atacando enquanto você estava desprevinido";
    }
    public Inimigos getInimigo(){
        return inimigo;
    }
}
