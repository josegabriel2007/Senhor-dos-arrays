package Criaturas;

public class Mago extends Inimigos {
    public Mago(){
        super("Mago",600, 100);
    }

    public String getIcon(){
        return "src/Cenarios/Imagens/darkmage-sprite.png";
    };
    @Override
    public void atacar(Entidades alvo) {
        alvo.receberDano(this.ataque);
    }
}
