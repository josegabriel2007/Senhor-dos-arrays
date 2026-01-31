package Criaturas;
public class Goblin extends Inimigos{
    public Goblin(){
        super("Goblin",377, 35,"377");
    }

    public String getIcon(){
        return "src/Criaturas/Icons/goblin-sprite.png";
    };
    public String getVidaMaxima(){
        return vidaMaxima;
    };
    @Override
    public void atacar(Entidades alvo) {
        alvo.receberDano(this.ataque);
    }
}
