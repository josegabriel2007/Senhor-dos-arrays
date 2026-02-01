package Cenarios;

import Criaturas.Inimigos;
import Criaturas.Ladrao;

public class CenaPrisao extends Cenas{

    Inimigos inimigo = new Ladrao();

    public String getTitulo(){
        return "PRISÃO";
    }
    public String getTransicao(){
        return "Como você não foi convidado, você teve que andar furtivamente pelo castelo, e olha onde veio parar";
    }
    public String getFundo(){
        return "src/Cenarios/Imagens/prisao.png";
    }
    public String getDialogo1(){
        return "Enquanto você se esgueirava pelos corredores do castelo, você encontrou um ladrão (ele não é muito diferente de você), o que deseja fazer?";
    }
    public String getDialogo2(){
        return "Ele só queria saquear o castelo, então também te ignorou.";
    }
    public Inimigos getInimigo(){
        return inimigo;
    }
}