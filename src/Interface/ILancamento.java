package Interface;

import ConexaoBD.Conexao;
import Utilitarios.Lancamento;
//import Utilitarios.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ILancamento {
    
    Lancamento  lanc = new Lancamento();
    private Connection connection;
    
    
    public ILancamento(){
        this.connection = new Conexao().getConexao();
}
    public Connection getConnection(){
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    //Insere cadastro dispesas no banco de dados
    //@Author Murilo Fiuza 04/02/2016
    public void inserirLancamento(Lancamento lanc){
        String sql ="INSERT INTO lancamento (descricao,modo,obs,valor,mes,vencimento,id_status) VALUES (?,?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, lanc.getDescricao());
            stmt.setString(2, lanc.getMd_pagamento());
            stmt.setString(3, lanc.getObs());
            stmt.setDouble(4, lanc.getValor());
            stmt.setString(5, lanc.getMes());
            stmt.setString(6, lanc.getDt_vencimento());
            stmt.setInt(7, lanc.getStatus());
            //stmt.setInt(8, lanc.getAcesso());
          
            stmt.executeUpdate();
            stmt.close();
            
           JOptionPane.showMessageDialog(null, "Registro Salvo com Sucesso!","Aviso",JOptionPane.WARNING_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro no Lançamento!","Aviso",JOptionPane.WARNING_MESSAGE);
        } 
    }
    /* public void remover(int id){
        String sql ="DELETE FROM lancamento WHERE id=?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(0, id);
            stmt.execute();
            stmt.close();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
            
        }
    }*/

     /*public void inserirUsuario(Usuario usu){
        String sql ="INSERT INTO acesso (usuario,senha) VALUES (?,?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usu.getUsuario());
            stmt.setString(2, usu.getSenha());
                     
            stmt.executeUpdate();
            stmt.close();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
            
        }
    }*/
    
    //Excluir os registros do banco de dados
    //@Author Murilo Fiuza 04/02/2016
    public void removerLancamento(int id){
        try{           
           PreparedStatement stmt=connection.prepareStatement("DELETE FROM lancamento WHERE id=?");
           stmt.setInt(1, id);
           
           stmt.executeUpdate();
           stmt.close();
       
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }                        
    }
    
    //Atualiza os registros do banco de dados
    //@Author Murilo Fiuza 04/02/2016
    public void atualizarLancamento(Lancamento lanc, int id){
            String sql ="UPDATE lancamento SET descricao=? ,modo=? ,obs=? ,valor=? ,mes=?, vencimento=?, id_status=?  WHERE id=?";
        try{
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, lanc.getDescricao());
                stmt.setString(2, lanc.getMd_pagamento());
                stmt.setString(3, lanc.getObs());
                stmt.setDouble(4, lanc.getValor());
                stmt.setString(5, lanc.getMes());
                stmt.setString(6, lanc.getDt_vencimento());
                stmt.setInt(7, lanc.getStatus());
                //stmt.setInt(8, lanc.getAcesso());
                stmt.setInt(8, id);
                
                stmt.executeUpdate();
                stmt.close();
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        }
    
   /* public void mostrarSoma(double valor){
         String sql = "SELECT SUM(valor) FROM lancamento";
        try{
            PreparedStatement stmt = getConnection().prepareStatement(sql);
           
            stmt.setDouble(1, valor);
          
            stmt.execute();
            stmt.close();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);  
        }
    }*/
}
