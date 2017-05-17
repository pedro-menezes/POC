/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poc.control;

import poc.model.Campeonato;
import poc.model.Campo;
import poc.model.Time;

/**
 *
 * @author pedro_menezes
 */
public class CampoController {
    private Campo campo;
    private int codigo = 1;
    private Campeonato campeonato;
    private Time times[];
    
    public Campo cadastrar(String nome){
        campo = new Campo();
        campo.setCodigo(codigo);
        campo.setNome(nome);
        codigo++;
        return campo;
    }
    
    public boolean verificar(String nome){
        campeonato = new Campeonato();
        times = campeonato.getTimes();
        for (Time time : times) {
            if (time.getCampo().getNome().equals(nome)) {
               return false;
            }
        }
        return true;
    }

}
