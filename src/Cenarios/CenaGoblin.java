package Cenarios;

import Criaturas.Goblin;
import Criaturas.Inimigos;

public class CenaGoblin extends Cenas{

    Inimigos inimigo = new Goblin();

    public String getTitulo(){
        return "FLORESTA";
    }
    public String getTransicao(){
        return "Andando mais um pouco pela floresta, você sente a presença de algo, mas não sabe o que é.";
    }
    public String getFundo(){
        return "src/Cenarios/Imagens/floresta.jpg";
    }
    public String getDialogo1(){
        return "Você não sabe falar goblinês. Ele ri da sua cara enquanto você se embola com as palavras";
    }
    public String getDialogo2(){
        return "\"gur groug urg\". Desta vez, ele até tenta se comunicar, mas desiste e começa a ficar impaciente. Pare com essa brincadeiras gostosas, você vai acabar morto.";
    }
    public Inimigos getInimigo(){
        return inimigo;
    }
}