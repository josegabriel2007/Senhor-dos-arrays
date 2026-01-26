package Jogaveis;

public class Dragao extends Inimigos {
    public Dragao(){
        super("Dragao",60, 10);
    }

    @Override
    public void atacar(Entidades alvo) {
        alvo.receberDano(this.ataque);
    }
}
