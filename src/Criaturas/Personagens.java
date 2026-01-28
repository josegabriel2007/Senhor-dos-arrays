package Criaturas;
public abstract class Personagens extends Entidades{
    public Personagens(String nome,int vida,int ataque){
        super(nome, vida, ataque);
    }

    public abstract void atacar(Entidades alvo);
    public abstract String getIcon();

    public int pocao(int cura){
        return cura;
    }
}
