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
 * @author pedro_menezes
 */
public class CampoController {
    private Campo campo;
    private int codigo = 1;
    private Campeonato campeonato;
    private ArrayList<Time> times = new ArrayList<>();
    
    public Campo cadastrar(String nome){
        campo = new Campo();
        campo.setCodigo(codigo);
        campo.setNome(nome);
        codigo++;
        return campo;
    }
    
    public int verificarCampo(String nome, CampeonatoController champ){
        
        return 0;
    }
  /*  public boolean verificar(String nome, CampeonatoController champ){
        campeonato = new Campeonato();
        times = campeonato.getTimes();
        times = champ.retornaArray();
        Campo c = new Campo(1, "AA");
        Time time = new Time(1, "A", 1, null,c , "GALO");
        times[0] =  time;
        
        for (Time time1: times) {
            if (time.getCampo().getNome().equals(nome)) {
               return false;
            }
        }
        return true;
    }*/

}
