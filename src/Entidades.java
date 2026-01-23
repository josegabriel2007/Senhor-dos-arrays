public abstract class Entidades {
    public String nome;
    public int vida;
    public int ataque;

    public Entidades(String nome, int vida, int ataque){
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
    }

    public abstract void atacar(Entidades alvo);

//Getters
    public String getNome() {
        return nome;
    }
    public int getVida() {
        return vida;
    }
    public int getAtaque() {
        return ataque;
    }

    public void receberDano(int dano){
        vida -= dano;
        if (vida < 0) {
            vida = 0;
        }
    }
}
