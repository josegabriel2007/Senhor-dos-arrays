package Criaturas;

public class Guarda extends Inimigos {
    public Guarda(){
        super("Guarda",400, 40,"400");
    }

    public String getIcon(){
        return "src/Criaturas/Icons/guardian1-sprite.png";
    }
    public String getVidaMaxima(){
        return vidaMaxima;
    };
    @Override
    public void atacar(Entidades alvo) {
        alvo.receberDano(this.ataque);
    }
}
