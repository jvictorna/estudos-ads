
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import model.JavaBeans;

public class DAO {
    /* Módulo de conexão */ 
    
    // Parâmetros de conexão
    
    private String driver = "org.mariadb.jdbc.Driver";
    private String url = "jdbc:mariadb://127.0.0.1:3306/estudos_jdbc";
    private String user = "root";
    private String password = "";
    
    // Método de conexão 
    
   public Connection conectar() {
        Connection con = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
   
   // Teste de conexão 
   
   public void testeConexao(){
    try {
        Connection con = conectar();

        if (con != null) {
            System.out.println("Conectado com sucesso!");
            con.close();
        }
    } catch (Exception e) {
        System.out.println(e);
    }
   } 
   
   // Método para inserir dados
   
   public void inserirContato(JavaBeans contato) {
       
       String sql = "insert into contatos (nome, fone, endereco) values (?, ?, ?)";
       
       try {
           Connection con = conectar();
           
           PreparedStatement pst = con.prepareStatement(sql);
           
           pst.setString(1, contato.getNome());
           pst.setString(2, contato.getFone());
           pst.setString(3, contato.getEndereco());
           
           pst.executeUpdate();
           
           con.close();
           
           System.out.println("Contato inserido com sucesso");
           
       } catch (Exception e) {
           System.out.println(e);
       }
   }
   
}
