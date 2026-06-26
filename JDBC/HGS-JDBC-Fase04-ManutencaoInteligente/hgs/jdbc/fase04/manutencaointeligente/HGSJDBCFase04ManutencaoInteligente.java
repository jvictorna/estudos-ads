package hgs.jdbc.fase04.manutencaointeligente;

import java.util.Scanner;
import dao.DAO;
import java.util.ArrayList;
import model.QuartoBean;
import service.CheckList;

/**
 * Sistema de Governança Hoteleira Controle de status e limpeza de quartos
 * Desenvolvido como projeto prático do curso de ADS
 *
 * @author João Adorno
 * @version 3.1
 */
public class HGSJDBCFase04ManutencaoInteligente {

    static int opcao, numQuarto, opcaoManut, posicao;

    static String resposta;

    static Scanner teclado = new Scanner(System.in);

    static DAO dao = new DAO();

    static ArrayList<QuartoBean> quartos = dao.listarQuartos();

    static void atualizarListaQuartos() {

        quartos = dao.listarQuartos();
        posicao = -1;

        for (int i = 0; i < quartos.size(); i++) {
            if (quartos.get(i).getNumero() == numQuarto) {
                posicao = i;
                break;
            }
        }
    }

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

            posicao = -1;

            for (int i = 0; i < quartos.size(); i++) {
                if (quartos.get(i).getNumero() == numQuarto) {
                    posicao = i;
                    break;
                }
            }
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
    } // Fechamento solicitarDados();

    static void validarTrava() {

        if (opcao == -1 || posicao == -1) {
            return;
        }

        if (opcao == 1) {
            if (quartos.get(posicao).getIdStatus() != 2) {
                System.out.println("=============== A T E N Ç Ã O =================");
                System.out.println("ERRO: Este quarto não possui hóspede ");
                System.out.println("      CHECK-OUT NÃO PERMITIDO        ");
                System.out.println("===============================================");
                System.out.println(" --- Pressione ENTER para continuar --- ");
                teclado.nextLine();
                teclado.nextLine();
                opcao = -1;
            }
        }

        if (opcao == 3) {

            if (quartos.get(posicao).getIdStatus() != 3) {
                if (quartos.get(posicao).getIdStatus() != 5) {
                    if (quartos.get(posicao).getIdStatus() != 6) {
                        if (quartos.get(posicao).getIdStatus() != 9) {
                            System.out.println("=========== A T E N Ç Ã O ================");
                            System.out.println("ERRO: A limpeza não pode ser iniciada agora!");
                            if (quartos.get(posicao).getIdStatus() == 2) {
                                System.out.println("MOTIVO: O quarto está OCUPADO! ");
                                System.out.println("Solicite primeiro a ARRUMAÇÃO PENDENTE (OPÇÃO 5)");
                            } else {
                                System.out.println("MOTIVO: O quarto esta LIMPO ou DISPONÍVEL");
                            }
                            System.out.println("==========================================");
                            System.out.println(" --- Pressione ENTER para continuar --- ");
                            teclado.nextLine();
                            teclado.nextLine();
                            opcao = -1;
                        }
                    }
                }
            }
        }

        if (opcao == 4) {
            if (quartos.get(posicao).getIdStatus() != 4) {
                if (quartos.get(posicao).getIdStatus() != 9) {
                    System.out.println("=========== A T E N Ç Ã O ================");
                    System.out.println("ERRO: Este quarto não esta apto para finalização! ");
                    System.out.println("     VERIFIQUE ESTADO ATUAL DO QUARTO     ");
                    System.out.println("==========================================");
                    System.out.println(" --- Pressione ENTER para continuar --- ");
                    teclado.nextLine();
                    teclado.nextLine();
                    opcao = -1;
                }
            }
        }

        if (opcao == 2) {
            if (quartos.get(posicao).getIdStatus() != 2) {
                System.out.println("=========== A T E N Ç Ã O ================");
                System.out.println("ERRO: Arrumação não permitida! ");
                System.out.println("MOTIVO: O quarto não está OCUPADO  ");
                System.out.println("==========================================");
                System.out.println(" --- Pressione ENTER para continuar --- ");
                teclado.nextLine();
                teclado.nextLine();
                opcao = -1;
            }
        }

        if (opcao == 5) {
            if (quartos.get(posicao).getIdStatus() != 1) {
                System.out.println("=========== A T E N Ç Ã O ================");
                System.out.println("ERRO: Check-in não permitido! ");
                if (quartos.get(posicao).getIdStatus() == 2) {
                    System.out.println("MOTIVO: O quarto já encontra-se OCUPADO");
                } else if (quartos.get(posicao).getIdStatus() == 7
                        || quartos.get(posicao).getIdStatus() == 8) {
                    System.out.println("MOTIVO: O quarto está EM MANUTENÇÃO");
                } else {
                    System.out.println("MOTIVO: O quarto NÃO está DISPONÍVEL");
                }
                System.out.println("===========================================");
                System.out.println(" --- Pressione ENTER para continuar --- ");
                teclado.nextLine();
                teclado.nextLine();
                opcao = -1;
            }
        }

        if (opcao == 6) {
            if (quartos.get(posicao).getIdStatus() != 1) {
                System.out.println("=========== A T E N Ç Ã O ================");
                System.out.println("ERRO: Revisão geral não permitida! ");
                System.out.println("MOTIVO: O quarto NÃO está DISPONÍVEL ");
                System.out.println("==========================================");
                System.out.println(" --- Pressione ENTER para continuar --- ");
                teclado.nextLine();
                teclado.nextLine();
                opcao = -1;
            }
        }

        if (opcao == 7) {

            int status = quartos.get(posicao).getIdStatus();

            if (status != 1 && status != 2 && status != 3
                    && status != 5 && status != 6) {

                System.out.println("=========== A T E N Ç Ã O ================");
                System.out.println("ERRO: Este quarto não pode ser bloqueado!");
                System.out.println("MOTIVO: Status atual não permite manutenção");
                System.out.println("==========================================");
                System.out.println(" --- Pressione ENTER para continuar --- ");
                teclado.nextLine();
                teclado.nextLine();
                opcao = -1;
            }
        }

        if (opcao == 8) {

            if (quartos.get(posicao).getIdStatus() != 7
                    && (quartos.get(posicao).getIdStatus() != 8)) {

                System.out.println("=========== A T E N Ç Ã O ================");
                System.out.println("ERRO: Este quarto NÃO está em manutenção! ");
                System.out.println("Verifique o status atual do quarto ");
                System.out.println("==========================================");
                System.out.println(" --- Pressione ENTER para continuar --- ");
                teclado.nextLine();
                teclado.nextLine();
                opcao = -1;
            }
        }

    } // Fechamento do validarTrava(); 

    static void realizarCheckout() {

        dao.realizarCheckout(
                quartos.get(posicao).getId()
        );
        atualizarListaQuartos();

        System.out.println("=========== A T E N Ç Ã O ================");
        System.out.println("    O quarto " + numQuarto + " foi definido como SUJO! ");
        System.out.println("        AGUARDANDO LIMPEZA           ");
        System.out.println("==========================================");
        System.out.println(" --- Pressione ENTER para continuar --- ");
        teclado.nextLine();
        teclado.nextLine();

    } // Fechamento do realizarCheckout(); 

    static void iniciarLimpeza() {

        switch (quartos.get(posicao).getIdStatus()) {

            case 3:
                dao.iniciarLimpezaPosCheckout(
                        quartos.get(posicao).getId());
                break;

            case 5:
                dao.iniciarLimpezaArrumacao(
                        quartos.get(posicao).getId());
                break;

            case 6:
                dao.iniciarLimpezaRevisao(
                        quartos.get(posicao).getId());
                break;
        }

        atualizarListaQuartos();

        System.out.println("=========== A T E N Ç Ã O ================");
        System.out.println("A limpeza do quarto " + numQuarto + " foi INICIADA ");
        System.out.println("    AGUARDANDO LIBERAÇÃO DA CAMAREIRA     ");
        System.out.println("==========================================");
        System.out.println(" --- Pressione ENTER para continuar --- ");
        teclado.nextLine();
        teclado.nextLine();

    } // Fechamento realizarLimpeza();

    static void realizarCheckin() {

        dao.realizarCheckIn(
                quartos.get(posicao).getId());
        atualizarListaQuartos();

        System.out.println("=========== A T E N Ç Ã O ================");
        System.out.println("O quarto " + numQuarto + " está OCUPADO ");
        System.out.println("=========================================");
        System.out.println(" --- Pressione ENTER para continuar --- ");
        teclado.nextLine();
        teclado.nextLine();

    } // Fechamento realizarCheckin(); 

    static void arrumacaoQuarto() {

        dao.arrumacaoQuarto(
                quartos.get(posicao).getId());
        atualizarListaQuartos();

        System.out.println("=========== A T E N Ç Ã O ================");
        System.out.println("O quarto " + numQuarto + " está com ARRUMAÇÃO PENDENTE");
        System.out.println("    AGUARDANDO INICIO DA LIMPEZA     ");
        System.out.println("==========================================");
        System.out.println("--- Pressione ENTER para continuar ---");
        teclado.nextLine();
        teclado.nextLine();
    } // Fechamento arrumacaoQuarto(); 

    static void iniciarRevisao() {

        dao.iniciarRevisao(
                quartos.get(posicao).getId());
        atualizarListaQuartos();

        System.out.println("=========== A T E N Ç Ã O ================");
        System.out.println("O quarto " + numQuarto + " precisa de REVISÃO DE LONGA DATA ");
        System.out.println("     AGUARDANDO INICIO DA LIMPEZA         ");
        System.out.println("==========================================");
        System.out.println(" --- Pressione ENTER para continuar --- ");
        teclado.nextLine();
        teclado.nextLine();

    } // Fechamento realizarRevisao();

    static void manutencaoTec() {

        dao.manutencaoTec(
                quartos.get(posicao).getId());
        atualizarListaQuartos();

        System.out.println("=========== A T E N Ç Ã O ================");
        System.out.println("Foi identificado um problema no quarto " + numQuarto);
        System.out.println("  QUARTO BLOQUEADO PARA MANUTENÇÃO TÉCNICA ");
        System.out.println("===========================================");
        System.out.println(" --- Pressione ENTER para continuar --- ");
        teclado.nextLine();
        teclado.nextLine();

    } // Fechamento manutencaoTec();

    static void manutencaoGer() {

        if (quartos.get(posicao).getIdStatus() == 7
                || quartos.get(posicao).getIdStatus() == 8) {

            System.out.println(" === CONCLUSÃO DE MANUTENÇÃO DO QUARTO " + numQuarto + " === ");
            System.out.println("A manutenção foi concluída? (S/N) ");
            resposta = teclado.next();
            teclado.nextLine();

            if (resposta.equalsIgnoreCase("S")) {
                dao.concluirManutencao(quartos.get(posicao).getId());
                atualizarListaQuartos();

                System.out.println("=========== S U C E S S O ================");
                System.out.println("       MANUTENÇÃO FINALIZADA              ");
                System.out.println("==========================================");
                System.out.println("=========== A T E N Ç Ã O ================");
                System.out.println("    AGUARDANDO INSPEÇÃO DA GOVERNANÇA     ");
                System.out.println("==========================================");
                System.out.println(" --- Pressione ENTER para continuar --- ");
                teclado.nextLine();
            }
        }

    } // Fechamento manutencaoGer();

    static void realizarInspecao() {

        int origemLimpeza = quartos.get(posicao).getIdOrigemLimpeza();
        int origemManutencao = quartos.get(posicao).getIdOrigemManutencao();

        System.out.println("Deseja iniciar a INSPEÇÃO do quarto " + numQuarto + " ? (S/N) ");
        resposta = teclado.next();

        if (resposta.equalsIgnoreCase("S")) {

            boolean possuiDefeito = false;

            boolean quartoLuxo
                    = quartos.get(posicao).getIdModelo() == 4
                    || quartos.get(posicao).getIdModelo() == 5;

            // BLOCO A — Revisão Pós-Manutenção (status 9)
            
            if (quartos.get(posicao).getIdStatus() == 9) {

                if (quartoLuxo) {
                    possuiDefeito = CheckList.executarCheckListRevisaoGeralLuxo(teclado);
                } else {
                    possuiDefeito = CheckList.executarCheckListRevisaoGeralComum(teclado);
                }

                if (possuiDefeito) {
                    dao.bloquearManutencao(quartos.get(posicao).getId());
                    atualizarListaQuartos();

                    System.out.println("=========== A T E N Ç Ã O ================");
                    System.out.println("DEFEITO TÉCNICO DETECTADO APÓS MANUTENÇÃO ");
                    System.out.println("QUARTO IRÁ RETORNAR PARA MANUTENÇÃO TÉCNICA");
                    System.out.println("===========================================");
                    System.out.println(" --- Pressione ENTER para continuar --- ");
                    teclado.nextLine();
                    teclado.nextLine();

                } else {
                    switch (origemManutencao) {
                        case 2: // Ocupado
                        case 5: // Arrumação Pendente
                            dao.realizarCheckIn(quartos.get(posicao).getId());
                            atualizarListaQuartos();
                            System.out.println("=========== A T E N Ç Ã O ================");
                            System.out.println("INSPEÇÃO CONCLUÍDA! Quarto retorna para OCUPADO");
                            System.out.println("==========================================");
                            break;
                        default: // Disponível (1), Sujo (3), Revisão (6)
                            dao.liberarQuarto(quartos.get(posicao).getId());
                            atualizarListaQuartos();
                            System.out.println("=========== A T E N Ç Ã O ================");
                            System.out.println("INSPEÇÃO CONCLUÍDA! Quarto retorna para DISPONÍVEL");
                            System.out.println("==========================================");
                            break;
                    }
                    System.out.println(" --- Pressione ENTER para continuar --- ");
                    teclado.nextLine();
                    teclado.nextLine();
                }

                // BLOCO B — Limpeza normal (status 4)
                
            } else {

                switch (origemLimpeza) {

                    case 3: // Pós-checkout
                        if (quartoLuxo) {
                            possuiDefeito = CheckList.executarCheckListPosCheckoutLuxo(teclado);
                        } else {
                            possuiDefeito = CheckList.executarCheckListPosCheckoutComum(teclado);
                        }
                        if (possuiDefeito) {
                            dao.bloquearManutencao(quartos.get(posicao).getId());
                            atualizarListaQuartos();
                            System.out.println("=========== A T E N Ç Ã O ================");
                            System.out.println("DEFEITO TÉCNICO DETECTADO DURANTE CHECK-OUT");
                            System.out.println("QUARTO EM MANUTENÇÃO - AGUARDANDO TÉCNICO");
                            System.out.println("===========================================");
                            System.out.println(" --- Pressione ENTER para continuar --- ");
                            teclado.nextLine();
                            teclado.nextLine();
                        }
                        break;

                    case 5: // Arrumação de quarto ocupado
                        if (quartoLuxo) {
                            possuiDefeito = CheckList.executarCheckListArrumacaoLuxo(teclado);
                        } else {
                            possuiDefeito = CheckList.executarCheckListArrumacaoComum(teclado);
                        }
                        if (possuiDefeito) {
                            dao.solicitarManutencaoUrgente(quartos.get(posicao).getId());
                            atualizarListaQuartos();
                            System.out.println("=========== A T E N Ç Ã O ================");
                            System.out.println("DEFEITO TÉCNICO DETECTADO DURANTE ARRUMAÇÃO");
                            System.out.println("QUARTO EM MANUTENÇÃO - URGENTE");
                            System.out.println("===========================================");
                            System.out.println(" --- Pressione ENTER para continuar --- ");
                            teclado.nextLine();
                            teclado.nextLine();
                        }
                        break;

                    case 6: // Revisão geral
                        if (quartoLuxo) {
                            possuiDefeito = CheckList.executarCheckListRevisaoGeralLuxo(teclado);
                        } else {
                            possuiDefeito = CheckList.executarCheckListRevisaoGeralComum(teclado);
                        }
                        if (possuiDefeito) {
                            dao.bloquearManutencao(quartos.get(posicao).getId());
                            atualizarListaQuartos();
                            System.out.println("=========== A T E N Ç Ã O ================");
                            System.out.println("DEFEITO TÉCNICO DETECTADO DURANTE INSPEÇÃO");
                            System.out.println("QUARTO EM MANUTENÇÃO - AGUARDANDO TÉCNICO");
                            System.out.println("===========================================");
                            System.out.println(" --- Pressione ENTER para continuar --- ");
                            teclado.nextLine();
                            teclado.nextLine();
                        }
                        break;
                }

                // Finalização da limpeza — apenas para status 4
                if (quartos.get(posicao).getIdStatus() != 7
                        && quartos.get(posicao).getIdStatus() != 8) {

                    System.out.println("Finalizar limpeza e liberar o quarto " + numQuarto + " ? (S/N) ");
                    resposta = teclado.next();

                    if (resposta.equalsIgnoreCase("S")) {
                        if (origemLimpeza == 5) {
                            dao.realizarCheckIn(quartos.get(posicao).getId());
                            atualizarListaQuartos();
                            System.out.println("=========== A T E N Ç Ã O ================");
                            System.out.println("Check-out NÃO DETECTADO! Quarto segue OCUPADO");
                            System.out.println("===========================================");
                            System.out.println(" --- Pressione ENTER para continuar --- ");
                            teclado.nextLine();
                            teclado.nextLine();
                        } else {
                            dao.liberarQuarto(quartos.get(posicao).getId());
                            atualizarListaQuartos();
                            System.out.println("=========== A T E N Ç Ã O ================");
                            System.out.println("O quarto " + numQuarto + " agora está DISPONÍVEL");
                            System.out.println("===========================================");
                            System.out.println(" --- Pressione ENTER para continuar --- ");
                            teclado.nextLine();
                            teclado.nextLine();
                        }
                    } else {
                        System.out.println("=========== A T E N Ç Ã O ================");
                        System.out.println("AVISO: Limpeza não finalizada! Quarto permanece EM LIMPEZA");
                        System.out.println("===========================================");
                        System.out.println(" --- Pressione ENTER para continuar --- ");
                        teclado.nextLine();
                        teclado.nextLine();
                    }
                }
            }

        } else {
            System.out.println("=========== A T E N Ç Ã O ================");
            System.out.println("Check-list NÃO iniciado! ");
            System.out.println("===========================================");
            System.out.println(" --- Pressione ENTER para continuar --- ");
            teclado.nextLine();
            teclado.nextLine();
        }
        
    } // Fechamento realizarInspecao();

    public static void main(String[] args) throws Exception {
        System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));

        do {
            quartos = dao.listarQuartos();
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
            validarTrava();

            switch (opcao) {
                case 1:
                    realizarCheckout();
                    break;
                case 2:
                    arrumacaoQuarto();
                    break;
                case 3:
                    iniciarLimpeza();
                    break;
                case 4:
                    realizarInspecao();
                    break;
                case 5:
                    realizarCheckin();
                    break;
                case 6:
                    iniciarRevisao();
                    break;
                case 7:
                    manutencaoTec();
                    break;
                case 8:
                    manutencaoGer();
                    break;
                case 0:
                    System.out.println("SISTEMA ENCERRADO");
                    break;
            }
        } while (opcao != 0);

    }

}
