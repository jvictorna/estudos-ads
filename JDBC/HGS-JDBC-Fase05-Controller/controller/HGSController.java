package controller;

import dao.DAO;
import java.util.ArrayList;
import java.util.Scanner;
import model.QuartoBean;
import service.CheckList;

/**
 *
 * @author João Adôrno
 */
public class HGSController {

    // =========================================
    // ATRIBUTOS E CONSTRUTOR
    // =========================================
    private DAO dao;
    private ArrayList<QuartoBean> quartos;
    private Scanner teclado;

    public HGSController(DAO dao, Scanner teclado) {
        this.dao = dao;
        this.teclado = teclado;
        this.quartos = dao.listarQuartos();
    }

    // =========================================
    // GERENCIAMENTO DA LISTA
    // =========================================
    public void atualizarLista() {
        this.quartos = dao.listarQuartos();
    }

    public ArrayList<QuartoBean> getQuartos() {
        return quartos;
    }

    public int getPosicao(int numQuarto) {
        for (int i = 0; i < quartos.size(); i++) {
            if (quartos.get(i).getNumero() == numQuarto) {
                return i;
            }
        }
        return -1;
    }

    // =========================================
    // VALIDAÇÃO — TRAVAS DE SEGURANÇA
    // =========================================    
    // validarTrava()
    // =========================================    
    public int validarTrava(int opcao, int posicao) {
           
        if (opcao == -1 || posicao == -1) return opcao; 

        if (opcao == 1) {
            if (quartos.get(posicao).getIdStatus() != 2) {
                System.out.println("=============== A T E N Ç Ã O =================");
                System.out.println("ERRO: Este quarto não possui hóspede ");
                System.out.println("      CHECK-OUT NÃO PERMITIDO        ");
                System.out.println("===============================================");
                System.out.println(" --- Pressione ENTER para continuar --- ");
                teclado.nextLine();
                teclado.nextLine();
                return -1;
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
                            return -1;
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
                    return -1;
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
                return -1;
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
                return -1;
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
                return -1;
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
                return -1;
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
                return -1;
            }
        }
        return opcao;
    }
    // =========================================
    // FLUXO DE HOSPEDAGEM
    // =========================================    
    // - Realizar Checkin
    // - Realizar Checkout
    // =========================================
    // realizarCheckin()
    // =========================================    
    public void realizarCheckin(int posicao, int numQuarto) {
        dao.realizarCheckIn(
                quartos.get(posicao).getId());
        atualizarLista();

        System.out.println("=========== A T E N Ç Ã O ================");
        System.out.println("O quarto " + numQuarto + " está OCUPADO ");
        System.out.println("=========================================");
        System.out.println(" --- Pressione ENTER para continuar --- ");
        teclado.nextLine();
        teclado.nextLine();
    }
    // =========================================
    // realizarCheckout()
    // =========================================
    public void realizarCheckout(int posicao, int numQuarto) {
        dao.realizarCheckout(
                quartos.get(posicao).getId());
        atualizarLista();

        System.out.println("=========== A T E N Ç Ã O ================");
        System.out.println("    O quarto " + numQuarto + " foi definido como SUJO! ");
        System.out.println("        AGUARDANDO LIMPEZA           ");
        System.out.println("==========================================");
        System.out.println(" --- Pressione ENTER para continuar --- ");
        teclado.nextLine();
        teclado.nextLine();
    }

    // =========================================
    // FLUXO DE LIMPEZA
    // =========================================
    // - Arumação quarto
    // - Iniciar revisão
    // - Iniciar limpeza
    // - Realizar inspeção
    // =========================================
    // arrumacaoQuarto()
    // =========================================
    public void arrumacaoQuarto(int posicao, int numQuarto) {
        dao.arrumacaoQuarto(
                quartos.get(posicao).getId());
        atualizarLista();

        System.out.println("=========== A T E N Ç Ã O ================");
        System.out.println("O quarto " + numQuarto + " está com ARRUMAÇÃO PENDENTE");
        System.out.println("    AGUARDANDO INICIO DA LIMPEZA     ");
        System.out.println("==========================================");
        System.out.println("--- Pressione ENTER para continuar ---");
        teclado.nextLine();
        teclado.nextLine();
    }

