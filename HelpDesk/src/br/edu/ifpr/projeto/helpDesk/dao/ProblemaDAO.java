
package br.edu.ifpr.projeto.helpDesk.dao;

import br.edu.ifpr.projeto.helpDesk.modelo.Problema;
import br.edu.ifpr.projeto.helpDesk.visao.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProblemaDAO {
    
 public static void inserir(Problema problema) throws SQLException {
        //captura da conexão
        Connection con = Conexao.getConexao();
        //Criação do SQL
        String sql = "insert into tb_Problema (tipo) values (?)";
        //Geração do Statement com a Sring sql
        PreparedStatement stmt = con.prepareStatement(sql);
        //envio de valores do objeto para o Statement
        stmt.setString(1, problema.getTipo());

        
        //Execucação 
        stmt.execute();
        //Fechando o Statement
        stmt.close();
        //Fechando a conexão com a Banco de Dados 
        con.close();
    }
    
        public static void excluir(Problema problema) throws SQLException {
        
        Connection con = Conexao.getConexao();
        String sql = "delete from tb_Problema where IdProblema =?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, problema.getIdProblema());
      
        stmt.executeUpdate();
        stmt.close();
        con.close();
    }
        
        
        public static List<Problema> pesquisar() throws SQLException {
        List<Problema> listaProblema = new ArrayList<Problema>();
        Connection con = Conexao.getConexao();
        String //where = onde
                sql = "select * from tb_Problema order by tipo";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Problema problema= new Problema();
            problema.setIdProblema(rs.getInt("IdProblema"));
            problema.setTipo(rs.getString("tipo"));
            
            listaProblema.add(problema);
        }
        stmt.close();
        rs.close();
        con.close();
        return listaProblema;
    }
        
        
        

    

    
}
