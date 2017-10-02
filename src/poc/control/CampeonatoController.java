/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poc.control;

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
        times = campeonato.getTimes();
        organizaMenorInicial(times);
        organizarPosicoes(times);
    }

    public boolean verificaJogou(Time time1, Time time2) {
        return false;
    }

    public void montarPares(ArrayList<Time> times) {
        ArrayList<Confronto> confrontos = new ArrayList<Confronto>();
        Confronto confronto = new Confronto();
        int a = 0;
        int b = 1;
        Time time1 = times.get(a);
        Time time2 = times.get(b);
        int cont = 1;

        for (int i = 0; i < times.size(); i++) {
            if (verificaJogou(time1, time2) == false) {
                confronto.setCodigo(cont);
                confronto.setTimeA(time1);
                confronto.setTimeB(time2);
                confrontos.add(confronto);
                break;
            } else if (verificaJogou(time1, time2) == true) {
                
            }
        }

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
            System.out.println("Prioridade: " + time.getPrioridade());
        }

    }

    public void organizarPosicoes(ArrayList<Time> times) {
        System.out.println("TIMES SIZE> " + times.size());
      
        for (int i = 0; i < times.size()-1; i++) {
            if (i != times.size()) {
                Collections.swap(times, 0, (i + 1));
            }
            
        }
        System.out.println("------");
        for (Time time : times) {
            System.out.println("Prioridade: " + time.getPrioridade());
        }

    }

}
