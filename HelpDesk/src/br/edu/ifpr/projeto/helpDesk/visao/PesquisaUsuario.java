/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.projeto.helpDesk.visao;
import br.edu.ifpr.projeto.helpDesk.dao.UsuarioDAO;
import br.edu.ifpr.projeto.helpDesk.modelo.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class PesquisaUsuario extends javax.swing.JFrame {

   
      private List<Usuario> usuarios = new ArrayList<Usuario>();
       private List<Usuario> usuarios2 = new ArrayList<Usuario>();
    
    public PesquisaUsuario() {
        initComponents();
        atualizaTabela();
        btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);
        this.setIconImage(new ImageIcon(getClass().getResource("iconeif.png")).getImage());
    }

    
      private Usuario retornaObjeto(){
        
        Usuario usuario= new Usuario();
        usuario.setNome_Usuario(txNome.getText().toUpperCase());
        
 
        return usuario;
    }
        
        private void atualizaBotao(){

           btAlterar.setEnabled(true);
           btExcluir.setEnabled(true);
         }
        
      private void atualizaTabela() {

           UsuarioDAO usuario = new UsuarioDAO();

           try {
              
               usuarios = UsuarioDAO.pesquisar(retornaObjeto());
               DefaultTableModel modelo = (DefaultTableModel) tbUsuario.getModel();
              
               modelo.setNumRows(0);

               for (Usuario usi : usuarios) {
                   modelo.addRow(new Object[]{
                       usi.getNome_Usuario(),
                       usi.getEmail(),
                       usi.getGrupo(),
                       usi.getUsuarioLogin(),
                       usi.getSenha(),
                       usi.getSetor().getIdSetor()
                       
                     
                   });
               }
           } catch (SQLException e) {
               System.out.println("Erro ao carregar tabela.");
               e.printStackTrace();
           }
       }

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuario = new javax.swing.JTable();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txNome = new javax.swing.JTextField();
        btPesquisar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tbUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOME", "EMAIL", "GRUPO", "USUARIO", "SENHA", "SETOR"
            }
        ));
        tbUsuario.setSelectionBackground(new java.awt.Color(51, 153, 0));
        tbUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUsuarioMouseClicked(evt);
            }
        });
        tbUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbUsuarioKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tbUsuario);

        btAlterar.setBackground(new java.awt.Color(255, 204, 0));
        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifpr/projeto/helpDesk/visao/icon/icones/alterar.png"))); // NOI18N
        btAlterar.setText("ALTERAR");
        btAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btAlterarMouseReleased(evt);
            }
        });

        btExcluir.setBackground(new java.awt.Color(255, 51, 51));
        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifpr/projeto/helpDesk/visao/icon/icones/excluir.png"))); // NOI18N
        btExcluir.setText("EXCLUIR");
        btExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btExcluirMouseReleased(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(51, 153, 0));
        jLabel1.setForeground(new java.awt.Color(51, 153, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifpr/projeto/helpDesk/visao/icon/icones/LupaPesquisar.png"))); // NOI18N
        jLabel1.setText("PESQUISAR");

        txNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txNomeKeyTyped(evt);
            }
        });

        btPesquisar.setBackground(new java.awt.Color(204, 255, 204));
        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifpr/projeto/helpDesk/visao/icon/icones/LupaPesquisar.png"))); // NOI18N
        btPesquisar.setText("PESQUISAR");
        btPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btPesquisarMouseReleased(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\NetBeansProjects\\HelpDesk\\imagens\\IFPR Menor.png")); // NOI18N

        btCancelar.setBackground(new java.awt.Color(255, 51, 51));
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifpr/projeto/helpDesk/visao/icon/icones/delete.png"))); // NOI18N
        btCancelar.setText("CANCELAR");
        btCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btCancelarMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btPesquisar)
                .addGap(0, 62, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(btAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisar))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btAlterar)
                            .addComponent(btExcluir)
                            .addComponent(btCancelar))
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUsuarioMouseClicked
        atualizaBotao();
    }//GEN-LAST:event_tbUsuarioMouseClicked

    private void btAlterarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAlterarMouseReleased

        Usuario usuario = usuarios.get(tbUsuario.getSelectedRow());

        new CadastroUsuario(usuario).setVisible(true);
        atualizaBotao();

    }//GEN-LAST:event_btAlterarMouseReleased

    private void tbUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbUsuarioKeyTyped
        
        atualizaTabela();
    }//GEN-LAST:event_tbUsuarioKeyTyped

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        atualizaTabela();
    }//GEN-LAST:event_formWindowGainedFocus

    private void btExcluirMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btExcluirMouseReleased
        
        Usuario usuarioSelecionada = usuarios.get(tbUsuario.getSelectedRow());
        Usuario usu = usuarios.get(tbUsuario.getSelectedRow());
        System.out.println( usu.getIdUsuario());
        
          try {
              usuarios2 = UsuarioDAO.pesquisarLoginA(usu.getIdUsuario());
        if(usuarios2.isEmpty()){
                 int opc = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o usuario: " + usuarioSelecionada.getNome_Usuario());
        if (opc == JOptionPane.YES_OPTION) {
            try {
                UsuarioDAO.excluir(usuarioSelecionada);
                atualizaTabela();
                
            } catch (SQLException e) {
                System.out.println("Erro ao excluir registro.");
                e.printStackTrace();
            }
        }
           atualizaBotao();
        }else{
            JOptionPane.showMessageDialog(null, "ESSE USUARIO TEM CHAMADOS EM ABERTO OU FECHADOS, IMPOSSIVEL EXCLUI-LO");
        }  

              
              
          } catch (SQLException ex) {
              Logger.getLogger(PesquisaUsuario.class.getName()).log(Level.SEVERE, null, ex);
          }
       
        
//        int opc = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o usuario: " + usuarioSelecionada.getNome_Usuario());
//        if (opc == JOptionPane.YES_OPTION) {
//            try {
//                UsuarioDAO.excluir(usuarioSelecionada);
//                atualizaTabela();
//                
//            } catch (SQLException e) {
//                System.out.println("Erro ao excluir registro.");
//                e.printStackTrace();
//            }
//        }
//           atualizaBotao();
        
        
    }//GEN-LAST:event_btExcluirMouseReleased

    private void txNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNomeKeyTyped
        
        atualizaTabela();
        
    }//GEN-LAST:event_txNomeKeyTyped

    private void btPesquisarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPesquisarMouseReleased
       
       atualizaTabela();
    }//GEN-LAST:event_btPesquisarMouseReleased

    private void btCancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCancelarMouseReleased
       
        this.dispose();
        
    }//GEN-LAST:event_btCancelarMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PesquisaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisaUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbUsuario;
    private javax.swing.JTextField txNome;
    // End of variables declaration//GEN-END:variables
}
