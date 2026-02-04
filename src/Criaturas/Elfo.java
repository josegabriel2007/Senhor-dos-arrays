package Criaturas;
public class Elfo extends Personagens{
    //Elfo: +vida, -ataque
    public Elfo(String nome){
        super(nome, 500, 80,"500");
    }

    public String getIcon(){
        return "Criaturas/Icons/elfo.png";
    };
    public String getVidaMaxima(){
        return vidaMaxima;
    };
}
