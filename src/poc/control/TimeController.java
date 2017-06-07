/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poc.control;

import java.util.ArrayList;
import poc.model.Campeonato;
import poc.model.Campo;
import poc.model.Time;

/**
 *
 * @author alunos
 */
public class TimeController {
    private Campo campo;
    private Campeonato campeonato;
    private CampeonatoController champControl;    
    private ArrayList<Time> times;
    
    public boolean verificarCadastro(Time time, Campeonato campeonato){
        times = campeonato.getTimes();
        
        for (Time time1 : times) {
            if (time1.getNome().equals(time.getNome())) {
                return false;
            }
        }
        
        return true;
    }
    
    /*public boolean verificar(String nome){
        campeonato = new Campeonato();
        times = campeonato.getTimes();
        
        for (Time time : times) {
            if (time.getCampo().getNome().equals(nome)) {
               return false;
            }
        }
        return true;
    }*/
}
