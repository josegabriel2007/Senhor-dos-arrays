package Criaturas;
public class Elfo extends Personagens{
    //Elfo: +vida, -ataque
    public Elfo(String nome){
        super(nome, 600, 79,"600");
    }
    public String getIcon(){
        return "src/Criaturas/Icons/elfo.png";
    };
    public String getVidaMaxima(){
        return vidaMaxima;
    };
    public void atacar(Entidades alvo){
        alvo.receberDano(this.ataque);
    }
}
