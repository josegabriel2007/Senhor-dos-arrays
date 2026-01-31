package Criaturas;

public class Principe extends Inimigos{
    public Principe(){
        super("Principe",20, 5,"20");
    }

    public String getIcon(){
        return "src/Criaturas/Icons/principe.png";
    };
    public String getVidaMaxima(){
        return vidaMaxima;
    };
    @Override
    public void atacar(Entidades alvo) {
        alvo.receberDano(this.ataque);
    }
}
