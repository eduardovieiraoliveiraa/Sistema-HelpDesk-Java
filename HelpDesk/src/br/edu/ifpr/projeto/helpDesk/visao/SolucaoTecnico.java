/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.projeto.helpDesk.visao;

import br.edu.ifpr.projeto.helpDesk.dao.ChamadoDAO;
import br.edu.ifpr.projeto.helpDesk.dao.ProblemaDAO;
import br.edu.ifpr.projeto.helpDesk.dao.SolucaoDAO;
import br.edu.ifpr.projeto.helpDesk.modelo.Chamado;
import br.edu.ifpr.projeto.helpDesk.modelo.Problema;
import br.edu.ifpr.projeto.helpDesk.modelo.Solucao;
import br.edu.ifpr.projeto.helpDesk.modelo.Usuario;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.plaf.metal.MetalBorders;

/**
 *
 * @author eduar
 */
public class SolucaoTecnico extends javax.swing.JDialog {

 
    private List<Chamado> urgencias = new ArrayList<Chamado>();
    private List<Problema> problemas = new ArrayList<Problema>();
    private List<Solucao> solucao = new ArrayList<Solucao>();
    private boolean salvar = false;
    private int id = 0;

    private Solucao solucao1;
   

    public SolucaoTecnico(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

   public SolucaoTecnico(Chamado chamado) {
       
       //CONSTRUTOR QUE RECEBE OS DADOS DO CHAMADO
       
        initComponents();
        preencheCombo();
        preencherCampos(chamado);
        id =  chamado.getIdChamado();
        txDescricao.setEnabled(false);
        txTitulo.setEnabled(false);
        cbProblema.setEnabled(false);
        cbUrgencia.setEnabled(false);
        cbTipo.setEnabled(false);
         this.setIconImage(new ImageIcon(getClass().getResource("iconeif.png")).getImage());
        
    }
   

       public void preencheCombo(){
    
        ProblemaDAO problema = new ProblemaDAO();

        try{
            
            problemas = problema.pesquisar();           
            for(Problema prob : problemas){
                cbProblema.addItem(prob.toString());
            }

        }catch(SQLException ex){
            
            System.out.println("erro ao preencher o combo");
            ex.printStackTrace();
        }
    }
        
       private void preencherCampos(Chamado chamado){

        cbProblema.setSelectedItem(chamado.getProblema().getTipo());
        cbUrgencia.setSelectedItem(chamado.getUrgencia());
        cbTipo.setSelectedItem(chamado.getTipo());
        txTitulo.setText(chamado.getTitulo());
        txDescricao.setText(chamado.getDescricao());  
   }
     
        
      //RETORNA RESPONSAVEL POR TERMINAR DE INSERIRI OS DADOS NO CHAMADO QUANDO O MESMO É FINALIZADO
      private Chamado retornaObjetoChamado(){ 
        Chamado chamado = new Chamado();
        
        Calendar c = Calendar.getInstance();
        chamado.setDataFechado(c);
        chamado.setStatus("Fechado");
        chamado.setIdChamado(id);
        
        return chamado;
    }
    
       //RERORNA OBJETO QUE INSERE A SOLUÇÃO DE ACORDO COM O CHAMADO SELECIONADO NO METODO ALTERAR DO CHAMADADODAO 
       private Solucao retornaObjeto(){ 
            
        Solucao solucao = new Solucao(); 
        solucao.setDescricao(txSolucao.getText().toUpperCase());
       

        return solucao;
    }
       
   
     
       private boolean validaCampos(){
        
        boolean validador = true;

         txSolucao.setText(txSolucao.getText().trim());

        if(txSolucao.getText().equals("")){
            
            validador = false;
            
            txSolucao.setBorder(BorderFactory.createLineBorder(Color.red));
            lbResultado.setText("Preencha os campos obrigatorios");
        }else {
            
             txSolucao.setBorder(MetalBorders.getTextFieldBorder());
        }
        return validador;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txTitulo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txDescricao = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbProblema = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbUrgencia = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btFecharChamado = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        txSolucao = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        lbResultado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("HELPDESK");
        setBackground(new java.awt.Color(51, 153, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txDescricao.setColumns(20);
        txDescricao.setRows(5);
        jScrollPane1.setViewportView(txDescricao);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 0));
        jLabel1.setText("TITULO");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 153, 0));
        jLabel2.setText("DESCRICÃO");

