package Criaturas;
public abstract class Inimigos extends Entidades{
    public Inimigos(String nome,int vida, int ataque, String vidaMaxima){
        super(nome, vida, ataque, vidaMaxima);
    }

    public abstract void atacar(Entidades alvo);
    public abstract String getIcon();
    public abstract String getVidaMaxima();
}
