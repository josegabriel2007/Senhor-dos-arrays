package Criaturas;
public class Guerreiro extends Personagens{
    //Guerreiro: Balanceado
    public Guerreiro(String nome){
        super(nome, 40, 20);
    }

    public String getIcon(){
        return "src/Cenarios/Imagens/guerreiro.png";
    };
    public void atacar(Entidades alvo){
        alvo.receberDano(this.ataque);
    }
}