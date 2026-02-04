package Criaturas;
public abstract class Personagens extends Entidades{
    public Personagens(String nome,double vida,double ataque,String vidaMaxima){
        super(nome, vida, ataque, vidaMaxima);
    }

    public abstract String getIcon();
    public abstract String getVidaMaxima();

    public int pocao(int cura){
        return cura;
    }
    public double bonus(boolean bonus){
        return ataque += 5;
    }
    public double maldicao(boolean maldicao){
        return ataque -= 5;
    }
}
