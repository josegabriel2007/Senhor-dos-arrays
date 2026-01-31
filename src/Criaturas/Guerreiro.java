package Criaturas;
public class Guerreiro extends Personagens{
    //Guerreiro: Balanceado
    public Guerreiro(String nome){
        super(nome, 400, 85,"400");
    }

    public String getIcon(){
        return "src/Criaturas/Icons/guerreiro.png";
    };
    public String getVidaMaxima(){
        return vidaMaxima;
    };
    public void atacar(Entidades alvo){
        alvo.receberDano(this.ataque);
    }
}