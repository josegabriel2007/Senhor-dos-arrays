public class Bug extends Inimigos{
    public Bug(){
        super("Bug", 50, 7);
    }

    @Override
    public void atacar(Entidades alvo) {
        alvo.receberDano(this.ataque);
    }
}
