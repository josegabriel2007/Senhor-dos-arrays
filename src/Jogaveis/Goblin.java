package Jogaveis;
public class Goblin extends Inimigos{
    public Goblin(){
        super("Goblin",60, 10);
    }

    @Override
    public void atacar(Entidades alvo) {
        alvo.receberDano(this.ataque);
    }
}
