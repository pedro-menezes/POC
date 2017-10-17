/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poc.control;

import java.io.File;
import java.io.IOException;
import poc.model.Campeonato;
import poc.model.Tabela;

/**
 *
 * @author pedro_menezes
 */
public class TabelaController {

    private Tabela tabela;

    public void gerarTabela(Campeonato campeonato){
        tabela = new Tabela(campeonato);
        File arquivo = tabela.gerarTabela();
        try {
        java.awt.Desktop.getDesktop().open(arquivo);
        } catch (Exception e) {
        }
    }
}
