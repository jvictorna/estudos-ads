
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import model.JavaBeans;
import java.sql.ResultSet;
import java.util.ArrayList;

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
   
   // Método para listar contatos
   
   public ArrayList<JavaBeans> listarContatos(){
       
       ArrayList<JavaBeans> contatos = new ArrayList<>();
       
       String sql = "select * from contatos order by nome";
       
       try {
           Connection con = conectar();
           
           PreparedStatement pst = con.prepareStatement(sql);
           
           ResultSet rs = pst.executeQuery();
           
           while (rs.next()) {
               int id = rs.getInt("id");
               String nome = rs.getString("nome");
               String fone = rs.getString("fone");
               String endereco = rs.getString("endereco");
               
               contatos.add(new JavaBeans(id, nome, fone, endereco));
           }    
           
           con.close();
           return contatos; 
           
       } catch (Exception e) {
           System.out.println(e);
           return null;
       }
   }
   
}
