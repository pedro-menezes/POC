/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poc.model;

import java.util.ArrayList;
import poc.model.ModelDistancia;
/**
 *
 * @author Joao
 */
public class Campeonato {
    private ArrayList<Time> times = new ArrayList<>();
    private ArrayList<ModelDistancia> distancias = new ArrayList<>();
    private ArrayList<Rodada> rodadas = new ArrayList<>();
            
    public Campeonato() {
    }

    public ArrayList<Time> getTimes() {
        return times;
    }

    public void setTimes(ArrayList<Time> times) {
        this.times = times;
    }

    public ArrayList<ModelDistancia> getDistancias() {
        return distancias;
    }

    public void setDistancias(ModelDistancia distancias) {
        this.distancias.add(distancias);
    }

    public ArrayList<Rodada> getRodadas() {
        return rodadas;
    }

    public void setRodadas(ArrayList<Rodada> rodadas) {
        this.rodadas = rodadas;
    }
    
}
