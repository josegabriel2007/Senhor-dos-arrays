package Jogaveis;
public class Elfo extends Personagens{
    //Elfo: +vida, -ataque
    public Elfo(String nome){
        super(nome, 45, 15);
    }
    public void atacar(Entidades alvo){
        alvo.receberDano(this.ataque);
    }
}
