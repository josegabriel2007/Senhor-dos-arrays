package Criaturas;

public class Dragao extends Inimigos {
    public Dragao(){
        super("Dragao",60, 10);
    }

    public String getIcon(){
        return "src/Cenarios/Imagens/dragon-sprite.png";
    };
    @Override
    public void atacar(Entidades alvo) {
        alvo.receberDano(this.ataque);
    }
}
