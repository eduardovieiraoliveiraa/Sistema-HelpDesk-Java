/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.projeto.helpDesk.visao;

import br.edu.ifpr.projeto.helpDesk.dao.ProblemaDAO;
import br.edu.ifpr.projeto.helpDesk.modelo.Problema;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.plaf.metal.MetalBorders;

/**
 *
 * @author eduar
 */
public class CadastroProblema extends javax.swing.JDialog {

      private  boolean salvar = true;
      
       private int id = 0;
    
    
    public CadastroProblema(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
         salvar = true;
          this.setIconImage(new ImageIcon(getClass().getResource("iconeif.png")).getImage());
    }
    
    
       private void preencherCampos(Problema problema){
       
       txProblema.setText(problema.getTipo());

   }
    
      private Problema retornaObjeto(){
        
        Problema problema = new Problema();
        //toUpperCase ele vai pega tudo que o usuario escrever e vai manda pro banco em maiusculo
        problema.setTipo(txProblema.getText().toUpperCase());
        problema.setIdProblema(id);
        return problema;
 
    }
      
      private boolean validaCampos(){
        
        boolean validador = true;
        
        //trim é para ignorar os espaços caso o usuario digite um espaco ele ira ignorar
        txProblema.setText(txProblema.getText().trim());
        
        if(txProblema.getText().equals("")){
            
            //ele ira validar se o tx esta preenchido
            validador = false;
            
            //deixa a borda vermelha se nap preenchido nada
            txProblema.setBorder(BorderFactory.createLineBorder(Color.red));
            lbResultado.setText("Preencher campos obrigatorios");
        }else {
            
             txProblema.setBorder(MetalBorders.getTextFieldBorder());
        }
        
        
        return validador;
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txProblema = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        lbResultado = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CADASTRO DE PROBLEMA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 153, 0))); // NOI18N

        jLabel1.setBackground(new java.awt.Color(51, 153, 0));
        jLabel1.setForeground(new java.awt.Color(51, 153, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\NetBeansProjects\\HelpDesk\\icons\\monitor_error.png")); // NOI18N
        jLabel1.setText("PROBELMA");

        btSalvar.setBackground(new java.awt.Color(0, 204, 0));
        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifpr/projeto/helpDesk/visao/icon/icones/DisqueteSalvar.png"))); // NOI18N
        btSalvar.setText("SALVAR");
        btSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btSalvarMouseReleased(evt);
            }
        });

        btCancelar.setBackground(new java.awt.Color(255, 0, 51));
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifpr/projeto/helpDesk/visao/icon/icones/delete.png"))); // NOI18N
        btCancelar.setText("CANCELAR");
        btCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btCancelarMouseReleased(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\NetBeansProjects\\HelpDesk\\imagens\\IFPR Menor.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(lbResultado)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btSalvar)
                                .addGap(18, 18, 18)
                                .addComponent(btCancelar))
                            .addComponent(txProblema, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txProblema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btSalvar)
                            .addComponent(btCancelar))
                        .addGap(59, 59, 59)))
                .addComponent(lbResultado)
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSalvarMouseReleased

        if(validaCampos()){
            try{
                if(salvar){
                    ProblemaDAO.inserir(retornaObjeto());
                    txProblema.setText("");
                    lbResultado.setText("Registro salvo.");
                }else{

                    //nao tem altera o setor

                }
            }catch(SQLException e){

                System.out.println("Eroo ao persisitir dados no banco!");
                e.printStackTrace();

            }

        }

    }//GEN-LAST:event_btSalvarMouseReleased

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
            java.util.logging.Logger.getLogger(CadastroProblema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroProblema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroProblema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroProblema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroProblema dialog = new CadastroProblema(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbResultado;
    private javax.swing.JTextField txProblema;
    // End of variables declaration//GEN-END:variables
}
