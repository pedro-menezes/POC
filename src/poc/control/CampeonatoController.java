/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poc.control;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import poc.model.Campeonato;
import poc.model.Campo;
import poc.model.Confronto;
import poc.model.MatrizDistancia;
import poc.model.ModelDistancia;
import poc.model.Rodada;
import poc.model.Time;
import poc.view.Distancia;

/**
 *
 * @author pedro_menezes
 */
public class CampeonatoController {

    private ArrayList<Time> times = new ArrayList<Time>();
    private ArrayList<Confronto> confrontos;
    private ArrayList<Rodada> rodadas = new ArrayList<Rodada>();
    private TabelaController tabelaControl;
    private int rodCodigo = 1;
    private int ordem;
    private Integer timeObservado = 0;

    public CampeonatoController() {

    }

    public CampeonatoController(Campeonato campeonato) {
    }

    public void cadastrarTime(Time time, Campeonato campeonato) {
        ArrayList<Time> times = campeonato.getTimes();
        times.add(time);
    }

    /*  public Time[] retornaArray(){
        campeonato = new Campeonato();
        return campeonato.getTimes();
    }
    
    public void addTime(Time[] time){
        campeonato = new Campeonato();
        campeonato.setTimes(time);
    }
    
    public int tamanhoArray(){
        campeonato = new Campeonato();
        System.out.println(campeonato.getTimes().length);
        return campeonato.getTimes().length;
    }*/
    public void cadastrarDistancias(ModelDistancia distancia, Campeonato campeonato) {
        campeonato.setDistancias(distancia);
    }

    public void gerarTabela(Campeonato campeonato) {
        times = campeonato.getTimes();
        organizaMenorInicial(times);
        int control = 0;
        for (int i = 0; i < times.size() - 1; i++) {
            if (!montarPares(times)) {
                while (true) {
                    if (control == times.size() - 1) {
                        organizarPosicoes(times);
                        control = 0;
                    }
                    if (timeObservado < times.size() - 1) {
                        timeObservado++;
                    } else {
                        timeObservado = 0;
                    };
                    if (montarPares(times)) {
                        if (timeObservado < times.size() - 1) {
                            timeObservado++;
                        } else {
                            timeObservado = 0;
                        };
                        break;
                    }
                    control++;
                }
            } else {
                if (timeObservado < times.size() - 1) {
                    timeObservado++;
                } else {
                    timeObservado = 0;
                };
            }

            System.out.println("-----RODADA-------" + (rodadas.size() + 1));

        }
        campeonato.setRodadas(rodadas);
        definirMandos(campeonato);
        tabelaControl = new TabelaController();
        tabelaControl.gerarTabela(campeonato);
    }

    public void definirMandos(Campeonato campeonato) {
        ArrayList<Rodada> rodadas = campeonato.getRodadas();
        ArrayList<ModelDistancia> distancias = campeonato.getDistancias();
        float distancia = 0;

        for (Rodada rodada : rodadas) {
            ArrayList<Confronto> confrontos = rodada.getConfrontos();

            for (Confronto confronto : confrontos) {
                Time timeA = confronto.getTimeA();
                Time timeB = confronto.getTimeB();

                for (ModelDistancia dist : distancias) {
                    if (dist.getTimeA() == timeA && dist.getTimeB() == timeB) {
                        distancia = dist.getDistancia();
                    }
                }

                if (timeA.getDistanciaViajada() == timeB.getDistanciaViajada()) {
                    if (timeA.getPrioridade() > timeB.getPrioridade()) {
                        confronto.setLocal(timeB.getCampo());
                        confronto.getTimeA().setDistanciaViajada(confronto.getTimeA().getDistanciaViajada() + distancia);
                        confronto.getTimeB().setDistanciaViajada(confronto.getTimeB().getDistanciaViajada() + distancia);
                    } else if (timeA.getPrioridade() < timeB.getPrioridade()) {
                        confronto.setLocal(timeA.getCampo());
                        confronto.getTimeA().setDistanciaViajada(confronto.getTimeA().getDistanciaViajada() + distancia);
                        confronto.getTimeB().setDistanciaViajada(confronto.getTimeB().getDistanciaViajada() + distancia);

                    }

                } else if (timeA.getDistanciaViajada() > timeB.getDistanciaViajada()) {
                    confronto.setLocal(timeA.getCampo());
                    confronto.getTimeA().setDistanciaViajada(confronto.getTimeA().getDistanciaViajada() + distancia);
                    confronto.getTimeB().setDistanciaViajada(confronto.getTimeB().getDistanciaViajada() + distancia);

                } else if (timeA.getDistanciaViajada() < timeB.getDistanciaViajada()) {
                    confronto.setLocal(timeB.getCampo());
                    confronto.getTimeA().setDistanciaViajada(confronto.getTimeA().getDistanciaViajada() + distancia);
                    confronto.getTimeB().setDistanciaViajada(confronto.getTimeB().getDistanciaViajada() + distancia);

                }
            }
        }
    }

