package br.edu.ifpr.projeto.helpDesk.visao;

import br.edu.ifpr.projeto.helpDesk.dao.ChamadoDAO;
import br.edu.ifpr.projeto.helpDesk.dao.UsuarioDAO;
import br.edu.ifpr.projeto.helpDesk.modelo.Chamado;
import br.edu.ifpr.projeto.helpDesk.modelo.Usuario;
import br.edu.ifpr.projeto.helpDesk.visao.util.Relatorio;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SolucaoUser extends javax.swing.JFrame {
        
      private List<Chamado> chamadosAbertos = new ArrayList<Chamado>();
      private List<Chamado> chamadosFechados = new ArrayList<Chamado>();
      private List<Usuario> usu = new ArrayList<Usuario>();
      private int id;
      private int idR;
      private String teste2;
      
      
    
    public SolucaoUser() {
        initComponents();
    }

    public SolucaoUser(Usuario usuario) {
         initComponents();
         idR = usuario.getIdUsuario();
         atualizaTabela(idR);
         id = usuario.getIdUsuario();
         teste2 = usuario.getNome_Usuario();
         this.setIconImage(new ImageIcon(getClass().getResource("iconeif.png")).getImage());
          
         
    }
    
         private void atualizaBotao(){
              btSolucao.setEnabled(true);

         }

  private void atualizaTabela(int t) {

          ChamadoDAO chamado = new ChamadoDAO();
          Usuario use2 = new Usuario();
          
          
          //METODO QUE INSERE OS CHAMADOS FECHADOS NA TABELA
           try {
               System.out.println(idR);
               chamadosFechados = ChamadoDAO.pesquisarFechado(t);
               DefaultTableModel modelo = (DefaultTableModel) tbSolucao.getModel();
              
               modelo.setNumRows(0);
               DateFormat formato = new SimpleDateFormat("dd/MM/yyyyy - HH:mm");

                   for(Chamado cha : chamadosFechados) {
                   
                       modelo.addRow(new Object[]{
                       cha.getIdChamado(),
                       cha.getTitulo(),
                       cha.getUrgencia(),
                       formato.format(cha.getDataAbertura().getTime()),
                       cha.getStatus(),
                       formato.format(cha.getDataFechado().getTime()),
                       cha.getTecnico() 
                      
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbSolucao = new javax.swing.JTable();
        btSolucao = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rbAberto = new javax.swing.JRadioButton();
        btPesquisar = new javax.swing.JButton();
        btRelatorio = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tbSolucao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero Chamado", "Titulo", "Urgencia", "Data Abertura", "Status", "Data de Encerramento", "Tecnico"
            }
        ));
        tbSolucao.setSelectionBackground(new java.awt.Color(51, 153, 0));
        tbSolucao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSolucaoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbSolucao);

        btSolucao.setForeground(new java.awt.Color(0, 204, 51));
        btSolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifpr/projeto/helpDesk/visao/icon/icones/pesquisar.png"))); // NOI18N
        btSolucao.setText("VER SOLUÇÃO");
        btSolucao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btSolucaoMouseReleased(evt);
            }
        });

        btSair.setForeground(new java.awt.Color(255, 0, 0));
        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifpr/projeto/helpDesk/visao/icon/icones/arrow_down.png"))); // NOI18N
        btSair.setText("VOLTAR");
        btSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btSairMouseReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 0));
        jLabel1.setText("SOLUÇÕES DOS CHAMADOS");

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\NetBeansProjects\\HelpDesk\\imagens\\IFPR Menor.png")); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FILTRAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 153, 0))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(0, 153, 51));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        rbAberto.setText("CHAMADOS ABERTOS");
        rbAberto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rbAbertoMouseReleased(evt);
            }
        });

        btPesquisar.setBackground(new java.awt.Color(255, 255, 153));
        btPesquisar.setForeground(new java.awt.Color(51, 51, 51));
        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifpr/projeto/helpDesk/visao/icon/icones/LupaPesquisar.png"))); // NOI18N
        btPesquisar.setText("PESQUISAR");
        btPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btPesquisarMouseReleased(evt);
            }
        });

        btRelatorio.setBackground(new java.awt.Color(0, 204, 204));
        btRelatorio.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\NetBeansProjects\\HelpDesk\\icons\\page_go.png")); // NOI18N
        btRelatorio.setText("GERAR RELATÓRIO");
        btRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btRelatorioMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(rbAberto, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btRelatorio)
                .addGap(41, 41, 41))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPesquisar)
                    .addComponent(btRelatorio)
                    .addComponent(rbAberto))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifpr/projeto/helpDesk/visao/icon/icones/iconeif.png"))); // NOI18N

        jLabel5.setForeground(new java.awt.Color(0, 153, 0));
        jLabel5.setText("Projeto integrador - Eduardo Vieira Oliveira - Instituto Federal do Parana - IFPR - 4º Periodo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 328, Short.MAX_VALUE)
                .addComponent(btSolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(358, 358, 358))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)))
                        .addComponent(jLabel2)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSolucao)
                    .addComponent(btSair))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbSolucaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSolucaoMouseClicked
       
       //DESCONTINUADO
        
    }//GEN-LAST:event_tbSolucaoMouseClicked

    private void btSairMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSairMouseReleased
       
        this.dispose();
        
    }//GEN-LAST:event_btSairMouseReleased

    private void rbAbertoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbAbertoMouseReleased
 
        //DESCONTINUADO
    }//GEN-LAST:event_rbAbertoMouseReleased

    private void btSolucaoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSolucaoMouseReleased
        
        if(rbAberto.isSelected()){
            //TRATANDO O ERRO AO PODER SOLUCIONAR DUAS VEZES O MESMO CHAMADO JA FECHADO
            JOptionPane.showMessageDialog(null,"O CHAMADO JÁ ESTÁ COM O TECNICO, AGUARDE O ATENDIMENTO");
        }else{
            Chamado chamado = chamadosFechados.get(tbSolucao.getSelectedRow());
             new SolucaoDetalhes(chamado).setVisible(true);
        }
        
     
       
    }//GEN-LAST:event_btSolucaoMouseReleased

    private void btPesquisarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPesquisarMouseReleased
        
        
        
          try {
              chamadosAbertos = ChamadoDAO.pesquisarAberto(idR,"Aberto");
              
             if(rbAberto.isSelected() && chamadosAbertos.isEmpty()){
               JOptionPane.showMessageDialog(null,"NAO HÁ CHAMADOS ABERTOS NO MOMENTO");
               
             }else if(rbAberto.isSelected()){ 
              
            System.out.println(idR);
            DefaultTableModel modelo = (DefaultTableModel) tbSolucao.getModel();
            
            modelo.setNumRows(0);
            DateFormat formato = new SimpleDateFormat("dd/MM/yyyyy - HH:mm");
            
            for(Chamado cha : chamadosAbertos) {
                
                   modelo.addRow(new Object[]{
                    cha.getIdChamado(),
                    cha.getTitulo(),
                    cha.getUrgencia(),
                    formato.format(cha.getDataAbertura().getTime()),
                    cha.getStatus(),
                    formato.format(cha.getDataFechado().getTime()),
                    cha.getTecnico()
                        
                });
            }
            
        }
         if(rbAberto.isSelected() == false){
             System.out.println(idR);
             atualizaTabela(idR);
                     
             
         }    
          } catch (SQLException ex) {
              Logger.getLogger(SolucaoUser.class.getName()).log(Level.SEVERE, null, ex);
          }
        
            
  
    }//GEN-LAST:event_btPesquisarMouseReleased

    private void btRelatorioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btRelatorioMouseReleased
        
        System.out.println(idR);
        
          try {
              Relatorio.gerarRelatorio("relatorios\\RelatorioUsu.jasper", ChamadoDAO.retornaRS03(idR, "Fechado"));
          } catch (SQLException ex) {
              Logger.getLogger(SolucaoUser.class.getName()).log(Level.SEVERE, null, ex);
          }
        
    }//GEN-LAST:event_btRelatorioMouseReleased

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
            //EM TESTE
    }//GEN-LAST:event_formWindowGainedFocus

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
            java.util.logging.Logger.getLogger(SolucaoUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SolucaoUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SolucaoUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SolucaoUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SolucaoUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btRelatorio;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSolucao;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbAberto;
    private javax.swing.JTable tbSolucao;
    // End of variables declaration//GEN-END:variables
}
