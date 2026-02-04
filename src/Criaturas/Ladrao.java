package Criaturas;

public class Ladrao extends  Inimigos{
    public Ladrao(){
        super("Ladrão",430, 52,"430");
    }

    public String getIcon(){
        return "Criaturas/Icons/ladrao.png";
    };
    public String getVidaMaxima(){
        return vidaMaxima;
    };
    @Override
    public void atacar(Entidades alvo) {
        alvo.receberDano(this.ataque);
    }
}
