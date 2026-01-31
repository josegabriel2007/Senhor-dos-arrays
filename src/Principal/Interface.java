package Principal;

import Cenarios.*;
import Criaturas.*;

import javax.swing.*;
import java.awt.*;

public class Interface extends JFrame {
    Personagens você;
    public int valorCenario = 1;
    public boolean valorBatalha = false;
    public boolean terminou = false;


    public Interface() {
        setTitle("Senhor dos Arrays");
        setSize(1500,900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        trocarTela();
    }

    public void trocarTela() {
        getContentPane().removeAll();
        if (valorCenario == 0){
            TelaAjuda ajuda = new TelaAjuda();
            ajuda.voltar.addActionListener(e -> {
                valorCenario ++;
                trocarTela();
            });
            add(ajuda);
        } else if (valorCenario == 1) {
            TelaInicial menu = new TelaInicial();

            menu.iniciar.addActionListener(e -> {
                valorCenario ++;
                trocarTela();
            });
            menu.ajuda.addActionListener(e -> {
                valorCenario --;
                trocarTela();
            });
            add(menu);
        } //        TELA DE ESCOLHA
        else if (valorCenario == 2) {
            Escolha menuEscolha = new Escolha();

            menuEscolha.elfo.addActionListener(e -> {
                você = new Elfo("Elfo");
                valorCenario ++;
                trocarTela();
            });

            menuEscolha.guerreiro.addActionListener(e -> {
                você = new Guerreiro("Guerreiro");
                valorCenario ++;
                trocarTela();
            });

            menuEscolha.barbaro.addActionListener(e -> {
                você = new Barbaro("Barbaro");
                valorCenario ++;
                trocarTela();
            });
            add(menuEscolha);
            } else if (valorCenario == 3) {
            Cenas principe = new CenaPrincipe();
            TelaTextos transicao = new TelaTextos(principe);
            transicao.avancar.addActionListener(e -> {
                valorCenario ++;
                trocarTela();
            });
            add(transicao);
        }
        //       PRIMEIRO CENARIO
        else if (valorCenario == 4) {
            Cenas principe = new CenaPrincipe();
            Dialogo dialogo = new Dialogo(this, principe, você);

            dialogo.botaoConversar.addActionListener(e -> {
                dialogo.botaoConversar.setText("SIM");
                dialogo.botaoAtacar.setText("NÃO");
                dialogo.botaoConversar.addActionListener(e1 -> {
                    valorCenario ++;
                    trocarTela();
                });
                dialogo.botaoAtacar.addActionListener(e2 -> {
                   valorCenario = 20;
                   trocarTela();
                });
            });

            dialogo.botaoAtacar.addActionListener(e -> {
                dialogo.botaoConversar.setText("REINICIAR");
                dialogo.botaoAtacar.setEnabled(false);
                dialogo.botaoConversar.addActionListener(e1 -> {
                    valorCenario = 1;
                    trocarTela();
                });
            });
        } else if (valorCenario == 5) {
            Cenas floresta = new CenaFloresta();
            TelaTextos transicao = new TelaTextos(floresta);
            transicao.avancar.addActionListener(e -> {
                valorCenario ++;
                trocarTela();
            });
            add(transicao);
        }
        else if (valorCenario == 6){
            Cenas floresta = new CenaFloresta();
            Dialogo dialogo = new Dialogo(this,floresta,você);

            //Ação do botão conversar que reinicia o jogo
            dialogo.botaoConversar.addActionListener(e -> {
                dialogo.botaoConversar.setText("REINICIAR");
                dialogo.botaoAtacar.setEnabled(false);
                dialogo.botaoConversar.addActionListener(e1 -> {
                    valorCenario = 1;
                    trocarTela();
                });
            });

            //Ação do botão atacar que começa a batalha
            dialogo.botaoAtacar.addActionListener(e -> {
                valorBatalha = true;
                trocarTela();
            });

            if (valorCenario == 6 && valorBatalha == true) {
                Batalha batalha = new Batalha(this, floresta, você);
                batalha.BarraPersonagem = 100;
                Timer monitor = new Timer(100, e -> {
                    if (batalha.BarraPersonagem == 0) {
                        valorCenario = 1;
                        valorBatalha = false;
                        trocarTela();
                        ((Timer) e.getSource()).stop();
                    } else if (batalha.BarraInimigo == 0) {
                        valorCenario ++;
                        valorBatalha = false;
                        trocarTela();
                        ((Timer) e.getSource()).stop();
                    }
                });
                monitor.start();
            }
        } else if (valorCenario == 7) {
            Cenas castelo = new CenaCastelo();
            TelaTextos transicao = new TelaTextos(castelo);
            transicao.avancar.addActionListener(e -> {
                valorCenario ++;
                trocarTela();
            });
            add(transicao);
        }
        //         SEGUNDO CENARIO
        else if (valorCenario == 8){
            Cenas castelo = new CenaCastelo();
            Dialogo dialogo = new Dialogo(this,castelo,você);

            //Ação do botão conversar que você tenta persuadir o guarda
            dialogo.botaoConversar.setText("PERSUADIR");
            dialogo.botaoConversar.addActionListener(e -> {
                dialogo.botaoConversar.setText("ENTRAR");
                dialogo.botaoAtacar.setEnabled(false);
                dialogo.botaoConversar.addActionListener(e1 -> {
                    valorCenario ++;
                    trocarTela();
                });
            });

            //Ação do botão atacar que começa a batalha
            dialogo.botaoAtacar.addActionListener(e -> {
                valorBatalha = true;
                trocarTela();
            });
            if (valorCenario == 8 && valorBatalha == true) {
                Batalha batalha = new Batalha(this, castelo, você);

                Timer monitor = new Timer(100,e -> {
                    if (batalha.BarraPersonagem == 0) {
                        valorCenario = 1;
                        valorBatalha = false;
                        trocarTela();
                        ((Timer)e.getSource()).stop();
                    }
                    else if (batalha.BarraInimigo == 0) {
                        valorCenario ++;
                        valorBatalha = false;
                        trocarTela();
                        ((Timer)e.getSource()).stop();
                    }
                });
                monitor.start();
            }
        } else if (valorCenario == 9) {
            Cenas prisao = new CenaPrisao();
            TelaTextos transicao = new TelaTextos(prisao);
            transicao.avancar.addActionListener(e -> {
                valorCenario ++;
                trocarTela();
            });
            add(transicao);
        }
        //TERCEIRO CENARIO
        else if (valorCenario == 10){
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
                            valorCenario = 1;
                            valorBatalha = false;
                            trocarTela();
                            ((Timer)e.getSource()).stop();
                        }
                        else if (batalha.BarraInimigo == 0) {
                            valorCenario ++;
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
            if (valorCenario == 10 && valorBatalha == true) {
                Batalha batalha = new Batalha(this, prisao, você);

                Timer monitor = new Timer(100,e -> {
                    if (batalha.BarraPersonagem == 0) {
                        valorCenario = 1;
                        valorBatalha = false;
                        trocarTela();
                        ((Timer)e.getSource()).stop();
                    }
                    else if (batalha.BarraInimigo == 0) {
                        valorCenario ++;
                        valorBatalha = false;
                        trocarTela();
                        ((Timer)e.getSource()).stop();
                    }
                });
                monitor.start();
            }
        } else if (valorCenario == 11) {
            Cenas terraco = new CenaTerraco();
            TelaTextos transicao = new TelaTextos(terraco);
            transicao.avancar.addActionListener(e -> {
                valorCenario ++;
                trocarTela();
            });
            add(transicao);
        }
        // QUARTO CENARIO
        else if (valorCenario == 12){
            Cenas terraco = new CenaTerraco();
            Dialogo dialogo = new Dialogo(this,terraco,você);

            //Ação do botão conversar que reinicia o jogo
            dialogo.botaoConversar.addActionListener(e -> {
                dialogo.botaoConversar.setText("REINICIAR");
                dialogo.botaoAtacar.setEnabled(false);
                dialogo.botaoConversar.addActionListener(e1 -> {
                    valorCenario = 1;
                    trocarTela();
                });
            });

            //Ação do botão atacar que começa a batalha
            dialogo.botaoAtacar.addActionListener(e -> {
                valorBatalha = true;
                trocarTela();
            });
            if (valorCenario == 12 && valorBatalha == true) {
                Batalha batalha = new Batalha(this, terraco, você);

                Timer monitor = new Timer(100,e -> {
                    if (batalha.BarraPersonagem == 0) {
                        valorCenario = 1;
                        batalha.BarraPersonagem = 100;
                        valorBatalha = false;
                        trocarTela();
                        ((Timer)e.getSource()).stop();
                    }
                    else if (batalha.BarraInimigo == 0) {
                        valorCenario = 1;
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