package Cenarios;

import Criaturas.Dragao;
import Criaturas.Inimigos;
import Criaturas.Mago;

public class CenaTerraco extends Cenas{

    Inimigos inimigo = new Dragao();

    public String getFundo(){
        return "src/Cenarios/Imagens/terrace-background.png";
    }
    public String getDialogo1(){
        return "Explorando o castelo você foi parar no terraço e achou um dragão, o que deseja fazer?";
    }
    public String getDialogo2(){
        return "Porque vocẽ tentou conversar com um dragão?";
    }
    public Inimigos getInimigo(){
        return inimigo;
    }
}