    // =========================================    
    // iniciarRevisao()
    // =========================================    
    public void iniciarRevisao(int posicao, int numQuarto) {
        dao.iniciarRevisao(
                quartos.get(posicao).getId());
        atualizarLista();

        System.out.println("=========== A T E N Ç Ã O ================");
        System.out.println("O quarto " + numQuarto + " precisa de REVISÃO DE LONGA DATA ");
        System.out.println("     AGUARDANDO INICIO DA LIMPEZA         ");
        System.out.println("==========================================");
        System.out.println(" --- Pressione ENTER para continuar --- ");
        teclado.nextLine();
        teclado.nextLine();
    }

    // =========================================    
    // iniciarLimpeza()
    // =========================================    
    public void iniciarLimpeza(int posicao, int numQuarto) {
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

        atualizarLista();

        System.out.println("=========== A T E N Ç Ã O ================");
        System.out.println("A limpeza do quarto " + numQuarto + " foi INICIADA ");
        System.out.println("    AGUARDANDO LIBERAÇÃO DA CAMAREIRA     ");
        System.out.println("==========================================");
        System.out.println(" --- Pressione ENTER para continuar --- ");
        teclado.nextLine();
        teclado.nextLine();
    }

    // =========================================    
    // realizarInspecao()
    // =========================================    
    public void realizarInspecao(int posicao, int numQuarto) {
        
        String resposta;
        
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
                    atualizarLista();

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
                            atualizarLista();
                            System.out.println("=========== A T E N Ç Ã O ================");
                            System.out.println("INSPEÇÃO CONCLUÍDA! Quarto retorna para OCUPADO");
                            System.out.println("==========================================");
                            break;
                        default: // Disponível (1), Sujo (3), Revisão (6)
                            dao.liberarQuarto(quartos.get(posicao).getId());
                            atualizarLista();
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
                            atualizarLista();
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
                            atualizarLista();
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
                            atualizarLista();
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
                            atualizarLista();
                            System.out.println("=========== A T E N Ç Ã O ================");
                            System.out.println("Check-out NÃO DETECTADO! Quarto segue OCUPADO");
                            System.out.println("===========================================");
                            System.out.println(" --- Pressione ENTER para continuar --- ");
                            teclado.nextLine();
                            teclado.nextLine();
                        } else {
                            dao.liberarQuarto(quartos.get(posicao).getId());
                            atualizarLista();
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
    }
    
    // =========================================
    // FLUXO DE MANUTENÇÃO
    // =========================================    
    // - Manutenção tec
    // - Manutenção ger
    // =========================================
    // manutencaoTec()
    // =========================================    
    public void manutencaoTec(int posicao, int numQuarto) {
        dao.manutencaoTec(
                quartos.get(posicao).getId());
        atualizarLista();

        System.out.println("=========== A T E N Ç Ã O ================");
        System.out.println("Foi identificado um problema no quarto " + numQuarto);
        System.out.println("  QUARTO BLOQUEADO PARA MANUTENÇÃO TÉCNICA ");
        System.out.println("===========================================");
        System.out.println(" --- Pressione ENTER para continuar --- ");
        teclado.nextLine();
        teclado.nextLine();
    }

    // =========================================    
    // manutencaoGer()
    // =========================================    
    public void manutencaoGer(int posicao, int numQuarto) {
        if (quartos.get(posicao).getIdStatus() == 7
                || quartos.get(posicao).getIdStatus() == 8) {

            System.out.println(" === CONCLUSÃO DE MANUTENÇÃO DO QUARTO " + numQuarto + " === ");
            System.out.println("A manutenção foi concluída? (S/N) ");
            String resposta = teclado.next();
            teclado.nextLine();

            if (resposta.equalsIgnoreCase("S")) {
                dao.concluirManutencao(quartos.get(posicao).getId());
                atualizarLista();

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
    }

} // Fechamento da classe Controller
