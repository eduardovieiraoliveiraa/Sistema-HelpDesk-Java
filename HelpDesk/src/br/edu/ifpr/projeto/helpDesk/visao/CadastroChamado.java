/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.projeto.helpDesk.visao;

import br.edu.ifpr.projeto.helpDesk.dao.ChamadoDAO;
import br.edu.ifpr.projeto.helpDesk.dao.ProblemaDAO;
import br.edu.ifpr.projeto.helpDesk.modelo.Chamado;
import br.edu.ifpr.projeto.helpDesk.modelo.Problema;
import br.edu.ifpr.projeto.helpDesk.modelo.Solucao;
import br.edu.ifpr.projeto.helpDesk.modelo.Usuario;
import java.awt.Color;
import java.sql.Date;
import java.util.Calendar;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.plaf.metal.MetalBorders;

public class CadastroChamado extends javax.swing.JFrame {
    
    private List<Chamado> urgencias = new ArrayList<Chamado>();
    private List<Problema> problemas = new ArrayList<Problema>();
    private List<Solucao> solucao = new ArrayList<Solucao>();
    private int id = 0;
    private String nome;
    private String nomeSetor;
    private Usuario usuario2;
    
    

    public CadastroChamado() {
        initComponents();
    }

    public CadastroChamado(Usuario usuario) {
           
        //CONSTRUTOR QUE RECEBE COMO PARAMETRO O OBJETO USUARIO. QUE RECEBE NO LOGIN TODOS OS DADOS DO MESMO. 
          initComponents();
 
          nome = usuario.getNome_Usuario();
          nomeSetor = usuario.getSetor().getNome_Setor();
          lbResultado.setText(nome);
          lbSetor.setText(nomeSetor);
          usuario2 = usuario;
          preencheCombo();
          this.setIconImage(new ImageIcon(getClass().getResource("iconeif.png")).getImage());
    }


    
     public void preencheCombo(){
    
        ProblemaDAO problema = new ProblemaDAO();
        
       
        try{
            
            //BUSCA AS CIDADES CADASTRADAS NO BANCO
            problemas = problema.pesquisar();
            
            //PERCORRE TODA A LISTA E ADD TODAS AS CIDADES NA COMBO BOX
            for(Problema prob : problemas){
                cbProblema.addItem(prob.toString());
            }

        }catch(SQLException ex){
            
            System.out.println("erro ao preencher o combo");
            ex.printStackTrace();
        }
    }
        
     private void preencherCampos(Chamado chamado){
       
        cbProblema.setSelectedItem(chamado.toString());
        cbUrgencia.setSelectedItem(chamado.toString());
        cbTipo.setSelectedItem(chamado.toString());
        txTitulo.setText(chamado.getTitulo());
        txDescricao.setText(chamado.getDescricao());
           
   }
     
     private Chamado retornaObjeto(){
        
        Chamado chamado = new Chamado();
         
        
         Calendar c = Calendar.getInstance();

        //toUpperCase ele vai pega tudo que o usuario escrever e vai manda pro banco em maiusculo
        chamado.setTitulo(txTitulo.getText().toUpperCase());
        Problema problemaSelecionado = problemas.get(cbProblema.getSelectedIndex() -1);
        chamado.setProblema(problemaSelecionado);
        chamado.setUrgencia(cbUrgencia.getSelectedItem().toString());
        chamado.setDescricao(txDescricao.getText().toUpperCase());
        chamado.setDataAbertura(c);
        chamado.setUsuario(usuario2);
        chamado.setStatus("Aberto");
        chamado.setTipo(cbTipo.getSelectedItem().toString());
        chamado.setIdChamado(id);
        
        return chamado;
    }
     
