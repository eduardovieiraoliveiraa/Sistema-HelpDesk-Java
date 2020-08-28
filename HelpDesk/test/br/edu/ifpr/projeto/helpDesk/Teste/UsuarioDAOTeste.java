
package br.edu.ifpr.projeto.helpDesk.Teste;

import br.edu.ifpr.projeto.helpDesk.dao.SetorDAO;
import br.edu.ifpr.projeto.helpDesk.dao.UsuarioDAO;
import br.edu.ifpr.projeto.helpDesk.modelo.Setor;
import br.edu.ifpr.projeto.helpDesk.modelo.Usuario;
import java.sql.SQLException;


public class UsuarioDAOTeste {
    
    public static void inserir(){
    
        
          Usuario usuario = new Usuario();
          UsuarioDAO use = new UsuarioDAO();
          Setor setor = new Setor();
          
          
        
          try{
          usuario.setNome_Usuario("progteste");
          usuario.setEmail("teste@teste");
          usuario.setGrupo("prog");
          setor.setIdSetor(1);
          usuario.setUsuarioLogin("dudu");
          usuario.setSenha("coco");
          usuario.setSetor(setor);
         
              use.inserir(usuario);
              System.out.println("Inserção realizada");
        
          }catch(SQLException ex){
              System.out.println("erro ao inserir dados no banco de dados");
              ex.printStackTrace();
          }
          
    }
    
    public static void alterar() throws SQLException{
            
        try{
        Usuario usuario = new Usuario();
        Setor setor = new Setor();
        usuario.setIdUsuario(1);
        usuario.setNome_Usuario("admin");
        usuario.setEmail("admin");
        usuario.setGrupo("admin");
        usuario.setUsuarioLogin("admin");
        usuario.setSenha("admin");
        setor.setIdSetor(1);
        usuario.setSetor(setor);
        UsuarioDAO.alterar(usuario);
        
        System.out.println("alterado");
     
        }catch(Exception e){
            
            System.out.println("IMPOSSIVEL ALTERAR");
            e.printStackTrace();
            
        }
        }
    
   
    
    
  public static void main(String[] args) throws SQLException {
       
      inserir();
      // alterar();

    }
    
}
