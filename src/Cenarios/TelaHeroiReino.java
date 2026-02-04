package Cenarios;

import Criaturas.Dragao;
import Criaturas.Inimigos;

public class TelaHeroiReino extends Cenas{
    Inimigos inimigo = new Dragao();

    public String getTitulo(){
        return "PARABÉNS, VOCÊ SALVOU O REINO!";
    }
    public String getTransicao(){
        return "Com um nobre coração, agiu de acordo com suas convicções e essa intuição que não falha, o rei foi exilado e seu filho assumiu o posto, com honra e empatia, agora serve ao povo, e não a si mesmo. E você? Sempre terá a gratidão do povo e será lembrado como \"o Herói\". Mas... no fim, será que você fez a escolha mais inteligente? ";
    }
    public String getFundo(){
        return "";
    }
    public String getDialogo1(){
        return "";
    }
    public String getDialogo2(){
        return "";
    }
    public Inimigos getInimigo(){
        return inimigo;
    }
}