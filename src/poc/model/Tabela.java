/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poc.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author pedro_menezes
 */
public class Tabela {
    private Campeonato campeonato;
    private String htmlTabela;

    public Tabela(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public String getHtmlTabela() {
        return htmlTabela;
    }

    public void setHtmlTabela(String htmlTabela) {
        this.htmlTabela = htmlTabela;
    }
    
    public File gerarTabela(){
        File arquivo = new File("tabela.html");
        boolean teste = false;
        String newLine = System.getProperty("line.separator");
        ArrayList<Rodada> rodadas = campeonato.getRodadas();
        
        try {
            teste = arquivo.createNewFile();
            do{
            if (teste == true) {
                System.out.println("O arquivo foi criado");
            } else if(arquivo.createNewFile() == false) {
                arquivo.delete();
                System.out.println("O arquivo não foi criado, talvez ele já exista");
                teste = true;
            }
            } while ( teste == false);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try (FileWriter fw = new FileWriter(arquivo)) {
            fw.write("<!DOCTYPE html><html><head><style>table {border-collapse: collapse;width: 100%;}th, td {text-align:left;padding: 8px;}tr:nth-child(even){background-color: #f2f2f2}th {background-color: #4CAF50;color: white;} .cabecalho{background-color: blue; }</style></head><body>");
            fw.write(newLine);
            fw.write("<h2>Tabela</h2>");
            fw.write(newLine);
            fw.write("<table>");
            fw.write(newLine);
            fw.write("<tr><th style=\"background-color: #F9EDBE\">Time 1</th><th style=\"background-color: #F9EDBE\">Time 2</th><th style=\"background-color: #F9EDBE\">Campo</th></tr>");
            
            for (Rodada rodada : rodadas) {
                ArrayList<Confronto> confrontos = rodada.getConfrontos();
                fw.write("<tr><th>Rodada "+rodada.getCodigo()+"</th><th></th><th></th></tr>");
                for (Confronto confronto : confrontos) {
                    fw.write("<tr>");
                    fw.write("    <td>" + confronto.getTimeA().getNome() + "</td>");
                    fw.write("    <td>" + confronto.getTimeB().getNome() + "</td>");
                    fw.write("    <td>" + confronto.getLocal().getNome()+ "</td>");
                    fw.write("</tr>");
                }
            }
                fw.write("</table></body></html>");
            
            fw.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return arquivo;
    }
}