    public boolean verificaJogouTurno(Time time1, Time time2) {
        if (time1 != time2) {
            boolean teste = time1.getJogou(time2.getCodigo());
            teste = time2.getJogou(time1.getCodigo());
            return teste;
        }
        return true;
    }

    public boolean verificaJogouRodada(Time time) {
        for (Confronto confronto : confrontos) {
            if (confronto.getTimeA() == time || confronto.getTimeB() == time) {
                return true;
            }
        }
        return false;
    }

    public boolean montarPares(ArrayList<Time> times) {
        confrontos = new ArrayList<Confronto>();
        Confronto confronto;
        int codigo1 = 0;
        Time time1 = times.get(codigo1);
        Time time2 = times.get(timeObservado);
        int contConfronto = 1;
        boolean achouConfronto = false;

        for (int j = 0; j < times.size() / 2; j++) { //rodadas
            for (int i = codigo1; i < times.size(); i++) { //time1
                if (verificaJogouRodada(time1) == false) {
                    for (int k = 0; k < times.size(); k++) { //time2
                        if (verificaJogouRodada(time2) == false) {
                            if (verificaJogouTurno(time1, time2) == false) {
                                confronto = new Confronto();
                                confronto.setCodigo(contConfronto);
                                confronto.setTimeA(time1);
                                confronto.setTimeB(time2);
                                confrontos.add(confronto);
                                achouConfronto = true;
                                if (timeObservado < times.size() - 1) {

                                    for (int w = 0; w < times.size(); w++) {
                                        if (!verificaJogouRodada(times.get(timeObservado++))) {
                                            break;
                                        } else {
                                            if (timeObservado >= times.size() - 1) {
                                                timeObservado = 0;
                                            };
                                        }
                                    }
                                } else {
                                    timeObservado = 0;
                                };
                                break;
                            }
                        }
                        if (timeObservado < times.size() - 1) {
                            timeObservado++;
                            time2 = times.get(timeObservado);
                        } else {
                            timeObservado = 0;
                            time2 = times.get(timeObservado);
                        };
                    }
                }

                if (achouConfronto || i == times.size() - 1) {
                    break;
                } else if (codigo1 < times.size() - 1) {
                    codigo1++;
                    time1 = times.get(codigo1);
                } else {
                    codigo1 = 0;
                    time1 = times.get(codigo1);
                }
            }
            time1.setJogou(time2.getCodigo());
            time2.setJogou(time1.getCodigo());
            //System.out.println("ACHOU-> " + time1.getNome() + " x " + time2.getNome());

            if (codigo1 < times.size() - 1) {
                codigo1++;
                time1 = times.get(codigo1);
            } else {
                codigo1 = 0;
                time1 = times.get(codigo1);
            }

            if (timeObservado < times.size() - 1) {
                timeObservado++;
                time2 = times.get(timeObservado);
            } else {
                timeObservado = 0;
                time2 = times.get(timeObservado);
            };
            contConfronto++;
            achouConfronto = false;
        }

        if (confrontos.size() == times.size() / 2) {
            Rodada rodada = new Rodada();
            rodada.setConfrontos(confrontos);
            rodada.setCodigo(rodCodigo);
            rodadas.add(rodada);
            rodCodigo++;

            for (Confronto confronto1 : confrontos) {
                System.out.println("CONFRONTO-> " + confronto1.getTimeA().getNome() + " x " + confronto1.getTimeB().getNome());
            }
            return true;
        } else {
            for (Confronto confronto1 : confrontos) {
                confronto1.getTimeA().desfazerSetJogou();
                confronto1.getTimeB().desfazerSetJogou();
            }
        }
        return false;
    }

    public void organizaMenorInicial(ArrayList<Time> times) {

        Collections.sort(times, new Comparator() {
            public int compare(Object o1, Object o2) {
                Time t1 = (Time) o1;
                Time t2 = (Time) o2;
                return t1.getPrioridade() < t2.getPrioridade() ? -1 : (t1.getPrioridade() > t2.getPrioridade() ? +1 : 0);
            }
        });

        for (Time time : times) {
            //System.out.println("Prioridade: " + time.getPrioridade());
        }
        System.out.println("##### REORGANIZANDO VETOR #####");

    }

    public void organizarPosicoes(ArrayList<Time> times) {

        for (int i = 0; i < times.size() - 1; i++) {
            if (i != times.size()) {
                Collections.swap(times, i, (i + 1));
            }
        }
        //System.out.println("------");
        for (Time time : times) {
            //System.out.println("Prioridade: " + time.getPrioridade());
        }

        System.out.println("##### REORGANIZANDO VETOR #####");

    }

}
