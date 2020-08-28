
package br.edu.ifpr.projeto.helpDesk.visao;

import br.edu.ifpr.projeto.helpDesk.dao.SetorDAO;
import br.edu.ifpr.projeto.helpDesk.dao.UsuarioDAO;
import br.edu.ifpr.projeto.helpDesk.modelo.Setor;
import br.edu.ifpr.projeto.helpDesk.modelo.Usuario;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.plaf.metal.MetalBorders;


public class CadastroUsuario extends javax.swing.JDialog {
        
    private List<Setor> setores = new ArrayList<Setor>();
    private List<Usuario> login = new ArrayList<Usuario>();
    private boolean salvar = false;
    private int id = 0;

    public CadastroUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        salvar = true;
        preencheCombo();
    }
    

    
        public CadastroUsuario(Usuario usuario){
        
        initComponents();
        salvar = false;
        id = usuario.getIdUsuario();
        preencheCombo();
        preencherCampos(usuario);
         this.setIconImage(new ImageIcon(getClass().getResource("iconeif.png")).getImage());
        
    }
        
              public void preencheCombo(){
    
            SetorDAO setor = new SetorDAO();
       
             try{   
                setores = setor.pesquisar();
                for(Setor set : setores){
                    cbSetor.addItem(set.toString());
            }

         }catch(SQLException ex){
            
            System.out.println("erro ao preencher o combo");
            ex.printStackTrace();
        }
    }
        
              private void preencherCampos(Usuario usuario){
       
       txNome.setText(usuario.getNome_Usuario());
        cbSetor.setSelectedItem(usuario.toString());
        txemail.setText(usuario.getEmail());
        cbGrupo.setSelectedItem(usuario.toString());
        txUserLogin.setText(usuario.getUsuarioLogin());
        txSenha.setText(usuario.getSenha());
        
   }
    
              private Usuario retornaObjeto(){
        
        Usuario usuario= new Usuario();
        //toUpperCase ele vai pega tudo que o usuario escrever e vai manda pro banco em maiusculo
        usuario.setNome_Usuario(txNome.getText().toUpperCase());
        Setor setorSelecionado = setores.get(cbSetor.getSelectedIndex() -1);
        usuario.setSetor(setorSelecionado);
        usuario.setEmail(txemail.getText().toUpperCase());
        usuario.setGrupo(String.valueOf(cbGrupo.getSelectedItem()));
        usuario.setUsuarioLogin(txUserLogin.getText().toUpperCase());
        usuario.setSenha(String.valueOf(txSenha.getPassword()));
        usuario.setIdUsuario(id);
        return usuario;
    }
     
              private boolean validaCampos(){
        
        boolean validador = true;
        
        //trim é para ignorar os espaços caso o usuario digite um espaco ele ira ignorar
        txNome.setText(txNome.getText().trim());
         txemail.setText(txemail.getText().trim());
         txUserLogin.setText(txUserLogin.getText().trim());
       
        if(txNome.getText().equals("")){
            
            //ele ira validar se o tx esta preenchido
            validador = false;
            
            //deixa a borda vermelha se nap preenchido nada
            txNome.setBorder(BorderFactory.createLineBorder(Color.red));
            lbResultado.setText("Preencher campos obrigatorios");
        }else {
            
             txNome.setBorder(MetalBorders.getTextFieldBorder());
        }
        
        if(cbSetor.getSelectedIndex() == 0){
            validador = false;
             cbSetor.setBorder(BorderFactory.createLineBorder(Color.red));
             lbResultado.setText("Preencher campos obrigatorios");
        }else{
            cbSetor.setBorder(MetalBorders.getTextFieldBorder());
        }
         if(txemail.getText().equals("")){
            
            //ele ira validar se o tx esta preenchido
            validador = false;
            
            //deixa a borda vermelha se nap preenchido nada
            txemail.setBorder(BorderFactory.createLineBorder(Color.red));
            lbResultado.setText("Preencher campos obrigatorios");
        }else {
            
             txemail.setBorder(MetalBorders.getTextFieldBorder());
        }
         if(cbGrupo.getSelectedIndex() == 0){
            validador = false;
             cbGrupo.setBorder(BorderFactory.createLineBorder(Color.red));
             lbResultado.setText("Preencher campos obrigatorios");
        }else{
            cbGrupo.setBorder(MetalBorders.getTextFieldBorder());
        }
          if(txUserLogin.getText().equals("")){
            
            //ele ira validar se o tx esta preenchido
            validador = false;
            
            //deixa a borda vermelha se nap preenchido nada
            txUserLogin.setBorder(BorderFactory.createLineBorder(Color.red));
            lbResultado.setText("Preencher campos obrigatorios");
        }else {
            
             txUserLogin.setBorder(MetalBorders.getTextFieldBorder());
        }
           if(txSenha.getPassword().equals("")){
            
            //ele ira validar se o tx esta preenchido
            validador = false;
            
            //deixa a borda vermelha se nap preenchido nada
            txSenha.setBorder(BorderFactory.createLineBorder(Color.red));
            lbResultado.setText("Preencher campos obrigatorios");
        }else {
            
             txSenha.setBorder(MetalBorders.getTextFieldBorder());
        }
         
        
        
        return validador;
    }
    
     
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txNome = new javax.swing.JTextField();
        cbSetor = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txemail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txUserLogin = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txSenha = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        cbGrupo = new javax.swing.JComboBox<>();
        lbResultado = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CADASTRO DE USUARIOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 153, 0))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setForeground(new java.awt.Color(51, 153, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\NetBeansProjects\\HelpDesk\\icons\\user_suit.png")); // NOI18N
        jLabel1.setText("NOME");

        cbSetor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Escolha o Setor que você Trabalha>" }));

        jLabel2.setForeground(new java.awt.Color(51, 153, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\NetBeansProjects\\HelpDesk\\icons\\book_edit.png")); // NOI18N
        jLabel2.setText("SETOR");

        jLabel3.setForeground(new java.awt.Color(51, 153, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\NetBeansProjects\\HelpDesk\\icons\\email.png")); // NOI18N
        jLabel3.setText("EMAIL");

        jLabel4.setForeground(new java.awt.Color(51, 153, 0));
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\NetBeansProjects\\HelpDesk\\icons\\group_edit.png")); // NOI18N
        jLabel4.setText("GRUPO");

        jLabel5.setForeground(new java.awt.Color(51, 153, 0));
        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\NetBeansProjects\\HelpDesk\\icons\\user_add.png")); // NOI18N
        jLabel5.setText("USUARIO");

        jLabel6.setForeground(new java.awt.Color(51, 153, 0));
        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\NetBeansProjects\\HelpDesk\\icons\\lock_add.png")); // NOI18N
        jLabel6.setText("SENHA");

        btSalvar.setBackground(new java.awt.Color(51, 204, 0));
        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifpr/projeto/helpDesk/visao/icon/icones/DisqueteSalvar.png"))); // NOI18N
        btSalvar.setText("SALVAR");
        btSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btSalvarMouseReleased(evt);
            }
        });

        btCancelar.setBackground(new java.awt.Color(255, 51, 51));
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifpr/projeto/helpDesk/visao/icon/icones/delete.png"))); // NOI18N
        btCancelar.setText("CANCELAR");
        btCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btCancelarMouseReleased(evt);
            }
        });

        cbGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Selecione o Grupo>", "ADMIN", "USUARIO" }));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\NetBeansProjects\\HelpDesk\\imagens\\IFPR2.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txNome)
                    .addComponent(txemail, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8))
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btCancelar))
                            .addComponent(txSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                            .addComponent(txUserLogin)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(lbResultado)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel8))
                .addGap(38, 38, 38)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txUserLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar)
                    .addComponent(btCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(lbResultado)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSalvarMouseReleased
           
        
            String pega = txUserLogin.getText();
            login = UsuarioDAO.comparaLogin(pega);
            if(login.isEmpty()){
            if(validaCampos()){
            try{
                if(salvar){
                    
                    UsuarioDAO.inserir(retornaObjeto());
                    txNome.setText("");
                    cbSetor.setSelectedIndex(0);
                    txemail.setText("");
                    cbGrupo.setSelectedIndex(0);
                    txUserLogin.setText("");
                    txSenha.setText("");
                    lbResultado.setText("Registro salvo.");
               }else{
                    UsuarioDAO.alterar(retornaObjeto());
                    txNome.setText("");
                    cbSetor.setSelectedIndex(0);
                    txemail.setText("");
                    cbGrupo.setSelectedIndex(0);
                    txUserLogin.setText("");
                    txSenha.setText("");
                   
                    new PesquisaUsuario();
                    lbResultado.setText("Registro alterado.");
                    this.dispose();  
                }
            }catch(SQLException e){
                System.out.println("Eroo ao persisitir dados no banco!");
                e.printStackTrace();
           } }
           }else{
           lbResultado.setText("Usuario ja existe. Por favor crie outro");
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
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroUsuario dialog = new CadastroUsuario(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cbGrupo;
    private javax.swing.JComboBox<String> cbSetor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbResultado;
    private javax.swing.JTextField txNome;
    private javax.swing.JPasswordField txSenha;
    private javax.swing.JTextField txUserLogin;
    private javax.swing.JTextField txemail;
    // End of variables declaration//GEN-END:variables
}
