/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poc.model;

import java.lang.reflect.Array;

/**
 *
 * @author pedro_menezes
 */
public class Campo {
    private int codigo;
    private String nome;
    
    public Campo() {
       
    }

    public Campo(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
