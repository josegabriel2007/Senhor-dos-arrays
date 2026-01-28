package Criaturas;
public class Goblin extends Inimigos{
    public Goblin(){
        super("Goblin",500, 50);
    }

    public String getIcon(){
        return "src/Cenarios/Imagens/goblin-sprite.png";
    };
    @Override
    public void atacar(Entidades alvo) {
        alvo.receberDano(this.ataque);
    }
}
