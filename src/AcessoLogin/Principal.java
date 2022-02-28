package AcessoLogin;


import Interface.ILancamento;
import Interface.IUsuario;
import Utilitarios.Lancamento;
import Utilitarios.Tempo;
import Utilitarios.Usuario;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class Principal extends javax.swing.JFrame {
    //Usuario usu = new Usuario();
    ILancamento ilanc = new ILancamento();
    Lancamento lanc = new Lancamento();
    Tempo tem = new Tempo();
    //IUsuario iusu = new IUsuario(); 
     
    public Principal() {
        initComponents();

        listarLancamento();
        popularStatus();
        //popularMeses();
       // popularMesesFiltro();
        //listarUsuario();
        //mostrarItemUsuario();
    
        this.setLocationRelativeTo(null);
        lbData.setLayout(null);
        //Tempo timer= new Tempo (1000, hora());
        //timer.start();
        tem.le_data2();
        lbData.setText(tem.getDia_semana()+" - "+tem.getDia()+" de "+tem.getMes2()+" de "+tem.getAno()); 
    }
    
    //Mostra registro do banco de dados na tabela
    public void listarLancamento(){
        String sql = "SELECT * FROM lancamento";
        try{
            PreparedStatement stmt =  ilanc.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);  
        }
    }
    //mostra usurios cadastrados
    /*public void listarUsuario(){
        String sql = "SELECT * FROM acesso ";
        try{
            PreparedStatement stmt =  ilanc.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            tbUsuario.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);  
        }
    }*/
    
    public void pesquisarLancamento(){
        String sql="SELECT * FROM lancamento";
        try{
            PreparedStatement stmt =  ilanc.getConnection().prepareStatement(sql);
            stmt.setString(1, jcbMesFiltro.getSelectedItem().toString()+"%");
            ResultSet rs = stmt.executeQuery();
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);   
        }
    }
    
/*public void mostrarItemUsuario(){
    int i = tbUsuario.getSelectedRow();
 
    txtUsuario.setText(tbUsuario.getModel().getValueAt(i, 0).toString());
    txtSenha.setText(tbUsuario.getModel().getValueAt(i, 1).toString ());

    //JOptionPane.showMessageDialog(null,"Registro "+lbCodigo+" excluido com sucesso!");
}*/

    public void mostrarItem(){
        int i = jTable2.getSelectedRow();
     
        lbCodigo.setText(jTable2.getModel().getValueAt(i, 0).toString());
        txtDescricao.setText(jTable2.getModel().getValueAt(i, 1).toString ());
        jcbModoPagamento.setSelectedItem(jTable2.getModel().getValueAt(i, 2).toString ());
        txtObs.setText(jTable2.getModel().getValueAt(i, 3).toString ());
        txtValor.setText(jTable2.getModel().getValueAt(i, 4).toString ());
        jcbMes.setSelectedItem( jTable2.getModel().getValueAt(i, 5).toString ());
        txtDataVencimento.setText(jTable2.getModel().getValueAt(i, 6).toString ());
        jcbStatus.setSelectedItem( jTable2.getModel().getValueAt(i, 7).toString ());
       
    //JOptionPane.showMessageDialog(null,"Registro "+lbCodigo+" excluido com sucesso!");
    }
    //Mostra o Check Box com os Status da Tabela Status no banco de dados.
 public void popularStatus(){
     String sql = "SELECT * FROM status";
     try{
     PreparedStatement stmt = ilanc.getConnection().prepareStatement(sql);
     ResultSet rs = stmt.executeQuery();
     
     while(rs.next()){
         jcbStatus.addItem(rs.getString("descricao"));
     }
 }catch(SQLException e){
     JOptionPane.showMessageDialog(null, e);
 }
 }

