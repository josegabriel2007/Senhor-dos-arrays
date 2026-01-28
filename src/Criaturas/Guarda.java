package Criaturas;

public class Guarda extends Inimigos {
    public Guarda(){
        super("Guarda",60, 10);
    }

    @Override
    public void atacar(Entidades alvo) {
        alvo.receberDano(this.ataque);
    }
}
