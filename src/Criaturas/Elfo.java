package Criaturas;
public class Elfo extends Personagens{
    //Elfo: +vida, -ataque
    public Elfo(String nome){
        super(nome, 500, 250);
    }
    public String getIcon(){
        return "src/Cenarios/Imagens/elfo.png";
    };
    public void atacar(Entidades alvo){
        alvo.receberDano(this.ataque);
    }
}
