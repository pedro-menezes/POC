/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poc.model;

/**
 *
 * @author Joao
 */
public class Campeonato {
    private Time[] times;
    private MatrizDistancia distancias;

    public Campeonato(Time[] times, MatrizDistancia distancias) {
        this.times = times;
        this.distancias = distancias;
    }

    public Campeonato() {
    }

    public Time[] getTimes() {
        return times;
    }

    public void setTimes(Time[] times) {
        this.times = times;
    }

    public MatrizDistancia getDistancias() {
        return distancias;
    }

    public void setDistancias(MatrizDistancia distancias) {
        this.distancias = distancias;
    }
    
    
}
