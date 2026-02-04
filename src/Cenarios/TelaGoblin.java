package Cenarios;

import Criaturas.Dragao;
import Criaturas.Inimigos;

public class TelaGoblin extends Cenas{
    Inimigos inimigo = new Dragao();

    public String getTitulo(){
        return "PARABÉNS, VOCÊ É QUASE UM INÚTIL!";
    }
    public String getTransicao(){
        return "Você conseguiu passar pelo goblin, mas seu senso de direção é péssimo, você se perde e acaba parando na goblinlândia, então se dedica a aprender goblinês, terminando sua vida nessas terras como um verdadeiro goblin.\nEssa foi a melhor decisão que poderia tomar!\nSuas últimas palavras: \"gru grou goru grau!\" (Encontrei a felicidade!)";
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