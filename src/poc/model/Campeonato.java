/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poc.model;

import java.util.ArrayList;

/**
 *
 * @author Joao
 */
public class Campeonato {
    private ArrayList<Time> times = new ArrayList<>();
    private MatrizDistancia distancias;

    public Campeonato(ArrayList<Time> times, MatrizDistancia distancias) {
        this.times = times;
        this.distancias = distancias;
    }
    
    public Campeonato() {
    }

    public ArrayList<Time> getTimes() {
        return times;
    }

    public void setTimes(ArrayList<Time> times) {
        this.times = times;
    }

    public MatrizDistancia getDistancias() {
        return distancias;
    }

    public void setDistancias(MatrizDistancia distancias) {
        this.distancias = distancias;
    }
    
    
}
