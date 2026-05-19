
package aula12e13polimorfismo;

public final class QuartoLuxo extends Quarto {
    
    boolean hidromassagem;

    public QuartoLuxo(int and, String tmh, int cap, boolean var, boolean hidro) {
        super(and, tmh, cap, var);
        this.hidromassagem = hidro;
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
    System.out.println("[ ] Banheira de Hidromassagem");
    }

    @Override
    public void mostrarEstado() {
        super.mostrarEstado();

        if (this.hidromassagem) {
            System.out.println("Possui hidromassagem");
        } else {
            System.out.println("Não possui hidromassagem");
        }
    }
}
