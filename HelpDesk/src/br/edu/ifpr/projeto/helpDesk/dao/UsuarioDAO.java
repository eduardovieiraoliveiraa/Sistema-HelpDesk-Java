
package br.edu.ifpr.projeto.helpDesk.dao;

import br.edu.ifpr.projeto.helpDesk.modelo.Chamado;
import br.edu.ifpr.projeto.helpDesk.modelo.Setor;
import br.edu.ifpr.projeto.helpDesk.modelo.Usuario;
import br.edu.ifpr.projeto.helpDesk.visao.util.Conexao;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioDAO {
    
     public static void inserir(Usuario usuario) throws SQLException {
        //captura da conexão
        Connection con = Conexao.getConexao();
        //Criação do SQL
        String sql = "insert into tb_Usuario (nome_Usuario, email, grupo, usuarioLogin, senha, IdSetor) values (?,?,?,?,?,?)";
        //Geração do Statement com a Sring sql
        PreparedStatement stmt = con.prepareStatement(sql);
        //envio de valores do objeto para o Statement
        stmt.setString(1, usuario.getNome_Usuario());
         stmt.setString(2, usuario.getEmail());
          stmt.setString(3, usuario.getGrupo());
           stmt.setString(4, usuario.getUsuarioLogin());
            stmt.setString(5, usuario.getSenha());
               stmt.setInt(6, usuario.getSetor().getIdSetor());
        
        //Execucação 
        stmt.execute();
        //Fechando o Statement
        stmt.close();
        //Fechando a conexão com a Banco de Dados 
        con.close();
    }
    
      public static void alterar(Usuario usuario) throws SQLException {
           Connection con = Conexao.getConexao();
            String sql = "update tb_Usuario set nome_Usuario = ?, email = ?, grupo = ?, usuarioLogin =?, senha =?, IdSetor =? where IdUsuario =?";
            PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, usuario.getNome_Usuario());
                stmt.setString(2, usuario.getEmail());
                stmt.setString(3, usuario.getGrupo());
                stmt.setString(4, usuario.getUsuarioLogin());
                stmt.setString(5, usuario.getSenha());
                stmt.setInt(6, usuario.getSetor().getIdSetor());
                stmt.setInt(7, usuario.getIdUsuario());
                
                stmt.executeUpdate();
                stmt.close();
                con.close();
            
        
   }

        public static void excluir(Usuario usuario) throws SQLException {
        
        Connection con = Conexao.getConexao();
        String sql = "delete from tb_Usuario where IdUsuario =?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, usuario.getIdUsuario());
      
        stmt.executeUpdate();
        stmt.close();
        con.close();
    }

    public static List<Usuario> pesquisar(Usuario usuarioPesq) throws SQLException {
        List<Usuario> listaUsuario = new ArrayList<>();
        Connection con = Conexao.getConexao();
        String sql = "SELECT \n"
                + "	*\n"
               
              
                + "FROM \n"
                + "	tb_Usuario,\n"
                + "	tb_Setor \n"
                
                + "WHERE\n"
                + "	tb_Usuario.IdSetor = tb_Setor.IdSetor AND\n"
                + "	tb_Usuario.nome_Usuario like '" + usuarioPesq.getNome_Usuario()+ "%' "
                + "ORDER BY tb_Usuario.nome_Usuario";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {

            Setor setor = new Setor();
            setor.setIdSetor(rs.getInt("IdSetor"));
            setor.setNome_Setor(rs.getString("nome_Setor"));
            

           Usuario usuario = new Usuario();
            
            usuario.setNome_Usuario(rs.getString("nome_Usuario"));
            usuario.setEmail(rs.getString("email"));
            usuario.setGrupo(rs.getString("grupo"));
            usuario.setUsuarioLogin(rs.getString("usuarioLogin"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setNome_Usuario(rs.getString("nome_Usuario"));
            usuario.setIdUsuario(rs.getInt("IdUsuario"));
            usuario.setSetor(setor);
             


            listaUsuario.add(usuario);
        }
        stmt.close();
        rs.close();
        con.close();
        return listaUsuario;
    }
    
 
       public static List<Usuario> comparaLogin(String usu){
        List<Usuario> listaUsuario = new ArrayList<>();
        
        try{
        Connection con = Conexao.getConexao();
        String sql = "SELECT * FROM tb_Usuario where  tb_Usuario.usuarioLogin = '"+usu+"'";
        
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
        Usuario usuario = new Usuario();
        usuario.setUsuarioLogin(rs.getString("usuarioLogin"));
        listaUsuario.add(usuario);
        }
        return listaUsuario;
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
       }
       
        public static List<Usuario> pesquisarLoginA(int x) throws SQLException {
        List<Usuario> listaUsuario = new ArrayList<>();
        Connection con = Conexao.getConexao();
        
    
        String sql = "SELECT * from tb_Usuario inner join tb_Chamado on tb_Usuario.IdUsuario = tb_Chamado.IdUsuario where tb_Chamado.IdUsuario = '"+x+"'";
                
               
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {

           Usuario usuario = new Usuario();
            
            usuario.setNome_Usuario(rs.getString("nome_Usuario")); 
            usuario.setGrupo(rs.getString("grupo"));
            usuario.setUsuarioLogin(rs.getString("usuarioLogin"));
            usuario.setSenha(rs.getString("senha")); 
            usuario.setIdUsuario(rs.getInt("IdUsuario"));
            
            Chamado chamado = new Chamado();
            
            chamado.setUsuario(usuario);

            listaUsuario.add(usuario);
        }
        stmt.close();
        rs.close();
        con.close();
        return listaUsuario;
        
    }
       
       
       
       
       
       
       
       
       
        public static List<Usuario> pesquisarLogin(String grupo, String user, String senha) throws SQLException {
        List<Usuario> listaUsuario = new ArrayList<>();
        Connection con = Conexao.getConexao();
        String sql = "SELECT \n"
                + "	*\n"
               
              
                + "FROM \n"
                + "	tb_Usuario,\n"
                + "	tb_Setor \n"
                
                + "WHERE\n"
                + "	tb_Usuario.IdSetor = tb_Setor.IdSetor AND\n"
                + "	 tb_Usuario.grupo = '"+grupo+"' AND tb_Usuario.usuarioLogin = '"+user+"' AND tb_Usuario.senha = '"+senha+"'";
               
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {

            Setor setor = new Setor();
            setor.setIdSetor(rs.getInt("IdSetor"));
            setor.setNome_Setor(rs.getString("nome_Setor"));
            

           Usuario usuario = new Usuario();
            
            usuario.setNome_Usuario(rs.getString("nome_Usuario")); 
            usuario.setGrupo(rs.getString("grupo"));
            usuario.setUsuarioLogin(rs.getString("usuarioLogin"));
            usuario.setSenha(rs.getString("senha")); 
            usuario.setIdUsuario(rs.getInt("IdUsuario"));
            usuario.setSetor(setor);
             


            listaUsuario.add(usuario);
        }
        stmt.close();
        rs.close();
        con.close();
        return listaUsuario;
    }
    
}
