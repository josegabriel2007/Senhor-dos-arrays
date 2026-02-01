package Criaturas;
public abstract class Entidades {
    public String nome;
    public double vida;
    public double ataque;
    public String vidaMaxima;

    public Entidades(String nome, double vida, double ataque, String vidaMaxima) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.vidaMaxima = vidaMaxima;
    }

//Getters
    public String getNome() {
        return nome;
    }
    public double getVida() {
        return vida;
    }
    public double getAtaque() {
        return ataque;
    }
    public abstract String getVidaMaxima();
    public abstract String getIcon();

    public void receberDano(double dano){
        vida -= dano;
        if (vida < 0) {
            vida = 0;
        }
    }
}
