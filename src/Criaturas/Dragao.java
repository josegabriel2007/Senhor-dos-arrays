package Criaturas;

public class Dragao extends Inimigos {
    public Dragao(){
        super("Dragao",400, 50,"400");
    }

    public String getIcon(){
        return "src/Criaturas/Icons/dragon-sprite.png";
    };
    public String getVidaMaxima(){
        return vidaMaxima;
    };
    @Override
    public void atacar(Entidades alvo) {
        alvo.receberDano(this.ataque);
    }
}
