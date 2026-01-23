public class Barbaro extends Personagens{
    //Barbaro: -vida, +ataque
    public Barbaro(String nome){
        super(nome, 35, 25);
    }
    public void atacar(Entidades alvo){
        alvo.receberDano(this.ataque);
    }
}
