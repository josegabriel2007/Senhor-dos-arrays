package Cenarios;

import Criaturas.Inimigos;
import Criaturas.Ladrao;

public class CenaPrisao extends Cenas{

    Inimigos inimigo = new Ladrao();

    public String getTitulo(){
        return "PRISÃO";
    }
    public String getTransicao(){
        return "Como você não foi convidado, você teve que andar furtivamente pelo castelo, e olha onde veio parar.";
    }
    public String getFundo(){
        return "src/Cenarios/Imagens/prisao.jpg";
    }
    public String getDialogo1(){
        return "Você acabou entrando na prisão, e encontrou um prisioneiro que escapou durante o caos, ele estava saqueando os soldados desacordados, o que deseja fazer?";
    }
    public String getDialogo2(){
        return "Preocupado com sua presença, momentos antes de sair do seu campo de visão ele lança uma poção amaldiçoada sobre você. \n(Você perdeu 10 pontos de ataque)";
    }
    public Inimigos getInimigo(){
        return inimigo;
    }
}