     private boolean validaCampos(){
        
        boolean validador = true;
        
        //trim é para ignorar os espaços caso o usuario digite um espaco ele ira ignorar
         txTitulo.setText(txTitulo.getText().trim());
         txDescricao.setText(txDescricao.getText().trim());
         
       
        if(txTitulo.getText().equals("")){
            
            //ele ira validar se o tx esta preenchido
            validador = false;
            
            //deixa a borda vermelha se nap preenchido nada
            txTitulo.setBorder(BorderFactory.createLineBorder(Color.red));
            lbResultado.setText("Preencher campos obrigatorios");
        }else {
            
             txTitulo.setBorder(MetalBorders.getTextFieldBorder());
        }
        
        if(cbProblema.getSelectedIndex() == 0){
            validador = false;
             cbProblema.setBorder(BorderFactory.createLineBorder(Color.red));
             lbResultado.setText("Preencher campos obrigatorios");
        }else{
            cbProblema.setBorder(MetalBorders.getTextFieldBorder());
        }
         if(txDescricao.getText().equals("")){
            
            //ele ira validar se o tx esta preenchido
            validador = false;
            
            //deixa a borda vermelha se nap preenchido nada
            txDescricao.setBorder(BorderFactory.createLineBorder(Color.red));
            lbResultado.setText("Preencher campos obrigatorios");
        }else {
            
             txDescricao.setBorder(MetalBorders.getTextFieldBorder());
        }
         if(cbUrgencia.getSelectedIndex() == 0){
            validador = false;
             cbUrgencia.setBorder(BorderFactory.createLineBorder(Color.red));
             lbResultado.setText("Preencher campos obrigatorios");
        }else{
            cbUrgencia.setBorder(MetalBorders.getTextFieldBorder());
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
        btRegistrar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbSetor = new javax.swing.JLabel();
        lbResultado = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        lbRegistro = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MenuSolucao = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txDescricao.setColumns(20);
        txDescricao.setRows(5);
        jScrollPane1.setViewportView(txDescricao);

        jLabel1.setForeground(new java.awt.Color(51, 153, 0));
        jLabel1.setText("TITULO");

        jLabel2.setForeground(new java.awt.Color(51, 153, 0));
        jLabel2.setText("DESCRICÃO");

        cbProblema.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<TIPO DO PROBLEMA>" }));

        jLabel3.setForeground(new java.awt.Color(51, 153, 0));
        jLabel3.setText("TIPO DO PROBLEMA");

        cbUrgencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<URGENCIA>", "BAIXA", "MEDIA", "ALTA", "MUITO ALTA" }));

        jLabel4.setForeground(new java.awt.Color(51, 153, 0));
        jLabel4.setText("URGENCIA");

        btRegistrar.setForeground(new java.awt.Color(0, 153, 0));
        btRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifpr/projeto/helpDesk/visao/icon/icones/DisqueteSalvar.png"))); // NOI18N
        btRegistrar.setText("REGISTRAR");
        btRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btRegistrarMouseReleased(evt);
            }
        });

        btCancelar.setForeground(new java.awt.Color(204, 0, 0));
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifpr/projeto/helpDesk/visao/icon/icones/delete.png"))); // NOI18N
        btCancelar.setText("CANCELAR");
        btCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btCancelarMouseReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 204));
        jLabel5.setText("USUARIO");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 204, 204));
        jLabel7.setText("SETOR");

        lbSetor.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lbSetor.setForeground(new java.awt.Color(51, 153, 0));

        lbResultado.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lbResultado.setForeground(new java.awt.Color(51, 153, 0));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 153, 0));
        jLabel6.setText("REGISTRE SEU CHAMADO ");

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\NetBeansProjects\\HelpDesk\\imagens\\IFPR Menor.png")); // NOI18N

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<TIPO DO CHAMADO>", "REQUISIÇÃO", "INCIDENTE" }));

        jLabel8.setForeground(new java.awt.Color(51, 153, 0));
        jLabel8.setText("Tipo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1)
                                        .addComponent(txTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbProblema, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(cbTipo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cbUrgencia, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel7))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbSetor)
                                            .addComponent(lbResultado)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(212, 212, 212)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbRegistro)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btRegistrar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btCancelar)))))
                        .addContainerGap(96, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(56, 56, 56))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lbResultado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lbSetor)))
                    .addComponent(jLabel9))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbProblema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbUrgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRegistrar)
                    .addComponent(btCancelar))
                .addGap(18, 18, 18)
                .addComponent(lbRegistro)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jMenu1.setBackground(new java.awt.Color(0, 153, 0));
        jMenu1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jMenu1.setForeground(new java.awt.Color(51, 153, 0));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifpr/projeto/helpDesk/visao/icon/icones/BotaoEditar.png"))); // NOI18N
        jMenu1.setText("OPÇÕES");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        MenuSolucao.setBackground(new java.awt.Color(51, 153, 0));
        MenuSolucao.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        MenuSolucao.setForeground(new java.awt.Color(51, 153, 0));
        MenuSolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifpr/projeto/helpDesk/visao/icon/icones/pesquisar.png"))); // NOI18N
        MenuSolucao.setText("Soluções");
        MenuSolucao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MenuSolucaoMouseReleased(evt);
            }
        });
        jMenu1.add(MenuSolucao);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

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

    private void btRegistrarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btRegistrarMouseReleased
       
        
           if(validaCampos()){
            try{
               
                    ChamadoDAO.inserir(retornaObjeto());
                    txTitulo.setText("");
                    cbProblema.setSelectedIndex(0);
                    txDescricao.setText("");
                    cbUrgencia.setSelectedIndex(0);
                    lbRegistro.setText("Registro salvo.");
                       
            }catch(Exception e){
                if(e instanceof com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException ){
                       lbRegistro.setText("ESSE USUARIO OU SENHA JA EXIXSTEM");
                }else{
                 System.out.println("Eroo ao persisitir dados no banco!");
                e.printStackTrace();
                }
     
           }
                    
        }
        
    }//GEN-LAST:event_btRegistrarMouseReleased

    private void MenuSolucaoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSolucaoMouseReleased
        
           
           SolucaoUser sol = new SolucaoUser(usuario2);
           sol.setVisible(true);
           
        
    }//GEN-LAST:event_MenuSolucaoMouseReleased

    private void btCancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCancelarMouseReleased
                 System.exit(0);
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
            java.util.logging.Logger.getLogger(CadastroChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroChamado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuSolucao;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btRegistrar;
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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbRegistro;
    private javax.swing.JLabel lbResultado;
    private javax.swing.JLabel lbSetor;
    private javax.swing.JTextArea txDescricao;
    private javax.swing.JTextField txTitulo;
    // End of variables declaration//GEN-END:variables
}
