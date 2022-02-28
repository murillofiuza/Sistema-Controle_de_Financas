package ConexaoBD;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexao {
    
    /*public ResultSet rs ;
    public Connection getConnection(){
        
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost/financeiro","root", "");
        }catch(SQLException e){
            
        throw new RuntimeException(e);
    }*/
    
    public static Connection con;
    public Statement st ;
    public ResultSet rs ;

    public static Connection getConexao(){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/financeiro";
        String login = "root";
        String senha = "";

        try {
            Class.forName(driver);
            try {
                con = DriverManager.getConnection(url, login, senha);
                // st = con.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException e) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, e);
        }
        return con;
    }

    public void close() {
        Connection conn;
        try {
            conn = Conexao.getConexao();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
     /*
     
    public Connection con;
    public Statement stmt;
    public ResultSet rs;
    
    String url="jdbc mysql://localhost:3306/Locadora";
     String driver="con.mysql.jdbc.Driver";
     String user="root";
     String password="";
     
     public void abrirConexao(){
         try{
             Class.forName(driver).new Instance();
             con = DriverManage.getConnection(url,user,password);
             
             stmt = (Statement) con.createStatement();
         }catch(Exception e){
          
         }*/
     }   
    
}
