package Principal;

import Cenarios.*;
import Criaturas.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Interface extends JFrame {
    Personagens você;
    public int valorCenario = 1;
    public boolean valorBatalha = false;
    public boolean terminou = false;
    protected boolean tomarDano = false;
    private int estadoDialogo = 0;


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
        //       PRIMEIRO CENARIO: PRINCIPE
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
                dialogo.zonaTexto.setText("Atacar uma criança, que tipo de herói é você? Enquanto você se prepara para atacá-la, uma guarda que procurava o príncipe na floresta estava à espreita. Ela te ataca pelas costas com um golpe fatal, e você morre.");
                dialogo.botaoConversar.addActionListener(e1 -> {
                    valorCenario = 30;
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
        } //  SEGUNDO CENARIO: GOBLIN
        else if (valorCenario == 6){
            Cenas floresta = new CenaFloresta();
            Dialogo dialogo = new Dialogo(this,floresta,você);

            //Ação do botão conversar que faz começar com menos vida
            dialogo.botaoConversar.addActionListener(e -> {
                    dialogo.botaoConversar.addActionListener(e1 -> {
                        valorCenario = 90;
                        trocarTela();
                    });
            });


            //Ação do botão atacar que começa a batalha
            dialogo.botaoAtacar.addActionListener(e -> {
                valorBatalha = true;
                trocarTela();
            });
            //Batalha começa
            if (valorCenario == 6 && valorBatalha == true) {
                Batalha batalha = new Batalha(this, floresta, você);
                batalha.BarraPersonagem = 100;

                if (tomarDano == true){
                    batalha.BarraPersonagem = batalha.BarraPersonagem - 15;
                    tomarDano = false;
                }

                Timer monitor = new Timer(100, e -> {
                    if (batalha.BarraPersonagem == 0) {
                        valorCenario = 30;
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
        }//         TERCEIRO CENARIO: GUARDA
        else if (valorCenario == 8){
            Cenas castelo = new CenaCastelo();
            Dialogo dialogo = new Dialogo(this,castelo,você);

            //Ação do botão conversar que você tenta subornar o guarda
            dialogo.botaoConversar.setText("SUBORNAR");
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
                        valorCenario = 30;
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
        }else if (valorCenario == 9) {
            Cenas corredor = new CenaCorredor();
            TelaTextos transicao = new TelaTextos(corredor);
            transicao.avancar.addActionListener(e -> {
                valorCenario ++;
                trocarTela();
            });
            add(transicao);
        }// QUARTO CENARIO: SOLDADO
        else if (valorCenario == 10) {
            Cenas corredor = new CenaCorredor();
            Dialogo dialogo = new Dialogo(this,corredor,você);

            //Ação do botão conversar que você tenta conversar com o soldado
            dialogo.botaoConversar.addActionListener(e -> {
                dialogo.heroi.bonus(true);
                dialogo.botaoConversar.setText("AVANÇAR");
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
            if (valorCenario == 10 && valorBatalha == true) {
                Batalha batalha = new Batalha(this, corredor, você);

                Timer monitor = new Timer(100,e -> {
                    if (batalha.BarraPersonagem == 0) {
                        valorCenario = 30;
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
            Cenas salao = new CenaSalao();
            TelaTextos transicao = new TelaTextos(salao);
            transicao.avancar.addActionListener(e -> {
                valorCenario ++;
                trocarTela();
            });
            add(transicao);
        }
        //     QUINTO CENARIO: MAGO
        else if (valorCenario == 12){
            Cenas salao = new CenaSalao();
            Dialogo dialogo = new Dialogo(this,salao,você);
            dialogo.botaoConversar.setText("OUVIR");
            //Ação do botão conversar que ele te conta a historia
            dialogo.botaoConversar.addActionListener(e -> {
                dialogo.botaoConversar.addActionListener(e1 -> {
                    valorCenario = 32;
                    trocarTela();
                });
                dialogo.botaoConversar.setText("SIM");
                dialogo.botaoAtacar.setText("NÃO");
            });

            //Ação do botão atacar que inicia a batalha
            dialogo.botaoAtacar.addActionListener(e -> {
                valorBatalha = true;
                trocarTela();
            });
            if (valorCenario == 12 && valorBatalha == true) {
                Batalha batalha = new Batalha(this, salao, você);

                Timer monitor = new Timer(100,e -> {
                    if (batalha.BarraPersonagem == 0) {
                        valorCenario = 30;
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
        } else if (valorCenario == 13) {
            Cenas terraco = new CenaTerraco();
            TelaTextos transicao = new TelaTextos(terraco);
            transicao.avancar.addActionListener(e -> {
                valorCenario ++;
                trocarTela();
            });
            add(transicao);
        }
        //      SEXTO CENARIO: DRAGÃO
        else if (valorCenario == 14){
            Cenas terraco = new CenaTerraco();
            Dialogo dialogo = new Dialogo(this,terraco,você);

            //Ação do botão conversar que reinicia o jogo
            dialogo.botaoConversar.addActionListener(e -> {
                dialogo.botaoConversar.setText("REINICIAR");
                dialogo.botaoConversar.addActionListener(e1 -> {
                    valorCenario = 30;
                    trocarTela();
                });
            });

            //Ação do botão atacar que começa a batalha
            dialogo.botaoAtacar.addActionListener(e -> {
                valorBatalha = true;
                trocarTela();
            });
            if (valorCenario == 14 && valorBatalha == true) {
                Batalha batalha = new Batalha(this, terraco, você);

                Timer monitor = new Timer(100,e -> {
                    if (batalha.BarraPersonagem == 0) {
                        valorCenario = 30;
                        batalha.BarraPersonagem = 100;
                        valorBatalha = false;
                        trocarTela();
                        ((Timer)e.getSource()).stop();
                    }
                    else if (batalha.BarraInimigo == 0) {
                        valorCenario = 31;
                        valorBatalha = false;
                        trocarTela();
                        ((Timer)e.getSource()).stop();
                    }
                });
                monitor.start();
            }
        }else if (valorCenario == 20) {
            Cenas floresta = new CenaFloresta();
            TelaTextos transicao = new TelaTextos(floresta);
            transicao.avancar.addActionListener(e -> {
                valorCenario ++;
                trocarTela();
            });
            add(transicao);
        }// SEGUNDA LINHA: SEGUNDO CENARIO: GOBLIN
        else if (valorCenario == 21) {
            Cenas floresta = new CenaFloresta();
            Dialogo dialogo = new Dialogo(this,floresta,você);

            //Ação do botão conversar que faz começar com menos vida
            dialogo.botaoConversar.addActionListener(e -> {
                dialogo.botaoAtacar.setText("BATALHAR");
                dialogo.botaoConversar.setEnabled(false);
                dialogo.botaoAtacar.addActionListener(e1 -> {
                    tomarDano = true;
                });
            });

            //Ação do botão atacar que começa a batalha
            dialogo.botaoAtacar.addActionListener(e -> {
                valorBatalha = true;
                trocarTela();
            });
            //Batalha começa
            if (valorCenario == 21 && valorBatalha == true) {
                Batalha batalha = new Batalha(this, floresta, você);
                batalha.BarraPersonagem = 100;

                if (tomarDano == true) {
                    batalha.BarraPersonagem = batalha.BarraPersonagem - 15;
                    tomarDano = false;
                }

                Timer monitor = new Timer(100, e -> {
                    if (batalha.BarraPersonagem == 0) {
                        valorCenario = 30;
                        valorBatalha = false;
                        trocarTela();
                        ((Timer) e.getSource()).stop();
                    } else if (batalha.BarraInimigo == 0) {
                        valorCenario++;
                        valorBatalha = false;
                        trocarTela();
                        ((Timer) e.getSource()).stop();
                    }
                });
                monitor.start();
            }
        }else if (valorCenario == 22) {
            Cenas castelo = new CenaCastelo();
            TelaTextos transicao = new TelaTextos(castelo);
            transicao.avancar.addActionListener(e -> {
                valorCenario ++;
                trocarTela();
            });
            add(transicao);
        }
        // SEGUNDA LINHA: TERCEIRO CENARIO: GUARDA
        else if (valorCenario == 23) {
            Cenas castelo = new CenaCastelo();
            Dialogo dialogo = new Dialogo(this,castelo,você);

            //Ação do botão conversar que você tenta subornar o guarda
            dialogo.botaoConversar.setText("SUBORNAR");
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
            if (valorCenario == 23 && valorBatalha == true) {
                Batalha batalha = new Batalha(this, castelo, você);

                Timer monitor = new Timer(100, e -> {
                    if (batalha.BarraPersonagem == 0) {
                        valorCenario = 30;
                        valorBatalha = false;
                        trocarTela();
                        ((Timer) e.getSource()).stop();
                    } else if (batalha.BarraInimigo == 0) {
                        valorCenario++;
                        valorBatalha = false;
                        trocarTela();
                        ((Timer) e.getSource()).stop();
                    }
                });
                monitor.start();
            }
        }else if (valorCenario == 24) {
            Cenas prisao = new CenaPrisao();
            TelaTextos transicao = new TelaTextos(prisao);
            transicao.avancar.addActionListener(e -> {
                valorCenario ++;
                trocarTela();
            });
            add(transicao);
        }
        // SEGUNDA LINHA: QUARTO CENARIO: LADRÃO
        else if (valorCenario == 25) {
            Cenas prisao = new CenaPrisao();
            Dialogo dialogo = new Dialogo(this,prisao, você);

            dialogo.botaoConversar.setText("IGNORAR");
            dialogo.botaoConversar.addActionListener(e -> {
                dialogo.heroi.maldicao(true);
                dialogo.botaoConversar.setText("AVANÇAR");
                dialogo.botaoAtacar.setEnabled(false);
                dialogo.botaoConversar.addActionListener(e1 -> {
                    valorCenario ++;
                    trocarTela();
                });
            });
            dialogo.botaoAtacar.addActionListener(e -> {
                valorBatalha = true;
                trocarTela();
            });
            if (valorCenario == 25 && valorBatalha == true) {
                Batalha batalha = new Batalha(this, prisao, você);

                Timer monitor = new Timer(100, e -> {
                    if (batalha.BarraPersonagem == 0) {
                        valorCenario = 30;
                        valorBatalha = false;
                        trocarTela();
                        ((Timer) e.getSource()).stop();
                    } else if (batalha.BarraInimigo == 0) {
                        valorCenario++;
                        valorBatalha = false;
                        trocarTela();
                        ((Timer) e.getSource()).stop();
                    }
                });
                monitor.start();
            }
        }else if (valorCenario == 26) {
            Cenas salao = new CenaSalao();
            TelaTextos transicao = new TelaTextos(salao);
            transicao.avancar.addActionListener(e -> {
                valorCenario ++;
                trocarTela();
            });
            add(transicao);
        }
        // SEGUNDA LINHA: QUINTO CENARIO: MAGO
        else if (valorCenario == 27) {
            Cenas salao = new CenaSalao();
            Dialogo dialogo = new Dialogo(this,salao,você);

            dialogo.zonaTexto.setText("Aparentemente você achou a mente por trás desse ataque, um mago com o rei de refém, ele parece furioso e não está disposto a conversar, o que deseja fazer?");
            //Ação do botão conversar que ele te conta a historia
            dialogo.botaoConversar.addActionListener(e -> {
                Timer monitor = new Timer(1,e3 -> {
                    dialogo.zonaTexto.setText("Ele te pulveriza com um ataque certeiro antes mesmo de uma palavra sair da sua boca.");
                });
                monitor.start();
                dialogo.botaoAtacar.setEnabled(false);
                dialogo.botaoConversar.setText("REINICIAR");
                dialogo.botaoConversar.addActionListener(e1 -> {
                    valorCenario = 30;
                    trocarTela();
                });
            });

            //Ação do botão atacar que inicia a batalha
            dialogo.botaoAtacar.addActionListener(e -> {
                valorBatalha = true;
                trocarTela();
            });
            if (valorCenario == 27 && valorBatalha == true) {
                Batalha batalha = new Batalha(this, salao, você);

                Timer monitor = new Timer(100,e -> {
                    if (batalha.BarraPersonagem == 0) {
                        valorCenario = 30;
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
        }else if (valorCenario == 28) {
            Cenas terraco = new CenaTerraco();
            TelaTextos transicao = new TelaTextos(terraco);
            transicao.avancar.addActionListener(e -> {
                valorCenario ++;
                trocarTela();
            });
            add(transicao);
        }
        // SEGUNDA LINHA: SEXTO CENARIO: DRAGÃO
        else if (valorCenario == 29) {
            Cenas terraco = new CenaTerraco();
            Dialogo dialogo = new Dialogo(this,terraco,você);

            //Ação do botão conversar que reinicia o jogo
            dialogo.botaoConversar.addActionListener(e -> {
                dialogo.botaoConversar.setText("CONVERSAR");
                dialogo.botaoConversar.addActionListener(e1 -> {
                    valorCenario = 30;
                    trocarTela();
                });
            });

            //Ação do botão atacar que começa a batalha
            dialogo.botaoAtacar.addActionListener(e -> {
                valorBatalha = true;
                trocarTela();
            });
            if (valorCenario == 29 && valorBatalha == true) {
                Batalha batalha = new Batalha(this, terraco, você);

                Timer monitor = new Timer(100,e -> {
                    if (batalha.BarraPersonagem == 0) {
                        valorCenario = 30;
                        batalha.BarraPersonagem = 100;
                        valorBatalha = false;
                        trocarTela();
                        ((Timer)e.getSource()).stop();
                    }
                    else if (batalha.BarraInimigo == 0) {
                        valorCenario = 33;
                        valorBatalha = false;
                        trocarTela();
                        ((Timer)e.getSource()).stop();
                    }
                });
                monitor.start();
            }
        }// TELAS FINAIS
        else if (valorCenario == 30){
            Cenas tela = new TelaDerrota();
            TelaTextos transicao = new TelaTextos(tela);
            transicao.avancar.setText("REINICIAR");
            transicao.avancar.addActionListener(e -> {
                valorCenario = 1;
                trocarTela();
            });
            add(transicao);
        }
        else if (valorCenario == 31){
            Cenas tela = new TelaHeroiRei();
            TelaTextos transicao = new TelaTextos(tela);
            transicao.avancar.setText("REINICIAR");
            transicao.avancar.addActionListener(e -> {
                valorCenario = 1;
                trocarTela();
            });
            add(transicao);
        }
        else if (valorCenario == 32){
            Cenas tela = new TelaHeroiReino();
            TelaTextos transicao = new TelaTextos(tela);
            transicao.avancar.setText("REINICIAR");
            transicao.avancar.addActionListener(e -> {
                valorCenario = 1;
                trocarTela();
            });
            add(transicao);
        }
        else if (valorCenario == 33){
            Cenas tela = new TelaHeroiProprio();
            TelaTextos transicao = new TelaTextos(tela);
            transicao.avancar.setText("REINICIAR");
            transicao.avancar.addActionListener(e -> {
                valorCenario = 1;
                trocarTela();
            });
            add(transicao);
        }else if (valorCenario == 34){
            Cenas tela = new TelaGoblin();
            TelaTextos transicao = new TelaTextos(tela);
            transicao.avancar.setText("REINICIAR");
            transicao.avancar.addActionListener(e -> {
                valorCenario = 1;
                trocarTela();
            });
            add(transicao);
        }else if (valorCenario == 90){
            Cenas tela = new CenaGoblin();
            Dialogo dialogo = new Dialogo(this, tela, você);

            dialogo.botaoConversar.addActionListener(e -> {
                dialogo.botaoConversar.addActionListener(e1 -> {
                    dialogo.botaoConversar.setText("AVANÇAR");
                    dialogo.botaoAtacar.setEnabled(false);
                    Timer monitor = new Timer(10,e2 -> {
                       dialogo.zonaTexto.setText("Você diz \"hum gruou ain ui\", cansado de tentar entender seus gemidos e sons estranhos, o goblin desiste e vai embora. Como você conseguiu fazer isso!? Pela primeira vez um goblin tomou uma decisão inteligente!");
                    });
                    dialogo.botaoConversar.addActionListener(e2 -> {
                        valorCenario = 34;
                        trocarTela();
                    });
                    monitor.start();
                });
            });

            dialogo.botaoAtacar.addActionListener(e -> {
                valorBatalha = true;
                valorCenario = 6;
                trocarTela();
            });
        }
        revalidate();
        repaint();

    }
}