/* public void popularMeses(){
     String sql = "SELECT * FROM meses";
     try{
     PreparedStatement stmt = ilanc.getConnection().prepareStatement(sql);
     ResultSet rs = stmt.executeQuery();
     
     while(rs.next()){
        
        jcbMes.addItem(rs.getString("descricao")); 
     }
 }catch(SQLException e){
     JOptionPane.showMessageDialog(null, e);
 }
 }
 
  public void popularMesesFiltro(){
     String sql = "SELECT * FROM meses";
     try{
     PreparedStatement stmt = ilanc.getConnection().prepareStatement(sql);
     ResultSet rs = stmt.executeQuery();
     
     while(rs.next()){
        jcbMesFiltro.addItem(rs.getString("descricao"));
         
     }
 }catch(SQLException e){
     JOptionPane.showMessageDialog(null, e);
 }
 }*/
 
 
 
 /*public void popularSoma() throws SQLException{
         String sql = "SELECT sum(valor) FROM lancamento";
        
         PreparedStatement stmt = ilanc.getConnection().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        ilanc.lblTotalDivida.addLabel(rs.getString("valor"));
 }*/
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jcbMes = new javax.swing.JComboBox();
        btnCadastrar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        txtDescricao = new javax.swing.JTextField();
        jcbModoPagamento = new javax.swing.JComboBox<>();
        lbMDPagamento = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbMDPagamento1 = new javax.swing.JLabel();
        txtObs = new javax.swing.JTextField();
        lbCodigo = new javax.swing.JLabel();
        txtDataVencimento = new javax.swing.JFormattedTextField();
        txtValor = new javax.swing.JTextField();
        jcbStatus = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        btnRelatorio = new javax.swing.JButton();
        jcbFiltroRelatorio = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JTextField();
        lblUsuario = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        btnAddUsuario = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuario = new javax.swing.JTable();
        btnExcluirUsuario = new javax.swing.JButton();
        btnAlterarUsuario = new javax.swing.JButton();
        lbId = new java.awt.Label();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        jcbMesFiltro = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        btnAlterar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        javax.swing.JLabel lblTotalDivida = new javax.swing.JLabel();
        lbTotalDivida = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lbData = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Obs:");

        jLabel5.setText("Mes:");

        jLabel4.setText("Valor:");

        jcbMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
        jcbMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMesActionPerformed(evt);
            }
        });

        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon_carregar.png"))); // NOI18N
        btnCadastrar.setText("Incluir");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon_descarregar.png"))); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        jcbModoPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cartão", "Avista" }));
        jcbModoPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbModoPagamentoActionPerformed(evt);
            }
        });

        lbMDPagamento.setText("Modo Pagamento:");

        jLabel2.setText("Descrição:");

        lbMDPagamento1.setText("Data Vencimento:");

        try {
            txtDataVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataVencimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataVencimentoActionPerformed(evt);
            }
        });

        txtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorActionPerformed(evt);
            }
        });

        jcbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbStatusActionPerformed(evt);
            }
        });

        jLabel7.setText("Status:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDescricao))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jcbMes, 0, 106, Short.MAX_VALUE)
                                        .addGap(77, 77, 77)
                                        .addComponent(jLabel4))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtObs))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(lbMDPagamento1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbMDPagamento)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtValor)
                                    .addComponent(jcbModoPagamento, 0, 109, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLimpar)
                            .addComponent(btnCadastrar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(lbCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbMDPagamento1)
                            .addComponent(lbMDPagamento)
                            .addComponent(jcbModoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jcbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCadastrar)
                        .addGap(11, 11, 11)
                        .addComponent(btnLimpar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(lbCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Incluir Lancamento", jPanel1);

        jButton4.setText("Cancelar");

        btnRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon_carregar.png"))); // NOI18N
        btnRelatorio.setText("Gerar Relatório");
        btnRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioActionPerformed(evt);
            }
        });

        jcbFiltroRelatorio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dívidas Vencidas", "Dívidas a Vencer", "Dívidas Pagas" }));
        jcbFiltroRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFiltroRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnRelatorio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addComponent(jcbFiltroRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(363, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jcbFiltroRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRelatorio)
                    .addComponent(jButton4))
                .addGap(29, 29, 29))
        );

        jTabbedPane5.addTab("Relatorios", jPanel4);

        lblUsuario.setText("Usuario:");

        lblSenha.setText("Senha:");

        btnAddUsuario.setText("Cadastrar");
        btnAddUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUsuarioActionPerformed(evt);
            }
        });

        btnCancelar.setText("Limpar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        tbUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbUsuario);

        btnExcluirUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon_cancel2.png"))); // NOI18N
        btnExcluirUsuario.setText("Excluir");
        btnExcluirUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirUsuarioActionPerformed(evt);
            }
        });

        btnAlterarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon_alter.png"))); // NOI18N
        btnAlterarUsuario.setText("Alterar");
        btnAlterarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btnAddUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lblUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(lblSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSenha)))
                .addGap(21, 21, 21)
                .addComponent(lbId, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAlterarUsuario)
                    .addComponent(btnExcluirUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblUsuario)
                                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblSenha)
                                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lbId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddUsuario)
                            .addComponent(btnCancelar)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btnAlterarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluirUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Criar acesso", jPanel5);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon_cancel2.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jcbMesFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
        jcbMesFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMesFiltroActionPerformed(evt);
            }
        });
        jcbMesFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jcbMesFiltroKeyReleased(evt);
            }
        });

        jLabel1.setText("Pesquisar:");

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon_alter.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnExcluir)
                        .addGap(27, 27, 27)
                        .addComponent(btnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbMesFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcbMesFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblTotalDivida.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblTotalDivida.setToolTipText("");

        lbTotalDivida.setText("Total de Divida:");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/[003782].png"))); // NOI18N
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/[003826alt].fw.png"))); // NOI18N
        jLabel6.setText("Sistema Financeiro Domestico");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbTotalDivida)
                        .addGap(18, 18, 18)
                        .addComponent(lblTotalDivida, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbData, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(34, 34, 34)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTotalDivida, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTotalDivida))
                        .addGap(18, 18, 18)
                        .addComponent(lbData, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane5)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        //Lancamento  lanc = new Lancamento();
        //ILancamento  ilanc = new ILancamento();
        
        if(txtDescricao.getText().equals("")){
            txtDescricao.requestFocus();
            JOptionPane.showMessageDialog(null, "Campo Descrição Obrigatorio!","Aviso",JOptionPane.WARNING_MESSAGE);
            return;
        }else if(txtDataVencimento.getText().equals("  /  /    ")){
            txtDataVencimento.requestFocus();
            JOptionPane.showMessageDialog(null, "Campo Data Vencimento Obrigatorio!","Aviso",JOptionPane.WARNING_MESSAGE);
            return;
        }else if(jcbModoPagamento.getSelectedItem().equals("")){
            jcbModoPagamento.requestFocus();
            JOptionPane.showMessageDialog(null, "Campo Modo Pagamento Obrigatorio!","Aviso",JOptionPane.WARNING_MESSAGE);
            return;
        }else if(jcbMes.getSelectedItem().equals("")){
            jcbMes.requestFocus();
            JOptionPane.showMessageDialog(null, "Campo Mês Obrigatorio!","Aviso",JOptionPane.WARNING_MESSAGE);
            return;
        }else if(txtObs.getText().equals("")){
            txtObs.requestFocus();
            JOptionPane.showMessageDialog(null, "Campo Observação Obrigatorio!","Aviso",JOptionPane.WARNING_MESSAGE);
            return;
        }
        lanc.setDescricao(txtDescricao.getText());
        lanc.setMd_pagamento(jcbModoPagamento.getSelectedItem().toString());
        lanc.setDt_vencimento(txtDataVencimento.getText());
        lanc.setValor(Double.parseDouble(txtValor.getText()));
        lanc.setObs(txtObs.getText());
        lanc.setMes(jcbMes.getSelectedItem().toString());
        lanc.setStatus(Integer.parseInt(jcbStatus.getSelectedItem().toString()));
        
        ilanc.inserirLancamento(lanc);
        listarLancamento();
       
        /*try {
        // TODO add your handling code here:
            PrintWriter arquivo = new PrintWriter(txtDescricao.getText()+".PDF");

            arquivo.println(txtCodigo.getText());
            arquivo.println(txtDescricao.getText());
            arquivo.println(txtDataVencimento.getText());
            arquivo.println(txtQuantidade.getText());
            arquivo.println(txtPreco.getText());

            arquivo.close();

            JOptionPane.showMessageDialog(null,"Cadastro Feito com sucesso");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CadastroLancamentos.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void jcbModoPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbModoPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbModoPagamentoActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        //ILancamento ilanc = new ILancamento();
        mostrarItem();
        ilanc.removerLancamento(Integer.parseInt(lbCodigo.getText()));
        listarLancamento();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jcbMesFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbMesFiltroKeyReleased
       
       pesquisarLancamento();
    }//GEN-LAST:event_jcbMesFiltroKeyReleased

    private void jcbMesFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMesFiltroActionPerformed
       pesquisarLancamento();
       
    }//GEN-LAST:event_jcbMesFiltroActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
       
        mostrarItem();
        lanc.setDescricao(txtDescricao.getText());
        lanc.setMd_pagamento(jcbModoPagamento.getSelectedItem().toString());
        lanc.setDt_vencimento(txtDataVencimento.getText());
        lanc.setValor(Double.parseDouble(txtValor.getText()));
        lanc.setObs(txtObs.getText());
        lanc.setMes(jcbMes.getSelectedItem().toString());
        lanc.setStatus(Integer.parseInt(jcbStatus.getSelectedItem().toString()));
        ilanc.atualizarLancamento(lanc, Integer.parseInt(lbCodigo.getText()));
        JOptionPane.showMessageDialog(null, "Registro alterado com Sucesso!","Aviso",JOptionPane.WARNING_MESSAGE);
        listarLancamento();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
     
        lbCodigo.setText("");
        txtDescricao.setText("");
        txtDataVencimento.setText("");
        txtValor.setText("");
        txtObs.setText("");
        jcbMes.setSelectedItem("");
        jcbModoPagamento.setSelectedItem("");
        
    }//GEN-LAST:event_btnLimparActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        mostrarItem();
    }//GEN-LAST:event_jTable2MouseClicked

    private void txtDataVencimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataVencimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataVencimentoActionPerformed

    private void btnAddUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUsuarioActionPerformed
       /* IUsuario iusu = new IUsuario();
        // Usuario usu = new Usuario();
        
        usu.setUsuario(txtUsuario.getText());
        usu.setSenha(txtSenha.getText());

        iusu.inserirUsuario(usu);
        //mostrarItemUsuario();
        //listarUsuario();*/
    }//GEN-LAST:event_btnAddUsuarioActionPerformed

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
          
        PrintWriter arquivo = null;
        try {
            // TODO add your handling code here:
            arquivo = new PrintWriter(jcbFiltroRelatorio.getSelectedItem()+".csv");
            if(jcbFiltroRelatorio.getSelectedItem().equals("Dívidas Vencidas")){
                // PrintWriter arquivo = new PrintWriter(txtDescricao.getText()+".csv");
                arquivo.print(jcbFiltroRelatorio.getSelectedItem());
                arquivo.print("Descrição");
                arquivo.print("Data de Vencimento");
                arquivo.print("Valor");
                arquivo.print("Mês de Janeiro");
                
                arquivo.close();
                
                JOptionPane.showMessageDialog(null,"Relatorio de Dívidas Vencidas Geradas");
            }else if(jcbFiltroRelatorio.getSelectedItem().equals("Dívidas a Vencer")){
                //PrintWriter arquivo = new PrintWriter(txtDescricao.getText()+".csv");
                
                arquivo.print(jcbFiltroRelatorio.getSelectedItem());
                arquivo.print("Descrição");
                arquivo.print("Data de Vencimento");
                arquivo.print("Valor");
                arquivo.print("Mês de Janeiro");
                
                arquivo.close();
                
                JOptionPane.showMessageDialog(null,"Relatorio de Dívidas a Vencer Geradas");
            }else if(jcbFiltroRelatorio.getSelectedItem().equals(" Dívidas Pagas")){
                //PrintWriter arquivo = new PrintWriter(txtDescricao.getText()+".csv");
                arquivo.print(jcbFiltroRelatorio.getSelectedItem());
                arquivo.print("Descrição");
                arquivo.print("Data de Vencimento");
                arquivo.print("Valor");
                arquivo.print("Mês de Janeiro");
                
                arquivo.close();
                
                JOptionPane.showMessageDialog(null,"Relatorio de  Dívidas Pagas Geradas");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            arquivo.close();
        }
           
    }//GEN-LAST:event_btnRelatorioActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        
        txtUsuario.setText("");
        txtSenha.setText("");
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jcbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbStatusActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jcbStatusActionPerformed

    private void btnExcluirUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirUsuarioActionPerformed
        /*/ TODO add your handling code here:
        //ILancamento ilanc = 
        mostrarItemUsuario();
        iusu.removerUsuario(Integer.parseInt(lbId.getText())); 
       // listarUsuario();*/
        
        
    }//GEN-LAST:event_btnExcluirUsuarioActionPerformed

    private void btnAlterarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarUsuarioActionPerformed
        /*/ TODO add your handling code here:
        mostrarItemUsuario();
        usu.setUsuario(txtUsuario.getText());
        usu.setSenha(txtSenha.getText());
        iusu.atualizarUsuario(usu, Integer.parseInt(lbId.getText()));
        JOptionPane.showMessageDialog(null, "Registro alterado com Sucesso!","Aviso",JOptionPane.WARNING_MESSAGE);
        //listarUsuario();*/
    }//GEN-LAST:event_btnAlterarUsuarioActionPerformed

    private void jcbMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMesActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jcbMesActionPerformed

    private void jcbFiltroRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFiltroRelatorioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbFiltroRelatorioActionPerformed

    private void txtValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUsuario;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAlterarUsuario;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnExcluirUsuario;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox<String> jcbFiltroRelatorio;
    private javax.swing.JComboBox jcbMes;
    private javax.swing.JComboBox jcbMesFiltro;
    private javax.swing.JComboBox<String> jcbModoPagamento;
    private javax.swing.JComboBox<String> jcbStatus;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbData;
    private java.awt.Label lbId;
    private javax.swing.JLabel lbMDPagamento;
    private javax.swing.JLabel lbMDPagamento1;
    private javax.swing.JLabel lbTotalDivida;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTable tbUsuario;
    private javax.swing.JFormattedTextField txtDataVencimento;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtObs;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
