/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poc.model;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author pedro_menezes
 */
public class Time {

    private int codigo;
    private String nome;
    private int prioridade;
    private ImageIcon escudo;
    private Campo campo;
    private String abreviacao;
    private double distanciaViajada;
    private ArrayList<Integer> timesJogados = new ArrayList<Integer>();

    public Time(int codigo, String nome, int prioridade, ImageIcon escudo, Campo campo, String abreviacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.prioridade = prioridade;
        this.escudo = escudo;
        this.campo = campo;
        this.abreviacao = abreviacao;
    }

    public Time() {
    }

    public void setJogou(int codigo) {
        timesJogados.add(codigo);
    }

    public boolean getJogou(int codigo) {
        for (int i = 0; i < timesJogados.size(); i++) {
            if (timesJogados.get(i) == codigo) {
                return true;
            }
        }
        return false;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }

    public double getDistanciaViajada() {
        return distanciaViajada;
    }

    public void setDistanciaViajada(double distanciaViajada) {
        this.distanciaViajada = distanciaViajada;
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

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public ImageIcon getEscudo() {
        return escudo;
    }

    public void setEscudo(ImageIcon escudo) {
        this.escudo = escudo;
    }

    public Campo getCampo() {
        return campo;
    }

    public void setCampo(Campo campo) {
        this.campo = campo;
    }

}
