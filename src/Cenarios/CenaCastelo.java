package Cenarios;

import Criaturas.Guarda;
import Criaturas.Inimigos;

public class CenaCastelo extends Cenas{
    Inimigos inimigo = new Guarda();

    public String getTitulo(){
        return "ENTRADA DO CASTELO";
    }
    public String getTransicao(){
        return "Depois de algum tempo na floresta você avistou algo no horizonte e foi em direção";
    }
    public String getFundo(){
        return "src/Cenarios/Imagens/castelo.jpg";
    }
    public String getDialogo1(){
        return "Você conseguiu sair da floresta e avistou um castelo, se aproximando dele um guarda veio falar com você, o que deseja fazer?";
    }
    public String getDialogo2(){
        return "Você conseguiu convencer ele e agora pode entrar no castelo";
    }
    public Inimigos getInimigo(){
        return inimigo;
    }
}
