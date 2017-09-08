/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poc.model;

import java.awt.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pedro_menezes
 */
public class TableModel extends AbstractTableModel{

    private Campeonato campeonato = new Campeonato();
    
    public TableModel(Campeonato campeonato) {
        this.campeonato = campeonato;
    }
    
    ArrayList<Time> dados = campeonato.getTimes();
    private ArrayList<String> coluna = new ArrayList<String>();
    
    public void colunas(){
        for (Time time : dados) {
            coluna.add(time.getNome());
        }
    }
    
    private String[] colunas=(String[])coluna.toArray(new String[coluna.size()]);
    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        
        if (columnIndex>rowIndex) {
            return true;
        }
        return false;
    }

 
    //Métodos abaixo são para manipulação de dados
 
    /**
     * retorna o valor da linha indicada
     * @param rowIndex
     * @return
     */
    public Time getValue(int rowIndex){
        return dados.get(rowIndex);
    }
 
    /**
     * retorna o indice do objeto
     * @param time
     * @return
     */
    public int indexOf(Time time) {
        return dados.indexOf(time);
    }
 
    /**
     * add um empregado á lista
     * @param time
     */
    public void onAdd(Time time) {
        dados.add(time);
        fireTableRowsInserted(indexOf(time), indexOf(time));
    }
 
    /**
     * add uma lista de empregados
     * @param dadosIn
     */
    public void onAddAll(ArrayList<Time> dadosIn) {
        dados.addAll(dadosIn);
        fireTableDataChanged();
    }
 
    /**
     * remove um registro da lista, através do indice
     * @param rowIndex
     */
    public void onRemove(int rowIndex) {
        dados.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
 
    /**
     * remove um registro da lista, através do objeto
     * @param time
     */
    public void onRemove(Time time) {
        int indexBefore=indexOf(time);//pega o indice antes de apagar
        dados.remove(time);  
        fireTableRowsDeleted(indexBefore, indexBefore);
    }
 
    /**
     * remove todos registros da lista
     */
    public void onRemoveAll() {
        dados.clear();
        fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
