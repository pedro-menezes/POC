/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poc.control;

import java.util.ArrayList;
import poc.model.Campeonato;
import poc.model.Time;

/**
 *
 * @author pedro_menezes
 */
public class CampeonatoController {
  
    public void cadastrarTime(Time time, Campeonato campeonato){
        ArrayList<Time> times = campeonato.getTimes();
        times.add(time);
        campeonato.setTimes(times);
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
}