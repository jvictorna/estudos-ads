package hgs.jdbc.fase05.controller;

import java.util.Scanner;
import dao.DAO;
import java.util.ArrayList;
import model.QuartoBean;
import service.CheckList;
import controller.HGSController;

/**
 * Sistema de Governança Hoteleira Controle de status e limpeza de quartos
 * Desenvolvido como projeto prático do curso de ADS
 *
 * @author João Adorno
 * @version 3.1
 */
public class HGSJDBCFase05Controller {

    static int opcao, numQuarto, opcaoManut, posicao;

    static String resposta;

    static Scanner teclado = new Scanner(System.in);

    static DAO dao = new DAO();

    static ArrayList<QuartoBean> quartos = dao.listarQuartos();

    static HGSController controller = new HGSController(dao, teclado);

    static void cabecalhoInicio() {
        System.out.println("=========================================");
        System.out.println("          SISTEMA DE GOVERNANÇA          ");
        System.out.println("=========================================");

    } // Fechamento cabecalhoInicio();

    static void exibirQuartos() {

        System.out.println("=========================================");
        System.out.println("                T E R R E O              ");
        System.out.println("=========================================");

        for (QuartoBean quarto : quartos) {

            if (quarto.getAndar() == 0) {

                System.out.println(
                        "Quarto "
                        + quarto.getNumero()
                        + ": "
                        + quarto.getStatusDescricao());
            }
        }

        System.out.println("=========================================");
        System.out.println("              1º A N D A R               ");
        System.out.println("=========================================");

        for (QuartoBean quarto : quartos) {

            if (quarto.getAndar() == 1) {

                System.out.println(
                        "Quarto "
                        + quarto.getNumero()
                        + ": "
                        + quarto.getStatusDescricao());
            }
        }

        System.out.println("=========================================");
        System.out.println("              2º A N D A R               ");
        System.out.println("=========================================");

        for (QuartoBean quarto : quartos) {

            if (quarto.getAndar() == 2) {

                System.out.println(
                        "Quarto "
                        + quarto.getNumero()
                        + ": "
                        + quarto.getStatusDescricao());
            }
        }

        System.out.println("=========================================");
        System.out.println("              3º A N D A R               ");
        System.out.println("=========================================");

        for (QuartoBean quarto : quartos) {

            if (quarto.getAndar() == 3) {

                System.out.println(
                        "Quarto "
                        + quarto.getNumero()
                        + ": "
                        + quarto.getStatusDescricao());
            }
        }

    } // Fechamento exibirQuartos();

    static void exibirMenu() {
        System.out.println("=========================================");
        System.out.println("           SELECIONE UMA OPÇÃO           ");
        System.out.println("=========================================");
        System.out.println("1. Checkout - ACIONAR CAMAREIRA II ");
        System.out.println("2. Arrumação pendente - ACIONAR CAMAREIRA I ");
        System.out.println("3. Limpeza iniciada - AGUARDANDO CONCLUSÃO ");
        System.out.println("4. Limpeza finalizada - INICIAR CHECK-LIST ");
        System.out.println("5. Check-in realizado - QUARTO OCUPADO ");
        System.out.println("6. Revisão geral - ACIONAR CAMAREIRA III ");
        System.out.println("7. Manutenção - BLOQUEAR QUARTO ");
        System.out.println("8. Manutenção concluída - LIBERAR QUARTO ");
        System.out.println("0. Encerrar sessão ");
        System.out.println("");

    } // Fechamento exibirMenu();

    static void solicitarDados() {

        if (opcao >= 1 && opcao <= 8) {
            System.out.print("Digite o número do quarto: ");

            try {
                numQuarto = teclado.nextInt();
            } catch (Exception e) {
                System.out.println("=========== A T E N Ç Ã O ================");
                System.out.println("ERRO: Digite apenas números!");
                System.out.println("==========================================");
                System.out.println(" --- Pressione ENTER para continuar --- ");
                teclado.next();
                teclado.nextLine();
                teclado.nextLine();
                opcao = -1;
                return;
            }

            posicao = controller.getPosicao(numQuarto); // ← substitui o for

            if (posicao == -1) {
                System.out.println("=========== A T E N Ç Ã O ================");
                System.out.println("QUARTO INVÁLIDO — verifique o número e tente novamente");
                System.out.println("==========================================");
                System.out.println(" --- Pressione ENTER para continuar --- ");
                teclado.nextLine();
                teclado.nextLine();
                opcao = -1;
            }
        }
    } // Fechamento solicitar dados

    public static void main(String[] args) throws Exception {
        System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));

        do {
            controller.atualizarLista();
            quartos = controller.getQuartos();
            cabecalhoInicio();
            exibirQuartos();
            exibirMenu();

            System.out.print("Selecione a opção: ");
            try {
                opcao = teclado.nextInt();
            } catch (Exception e) {
                System.out.println("=========== A T E N Ç Ã O ================");
                System.out.println("ERRO: Digite apenas números! ");
                System.out.println("==========================================");
                System.out.println(" --- Pressione ENTER para continuar --- ");
                teclado.next();
                teclado.nextLine();
                teclado.nextLine();
                opcao = -1;
            }

            solicitarDados();
            opcao = controller.validarTrava(opcao, posicao);

            switch (opcao) {
                case 1:
                    controller.realizarCheckout(posicao, numQuarto);
                    break;
                case 2:
                    controller.arrumacaoQuarto(posicao, numQuarto);
                    break;
                case 3:
                    controller.iniciarLimpeza(posicao, numQuarto);
                    break;
                case 4:
                    controller.realizarInspecao(posicao, numQuarto);
                    break;
                case 5:
                    controller.realizarCheckin(posicao, numQuarto);
                    break;
                case 6:
                    controller.iniciarRevisao(posicao, numQuarto);
                    break;
                case 7:
                    controller.manutencaoTec(posicao, numQuarto);
                    break;
                case 8:
                    controller.manutencaoGer(posicao, numQuarto);
                    break;
                case 0:
                    System.out.println("SISTEMA ENCERRADO");
                    break;
            }
        } while (opcao != 0);

    }

}
