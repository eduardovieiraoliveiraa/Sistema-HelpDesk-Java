/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.projeto.helpDesk.visao;

import br.edu.ifpr.projeto.helpDesk.dao.ChamadoDAO;
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


public class TelaTecnico extends javax.swing.JFrame {

        
    private int idTec = 0;
    private List<Chamado> chamados = new ArrayList<Chamado>();
    private List<Chamado> chamados2 = new ArrayList<Chamado>();
     private List<Chamado> chamados3 = new ArrayList<Chamado>();
    private String nome;
    private String usu;
    private int id;
    private String retornaRelatorio = "Fechado";
    private String tecnico;
 
       
    
    public TelaTecnico() {
        initComponents();

    }
    

   public TelaTecnico(Usuario usuario) throws SQLException {
        
       initComponents();
       setExtendedState(MAXIMIZED_BOTH);
       idTec = usuario.getIdUsuario();
       nome = usuario.getNome_Usuario();
       lbResultado.setText(nome);
       atualizaTabela();
       btExcluir.setEnabled(false);
       btAtender.setEnabled(false);
       this.setIconImage(new ImageIcon(getClass().getResource("iconeif.png")).getImage());
       usu = usuario.getNome_Usuario();
       tecnico = usuario.getNome_Usuario();
       rbTodos.setSelected(true);
       retornacont();

    }
    
       private Chamado retornaObjeto(){
        
        Chamado chamado = new Chamado();
        chamado.setTitulo(txNome.getText().toUpperCase());
        
 
        return chamado;
    }
       
 
      
      
     private int retornacont(){
          
         int i = ChamadoDAO.contadorteste("Aberto");
         lbAbertos.setText(String.valueOf(i));
         return i;
      }
       
        
      private void atualizaBotao(){
            
           btAtender.setEnabled(true);
           btExcluir.setEnabled(true);
           
         }
      

       private Chamado retornaObjetoTec(){
           
        Chamado cha = new Chamado();
        Chamado chamado = chamados.get(tbChamado.getSelectedRow());
        id =  chamado.getIdChamado();
        cha.setTecnico(nome);
        cha.setIdChamado(id);
        
        return cha;
       }
       
      private Chamado retornaObjetoTecAberto(){
           
        Chamado cha = new Chamado();
        Chamado chamado = chamados2.get(tbChamado.getSelectedRow());
        id =  chamado.getIdChamado();
        cha.setTecnico(nome);
        cha.setIdChamado(id);
        
        return cha;
       }
       
       
       
       
        
          //METODO PARA PREENCHER TODOS OS CHAMADOS NA TABELA DO TECNICO
         private void atualizaTabela() {

          ChamadoDAO chamado = new ChamadoDAO();

           try {
             
               chamados = ChamadoDAO.pesquisar(retornaObjeto());
               DefaultTableModel modelo = (DefaultTableModel) tbChamado.getModel();   
               modelo.setNumRows(0);

               String substitui = "Nao Fechado";

             
               DateFormat formato = new SimpleDateFormat("dd/MM/yyyyy - HH:mm");
                      for(Chamado cha : chamados) {
                   
                       modelo.addRow(new Object[]{
                       cha.getIdChamado(),
                       cha.getUsuario().getNome_Usuario(),
                       cha.getTitulo(),
                       cha.getUrgencia(),
                       cha.getUsuario().getSetor().getNome_Setor(),
                       cha.getTipo(),
                       cha.getProblema().getTipo(),
                       formato.format(cha.getDataAbertura().getTime()),
                       cha.getStatus(),
                       formato.format(cha.getDataFechado().getTime()),
                       cha.getTecnico()
  

                   });
               }
           
           }catch (SQLException e) {
               System.out.println("Erro ao carregar tabela.");
               e.printStackTrace();
               
           
           }
           }
      
