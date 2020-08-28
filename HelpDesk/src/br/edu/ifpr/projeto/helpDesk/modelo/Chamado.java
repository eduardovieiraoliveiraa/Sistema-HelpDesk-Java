
package br.edu.ifpr.projeto.helpDesk.modelo;

import java.sql.Date;
import java.util.Calendar;




public class Chamado {
    
     private int IdChamado;
     private String titulo;
     private String urgencia;
     private String descricao;
     private Problema problema;
     private Usuario usuario;
     private Solucao solucao;
     private Calendar dataAbertura;
     private Calendar dataFechado;
     private String status;
     private String tipo;
     private String tecnico;
     private int contador;

    public int getIdChamado() {
        return IdChamado;
    }

    public void setIdChamado(int IdChamado) {
        this.IdChamado = IdChamado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Problema getProblema() {
        return problema;
    }

    public void setProblema(Problema problema) {
        this.problema = problema;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Solucao getSolucao() {
        return solucao;
    }

    public void setSolucao(Solucao solucao) {
        this.solucao = solucao;
    }


    public String getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }

    public Calendar getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Calendar dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Calendar getDataFechado() {
        return dataFechado;
    }

    public void setDataFechado(Calendar dataFechado) {
        this.dataFechado = dataFechado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
       
     return this.getDataAbertura().toString()+ this.solucao.getDescricao();
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

 
    
    
    
}
