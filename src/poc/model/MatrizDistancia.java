/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poc.model;

/**
 *
 * @author alunos
 */
public class MatrizDistancia {

    private float[] distancia;
    private int ordem;

    public MatrizDistancia(int ordem) {
        int celulas = ordem * (ordem - 1) / 2;
        this.distancia = new float[celulas];
        this.ordem = ordem;
    }

    public float getDistancia(Time a, Time b) {
        int i = a.getCodigo();
        int j = b.getCodigo();
        if (i == j) {
            return 0;
        }
        if (i < j) {
            j = a.getCodigo();
            i = b.getCodigo();
        }
        int x = (i - 1) * (i - 2) / 2 + j;
        return this.distancia[x-1];
    }

    public void setDistancia(Time a, Time b, float distancia) {
        int i = a.getCodigo();
        int j = b.getCodigo();
        if (i == j) {
         return;   
        }
        if (i < j) {
            j = a.getCodigo();
            i = b.getCodigo();
        }
        int x = (i - 1) * (i - 2) / 2 + j;    
        this.distancia[x-1] = distancia;
    }

    public int getOrdem() {
        return ordem;
    }

    public float[] getDistancia() {
        return distancia;
    }
}
