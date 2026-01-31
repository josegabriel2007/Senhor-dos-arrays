package Cenarios;

import Criaturas.Dragao;
import Criaturas.Inimigos;
import Criaturas.Mago;

public class CenaTerraco extends Cenas{

    Inimigos inimigo = new Dragao();

    public String getTitulo(){
        return "TERRAÇO";
    }
    public String getTransicao(){
        return "Depois de explorar bastante o castelo, parece que você achou uma 'saida' ";
    }
    public String getFundo(){
        return "src/Cenarios/Imagens/terraco.png";
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
