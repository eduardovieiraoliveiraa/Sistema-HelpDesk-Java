
package br.edu.ifpr.projeto.helpDesk.dao;

import br.edu.ifpr.projeto.helpDesk.modelo.Setor;
import br.edu.ifpr.projeto.helpDesk.visao.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SetorDAO {
    
        //o método inserir recebe como parametro o objeto
    // que será persistido na tabela do banco de dados
       public static void inserir(Setor setor) throws SQLException {
        //captura da conexão
        Connection con = Conexao.getConexao();
        //Criação do SQL
        String sql = "insert into tb_Setor (nome_Setor) values (?)";
        //Geração do Statement com a Sring sql
        PreparedStatement stmt = con.prepareStatement(sql);
        //envio de valores do objeto para o Statement
        stmt.setString(1, setor.getNome_Setor());
 
        //Execucação 
        stmt.execute();
        //Fechando o Statement
        stmt.close();
        //Fechando a conexão com a Banco de Dados 
        con.close();
    }
       public static void excluir(Setor setor) throws SQLException{
         Connection con = Conexao.getConexao();
         String sql = "delete from tb_Setor where IdSetor=?";
         PreparedStatement stmt = con.prepareStatement(sql);
         stmt.setInt(1, setor.getIdSetor());
         stmt.executeUpdate();
         stmt.close();
         con.close();
     }
       public static List<Setor> pesquisar(Setor setPesq) throws SQLException {
        List<Setor> listaSetor = new ArrayList<Setor>();
        Connection con = Conexao.getConexao();
        String //where = onde
                sql = "select * from tb_Setor where nome_Setor like '" + setPesq.getNome_Setor()+ "%' order by nome_Setor";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Setor setor= new Setor();
            setor.setIdSetor(rs.getInt("IdSetor"));
            setor.setNome_Setor(rs.getString("nome_Setor"));
            
            listaSetor.add(setor);
        }
        stmt.close();
        rs.close();
        con.close();
        return listaSetor;
    }
       
     public static List<Setor> pesquisar() throws SQLException {
        List<Setor> listaSetor = new ArrayList<Setor>();
        Connection con = Conexao.getConexao();
        String //where = onde
                sql = "select * from tb_Setor order by nome_Setor";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Setor setor= new Setor();
            setor.setIdSetor(rs.getInt("IdSetor"));
            setor.setNome_Setor(rs.getString("nome_Setor"));
            
            listaSetor.add(setor);
        }
        stmt.close();
        rs.close();
        con.close();
        return listaSetor;
    }
       
       
       public static void alterar(Setor setor) throws SQLException{
          
          Connection con = Conexao.getConexao();
          
          //update = atualizar dados
          
          String sql = "update tb_Setor set nome_Setor = ?"
                  + "where IdSetor = ?";
          
          PreparedStatement stmt = con.prepareStatement(sql);
          stmt.setString(1,setor.getNome_Setor());
          stmt.setInt(2,setor.getIdSetor());
          stmt.executeUpdate();
          stmt.close();
          con.close();
          
      }

    
}
