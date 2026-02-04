package Cenarios;

import Criaturas.Guarda;
import Criaturas.Inimigos;

public class CenaCastelo extends Cenas{
    Inimigos inimigo = new Guarda();

    public String getTitulo(){
        return "ENTRADA DO CASTELO";
    }
    public String getTransicao(){
        return "Depois de algum tempo na floresta você avistou algo no horizonte e foi em direção.";
    }
    public String getFundo(){
        return "src/Cenarios/Imagens/castelo.jpg";
    }
    public String getDialogo1(){
        return "Saindo da floresta você se depara com um mercenário na entrada do castelo, ele está barrando o portão. Você pode tentar suborná-lo, o que irá fazer?";
    }
    public String getDialogo2(){
        return "Você tinha algumas moedas no bolso e essas poucas foram o suficiente para ele, você pode passar.";
    }
    public Inimigos getInimigo(){
        return inimigo;
    }
}
