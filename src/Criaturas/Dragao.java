package Criaturas;

public class Dragao extends Inimigos {
    public Dragao(){
        super("Dragao",650, 57,"650");
    }

    public String getIcon(){
        return "src/Criaturas/Icons/dragao.png";
    };
    public String getVidaMaxima(){
        return vidaMaxima;
    };
    @Override
    public void atacar(Entidades alvo) {
        alvo.receberDano(this.ataque);
    }
}