          //METODO PARA PESQUISAER/FILTRAR OS CHAMADOS ABERTOS
          private void atualizaTabelaAberto(){

          ChamadoDAO chamado = new ChamadoDAO();
          
          
          
           try {
              
               chamados2 = ChamadoDAO.pesquisarAbertoTecnico("Aberto");
               DefaultTableModel modelo = (DefaultTableModel) tbChamado.getModel();        
               modelo.setNumRows(0);
               
               Chamado c = chamados2.get(0);
               String substitui = "Nao Fechado";
               
               if(c.getStatus().equals("Aberto")){
               
               DateFormat formato = new SimpleDateFormat("dd/MM/yyyyy - HH:mm");

               for(Chamado cha1 : chamados2) {
                   
                   modelo.addRow(new Object[]{
                       cha1.getIdChamado(),
                       cha1.getUsuario().getNome_Usuario(),
                       cha1.getTitulo(),
                       cha1.getUrgencia(),
                       cha1.getUsuario().getSetor().getNome_Setor(),
                       cha1.getTipo(),
                       cha1.getProblema().getTipo(),
                       formato.format(cha1.getDataAbertura().getTime()),
                       cha1.getStatus(),
                       substitui,
                       cha1.getTecnico()
                       

                   });
               }
               }else{
                    DateFormat formato = new SimpleDateFormat("dd/MM/yyyyy - HH:mm");
                    for(Chamado cha1 : chamados2) {
                   
                      modelo.addRow(new Object[]{
                       cha1.getIdChamado(),
                       cha1.getUsuario().getNome_Usuario(),
                       cha1.getTitulo(),
                       cha1.getUrgencia(),
                       cha1.getUsuario().getSetor().getNome_Setor(),
                       cha1.getTipo(),
                       cha1.getProblema().getTipo(),
                       formato.format(cha1.getDataAbertura().getTime()),
                       cha1.getStatus(),
                       formato.format(cha1.getDataFechado().getTime()),
                       cha1.getTecnico()
                       

                   });
               }
               }
               
           } catch (SQLException e) {
               System.out.println("Erro ao carregar tabela.");
               e.printStackTrace();
               
           
           }
           }
         
         
         //METODO PARA PESQUISAER/FILTRAR OS CHAMADOS FECHADOS
          private void atualizaTabelaFechado(){

          ChamadoDAO chamado = new ChamadoDAO();

           try {
               // a lista recebe o resultado do método pesquisar que está no DAO
               chamados3 = ChamadoDAO.pesquisarAbertoTecnico("Fechado");
               DefaultTableModel modelo = (DefaultTableModel) tbChamado.getModel();
               //Alterar o número de linhas para 0 no modelo
               modelo.setNumRows(0);
               DateFormat formato = new SimpleDateFormat("dd/MM/yyyyy - HH:mm");

               for(Chamado cha1 : chamados3) {
                   
                   modelo.addRow(new Object[]{
                       cha1.getIdChamado(),
                       cha1.getUsuario().getNome_Usuario(),
                       cha1.getTitulo(),
                       cha1.getUrgencia(),
                       cha1.getUsuario().getSetor().getNome_Setor(),
                       cha1.getTipo(),  
                       cha1.getProblema().getTipo(),
                       formato.format(cha1.getDataAbertura().getTime()),
                       cha1.getStatus(),
                       formato.format(cha1.getDataFechado().getTime()),
                       cha1.getTecnico()
                       
                       

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

        jMenuItem1 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbChamado = new javax.swing.JTable();
        btAtender = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        lbResultado = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btPesquisar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        btAtribuir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rbAberto = new javax.swing.JRadioButton();
        btFiltrar = new javax.swing.JButton();
        rbFechado = new javax.swing.JRadioButton();
        rbTodos = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        rbIncidente = new javax.swing.JRadioButton();
        rbAtendimento = new javax.swing.JRadioButton();
        btRelatorio = new javax.swing.JButton();
        rbRequisicao = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        lbAbertos = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuCadastroUsuario = new javax.swing.JMenu();
        menuCadastroUsuarioCerto = new javax.swing.JMenuItem();
        MenuAlterarUsuario = new javax.swing.JMenuItem();
        MenuItens = new javax.swing.JMenu();
        MenuSetor = new javax.swing.JMenuItem();
        MenuProblema = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenuItem5.setText("jMenuItem5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tbChamado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbChamado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NUMERO CHAMADO", "USUARIO", "TITULO", "URGENCIA", "SETOR", "TIPO", "TIPO EQUIPAMENTO", "DATA DE ABERTURA", "STATUS", "DATA DE ENCERRAMENTO", "TECNICO ATRIBUIDO"
            }
        ));
        tbChamado.setAutoscrolls(false);
        tbChamado.setGridColor(new java.awt.Color(0, 153, 0));
        tbChamado.setSelectionBackground(new java.awt.Color(0, 102, 51));
        tbChamado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbChamadoMouseClicked(evt);
            }
        });
        tbChamado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbChamadoKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tbChamado);

        btAtender.setBackground(new java.awt.Color(102, 255, 51));
        btAtender.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btAtender.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\NetBeansProjects\\HelpDesk\\icons\\accept.png")); // NOI18N
        btAtender.setText("ATENDER");
        btAtender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btAtenderMouseReleased(evt);
            }
        });

        btExcluir.setBackground(new java.awt.Color(255, 51, 51));
        btExcluir.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifpr/projeto/helpDesk/visao/icon/icones/excluir.png"))); // NOI18N
        btExcluir.setText("EXCLUIR");
        btExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btExcluirMouseReleased(evt);
            }
        });

        lbResultado.setBackground(new java.awt.Color(0, 153, 0));
        lbResultado.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lbResultado.setForeground(new java.awt.Color(0, 153, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\NetBeansProjects\\HelpDesk\\imagens\\IFPR2.png")); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\NetBeansProjects\\HelpDesk\\icons\\user.png")); // NOI18N
        jLabel2.setText("Usuario");
        jLabel2.setBorder(new javax.swing.border.MatteBorder(null));

        txNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txNomeMouseClicked(evt);
            }
        });
        txNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txNomeKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 153, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifpr/projeto/helpDesk/visao/icon/icones/LupaPesquisar.png"))); // NOI18N
        jLabel3.setText("PESQUISAR");

        btPesquisar.setBackground(new java.awt.Color(255, 255, 102));
        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifpr/projeto/helpDesk/visao/icon/icones/LupaPesquisar.png"))); // NOI18N
        btPesquisar.setText("PESQUISAR");
        btPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btPesquisarMouseReleased(evt);
            }
        });

        btSair.setForeground(new java.awt.Color(204, 0, 0));
        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifpr/projeto/helpDesk/visao/icon/icones/delete.png"))); // NOI18N
        btSair.setText("SAIR");
        btSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btSairMouseReleased(evt);
            }
        });

        btAtribuir.setBackground(new java.awt.Color(0, 255, 204));
        btAtribuir.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\NetBeansProjects\\HelpDesk\\icons\\user_add.png")); // NOI18N
        btAtribuir.setText("ATRIBUIR-SE AO CHAMDO");
        btAtribuir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btAtribuirMouseReleased(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifpr/projeto/helpDesk/visao/icon/icones/iconeif.png"))); // NOI18N

        jLabel5.setForeground(new java.awt.Color(0, 153, 0));
        jLabel5.setText("Projeto integrador - Eduardo Vieira Oliveira - Instituto Federal do Parana - IFPR - 4º Periodo");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FILTRAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13), new java.awt.Color(0, 153, 0))); // NOI18N

        rbAberto.setBackground(new java.awt.Color(204, 255, 204));
        buttonGroup1.add(rbAberto);
        rbAberto.setForeground(new java.awt.Color(51, 153, 0));
        rbAberto.setText("CHAMADOS ABERTOS");

        btFiltrar.setBackground(new java.awt.Color(51, 255, 204));
        btFiltrar.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\NetBeansProjects\\HelpDesk\\icons\\magnifier.png")); // NOI18N
        btFiltrar.setText("FILTRAR");
        btFiltrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btFiltrarMouseReleased(evt);
            }
        });

        rbFechado.setBackground(new java.awt.Color(204, 0, 0));
        buttonGroup1.add(rbFechado);
        rbFechado.setForeground(new java.awt.Color(204, 0, 0));
        rbFechado.setText("CHAMADOS FECHADOS");

        buttonGroup1.add(rbTodos);
        rbTodos.setForeground(new java.awt.Color(0, 102, 51));
        rbTodos.setText("TODOS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbTodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbAberto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbFechado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btFiltrar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbAberto)
                    .addComponent(btFiltrar)
                    .addComponent(rbFechado)
                    .addComponent(rbTodos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RELATÓRIOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 153, 0))); // NOI18N

        buttonGroup2.add(rbIncidente);
        rbIncidente.setText("Incidentes");

        buttonGroup2.add(rbAtendimento);
        rbAtendimento.setText("Meus Atendimentos");

        btRelatorio.setBackground(new java.awt.Color(204, 255, 204));
        btRelatorio.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\NetBeansProjects\\HelpDesk\\icons\\page_go.png")); // NOI18N
        btRelatorio.setText("GERAR RELATÓRIO");
        btRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btRelatorioMouseReleased(evt);
            }
        });

        buttonGroup2.add(rbRequisicao);
        rbRequisicao.setText("Requisição");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(rbIncidente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbRequisicao, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(rbAtendimento)))
                .addGap(47, 47, 47))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btRelatorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbIncidente)
                    .addComponent(rbAtendimento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbRequisicao)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lbAbertos.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 0));
        jLabel6.setText("CHAMADOS EM ABERTO:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbAbertos)
                .addGap(119, 119, 119))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAbertos)
                    .addComponent(jLabel6))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(lbResultado))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btPesquisar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(363, 363, 363))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(436, 436, 436))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(306, 306, 306)
                        .addComponent(btAtribuir, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btAtender, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(btSair))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1704, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbResultado)
                                    .addComponent(jLabel2)
                                    .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(btPesquisar))
                                .addGap(30, 30, 30)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(btSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btAtribuir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btAtender, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(173, 173, 173))
        );

        MenuCadastroUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        MenuCadastroUsuario.setForeground(new java.awt.Color(0, 153, 51));
        MenuCadastroUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifpr/projeto/helpDesk/visao/icon/icones/BotaoEditar.png"))); // NOI18N
        MenuCadastroUsuario.setText("OPÇÕES");
        MenuCadastroUsuario.setAutoscrolls(true);
        MenuCadastroUsuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        MenuCadastroUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MenuCadastroUsuarioMouseReleased(evt);
            }
        });

        menuCadastroUsuarioCerto.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        menuCadastroUsuarioCerto.setForeground(new java.awt.Color(51, 153, 0));
        menuCadastroUsuarioCerto.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\NetBeansProjects\\HelpDesk\\icons\\user_add.png")); // NOI18N
        menuCadastroUsuarioCerto.setText("CADASTRAR USUARIO");
        menuCadastroUsuarioCerto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                menuCadastroUsuarioCertoMouseReleased(evt);
            }
        });
        MenuCadastroUsuario.add(menuCadastroUsuarioCerto);

        MenuAlterarUsuario.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        MenuAlterarUsuario.setForeground(new java.awt.Color(0, 153, 0));
        MenuAlterarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifpr/projeto/helpDesk/visao/icon/icones/alterar.png"))); // NOI18N
        MenuAlterarUsuario.setText("ALTERAR USUARIO");
        MenuAlterarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MenuAlterarUsuarioMouseReleased(evt);
            }
        });
        MenuAlterarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAlterarUsuarioActionPerformed(evt);
            }
        });
        MenuCadastroUsuario.add(MenuAlterarUsuario);

        MenuItens.setForeground(new java.awt.Color(51, 153, 0));
        MenuItens.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifpr/projeto/helpDesk/visao/icon/icones/novo.png"))); // NOI18N
        MenuItens.setText("CADASTRAR ITENS");
        MenuItens.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        MenuSetor.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        MenuSetor.setForeground(new java.awt.Color(0, 153, 51));
        MenuSetor.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\NetBeansProjects\\HelpDesk\\icons\\layout_add.png")); // NOI18N
        MenuSetor.setText("CADASTRO DE SETOR");
        MenuSetor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MenuSetorMouseReleased(evt);
            }
        });
        MenuItens.add(MenuSetor);

        MenuProblema.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        MenuProblema.setForeground(new java.awt.Color(0, 153, 51));
        MenuProblema.setIcon(new javax.swing.ImageIcon("C:\\Users\\eduar\\Documents\\NetBeansProjects\\HelpDesk\\icons\\monitor_error.png")); // NOI18N
        MenuProblema.setText("CADASTRO DE PROBLEMA");
        MenuProblema.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MenuProblemaMouseReleased(evt);
            }
        });
        MenuItens.add(MenuProblema);

        MenuCadastroUsuario.add(MenuItens);

        jMenuBar1.add(MenuCadastroUsuario);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuCadastroUsuarioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuCadastroUsuarioMouseReleased
      
         new CadastroUsuario(this, true).setVisible(true);
        
    }//GEN-LAST:event_MenuCadastroUsuarioMouseReleased

    private void menuCadastroUsuarioCertoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadastroUsuarioCertoMouseReleased
        new CadastroUsuario(this, true).setVisible(true);
    }//GEN-LAST:event_menuCadastroUsuarioCertoMouseReleased

    private void MenuAlterarUsuarioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAlterarUsuarioMouseReleased
        
         PesquisaUsuario pesq = new PesquisaUsuario();
         pesq.setVisible(true);
        
    }//GEN-LAST:event_MenuAlterarUsuarioMouseReleased

    private void MenuSetorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSetorMouseReleased
       
      new CadastroSetor(this, true).setVisible(true);
        
        
    }//GEN-LAST:event_MenuSetorMouseReleased

    private void MenuAlterarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAlterarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuAlterarUsuarioActionPerformed

    private void MenuProblemaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuProblemaMouseReleased
      
        new CadastroProblema(this, true).setVisible(true);
        
    }//GEN-LAST:event_MenuProblemaMouseReleased

    private void tbChamadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbChamadoMouseClicked
        
        atualizaBotao();
        
    }//GEN-LAST:event_tbChamadoMouseClicked

    private void btAtenderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAtenderMouseReleased
       
       
        
         if(rbAberto.isSelected()){
            Chamado chamado = chamados2.get(tbChamado.getSelectedRow()); 
             try{
        
         if(chamado.getStatus().equals("Fechado")){
             //TRATANDO O ERRO, EVITANDO A POSSIBILIDADE DE ATENDER O MESMO CHAMADO VARIAS VEZES, N PODENDO SER REDUNDANTE
             JOptionPane.showMessageDialog(rootPane,"ESSE CHAMADO JA SE ENCONTRA FECHADO. NÃO É POSSIVEL ATENDELO NOVAMENTE", "OPERAÇÃO INVALIDA", HEIGHT);
                
         }else if(chamado.getStatus().equals("Aberto") && chamado.getTecnico().equals(usu)){
//           
              new SolucaoTecnico(chamado).setVisible(true);
              atualizaBotao();
              
         }else{
               JOptionPane.showMessageDialog(rootPane,"ESSE CHAMADO JA SE ENCONTRA EM ATENDIMENTO PELO TECNICO "+chamado.getTecnico()+". NÃO É POSSIVEL ATENDELO", "OPERAÇÃO INVALIDA", HEIGHT);
         }

         }catch(Exception ArrayIndexOutOfBoundsException){
             System.out.println("NAO HA CHAMADOS");
         }
         }else if(rbTodos.isSelected()){
         Chamado chamado = chamados.get(tbChamado.getSelectedRow());
         try{
        
         if(chamado.getStatus().equals("Fechado")){
             //TRATANDO O ERRO, EVITANDO A POSSIBILIDADE DE ATENDER O MESMO CHAMADO VARIAS VEZES, N PODENDO SER REDUNDANTE
             JOptionPane.showMessageDialog(rootPane,"ESSE CHAMADO JA SE ENCONTRA FECHADO. NÃO É POSSIVEL ATENDELO NOVAMENTE", "OPERAÇÃO INVALIDA", HEIGHT);
                
         }else if(chamado.getStatus().equals("Aberto") && chamado.getTecnico().equals(usu)){
//           
              new SolucaoTecnico(chamado).setVisible(true);
              atualizaBotao();
              
         }else{
               JOptionPane.showMessageDialog(rootPane,"ESSE CHAMADO JA SE ENCONTRA EM ATENDIMENTO PELO TECNICO "+chamado.getTecnico()+". NÃO É POSSIVEL ATENDELO", "OPERAÇÃO INVALIDA", HEIGHT);
         }

         }catch(Exception ArrayIndexOutOfBoundsException){
             System.out.println("NAO HA CHAMADOS");
         }
             
         }
         if(rbFechado.isSelected()){
          JOptionPane.showMessageDialog(rootPane,"ESSE CHAMADO JA SE ENCONTRA FECHADO. NÃO É POSSIVEL ATENDELO NOVAMENTE", "OPERAÇÃO INVALIDA", HEIGHT);
         }
       
         
        
    }//GEN-LAST:event_btAtenderMouseReleased

    private void tbChamadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbChamadoKeyTyped

                  atualizaBotao();
                   retornacont();    
    }//GEN-LAST:event_tbChamadoKeyTyped

    private void txNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txNomeMouseClicked
                 atualizaTabela();
    }//GEN-LAST:event_txNomeMouseClicked

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
            retornacont();
            
       if(rbAberto.isSelected()){
           
          atualizaTabelaAberto();
          
       }else if(rbFechado.isSelected()){
           
          atualizaTabelaFechado();
       }
       if(rbTodos.isSelected()){
           atualizaTabela();
       }
            
    }//GEN-LAST:event_formWindowGainedFocus

    private void btExcluirMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btExcluirMouseReleased

        
        if(rbAberto.isSelected()){
        Chamado chamadoSelecionada = chamados2.get(tbChamado.getSelectedRow());
        int opc = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o chamado numero: " + chamadoSelecionada.getIdChamado() );
        if (opc == JOptionPane.YES_OPTION) {
            try {
                ChamadoDAO.excluir(chamadoSelecionada);
                
            } catch (SQLException e) {
                System.out.println("Erro ao excluir registro.");
                e.printStackTrace();
            }
        }
        }else if(rbFechado.isSelected()){
            
        Chamado chamadoSelecionada = chamados3.get(tbChamado.getSelectedRow());
        int opc = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o chamado numero: " + chamadoSelecionada.getIdChamado() );
        if (opc == JOptionPane.YES_OPTION) {
            try {
                ChamadoDAO.excluir(chamadoSelecionada);
                
            } catch (SQLException e) {
                System.out.println("Erro ao excluir registro.");
                e.printStackTrace();
            }
        }  
        }
        
        if(rbTodos.isSelected()){
        Chamado chamadoSelecionada = chamados.get(tbChamado.getSelectedRow());
        int opc = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o chamado numero: " + chamadoSelecionada.getIdChamado() );
        if (opc == JOptionPane.YES_OPTION) {
            try {
                ChamadoDAO.excluir(chamadoSelecionada);
                
            } catch (SQLException e) {
                System.out.println("Erro ao excluir registro.");
                e.printStackTrace();
            }
        }
            
        }
        
        
      
           atualizaBotao();
        
        
        
    }//GEN-LAST:event_btExcluirMouseReleased

    private void btPesquisarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPesquisarMouseReleased
                 atualizaTabela();      
    }//GEN-LAST:event_btPesquisarMouseReleased

    private void txNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNomeKeyTyped
                 atualizaTabela();
    }//GEN-LAST:event_txNomeKeyTyped

    private void btFiltrarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btFiltrarMouseReleased
       
            if(rbAberto.isSelected()){
                
              atualizaTabelaAberto();
                
            }else if(rbFechado.isSelected()){
                
                   atualizaTabelaFechado();
                   
            }else if(rbTodos.isSelected()){
                  atualizaTabela();
            }
        
    }//GEN-LAST:event_btFiltrarMouseReleased

    private void btSairMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSairMouseReleased
           System.exit(0);
    }//GEN-LAST:event_btSairMouseReleased

    private void btAtribuirMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAtribuirMouseReleased



        if(rbAberto.isSelected()){
        Chamado chamadoSelecionada = chamados2.get(tbChamado.getSelectedRow());
        int opc = JOptionPane.showConfirmDialog(null, "Deseja realmente deseja atribuir se ao chamado: " + chamadoSelecionada.getIdChamado() );
        if (opc == JOptionPane.YES_OPTION) {
            try {
                ChamadoDAO.alterarTecnico(retornaObjetoTecAberto());
                
            } catch (SQLException e) {
                System.out.println("Erro ao excluir registro.");
                e.printStackTrace();
            }
        }
        }else if(rbFechado.isSelected()){
            
        Chamado chamado = chamados3.get(tbChamado.getSelectedRow());
       
        if (chamado.getStatus().equals("Fechado")) {
            JOptionPane.showMessageDialog(rootPane,"ESSE CHAMADO JA SE ENCONTRA FECHADO, IMPOSSIVEL ATRIBUILO NOVAMENTE ", "AVISO", HEIGHT);
        }  
        }
        
        if(rbTodos.isSelected()){
        Chamado chamadoSelecionada = chamados.get(tbChamado.getSelectedRow());
        
        if(chamadoSelecionada.getStatus().equals("Fechado")){
            
             JOptionPane.showMessageDialog(rootPane,"ESSE CHAMADO JA SE ENCONTRA FECHADO, IMPOSSIVEL ATRIBUILO NOVAMENTE ", "AVISO", HEIGHT);
            
        }else{
            
        int opc = JOptionPane.showConfirmDialog(null, "Deseja realmente atribuir-se ao chamado: " + chamadoSelecionada.getIdChamado() );
        if (opc == JOptionPane.YES_OPTION) {
            try {
                
              ChamadoDAO.alterarTecnico(retornaObjetoTec());
                
            } catch (SQLException e) {
                System.out.println("Erro ao excluir registro.");
                e.printStackTrace();
            }
        }
        }   
        }
        
        



