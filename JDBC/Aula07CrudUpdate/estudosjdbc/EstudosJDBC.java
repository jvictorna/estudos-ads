
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
        contato.setNome("João Atualizado");
        contato.setFone("8199999-0000");
        contato.setEndereco("Recife");

    dao.editarContato(contato);
    
    JavaBeans contato2 = new JavaBeans();
    
        contato2.setEndereco("Pernambuco");
        contato2.setFone("8191111-2222");
        contato2.setId(5);
        contato2.setNome("Pedro Atualizado");
        
        dao.editarContato(contato2);
            
    }
    
}
