package Criaturas;

public class Mago extends Inimigos {
    public Mago(){
        super("Mago",400, 50,"400");
    }

    public String getIcon(){
        return "src/Criaturas/Icons/darkmage-sprite.png";
    };
    public String getVidaMaxima(){
        return vidaMaxima;
    };
    @Override
    public void atacar(Entidades alvo) {
        alvo.receberDano(this.ataque);
    }
}
