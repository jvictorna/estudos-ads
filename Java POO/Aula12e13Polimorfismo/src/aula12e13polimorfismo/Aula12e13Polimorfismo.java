
package aula12e13polimorfismo;

public class Aula12e13Polimorfismo {
    
    public static void main(String[] args) {
     
        /*
 * Exercício — Aulas 12 e 13
 * Polimorfismo — Sobreposição e Sobrecarga
 *
 * Evolua o exercício anterior aplicando polimorfismo,
 * demonstrando como objetos diferentes respondem ao mesmo
 * método de formas distintas.
 *
 * Requisitos — Sobreposição:
 * 1. Manter a herança do exercício anterior (Quarto, QuartoComum, QuartoLuxo)
 * 2. Sobrepor o método mostrarEstado() no QuartoLuxo — além do status,
 *    exibir também se possui hidromassagem
 * 3. Criar um array Quarto[] com objetos de tipos diferentes
 *    (QuartoComum e QuartoLuxo misturados)
 * 4. Percorrer o array chamando executarChecklist() e mostrarEstado()
 *    em cada posição — sem verificar o tipo do objeto
 *
 * Requisitos — Sobrecarga:
 * 5. Na classe Quarto, criar duas versões do método mostrarEstado():
 *    — sem parâmetro: exibe apenas o status
 *    — com parâmetro boolean detalhado: exibe status + andar + tamanho + capacidade
 * 6. No main, chamar as duas versões para demonstrar a diferença
 *
 * Objetivo principal:
 * O array Quarto[] deve chamar os métodos sem saber se o objeto
 * é QuartoComum ou QuartoLuxo — cada um responde do seu jeito.
 */
        
        Quarto[] quartos = new Quarto[4];

        quartos[0] = new QuartoComum(1, "M", 2, true);
        quartos[1] = new QuartoLuxo(2, "G", 4, true, true);
        quartos[2] = new QuartoComum(0, "P", 1, false);
        quartos[3] = new QuartoLuxo(3, "GG", 5, true, false);

        System.out.println("=== POLIMORFISMO ===");

        for (Quarto quarto : quartos) {
            System.out.println("--------------------");
            quarto.executarChecklist();
            quarto.mostrarEstado();
        }

        System.out.println("\n=== SOBRECARGA ===");

        Quarto quartoTeste = new QuartoComum(1, "M", 2, true);

        System.out.println("Mostrar estado simples:");
        quartoTeste.mostrarEstado();

        System.out.println("\nMostrar estado detalhado:");
        quartoTeste.mostrarEstado(true);
    }
        
    }
