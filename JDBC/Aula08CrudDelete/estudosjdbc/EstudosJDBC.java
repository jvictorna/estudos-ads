
package estudosjdbc;

import dao.DAO;
import java.util.ArrayList;
import java.util.Scanner;
import model.JavaBeans;

public class EstudosJDBC {
  
    public static void main(String[] args) throws Exception {
        System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
       
    DAO dao = new DAO();
    
   JavaBeans contato = new JavaBeans();

        contato.setId(1);

   dao.deletarContato(contato);
          
    }
    
}
