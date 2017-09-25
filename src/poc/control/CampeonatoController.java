/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poc.control;

import java.util.ArrayList;
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

    private int ordem;

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
        ArrayList<Rodada> rodadas = new ArrayList<Rodada>();
        ArrayList<Confronto> confrontos = new ArrayList<Confronto>();
        int cont = 0;
        //Time timeA = times.get(0);
        //Time timeB = times.get(1);
        // Campo campo = new Campo(0, "0");
        // Time timeC = new Time(0, "0", 0, null, campo, "0");
        //confronto inicial
        //  for (int j = 0; j < campeonato.getTimes().size() - 1; j++) {
        //    for (int i = 0; i < campeonato.getTimes().size() / 2; i++) {
        //      Confronto confronto = new Confronto();
        //    for (Time time : times) {
        /*     if (timeA.getPrioridade() > time.getPrioridade() && timeA.getCodigo() != time.getCodigo()) {
                        timeA = time;
                    }else if (timeB.getPrioridade() > time.getPrioridade() && timeB.getCodigo() != time.getCodigo()) {
                        if (timeA.getJogou(time.getCodigo()) == true) {
                            
                        } else {
                            timeB = time;
                        }
                    }else if (timeB.getPrioridade() == time.getPrioridade() && timeB.getCodigo() != time.getCodigo() && timeB.getPrioridade() < timeA.getPrioridade()) {
                        timeA = time;
                    }else if (timeA.getPrioridade() == time.getPrioridade() && timeA.getCodigo() != time.getCodigo() && timeA.getPrioridade() < timeB.getPrioridade()) {
                        timeB = time;
                    }
                    if (timeA.getPrioridade() > time.getPrioridade() && timeA.getCodigo() != time.getCodigo()) {
                        timeC = timeA;
                        timeA = time;
                    } else if (timeB.getPrioridade() > time.getPrioridade() && timeB.getCodigo() != time.getCodigo()) {
                        timeC = timeB;
                        timeB = time;
                    } else if (timeB.getPrioridade() == time.getPrioridade() && timeB.getCodigo() != time.getCodigo() && timeB.getPrioridade() < timeA.getPrioridade()) {
                        timeC = timeA;
                        timeA = time;
                    } else if (timeA.getPrioridade() == time.getPrioridade() && timeA.getCodigo() != time.getCodigo() && timeA.getPrioridade() < timeB.getPrioridade()) {
                        timeC = timeB;
                        timeB = time;
                    }

                    if (timeA.getPrioridade() < timeB.getPrioridade()) {
                        if (timeA.getJogou(timeB.getCodigo())) {
                            //timeB = timeC;
                            confronto.setCodigo(confrontos.size() + 1);
                            confronto.setTimeA(timeA);
                            confronto.setTimeB(timeB);


                            confronto.setLocal(timeA.getCampo());

                            confrontos.add(confronto);
                            timeA.setJogou(timeB.getCodigo());
                            timeB.setJogou(timeA.getCodigo());
                        }
                    } else if (timeA.getJogou(timeB.getCodigo())) {
                        //timeA = timeC;
                        confronto.setCodigo(confrontos.size() + 1);
                        confronto.setTimeA(timeA);
                        confronto.setTimeB(timeB);

                        confronto.setLocal(timeB.getCampo());

                        confrontos.add(confronto);
                        System.out.println(timeB.getCodigo());
                        timeA.setJogou(timeB.getCodigo());
                        timeB.setJogou(timeA.getCodigo());
                    } else {
                        confronto.setCodigo(confrontos.size() + 1);
                        confronto.setTimeA(timeA);
                        confronto.setTimeB(timeB);

                        confronto.setLocal(timeB.getCampo());

                        confrontos.add(confronto);
                        timeA.setJogou(timeB.getCodigo());
                        timeB.setJogou(timeA.getCodigo());
                    }

                System.out.println("TESTE: timeA " + timeA.getNome());
                System.out.println("TESTE: timeB " + timeB.getNome());
                System.out.println("TESTE: cofronto "+ timeA.getNome()+" x "+timeB.getNome() );
                }*/

        Rodada rodada = new Rodada();
        Campo campo = new Campo(0, " ");
        ArrayList<Time> times = campeonato.getTimes();
        ArrayList<Time> timeJogou = new ArrayList<Time>();
        ArrayList<Time> timeLivre = new ArrayList<Time>();
        System.out.println("SIZE " + timeJogou.size());
        Time timeA = times.get(times.size() - 1);
        Time timeB = times.get(times.size() - 2);

        for (int i = 0; i < campeonato.getTimes().size() / 2; i++) {//for de confrontos

            if (confrontos.size() == 0) {
                for (Time time : times) {
                    if (timeA.getPrioridade() > time.getPrioridade()) {
                        timeA = time;
                        System.out.println(timeA.getNome());
                    }
                    if (timeB.getPrioridade() > time.getPrioridade() && time.getCodigo() != timeA.getCodigo()) {
                        timeB = time;
                    }
                }
            } else {
                for (int j = 0; j < campeonato.getTimes().size() / 2; j++) {
                    if (j == 0) {
                        for (Time time : timeJogou) {
                            if (timeA.getPrioridade() < time.getPrioridade()) {
                                for (Confronto confronto : confrontos) {
                                    if (time.getCodigo() == confronto.getTimeA().getCodigo() || time.getCodigo() == confronto.getTimeB().getCodigo()) {
                                        System.out.println("ENTROU");
                                        System.out.println("TIME: " + time.getNome());
                                        System.out.println("TIMEA: " + confronto.getTimeA().getNome());
                                        System.out.println("TIMEB: " + confronto.getTimeB().getNome());
                                    } else {
                                        timeA = time;
                                        System.out.println(timeA.getNome());
                                    }
                                }

                            }
                            if (timeB.getPrioridade() < time.getPrioridade() && time.getCodigo() != timeA.getCodigo()) {
                                for (Confronto confronto : confrontos) {
                                    if (time.getCodigo() == confronto.getTimeA().getCodigo() || time.getCodigo() == confronto.getTimeB().getCodigo()) {
                                        System.out.println("ENTROU");
                                        System.out.println("TIME: " + time.getNome());
                                        System.out.println("TIMEA: " + confronto.getTimeA().getNome());
                                        System.out.println("TIMEB: " + confronto.getTimeB().getNome());
                                    } else {
                                        timeB = time;
                                        System.out.println(timeA.getNome());
                                    }
                                }
                            }
                        }
                    }
                    /*if (confronto.getTimeA() == time && confronto.getTimeB() == time) {
                            System.out.println("ENTROU"
                                    + "TIME1: " + timeA.getNome() + timeB.getNome()
                                    + "TIME: " + time.getNome());

                           

                        }*/
                }
            }

            System.out.println("TIME A: " + timeA.getNome());
            System.out.println("TIME B: " + timeB.getNome());

            System.out.println("MENOR PRIORIDADE: " + timeA.getNome());
            System.out.println("SEGUNDA MENOR PRIORIDADE: " + timeB.getNome());

            Confronto confronto = new Confronto(confrontos.size() + 1, timeA, timeB, timeA.getCampo());
            confrontos.add(confronto);
            Confronto confronto1 = new Confronto(confrontos.size() + 1, timeB, timeA, timeA.getCampo());
            confrontos.add(confronto1);
            timeJogou.add(timeA);
            timeJogou.add(timeB);

        }
    }
}
