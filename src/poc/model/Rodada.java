/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poc.model;

import java.util.ArrayList;

/**
 *
 * @author pedro_menezes
 */
public class Rodada {
    private int codigo;
    private ArrayList<Confronto> confrontos = new ArrayList<>();

    public Rodada() {
    }

    public Rodada(int codigo, ArrayList<Confronto> confrontos) {
        this.codigo = codigo;
        this.confrontos = confrontos;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Confronto> getConfrontos() {
        return confrontos;
    }

    public void setConfrontos(ArrayList<Confronto> confrontos) {
        this.confrontos = confrontos;
    }
    
}
