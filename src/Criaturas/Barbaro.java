package Criaturas;
public class Barbaro extends Personagens{
    //Barbaro: -vida, +ataque
    public Barbaro(String nome){
        super(nome, 35, 25);
    }

    public String getIcon(){
        return "src/Cenarios/Imagens/barbaro.png";
    };
    public void atacar(Entidades alvo){
        alvo.receberDano(this.ataque);
    }
}
