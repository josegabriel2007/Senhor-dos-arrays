package Criaturas;

public class Guarda extends Inimigos {
    public Guarda(){
        super("Guarda",600, 10);
    }

    public String getIcon(){
        return "src/Cenarios/Imagens/guardian1-sprite.png";
    }
    @Override
    public void atacar(Entidades alvo) {
        alvo.receberDano(this.ataque);
    }
}
