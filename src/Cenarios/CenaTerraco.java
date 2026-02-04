package Cenarios;

import Criaturas.Dragao;
import Criaturas.Inimigos;

public class CenaTerraco extends Cenas{

    Inimigos inimigo = new Dragao();

    public String getTitulo(){
        return "TERRAÇO";
    }
    public String getTransicao(){
        return "Depois de derrotar o mago, você escuta um estrondoso rugido, talvez uma ultima ameaça, aparentemente o mago não estava sozinho.";
    }
    public String getFundo(){
        return "src/Cenarios/Imagens/terraco.jpg";
    }
    public String getDialogo1(){
        return "Chegando no terraço do castelo você achou um dragão, o que deseja fazer?";
    }
    public String getDialogo2(){
        return "Porque vocẽ tentou conversar com um dragão? Vou te dar uma segunda chance, mas você iniciará a batalha com menos vida.";
    }
    public Inimigos getInimigo(){
        return inimigo;
    }
}
