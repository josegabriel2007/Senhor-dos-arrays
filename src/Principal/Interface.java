package Principal;

import Cenarios.*;
import Criaturas.*;

import javax.swing.*;
import java.awt.*;

public class Interface extends JFrame {
    Personagens você;
    public int valorCenario = 0;
    public boolean valorBatalha = false;
    public boolean terminou = false;


    public Interface() {
        setTitle("Senhor dos Arrays");
        setSize(1000,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        trocarTela();
    }

    public void trocarTela() {
        getContentPane().removeAll();
        if (valorCenario == 0) {
            TelaInicial menu = new TelaInicial();

            menu.iniciar.addActionListener(e -> {
                valorCenario = 1;
                trocarTela();
            });
            add(menu);
        } //        TELA DE ESCOLHA
        else if (valorCenario == 1) {
            Escolha menuEscolha = new Escolha();

            menuEscolha.elfo.addActionListener(e -> {
                você = new Elfo("Elfo");
                valorCenario = 2;
                trocarTela();
            });

            menuEscolha.guerreiro.addActionListener(e -> {
                você = new Guerreiro("Guerreiro");
                valorCenario = 2;
                trocarTela();
            });

            menuEscolha.barbaro.addActionListener(e -> {
                você = new Barbaro("Barbaro");
                valorCenario = 2;
                trocarTela();
            });
            add(menuEscolha);
            } //       PRIMEIRO CENARIO
        else if (valorCenario == 2){
            Cenas floresta = new CenaFloresta();
            Dialogo dialogo = new Dialogo(this,floresta,você);

            //Ação do botão conversar que reinicia o jogo
            dialogo.botaoConversar.addActionListener(e -> {
                dialogo.botaoConversar.setText("REINICIAR");
                dialogo.botaoAtacar.setEnabled(false);
                dialogo.botaoConversar.addActionListener(e1 -> {
                    valorCenario = 0;
                    trocarTela();
                });
            });

            //Ação do botão atacar que começa a batalha
            dialogo.botaoAtacar.addActionListener(e -> {
                valorBatalha = true;
                trocarTela();
            });
                 if (valorCenario == 2 && valorBatalha == true) {
                     Batalha batalha = new Batalha(this, floresta, você);
                     batalha.BarraPersonagem = 100;
                     Timer monitor = new Timer(100,e -> {
                         if (batalha.BarraPersonagem == 0) {
                             valorCenario = 0;
                             valorBatalha = false;
                             trocarTela();
                             ((Timer)e.getSource()).stop();
                         }
                          else if (batalha.BarraInimigo == 0) {
                             valorCenario = 3;
                             valorBatalha = false;
                             trocarTela();
                             ((Timer)e.getSource()).stop();
                         }
                     });
                    monitor.start();
                 }
        }//         SEGUNDO CENARIO
        else if (valorCenario == 3){
            Cenas castelo = new CenaCastelo();
            Dialogo dialogo = new Dialogo(this,castelo,você);

            //Ação do botão conversar que você tenta persuadir o guarda
            dialogo.botaoConversar.setText("PERSUADIR");
            dialogo.botaoConversar.addActionListener(e -> {
                dialogo.botaoConversar.setText("ENTRAR");
                dialogo.botaoAtacar.setEnabled(false);
                dialogo.botaoConversar.addActionListener(e1 -> {
                    valorCenario = 4;
                    trocarTela();
                });
            });

            //Ação do botão atacar que começa a batalha
            dialogo.botaoAtacar.addActionListener(e -> {
                valorBatalha = true;
                trocarTela();
            });
            if (valorCenario == 3 && valorBatalha == true) {
                Batalha batalha = new Batalha(this, castelo, você);

                Timer monitor = new Timer(100,e -> {
                    if (batalha.BarraPersonagem == 0) {
                        valorCenario = 0;
                        valorBatalha = false;
                        trocarTela();
                        ((Timer)e.getSource()).stop();
                    }
                    else if (batalha.BarraInimigo == 0) {
                        valorCenario = 4;
                        valorBatalha = false;
                        trocarTela();
                        ((Timer)e.getSource()).stop();
                    }
                });
                monitor.start();
            }
        }       //TERCEIRO CENARIO
        else if (valorCenario == 4){
            Cenas prisao = new CenaPrisao();
            Dialogo dialogo = new Dialogo(this,prisao,você);

            //Ação do botão conversar que começa uma batalha com menos vida pois o mago te atacou
            dialogo.botaoConversar.addActionListener(e -> {
                dialogo.botaoAtacar.setText("BATALHAR");
                dialogo.botaoConversar.setEnabled(false);
                //Começo da batalha
                dialogo.botaoAtacar.addActionListener(e1 -> {
                    Batalha batalha = new Batalha(this, prisao, você);
                    batalha.BarraPersonagem = batalha.BarraPersonagem - 20;
                    Timer monitor = new Timer(100,e2 -> {
                        if (batalha.BarraPersonagem == 0) {
                            valorCenario = 0;
                            valorBatalha = false;
                            trocarTela();
                            ((Timer)e.getSource()).stop();
                        }
                        else if (batalha.BarraInimigo == 0) {
                            valorCenario = 5;
                            valorBatalha = false;
                            trocarTela();
                            ((Timer)e.getSource()).stop();
                        }
                    });
                    monitor.start();
                    trocarTela();
                });
            });

            //Ação do botão atacar que inicia a batalha
            dialogo.botaoAtacar.addActionListener(e -> {
                valorBatalha = true;
                trocarTela();
            });
            if (valorCenario == 4 && valorBatalha == true) {
                Batalha batalha = new Batalha(this, prisao, você);

                Timer monitor = new Timer(100,e -> {
                    if (batalha.BarraPersonagem == 0) {
                        valorCenario = 0;
                        valorBatalha = false;
                        trocarTela();
                        ((Timer)e.getSource()).stop();
                    }
                    else if (batalha.BarraInimigo == 0) {
                        valorCenario = 5;
                        valorBatalha = false;
                        trocarTela();
                        ((Timer)e.getSource()).stop();
                    }
                });
                monitor.start();
            }
            }// QUARTO CENARIO
        else if (valorCenario == 5){
            Cenas terraco = new CenaTerraco();
            Dialogo dialogo = new Dialogo(this,terraco,você);

            //Ação do botão conversar que reinicia o jogo
            dialogo.botaoConversar.addActionListener(e -> {
                dialogo.botaoConversar.setText("REINICIAR");
                dialogo.botaoAtacar.setEnabled(false);
                dialogo.botaoConversar.addActionListener(e1 -> {
                    valorCenario = 0;
                    trocarTela();
                });
            });

            //Ação do botão atacar que começa a batalha
            dialogo.botaoAtacar.addActionListener(e -> {
                valorBatalha = true;
                trocarTela();
            });
            if (valorCenario == 5 && valorBatalha == true) {
                Batalha batalha = new Batalha(this, terraco, você);

                Timer monitor = new Timer(100,e -> {
                    if (batalha.BarraPersonagem == 0) {
                        valorCenario = 0;
                        batalha.BarraPersonagem = 100;
                        valorBatalha = false;
                        trocarTela();
                        ((Timer)e.getSource()).stop();
                    }
                    else if (batalha.BarraInimigo == 0) {
                        valorCenario = 0;
                        valorBatalha = false;
                        trocarTela();
                        ((Timer)e.getSource()).stop();
                    }
                });
                monitor.start();
            }
        }
        revalidate();
        repaint();
    }
}