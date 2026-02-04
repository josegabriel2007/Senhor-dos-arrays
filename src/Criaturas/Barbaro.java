package Criaturas;
public class Barbaro extends Personagens{
    //Barbaro: -vida, +ataque
    public Barbaro(String nome){
        super(nome, 300, 100,"300");
    }

    public String getIcon(){
        return "Criaturas/Icons/barbaro.png";
    };
    public String getVidaMaxima(){
        return vidaMaxima;
    };
}