        cbProblema.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<TIPO DO PROBLEMA>" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 153, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\NetBeansProjects\\HelpDesk\\icons\\book_edit.png")); // NOI18N
        jLabel3.setText("TIPO DO PROBLEMA");

        cbUrgencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<URGENCIA>", "BAIXA", "MEDIA", "ALTA", "MUITO ALTA" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 153, 0));
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\NetBeansProjects\\HelpDesk\\icons\\hourglass_add.png")); // NOI18N
        jLabel4.setText("URGENCIA");

        btFecharChamado.setBackground(new java.awt.Color(51, 204, 0));
        btFecharChamado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifpr/projeto/helpDesk/visao/icon/icones/arrow_down.png"))); // NOI18N
        btFecharChamado.setText("FECHAR CHAMADO");
        btFecharChamado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btFecharChamadoMouseReleased(evt);
            }
        });

        btSair.setBackground(new java.awt.Color(255, 0, 0));
        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifpr/projeto/helpDesk/visao/icon/icones/delete.png"))); // NOI18N
        btSair.setText("CANCELAR");
        btSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btSairMouseReleased(evt);
            }
        });

        txSolucao.setColumns(20);
        txSolucao.setRows(5);
        jScrollPane2.setViewportView(txSolucao);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 153, 0));
        jLabel5.setText("SOLUÇÃO");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 0));
        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\NetBeansProjects\\HelpDesk\\icons\\wand.png")); // NOI18N
        jLabel7.setText("DESCRIÇÕES DO CHAMADO");

        jLabel6.setBackground(new java.awt.Color(0, 153, 0));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 153, 0));
        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\NetBeansProjects\\HelpDesk\\icons\\wand.png")); // NOI18N
        jLabel6.setText("DESCREVA A SOLUÇÃO DO CHAMADO");

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\NetBeansProjects\\HelpDesk\\imagens\\IFPR Menor.png")); // NOI18N

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<TIPO DO CHAMADO>", "REQUISIÇÃO", "INCIDENTE" }));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 153, 0));
        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\NetBeansProjects\\HelpDesk\\icons\\book_add.png")); // NOI18N
        jLabel9.setText("TIPO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                                .addComponent(txTitulo)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel9))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbUrgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbProblema, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel7))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(226, 226, 226)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbResultado)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btFecharChamado)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btSair)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2)))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(168, 168, 168))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel7)
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbProblema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbUrgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel2)))
                        .addGap(26, 26, 26)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(106, 106, 106)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btFecharChamado)
                    .addComponent(btSair))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbResultado)
                .addContainerGap(43, Short.MAX_VALUE))
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

    private void btFecharChamadoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btFecharChamadoMouseReleased
    
        if(validaCampos()){
            try{

                ChamadoDAO.alterar(retornaObjeto(), retornaObjetoChamado());
                txSolucao.setText("");
                lbResultado.setText("Inserido no banco");
                  
            }catch(SQLException e){
                
                System.out.println("Eroo ao persisitir dados no banco!");
                e.printStackTrace();
                
            }
                    
        }
            
            
    }//GEN-LAST:event_btFecharChamadoMouseReleased

    private void btSairMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSairMouseReleased
      
        this.dispose();
        
    }//GEN-LAST:event_btSairMouseReleased

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
            java.util.logging.Logger.getLogger(SolucaoTecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SolucaoTecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SolucaoTecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SolucaoTecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SolucaoTecnico dialog = new SolucaoTecnico(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFecharChamado;
    private javax.swing.JButton btSair;
    private javax.swing.JComboBox<String> cbProblema;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JComboBox<String> cbUrgencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbResultado;
    private javax.swing.JTextArea txDescricao;
    private javax.swing.JTextArea txSolucao;
    private javax.swing.JTextField txTitulo;
    // End of variables declaration//GEN-END:variables
}
