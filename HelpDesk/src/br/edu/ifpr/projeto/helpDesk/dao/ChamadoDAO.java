
package br.edu.ifpr.projeto.helpDesk.dao;

import br.edu.ifpr.projeto.helpDesk.modelo.Chamado;
import br.edu.ifpr.projeto.helpDesk.modelo.Problema;
import br.edu.ifpr.projeto.helpDesk.modelo.Setor;
import br.edu.ifpr.projeto.helpDesk.modelo.Solucao;
import br.edu.ifpr.projeto.helpDesk.modelo.Usuario;
import br.edu.ifpr.projeto.helpDesk.visao.util.Conexao;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class ChamadoDAO {
    
         public static void inserir(Chamado chamado) throws SQLException {
        
        Connection con = Conexao.getConexao();
        
        String sql = "insert into tb_Chamado (titulo_Chamado, urgencia, descricao, IdUsuario, IdProblema,data_Abertura, status_Chamado, tipoChamado) values (?,?,?,?,?,?,?,?)";
        
        PreparedStatement stmt = con.prepareStatement(sql);
        
        stmt.setString(1, chamado.getTitulo());
        stmt.setString(2, chamado.getUrgencia());
        stmt.setString(3, chamado.getDescricao());
        stmt.setInt(4, chamado.getUsuario().getIdUsuario());
        stmt.setInt(5, chamado.getProblema().getIdProblema());    
        stmt.setTimestamp(6,new java.sql.Timestamp(chamado.getDataAbertura().getTime().getTime()));
        stmt.setString(7,chamado.getStatus());
        stmt.setString(8,chamado.getTipo());
  
       
        stmt.execute(); 
        stmt.close();
        con.close();
    }
         
        public static void alterarTecnico(Chamado chamado) throws SQLException {
        
        Connection con = Conexao.getConexao();
        
        String sql = "update tb_Chamado set tecnico = ? where IdChamado = ?";
        
        PreparedStatement stmt = con.prepareStatement(sql);
        
        stmt.setString(1, chamado.getTecnico());
        stmt.setInt(2, chamado.getIdChamado());
       
       
        stmt.execute(); 
        stmt.close();
        con.close();
    }    
         
         
    
      public static void alterar(Solucao solucao,Chamado chamado) throws SQLException {
             Connection con = Conexao.getConexao();
           
             
             PreparedStatement stmt2 = con.prepareStatement("insert into tb_Solucao (solucao)values(?)",Statement.RETURN_GENERATED_KEYS);
           
              stmt2.setString(1, solucao.getDescricao());
           
              stmt2.execute();
              
              ResultSet rs = stmt2.getGeneratedKeys();
              int id = 0;
              if(rs.next()){
                  id = rs.getInt(1);
              }
           
            String sql = "update tb_Chamado set IdSolucao=?,data_Fechado=?, status_chamado=?"
                     + "where IdChamado = ?";
            
                PreparedStatement stmt = con.prepareStatement(sql);
           
            
            

                stmt.setInt(1,id);
                stmt.setTimestamp(2,new java.sql.Timestamp(chamado.getDataFechado().getTime().getTime())); 
                stmt.setString(3, chamado.getStatus());
                stmt.setInt(4, chamado.getIdChamado());
                
                stmt.executeUpdate();
                stmt.close();
                con.close();
            
        
   }
      
      public static ResultSet retornaRS01(String x) throws SQLException{
             
          Connection con = Conexao.getConexao();
          
          String sql = "SELECT \n"
                + " tb_Chamado.IdChamado, tb_Chamado.titulo_Chamado, tb_Chamado.IdProblema, tb_Problema.tipo, tb_Chamado.tipoChamado\n"
                + "FROM \n"
                + "	tb_Chamado inner join tb_Problema on tb_Chamado.IdProblema = tb_Problema.IdProblema where tb_Chamado.tipoChamado = '"+x+"'";
      
              
          
                  System.out.println(sql);
                  PreparedStatement stmt = con.prepareStatement(sql);
                  ResultSet rs = stmt.executeQuery();
                  return rs;
      }
      
      
       public static ResultSet retornaRS02(String x) throws SQLException{
             
          Connection con = Conexao.getConexao();
          
          String sql = "SELECT \n"
                + " tb_usuario.nome_Usuario,tb_Chamado.IdChamado,tb_Chamado.titulo_chamado, tb_Chamado.tipoChamado, tb_Chamado.status_Chamado, tb_Problema.tipo, tb_Chamado.tecnico, tb_Problema.IdProblema"   
                + " FROM \n"
                + "	tb_Chamado inner join tb_Problema on tb_Chamado.IdProblema = tb_Problema.IdProblema inner join tb_Usuario on tb_Chamado.IdUsuario = tb_Usuario.IdUsuario"
                + " where tb_Chamado.tecnico = '"+x+"'";
      
              
          
                  System.out.println(sql);
                  PreparedStatement stmt = con.prepareStatement(sql);
                  ResultSet rs = stmt.executeQuery();
                  return rs;
      }
      

        public static void excluir(Chamado chamado) throws SQLException {
        
        Connection con = Conexao.getConexao();
        String sql = "delete from tb_Chamado where IdChamado =?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, chamado.getIdChamado());
      
        stmt.executeUpdate();
        stmt.close();
        con.close();
    }
        
     

    public static List<Chamado> pesquisar(Chamado chamadoPesq) throws SQLException {
        List<Chamado> listaChamado = new ArrayList<>();
        
        //METODO DE PESQUISA USADO SOMENTE PELA TELA DO TECNICO
        
        Connection con = Conexao.getConexao();
        
        String sql = "SELECT \n"
                + "	*\n"
               
              
                + "FROM \n"
                + "	tb_Chamado,\n"
                + "	tb_Usuario, \n"
                + "	tb_Problema, \n"
                + "	tb_Setor \n"
                
                + "WHERE\n"
                + "	tb_Chamado.IdUsuario = tb_Usuario.IdUsuario AND\n"
                 + "	tb_Setor.IdSetor = tb_Usuario.IdSetor AND\n"
                + "	tb_Chamado.IdProblema = tb_Problema.IdProblema AND\n"  
                + "	tb_Chamado.titulo_Chamado like '" + chamadoPesq.getTitulo()+ "%' "
                + "ORDER BY tb_Chamado.titulo_Chamado";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
            while (rs.next()) {

            Usuario usuario = new Usuario();
            Setor setor = new Setor();
            usuario.setIdUsuario(rs.getInt("IdUsuario"));
            usuario.setNome_Usuario(rs.getString("nome_Usuario"));
            usuario.setGrupo(rs.getString("grupo"));
            
            setor.setIdSetor(rs.getInt("IdSetor"));
            setor.setNome_Setor(rs.getString("nome_Setor"));
            usuario.setSetor(setor);
           
            Problema problema = new Problema();
            
            problema.setIdProblema(rs.getInt("IdProblema"));
            problema.setTipo(rs.getString("tipo"));
            
            Solucao solucao = new Solucao();
            
            solucao.setIdSolucao(rs.getInt("IdProblema"));
            solucao.setDescricao(rs.getString("descricao"));
            
            Chamado chamado = new Chamado();
            Calendar abertura = Calendar.getInstance();
           
       

          chamado.setIdChamado(rs.getInt("IdChamado"));
          chamado.setTitulo(rs.getString("titulo_Chamado"));
          chamado.setUrgencia(rs.getString("urgencia"));
          chamado.setDescricao(rs.getString("descricao"));
          chamado.setUsuario(usuario);
          chamado.setProblema(problema);
          chamado.setSolucao(solucao);
          abertura.setTime(rs.getTimestamp("data_Abertura"));
          chamado.setDataAbertura(abertura);
          chamado.setTecnico(rs.getString("tecnico"));
          
          Calendar fechado = Calendar.getInstance();
          
          chamado.setStatus(rs.getString("status_chamado"));
          chamado.setTipo(rs.getString("tipoChamado")); 
          fechado.setTime(rs.getTimestamp("data_Fechado"));
          chamado.setTecnico(rs.getString("tecnico"));
          chamado.setDataFechado(fechado);

           

           listaChamado.add(chamado);
        }
        stmt.close();
        rs.close();
        con.close();
        return listaChamado;
    }
    
       public static List<Chamado> pesquisarAbertoTecnico(String status) throws SQLException {
        List<Chamado> listaChamado = new ArrayList<>();
        
        Connection con = Conexao.getConexao();
        
        String sql = "SELECT *\n"+
                "from tb_Chamado inner join tb_Usuario on\n"+
                "tb_Usuario.IdUsuario = tb_Chamado.IdUsuario inner join tb_Setor on  tb_Setor.IdSetor = tb_Usuario.IdSetor  \n"+
                "inner join tb_Problema on tb_Problema.IdProblema = tb_Chamado.IdProblema \n"+
                "where tb_chamado.status_chamado = '"+status+"'\n";
//                "order by tb_Chamado.titulo_Chamado";
                

            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
        
            while (rs.next()) {
           
             Usuario usuario = new Usuario();
            Setor setor = new Setor();
            usuario.setIdUsuario(rs.getInt("IdUsuario"));
            usuario.setNome_Usuario(rs.getString("nome_Usuario"));
            usuario.setGrupo(rs.getString("grupo"));
            
            setor.setIdSetor(rs.getInt("IdSetor"));
            setor.setNome_Setor(rs.getString("nome_Setor"));
            usuario.setSetor(setor);
           
            Problema problema = new Problema();
            
            problema.setIdProblema(rs.getInt("IdProblema"));
            problema.setTipo(rs.getString("tipo"));
            
//            Solucao solucao = new Solucao();
//            
//            solucao.setIdSolucao(rs.getInt("IdProblema"));
//            solucao.setDescricao(rs.getString("descricao"));
            
            Chamado chamado = new Chamado();
            Calendar abertura = Calendar.getInstance();
           
       

          chamado.setIdChamado(rs.getInt("IdChamado"));
          chamado.setTitulo(rs.getString("titulo_Chamado"));
          chamado.setUrgencia(rs.getString("urgencia"));
          chamado.setDescricao(rs.getString("descricao"));
          chamado.setUsuario(usuario);
          chamado.setProblema(problema);
//          chamado.setSolucao(solucao);
          abertura.setTime(rs.getTimestamp("data_Abertura"));
          chamado.setDataAbertura(abertura);
          
          Calendar fechado = Calendar.getInstance();
          
          chamado.setStatus(rs.getString("status_chamado"));
          chamado.setTipo(rs.getString("tipoChamado")); 
          fechado.setTime(rs.getTimestamp("data_Fechado"));
          chamado.setTecnico(rs.getString("tecnico"));
          chamado.setDataFechado(fechado);

        
             listaChamado.add(chamado);

        }
        stmt.close();
        rs.close();
        con.close();
        return listaChamado;
    }
       
       
       public static List<Chamado> pesquisarFechadoTecnico(String status) throws SQLException {
        List<Chamado> listaChamado = new ArrayList<>();
        
        Connection con = Conexao.getConexao();
        
        String sql = "SELECT *\n"+
                "from tb_Chamado inner join tb_Usuario on\n"+
                "tb_Usuario.IdUsuario = tb_Chamado.IdUsuario inner join tb_Setor on  tb_Setor.IdSetor = tb_Usuario.IdSetor  \n"+
                "inner join tb_Problema on tb_Problema.IdProblema = tb_Chamado.IdProblema \n"+
                "where tb_chamado.status_chamado = '"+status+"'\n";
//                "order by tb_Chamado.titulo_Chamado";
                

            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
        
            while (rs.next()) {
           
             Usuario usuario = new Usuario();
            Setor setor = new Setor();
            usuario.setIdUsuario(rs.getInt("IdUsuario"));
            usuario.setNome_Usuario(rs.getString("nome_Usuario"));
            usuario.setGrupo(rs.getString("grupo"));
            
            setor.setIdSetor(rs.getInt("IdSetor"));
            setor.setNome_Setor(rs.getString("nome_Setor"));
            usuario.setSetor(setor);
           
            Problema problema = new Problema();
            
            problema.setIdProblema(rs.getInt("IdProblema"));
            problema.setTipo(rs.getString("tipo"));
            
//            Solucao solucao = new Solucao();
//            
//            solucao.setIdSolucao(rs.getInt("IdProblema"));
//            solucao.setDescricao(rs.getString("descricao"));
            
            Chamado chamado = new Chamado();
            Calendar abertura = Calendar.getInstance();
           
       

          chamado.setIdChamado(rs.getInt("IdChamado"));
          chamado.setTitulo(rs.getString("titulo_Chamado"));
          chamado.setUrgencia(rs.getString("urgencia"));
          chamado.setDescricao(rs.getString("descricao"));
          chamado.setUsuario(usuario);
          chamado.setProblema(problema);
//          chamado.setSolucao(solucao);
          abertura.setTime(rs.getTimestamp("data_Abertura"));
          chamado.setDataAbertura(abertura);
          
          Calendar fechado = Calendar.getInstance();
          
          chamado.setStatus(rs.getString("status_chamado"));
          chamado.setTipo(rs.getString("tipoChamado")); 
          fechado.setTime(rs.getTimestamp("data_Fechado"));
          chamado.setTecnico(rs.getString("tecnico"));
          chamado.setDataFechado(fechado);

        
             listaChamado.add(chamado);

        }
        stmt.close();
        rs.close();
        con.close();
        return listaChamado;
    }
    

      
    
    
        public static List<Chamado> pesquisarFechado(int x) throws SQLException {
        List<Chamado> listaChamado = new ArrayList<>();
        
        Connection con = Conexao.getConexao();
        
        //METODO DE PESQUISA QUE PEGA POR PARAMETRO O ID DO USUARIO, PARA PEGAR SOMENTE OS CHAMADOS DO DETERMINADO USUARIO
        // E COMO ESTA SENDO PASSADO O ID DA SOLUCAO CONSEQUENTEMENTE ELE IRÁ CHAMAR SOMENTE OS CHAMADOS FECHADOS, QUAL TAL JA TEM UMA SOLUCAO
        
        String sql = "SELECT *\n"+
                "from tb_Chamado inner join tb_Usuario on\n"+
                "tb_Usuario.IdUsuario = tb_Chamado.IdUsuario inner join tb_Solucao on tb_Solucao.IdSolucao = tb_Chamado.IdSolucao\n"+
                "where tb_Chamado.IdUsuario = '"+x+"'"+
                "order by tb_Chamado.titulo_Chamado";
                

            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
        
            while (rs.next()) {
           
             Usuario usuario = new Usuario();
             usuario.setIdUsuario(rs.getInt("IdUsuario"));
                
            Chamado chamado = new Chamado();
            
            Solucao solucao = new Solucao();
            solucao.setIdSolucao(rs.getInt("IdSolucao"));
            solucao.setDescricao(rs.getString("solucao"));
            
            chamado.setIdChamado(rs.getInt("IdChamado"));
            chamado.setTitulo(rs.getString("titulo_Chamado"));
            chamado.setUrgencia(rs.getString("urgencia"));
            chamado.setDescricao(rs.getString("descricao"));
            
            Calendar abertura = Calendar.getInstance();
            abertura.setTime(rs.getTimestamp("data_Abertura"));
            chamado.setDataAbertura(abertura);
            
            Calendar fechado = Calendar.getInstance();
            fechado.setTime(rs.getTimestamp("data_Fechado"));
            chamado.setDataFechado(fechado);
          
            chamado.setStatus(rs.getString("status_chamado"));
            chamado.setTecnico(rs.getString("tecnico"));
            chamado.setUsuario(usuario);
             chamado.setSolucao(solucao);
        
             listaChamado.add(chamado);

        }
        stmt.close();
        rs.close();
        con.close();
        return listaChamado;
    }
        
      public static List<Chamado> pesquisarAberto(int x) throws SQLException {
        List<Chamado> listaChamado = new ArrayList<>();
        
        Connection con = Conexao.getConexao();
        
        //METODO DE PESQUISA QUE PEGA POR PARAMETRO O ID DO USUARIO, PARA PEGAR SOMENTE OS CHAMADOS DO DETERMINADO USUARIO
        // E COMO ESTA SENDO PASSADO O ID DA SOLUCAO CONSEQUENTEMENTE ELE IRÁ CHAMAR SOMENTE OS CHAMADOS FECHADOS, QUAL TAL JA TEM UMA SOLUCAO
        
        String sql = "SELECT *\n"+
                "from tb_Chamado inner join tb_Usuario on\n"+
                "tb_Usuario.IdUsuario = tb_Chamado.IdUsuario\n"+
                "where tb_Chamado.IdUsuario = '"+x+"'"+
                "order by tb_Chamado.titulo_Chamado";
                

            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
        
            while (rs.next()) {
           
             Usuario usuario = new Usuario();
             usuario.setIdUsuario(rs.getInt("IdUsuario"));
                
            Chamado chamado = new Chamado();

            chamado.setIdChamado(rs.getInt("IdChamado"));
            chamado.setTitulo(rs.getString("titulo_Chamado"));
            chamado.setUrgencia(rs.getString("urgencia"));
            chamado.setDescricao(rs.getString("descricao"));
            
            Calendar abertura = Calendar.getInstance();
            abertura.setTime(rs.getTimestamp("data_Abertura"));
            chamado.setDataAbertura(abertura);
            
            Calendar fechado = Calendar.getInstance();
            fechado.setTime(rs.getTimestamp("data_Fechado"));
            chamado.setDataFechado(fechado);
          
            chamado.setStatus(rs.getString("status_chamado"));
            chamado.setTecnico(rs.getString("tecnico"));
            chamado.setUsuario(usuario);
            
        
             listaChamado.add(chamado);

        }
        stmt.close();
        rs.close();
        con.close();
        return listaChamado;
    }
           
        
        
        
        
         public static int contadorteste(String x) 
            { 
            String sql; 
            sql = "SELECT count(*) FROM tb_Chamado where tb_Chamado.status_Chamado = '"+x+"'"; 
            try 
            { 
            Connection con = Conexao.getConexao(); 
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet CONT = stm.executeQuery(sql); 
            CONT.next();
            return CONT.getInt("count(*)"); 
            } 
            catch (Exception e) 
            { 
            e.printStackTrace(); 
            } 

            return 0;     
            }   
        
      
   public static ResultSet retornaRS03(int x, String y) throws SQLException{
             
          Connection con = Conexao.getConexao();
          
          
          
                   String sql = "SELECT \n"
                + " tb_usuario.nome_Usuario,tb_Chamado.IdChamado,tb_Chamado.titulo_chamado, tb_Chamado.tipoChamado, tb_Chamado.status_Chamado, tb_Problema.tipo, tb_Chamado.tecnico, tb_Problema.IdProblema"   
                + " FROM \n"
                + "	tb_Chamado inner join tb_Problema on tb_Chamado.IdProblema = tb_Problema.IdProblema inner join tb_Usuario on tb_Chamado.IdUsuario = tb_Usuario.IdUsuario"
                + " where tb_Chamado.IdUsuario = '"+x+"' AND tb_Chamado.status_Chamado = '"+y+"'";
          
 
          
                  System.out.println(sql);
                  PreparedStatement stmt = con.prepareStatement(sql);
                  ResultSet rs = stmt.executeQuery();
                  return rs;
      }
   
  
        
        
   public static List<Chamado> pesquisarAberto(int x, String status) throws SQLException {
        List<Chamado> listaChamado = new ArrayList<>();
        
        Connection con = Conexao.getConexao();
        
        //METODO USADO PELA TELA DO USUARIO PARA FILTRAR OS CHAMADOS QUE AINDA ESTAO ABERTOS
        
        String sql = "SELECT *\n"+
                "from tb_Chamado inner join tb_Usuario on\n"+
                "tb_Usuario.IdUsuario = tb_Chamado.IdUsuario\n"+
                "where tb_Chamado.IdUsuario = '"+x+"' AND tb_chamado.status_chamado = '"+status+"'\n";
//                "order by tb_Chamado.titulo_Chamado";
                

            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
        
            while (rs.next()) {
           
             Usuario usuario = new Usuario();
             usuario.setIdUsuario(rs.getInt("IdUsuario"));
                
            Chamado chamado = new Chamado();
            
            
            chamado.setIdChamado(rs.getInt("IdChamado"));
            chamado.setTitulo(rs.getString("titulo_Chamado"));
            chamado.setUrgencia(rs.getString("urgencia"));
            chamado.setDescricao(rs.getString("descricao"));
            
            Calendar abertura = Calendar.getInstance();
            abertura.setTime(rs.getTimestamp("data_Abertura"));
            chamado.setDataAbertura(abertura);
            
           Calendar fechado = Calendar.getInstance();
           fechado.setTime(rs.getTimestamp("data_Fechado"));
           chamado.setDataFechado(fechado);
           chamado.setTecnico(rs.getString("tecnico"));
           chamado.setStatus(rs.getString("status_chamado"));
            chamado.setUsuario(usuario);
        
             listaChamado.add(chamado);

        }
        stmt.close();
        rs.close();
        con.close();
        return listaChamado;
    }
    
}
