package Interface;

import ConexaoBD.Conexao;
import Utilitarios.Usuario;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class IUsuario {
    private Connection connection;
    
    Usuario usu = new Usuario();
    public IUsuario(){
        this.connection = new Conexao().getConexao();
}
    public Connection getConnection(){
        return connection;
    }

    /* @param connection the connection to set */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    //Inserir os registros do banco de dados
    //@Author Murilo Fiuza 04/02/2016
    public void inserirUsuario(Usuario usu){
        String sql ="INSERT INTO acesso (usuario,senha) VALUES (?,?)";
        try{
           PreparedStatement stmt = connection.prepareStatement(sql);
           stmt.setString(1, usu.getUsuario());
           stmt.setString(2, usu.getSenha());
                     
           stmt.executeUpdate();
           stmt.close();
            
        JOptionPane.showMessageDialog(null, "UsuarioRegistrado com Sucesso!","Aviso",JOptionPane.WARNING_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro no Lançamento!","Aviso",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    //Excluir os registros de usuarios do banco de dados
    //@Author Murilo Fiuza 04/02/2016
    public void removerUsuario(int id){
           try{           
           PreparedStatement stmt=connection.prepareStatement("DELETE FROM acesso WHERE id=?");
           stmt.setInt(1, id);
           stmt.executeUpdate();
           stmt.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }                   
    }
    
    //Atualiza os registros de usuarios do banco de dados
    //@Author Murilo Fiuza 04/02/2016
     public void atualizarUsuario(Usuario usu, int id){
        String sql ="UPDATE acesso SET usuario=? ,senha=?  WHERE id=?";
        try{
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(3, usu.getUsuario());
                stmt.setString(1, usu.getSenha());
                
                // stmt.setInt(8, lanc.getAcesso());
                stmt.setInt(2, id);
                stmt.execute();
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e); 
        }
    }
     
     
     /*public File getFile( int id ) throws FileNotFoundException, IOException{
    Connection c = this.getConnection();//busca uma conexao com o banco
    File f = null;
    try {
        PreparedStatement ps = c.prepareStatement("SELECT id, nome, arquivo FROM arquivo WHERE id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if ( rs.next() ){
            byte [] bytes = rs.getBytes("arquivo");
            String nome = rs.getString("nome");

            //converte o array de bytes em file
            f = new File( "C:\\" + nome );
            FileOutputStream fos = new FileOutputStream( f);
            fos.write( bytes );
            fos.close();
        }
        rs.close();
        ps.close();
        c.close();
        return f;
} catch (SQLException ex) {
ex.printStackTrace();
}
catch (IOException ex) {
ex.printStackTrace();
}
return null;
}*/
     
}
