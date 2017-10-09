/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poc.model;

/**
 *
 * @author pedro_menezes
 */
public class Confronto {
    private int codigo;
    private Time timeA;
    private Time timeB;
    private Campo local;

    public Confronto() {
    }

    public Confronto(int codigo, Time timeA, Time timeB, Campo local) {
        this.codigo = codigo;
        this.timeA = timeA;
        this.timeB = timeB;
        this.local = local;
    }    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Time getTimeA() {
        return timeA;
    }

    public void setTimeA(Time timeA) {
        this.timeA = timeA;
    }

    public Time getTimeB() {
        return timeB;
    }

    public void setTimeB(Time timeB) {
        this.timeB = timeB;
    }

    public Campo getLocal() {
        return local;
    }

    public void setLocal(Campo local) {
        this.local = local;
    }
    
    public boolean verificaJogou(Time time){
        if (time == timeA || time == timeB) {
            return true;
        }
        return false;
    }
    
}
