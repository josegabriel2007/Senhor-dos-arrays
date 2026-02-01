package Cenarios;

import Criaturas.Soldado;
import Criaturas.Inimigos;

public class CenaCorredor extends Cenas{

    Inimigos inimigo = new Soldado();

    public String getTitulo(){
        return "CORREDOR DO CASTELO";
    }
    public String getTransicao(){
        return "Explorando o castelo em busca do mago, você parece que encontrou alguém.";
    }
    public String getFundo(){
        return "src/Cenarios/Imagens/corredor.png";
    }
    public String getDialogo1(){
        return "Você achou um soldado que também está a procura do mago, o que desejas fazer?";
    }
    public String getDialogo2(){
        return "Você explicou que também está a procura do mago e ele te deixou passar";
    }
    public Inimigos getInimigo(){
        return inimigo;
    }
}
