public abstract class Personagens extends Entidades{
    public Personagens(String nome,int vida,int ataque){
        super(nome, vida, ataque);
    }

    public abstract void atacar();

    public void pocao(int cura){
        this.vida += 10;
    }
}
