package Cenarios;

import Criaturas.Goblin;
import Criaturas.Inimigos;

public class CenaFloresta extends Cenas{

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
        return "Você acabou encontrando um goblin, ele faz sons estranhos e parece impaciente, o que deseja fazer?";
    }
    public String getDialogo2(){
        return "Ele não te entendeu, ficou furioso e acabou te atacando enquanto você estava desprevenido.\n(Você iniciará a batalha com menos vida)";
    }
    public Inimigos getInimigo(){
        return inimigo;
    }
}
