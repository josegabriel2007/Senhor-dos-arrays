package Cenarios;

import Criaturas.Principe;
import Criaturas.Inimigos;

public class CenaPrincipe extends Cenas{

    Inimigos inimigo = new Principe();

    public String getTitulo(){
        return "FLORESTA";
    }
    public String getTransicao(){
        return "Olá, aventureiro! Uma floresta densa e milenar se estende diante de você. Suas copas se entrelaçam em um dossel quase impenetrável, bloqueando a luz solar e mergulhando o caminho em uma penumbra constante. Grandes aventuras o aguardam; é aqui que sua jornada começa.";
    }
    public String getFundo(){
        return "src/Cenarios/Imagens/floresta.jpg";
    }
    public String getDialogo1(){
        return "Enquanto você viaja pela floresta, você encontra um menino. Ele parece desnorteado, assustado e sozinho, o que deseja fazer?";
    }
    public String getDialogo2(){
        return "Ele se diz príncipe do reino e pede desesperadamente por sua ajuda. Ele pede que salve seu castelo, que foi invadido por monstros.\n" +
                "Você pretende ajudá-lo?";
    }
    public Inimigos getInimigo(){
        return inimigo;
    }
}