
package br.edu.ifpr.projeto.helpDesk.modelo;


public class Problema {
    
    private int IdProblema;
    private String tipo;

    public int getIdProblema() {
        return IdProblema;
    }

    public void setIdProblema(int IdProblema) {
        this.IdProblema = IdProblema;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
      return  this.tipo;
    }
    
    
    
}
