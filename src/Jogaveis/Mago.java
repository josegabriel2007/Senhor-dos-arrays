package Jogaveis;

public class Mago extends Inimigos {
    public Mago(){
        super("Mago",60, 10);
    }

    @Override
    public void atacar(Entidades alvo) {
        alvo.receberDano(this.ataque);
    }
}
