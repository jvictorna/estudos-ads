
package estudosjdbc;

import dao.DAO;
import java.util.ArrayList;
import java.util.Scanner;
import model.JavaBeans;
import relatorio.relatorioPDF;

public class EstudosJDBC {
  
    public static void main(String[] args) throws Exception {
        System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
       
    relatorioPDF pdf = new relatorioPDF();
        pdf.gerarRelatorio();
          
    }
    
}
