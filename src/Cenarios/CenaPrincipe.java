package Cenarios;

import Criaturas.Principe;
import Criaturas.Inimigos;

public class CenaPrincipe extends Cenas{

    Inimigos inimigo = new Principe();

    public String getTitulo(){
        return "FLORESTA";
    }
    public String getTransicao(){
        return "Você andando por ai acabou entrando em uma floresta";
    }
    public String getFundo(){
        return "src/Cenarios/Imagens/floresta.png";
    }
    public String getDialogo1(){
        return "Você entrou em uma floresta e acabou encontrando um goblin, ele parece impaciente, o que deseja fazer?";
    }
    public String getDialogo2(){
        return "Ele pede ajuda, que dasdddasdaa";
    }
    public Inimigos getInimigo(){
        return inimigo;
    }
}