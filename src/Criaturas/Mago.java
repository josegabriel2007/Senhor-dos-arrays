package Criaturas;

public class Mago extends Inimigos {
    public Mago(){
        super("Mago",480, 53,"480");
    }

    public String getIcon(){
        return "Criaturas/Icons/darkmage-sprite.png";
    };
    public String getVidaMaxima(){
        return vidaMaxima;
    };
    @Override
    public void atacar(Entidades alvo) {
        alvo.receberDano(this.ataque);
    }
}
