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
public class Tabela {
    private int codigo;
    private ArrayList<Rodada> rodadas = new ArrayList<>();

    public Tabela(int codigo, ArrayList<Rodada> rodadas) {
        this.codigo = codigo;
        this.rodadas = rodadas;
    }

    public Tabela() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Rodada> getRodadas() {
        return rodadas;
    }

    public void setRodadas(ArrayList<Rodada> rodadas) {
        this.rodadas = rodadas;
    }
    
}
