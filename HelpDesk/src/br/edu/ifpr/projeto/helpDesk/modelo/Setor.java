
package br.edu.ifpr.projeto.helpDesk.modelo;


public class Setor {
    
    private int IdSetor;
    private String nome_Setor;

    public int getIdSetor() {
        return IdSetor;
    }

    public void setIdSetor(int IdSetor) {
        this.IdSetor = IdSetor;
    }

    public String getNome_Setor() {
        return nome_Setor;
    }

    public void setNome_Setor(String nome_Setor) {
        this.nome_Setor = nome_Setor;
    }

    @Override
    public String toString() {
        return this.nome_Setor;
    }
    
    
   
}