//        try {   
//            
//         if(rbTodos.isSelected()){
//         Chamado chamado = chamados.get(tbChamado.getSelectedRow());
//         if(chamado.getStatus().equals( "Fechado")){
//           
//        JOptionPane.showMessageDialog(rootPane,"ESSE CHAMADO JA SE ENCONTRA FECHADO, IMPOSSIVEL ATRIBUILO NOVAMENTE ", "AVISO", HEIGHT);
//        
//        }else{
//            
//            ChamadoDAO.alterarTecnico(retornaObjetoTec());
//            JOptionPane.showMessageDialog(rootPane,"CHAMADO ATRIBUIDO COM SUCESSO ", "AVISO", HEIGHT);
//        }   
//        }else if(rbAberto.isSelected()){
//         Chamado chamado = chamados2.get(tbChamado.getSelectedRow());
//         ChamadoDAO.alterarTecnico(retornaObjetoTec());
//         
//         if(chamado.getStatus().equals( "Fechado")){
//           
//        JOptionPane.showMessageDialog(rootPane,"ESSE CHAMADO JA SE ENCONTRA FECHADO, IMPOSSIVEL ATRIBUILO NOVAMENTE ", "AVISO", HEIGHT);
//        
//        }}  
//        if(rbFechado.isSelected()){
//            JOptionPane.showMessageDialog(rootPane,"ESSE CHAMADO JA SE ENCONTRA FECHADO, IMPOSSIVEL ATRIBUILO NOVAMENTE ", "AVISO", HEIGHT);
//        }    
//        
//        } catch (SQLException ex) {
//            
//            System.out.println("erro ao alterar tabela"); 
//        }
//        
//        
    }//GEN-LAST:event_btAtribuirMouseReleased

    private void btRelatorioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btRelatorioMouseReleased
      
        String incidente = "Incidente";
        String requisicao = "Requisicao";
        
        if(rbIncidente.isSelected()){
            try {
                Relatorio.gerarRelatorio("relatorios\\RelatorioIncidente.jasper", ChamadoDAO.retornaRS01(incidente));
               
            } catch (SQLException ex) {
                System.out.println("nao gerou");
            }
        }else if(rbRequisicao.isSelected()){
            try {
                Relatorio.gerarRelatorio("relatorios\\RelatorioIncidente.jasper", ChamadoDAO.retornaRS01(requisicao));
               
            } catch (SQLException ex) {
                Logger.getLogger(TelaTecnico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(rbAtendimento.isSelected()){
            try {
                Relatorio.gerarRelatorio("relatorios\\RelatorioAte.jasper", ChamadoDAO.retornaRS02(tecnico));
                System.out.println(tecnico);
            } catch (SQLException ex) {
                Logger.getLogger(TelaTecnico.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
    }//GEN-LAST:event_btRelatorioMouseReleased


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
            java.util.logging.Logger.getLogger(TelaTecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaTecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaTecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaTecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaTecnico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuAlterarUsuario;
    private javax.swing.JMenu MenuCadastroUsuario;
    private javax.swing.JMenu MenuItens;
    private javax.swing.JMenuItem MenuProblema;
    private javax.swing.JMenuItem MenuSetor;
    private javax.swing.JButton btAtender;
    private javax.swing.JButton btAtribuir;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btFiltrar;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btRelatorio;
    private javax.swing.JButton btSair;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAbertos;
    private javax.swing.JLabel lbResultado;
    private javax.swing.JMenuItem menuCadastroUsuarioCerto;
    private javax.swing.JRadioButton rbAberto;
    private javax.swing.JRadioButton rbAtendimento;
    private javax.swing.JRadioButton rbFechado;
    private javax.swing.JRadioButton rbIncidente;
    private javax.swing.JRadioButton rbRequisicao;
    private javax.swing.JRadioButton rbTodos;
    private javax.swing.JTable tbChamado;
    private javax.swing.JTextField txNome;
    // End of variables declaration//GEN-END:variables
}

