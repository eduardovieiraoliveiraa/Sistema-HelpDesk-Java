/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.projeto.helpDesk.dao;

import br.edu.ifpr.projeto.helpDesk.modelo.Solucao;
import br.edu.ifpr.projeto.helpDesk.visao.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eduar
 */
public class SolucaoDAO {
    
         public static void inserir(Solucao solucao) throws SQLException {
        //captura da conexão
        Connection con = Conexao.getConexao();
        //Criação do SQL
        String sql = "insert into tb_Solucao (solucao) values (?)";
        //Geração do Statement com a Sring sql
        PreparedStatement stmt = con.prepareStatement(sql);
        //envio de valores do objeto para o Statement
        stmt.setString(1, solucao.getDescricao());
         
               
        
        //Execucação 
        stmt.execute();
        //Fechando o Statement
        stmt.close();
        //Fechando a conexão com a Banco de Dados 
        con.close();
    }
    
       public static List<Solucao> pesquisar(Solucao solucaoPesq) throws SQLException {
        List<Solucao> listaSolucao = new ArrayList<Solucao>();
        Connection con = Conexao.getConexao();
        String //where = onde
                sql = "select * from tb_Solucao where IdSolucao like '" + solucaoPesq.getIdSolucao()+ "%' order by IdSolucao";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Solucao solucao= new Solucao();
            solucao.setIdSolucao(rs.getInt("IdSolucao"));
            solucao.setDescricao(rs.getString("solucao"));
            
            listaSolucao.add(solucao);
        }
        stmt.close();
        rs.close();
        con.close();
        return listaSolucao;
    }

    
}
