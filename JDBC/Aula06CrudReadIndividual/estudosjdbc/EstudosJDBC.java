
package estudosjdbc;

import dao.DAO;
import java.util.ArrayList;
import java.util.Scanner;
import model.JavaBeans;

public class EstudosJDBC {
  
    public static void main(String[] args) throws Exception {
        System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
       
    DAO dao = new DAO();
    
    JavaBeans contato = dao.buscarContato(10);
    
        System.out.println("ID: " + contato.getId());
        System.out.println("Nome: " + contato.getNome());
        System.out.println("Telefone: " + contato.getFone());
        System.out.println("Endereço: " + contato.getEndereco());
            
    }
    
}
