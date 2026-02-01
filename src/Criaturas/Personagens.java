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
}
