package Criaturas;
public abstract class Inimigos extends Entidades{
    public Inimigos(String nome,int vida, int ataque){
        super(nome, vida, ataque);
    }

    public abstract void atacar(Entidades alvo);
    public abstract String getIcon();
}
