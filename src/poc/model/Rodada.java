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
public class Rodada {
    private int codigo;
    private Confronto[] confrontos;

    public Rodada() {
    }

    public Rodada(int codigo, Confronto[] confrontos) {
        this.codigo = codigo;
        this.confrontos = confrontos;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Confronto[] getConfrontos() {
        return confrontos;
    }

    public void setConfrontos(Confronto[] confrontos) {
        this.confrontos = confrontos;
    }
    
    
}
