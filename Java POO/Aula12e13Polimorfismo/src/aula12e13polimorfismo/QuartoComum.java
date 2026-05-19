
package aula12e13polimorfismo;

public final class QuartoComum extends Quarto {
    
    public QuartoComum(int and, String tmh, int cap, boolean var) {
        super(and, tmh, cap, var);
    }

    @Override
    public void executarChecklist() {
        System.out.println("[ ] Cama arrumada");
        System.out.println("[ ] Enxoval trocado");
        System.out.println("[ ] Toalhas trocadas");
        System.out.println("[ ] Banheiro higienizado");
        System.out.println("[ ] Lixo retirado");
        System.out.println("[ ] Frigobar verificado");
        System.out.println("[ ] Ar condicionado verificado");
        System.out.println("[ ] Televisão verificada");
    }
}