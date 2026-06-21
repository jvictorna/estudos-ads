
package estudosjdbc;

import dao.DAO;
import java.util.Scanner;
import model.JavaBeans;

public class EstudosJDBC {
  
    public static void main(String[] args) {
    
    Scanner teclado = new Scanner(System.in);
    
    JavaBeans contato = new JavaBeans();

        System.out.print("Digite o nome: ");
        contato.setNome(teclado.nextLine());
        
        System.out.print("Digite o telefone: ");
        contato.setFone(teclado.nextLine());
        
        System.out.print("Digite o endereço: ");
        contato.setEndereco(teclado.nextLine());
    
    DAO dao = new DAO();
    dao.inserirContato(contato);

    }
    
}
