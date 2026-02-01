package Criaturas;

public class Soldado extends Inimigos{
    public Soldado(){
        super("Soldado",450, 50,"450");
    }

    public String getIcon(){
        return "src/Criaturas/Icons/soldado.png";
    };
    public String getVidaMaxima(){
        return vidaMaxima;
    };
    @Override
    public void atacar(Entidades alvo) {
        alvo.receberDano(this.ataque);
    }
}
