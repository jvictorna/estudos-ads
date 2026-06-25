
package hgs.jdbc.fase01.leituraquartos;

import java.util.Scanner;
import dao.DAO;
import java.util.ArrayList;
import model.QuartoBean;

/**
 * Sistema de Governança Hoteleira
 * Controle de status e limpeza de quartos
 * Desenvolvido como projeto prático do curso de ADS
 * 
 * @author João Adorno
 * @version 3.1
 */

public class HGSJDBCFase01LeituraQuartos {
    
        static int opcao, numQuarto, opcaoManut, posicao;

    static String resposta;

    static Scanner teclado = new Scanner(System.in);
       
    static Quarto[] quartos = new Quarto[38]; 
    
    static void inicializarQuartos() {
    
    quartos[0] = new QuartoComum(2, 0, "Standard Sem Varanda", "Triplo", "Pequeno"); 
    quartos[1] = new QuartoComum(3, 0, "Standard Sem Varanda", "Triplo" , "Pequeno");
    quartos[2] = new QuartoComum(4, 0, "Standard Sem Varanda", "Triplo", "Pequeno");
    quartos[3] = new QuartoComum(5, 0, "Standard Sem Varanda", "Casal", "Pequeno");
    quartos[4] = new QuartoComum(101, 1, "Varanda Lateral", "Casal", "Médio");
    quartos[5] = new QuartoComum(102, 1, "Varanda Lateral", "Casal", "Médio");
    quartos[6] = new QuartoComum(103, 1, "Varanda Lateral", "Casal", "Médio");
    quartos[7] = new QuartoComum(104, 1, "Varanda Lateral", "Casal", "Médio");
    quartos[8] = new QuartoComum(105, 1, "Varanda Lateral", "Casal", "Médio");
    quartos[9] = new QuartoComum(106, 1, "Varanda Lateral", "Casal", "Médio");
    quartos[10] = new QuartoComum(107, 1, "Varanda Lateral", "Casal", "Médio");
    quartos[11] = new QuartoComum(108, 1, "Varanda Frente Mar", "Casal", "Médio");
    quartos[12] = new QuartoComum(109, 1, "Varanda Frente Mar", "Casal", "Médio");
    quartos[13] = new QuartoComum(110, 1, "Standard Sem Varanda", "Quádruplo", "Extra Grande");
    quartos[14] = new QuartoComum(111, 1, "Standard Sem Varanda", "Quádruplo", "Extra Grande");
    quartos[15] = new QuartoComum(112, 1, "Standard Sem Varanda", "Quíntuplo", "Extra Grande");
    quartos[16] = new QuartoComum(201, 2, "Varanda Lateral", "Casal", "Médio");
    quartos[17] = new QuartoComum(202, 2, "Varanda Lateral", "Casal", "Médio");
    quartos[18] = new QuartoComum(203, 2, "Varanda Lateral", "Triplo", "Médio");
    quartos[19] = new QuartoComum(204, 2, "Varanda Lateral", "Triplo", "Médio");
    quartos[20] = new QuartoComum(205, 2, "Varanda Lateral", "Triplo", "Médio");
    quartos[21] = new QuartoComum(206, 2, "Varanda Lateral", "Triplo", "Médio");
    quartos[22] = new QuartoComum(207, 2, "Varanda Lateral", "Triplo", "Médio");
    quartos[23] = new QuartoLuxo(208, 2, "Luxo Varanda Frente Mar", "Casal", "Grande", true);
    quartos[24] = new QuartoComum(209, 2, "Standard Sem Varanda", "Quádruplo", "Extra Grande");
    quartos[25] = new QuartoComum(210, 2, "Standard Sem Varanda", "Quádruplo", "Extra Grande");
    quartos[26] = new QuartoComum(211, 2, "Standard Sem Varanda", "Quíntuplo", "Extra Grande");
    quartos[27] = new QuartoComum(301, 3, "Standard Sem Varanda", "Quíntuplo", "Extra Grande");
    quartos[28] = new QuartoComum(302, 3, "Standard Sem Varanda", "Triplo", "Pequeno");
    quartos[29] = new QuartoComum(303, 3, "Standard Sem Varanda", "Casal", "Pequeno");
    quartos[30] = new QuartoComum(304, 3, "Standard Sem Varanda", "Casal", "Pequeno");
    quartos[31] = new QuartoLuxo(305, 3, "Luxo Sem Varanda", "Casal", "Grande", true);
    quartos[32] = new QuartoComum(306, 3, "Standard Sem Varanda", "Casal", "Pequeno");
    quartos[33] = new QuartoComum(307, 3, "Varanda Frente Mar", "Triplo", "Médio");
    quartos[34] = new QuartoComum(308, 3, "Varanda Frente Mar", "Triplo", "Médio");
    quartos[35] = new QuartoComum(309, 3, "Standard Sem Varanda", "Quádruplo", "Extra Grande");
    quartos[36] = new QuartoComum(310, 3, "Standard Sem Varanda", "Quádruplo", "Extra Grande");
    quartos[37] = new QuartoComum(311, 3, "Standard Sem Varanda", "Quíntuplo", "Extra Grande");
    }


    
static void cabecalhoInicio(){    
        System.out.println("=========================================");
        System.out.println("          SISTEMA DE GOVERNANÇA          ");
        System.out.println("=========================================");  
        
} // Fechamento cabecalhoInicio();

static void exibirQuartos() {
    
       System.out.println("========================================="); 
       System.out.println("                T E R R E O              ");
       System.out.println("========================================="); 
       
   for (int i = 0; i < 4; i++) {
       
       System.out.println(
               "Quarto " 
               + quartos[i].getNumero()
               +": " 
               + quartos[i].getDescricaoStatus() );    
   }
   
       System.out.println("========================================="); 
       System.out.println("              1º A N D A R               ");
       System.out.println("========================================="); 
       
    for (int i = 4; i < 16; i++) {
        
        System.out.println(
                "Quarto "
                + quartos[i].getNumero() 
                + ": "
                + quartos[i].getDescricaoStatus() );
       
        }
    
       System.out.println("========================================="); 
       System.out.println("              2º A N D A R               ");
       System.out.println("========================================="); 
       
    for (int i = 16; i < 27; i++) {
        
        System.out.println(
                "Quarto " 
                + quartos[i].getNumero() 
                + ": "
                + quartos[i].getDescricaoStatus() );
    }

       System.out.println("========================================="); 
       System.out.println("              3º A N D A R               ");
       System.out.println("========================================="); 
       
    for (int i = 27; i <= 37; i++) {
        
        System.out.println(
                "Quarto " 
                + quartos[i].getNumero() 
                + ": "
                + quartos[i].getDescricaoStatus() );   
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
        
        for (int i = 0; i < 38; i++) {
            if (quartos[i].getNumero() == numQuarto) {
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
    if (opcao == -1 || posicao == -1) return;
    
    if (opcao == 1) {
        if (quartos[posicao].getStatus() != 4) {
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
        if (quartos[posicao].getStatus() != 2) {
            if (quartos[posicao].getStatus() != 5) {
                if (quartos[posicao].getStatus() != 6) {
                    if (quartos[posicao].getStatus() != 9) {
            System.out.println("=========== A T E N Ç Ã O ================");
            System.out.println("ERRO: A limpeza não pode ser iniciada agora!");
                       if (quartos[posicao].getStatus() == 4) {
                              System.out.println("MOTIVO: O quarto está OCUPADO! ");
                              System.out.println("Solicite primeiro a ARRUMAÇÃO PENDENTE (OPÇÃO 5)");
                       } else { System.out.println("MOTIVO: O quarto esta LIMPO ou DISPONÍVEL"); 
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
        if (quartos[posicao].getStatus() != 3) {
            if (quartos[posicao].getStatus() != 9) {
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
        if (quartos[posicao].getStatus() != 4) {
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
        if (quartos[posicao].getStatus() != 1) {
            System.out.println("=========== A T E N Ç Ã O ================");
            System.out.println("ERRO: Check-in não permitido! ");
            if (quartos[posicao].getStatus() == 4) {
                System.out.println("MOTIVO: O quarto já encontra-se OCUPADO ");                
            } else { System.out.println("MOTIVO: O quarto NÃO está DISPONÍVEL  "); }
            System.out.println("===========================================");
            System.out.println(" --- Pressione ENTER para continuar --- ");
            teclado.nextLine();
            teclado.nextLine();
            opcao = -1;
        }
    }
    
    if (opcao == 6) {
        if (quartos[posicao].getStatus() != 1) {
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
        if (quartos[posicao].getStatus() == 7 || (quartos[posicao].getStatus() == 8)) {
            System.out.println("=========== A T E N Ç Ã O ================");
            System.out.println("ERRO: Quarto já encontra-se em MANUTENÇÃO! ");
            System.out.println("===========================================");
            System.out.println(" --- Pressione ENTER para continuar --- ");
            teclado.nextLine();
            teclado.nextLine();
            opcao = -1; 
        }
    }
    
    if (opcao == 8) {
        if (quartos[posicao].getStatus() != 7 && (quartos[posicao].getStatus() != 8)) {
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
    
    quartos[posicao].realizarCheckout();
    
    System.out.println("=========== A T E N Ç Ã O ================");
    System.out.println("    O quarto " + numQuarto + " foi definido como SUJO! ");
    System.out.println("        AGUARDANDO LIMPEZA           ");
    System.out.println("==========================================");
    System.out.println(" --- Pressione ENTER para continuar --- ");
    teclado.nextLine();
    teclado.nextLine();
    
} // Fechamento do realizarCheckout(); 

static void realizarLimpeza() {
    
    quartos[posicao].iniciarLimpeza();
    
    System.out.println("=========== A T E N Ç Ã O ================");
    System.out.println("A limpeza do quarto " + numQuarto + " foi INICIADA ");
    System.out.println("    AGUARDANDO LIBERAÇÃO DA CAMAREIRA     ");
    System.out.println("==========================================");
    System.out.println(" --- Pressione ENTER para continuar --- ");
    teclado.nextLine();
    teclado.nextLine();
    
} // Fechamento realizarLimpeza();

static void realizarCheckin() {
    
    quartos[posicao].realizarCheckin();
    
    System.out.println("=========== A T E N Ç Ã O ================");
    System.out.println("O quarto " + numQuarto + " está OCUPADO ");
    System.out.println("=========================================");
    System.out.println(" --- Pressione ENTER para continuar --- ");
    teclado.nextLine();
    teclado.nextLine();
    
} // Fechamento realizarCheckin(); 

static void arrumacaoQuarto() {
    
    quartos[posicao].solicitarArrumacao();
    
    System.out.println("=========== A T E N Ç Ã O ================");
    System.out.println("O quarto " + numQuarto + " está com ARRUMAÇÃO PENDENTE");
    System.out.println("    AGUARDANDO INICIO DA LIMPEZA     ");
    System.out.println("==========================================");
    System.out.println("--- Pressione ENTER para continuar ---");
    teclado.nextLine();
    teclado.nextLine();
} // Fechamento arrumacaoQuarto(); 

static void realizarRevisao() {
    
    quartos[posicao].solicitarRevisaoGeral();
    
    System.out.println("=========== A T E N Ç Ã O ================");
    System.out.println("O quarto " + numQuarto + " precisa de REVISÃO DE LONGA DATA ");
    System.out.println("     AGUARDANDO INICIO DA LIMPEZA         ");
    System.out.println("==========================================");
    System.out.println(" --- Pressione ENTER para continuar --- ");
    teclado.nextLine();
    teclado.nextLine();
    
} // Fechamento realizarRevisao();

static void manutencaoTec() {
    
    quartos[posicao].bloquearManutencao();
    
    System.out.println("=========== A T E N Ç Ã O ================");
    System.out.println("Foi identificado um problema no quarto " + numQuarto );
    System.out.println("  QUARTO BLOQUEADO PARA MANUTENÇÃO TÉCNICA ");
    System.out.println("===========================================");
    System.out.println(" --- Pressione ENTER para continuar --- ");
    teclado.nextLine();
    teclado.nextLine();
    
    
} // Fechamento manutencaoTec();

static void manutencaoGer() {
    
    if (quartos[posicao].getStatus() == 7 || quartos[posicao].getStatus() == 8) {
        
        System.out.println(" === CONCLUSÃO DE MANUTENÇÃO DO QUARTO " + numQuarto + " === ");
        System.out.println("1. Manutenção em quarto COM HÓSPEDE ");
        System.out.println("2. Manutenção em quarto VAZIO ");
        System.out.println("3. Manutenção concluída ");
        System.out.println("");
        System.out.println("INDIQUE A OPÇÃO ADEQUADA: ");
        opcaoManut = teclado.nextInt();
        teclado.nextLine();
        
        switch (opcaoManut) { 
            
            case 1: 
                quartos[posicao].realizarCheckin();
                
                System.out.println("=========== S U C E S S O ================");
                System.out.println("       MANUTENÇÃO FINALIZADA              ");
                System.out.println("==========================================");
                System.out.println(" --- Pressione ENTER para continuar --- ");
                teclado.nextLine();
                
            break;
            
            case 2: 
                quartos[posicao].liberarQuarto();
                
                System.out.println("=========== S U C E S S O ================");
                System.out.println("       MANUTENÇÃO FINALIZADA              ");
                System.out.println("==========================================");
                System.out.println(" --- Pressione ENTER para continuar --- ");
                teclado.nextLine();
                
            break; 
            
            case 3: 
                quartos[posicao].solicitarRevisaoPosManutencao();
                
                System.out.println("=========== S U C E S S O ================");
                System.out.println("       MANUTENÇÃO FINALIZADA              ");
                System.out.println("==========================================");
                System.out.println("=========== A T E N Ç Ã O ================");
                System.out.println("    AGUARDANDO INSPEÇÃO DA GOVERNANÇA     ");
                System.out.println("==========================================");
                teclado.nextLine();
                
            break;
            
            default: System.out.println("ERRO: Verifique a opção digitada e tente novamente ");
                
        } // Fechamento switch              
    } // Fechamento if inicial    
} // Fechamento manutencaoGer();

static void realizarInspecao() {
     
    int statusAnterior = quartos[posicao].getStatusAnterior();
    
    System.out.println("Deseja iniciar a INSPEÇÃO do quarto " + numQuarto + " ? (S/N) ");
    resposta = teclado.next();
    
        if (resposta.equalsIgnoreCase("S")) {
            
            boolean possuiDefeito = false;
            
            if (quartos[posicao].getStatus() == 9) {
                possuiDefeito = quartos[posicao].executarCheckListRevisaoGeral(teclado);
                if (possuiDefeito) {
                    quartos[posicao].bloquearManutencao();
                    System.out.println("=========== A T E N Ç Ã O ================");
                    System.out.println("DEFEITO TÉCNICO DETECTADO APÓS MANUTENÇÃO ");
                    System.out.println("QUARTO IRÁ RETORNAR PARA MANUTENÇÃO TÉCNICA ");
                    System.out.println("===========================================");
                    System.out.println(" --- Pressione ENTER para continuar --- ");
                    teclado.nextLine();
                    teclado.nextLine();
                }
            } else {
                
                switch (statusAnterior) {
                    
                    case 2: 
                        possuiDefeito = quartos[posicao].executarCheckListPosCheckout(teclado);
                        
                        if (possuiDefeito) {
                            quartos[posicao].bloquearManutencao();
                            System.out.println("=========== A T E N Ç Ã O ================");
                            System.out.println("DEFEITO TÉCNICO DETECTADO DURANTE CHECK-OUT");
                            System.out.println("QUARTO EM MANUTENÇÃO - AGUARDANDO TÉCNICO");
                            System.out.println("===========================================");
                            System.out.println(" --- Pressione ENTER para continuar --- ");
                            teclado.nextLine();
                            teclado.nextLine();
                        }
                        break;
                        
                    case 5: 
                        possuiDefeito = quartos[posicao].executarCheckListArrumacao(teclado);
                        
                        if (possuiDefeito) {
                            quartos[posicao].solicitarManutencaoUrgente();
                            System.out.println("=========== A T E N Ç Ã O ================");
                            System.out.println("DEFEITO TÉCNICO DETECTADO DURANTE ARRUMAÇÃO");
                            System.out.println("QUARTO EM MANUTENÇÃO - URGENTE - ");
                            System.out.println("===========================================");
                            System.out.println(" --- Pressione ENTER para continuar --- ");
                            teclado.nextLine();
                            teclado.nextLine();
                        }
                        break;
                    case 6: 
                        possuiDefeito = quartos[posicao].executarCheckListRevisaoGeral(teclado);
                        
                        if (possuiDefeito) {
                            quartos[posicao].bloquearManutencao();
                            System.out.println("=========== A T E N Ç Ã O ================");
                            System.out.println("DEFEITO TÉCNICO DETECTADO DURANTE INSPEÇÃO");
                            System.out.println("QUARTO EM MANUTENÇÃO - AGUARDANDO TÉCNICO ");
                            System.out.println("===========================================");
                            System.out.println(" --- Pressione ENTER para continuar --- ");
                            teclado.nextLine();
                            teclado.nextLine();
                        }
                        break;
                }
            }    

         if (quartos[posicao].getStatus() != 7 && quartos[posicao].getStatus() != 8) {
             System.out.println("Finalizar limpeza e liberar o quarto " + numQuarto + " ? (S/N) ");
             resposta = teclado.next();
             
                if (resposta.equalsIgnoreCase("S")) {
                    if (statusAnterior == 5) {
                        quartos[posicao].realizarCheckin();
                        System.out.println("=========== A T E N Ç Ã O ================");
                        System.out.println("Check-out NÃO DETECTADO! Quarto segue OCUPADO ");
                        System.out.println("===========================================");
                        System.out.println(" --- Pressione ENTER para continuar --- ");
                         teclado.nextLine();
                         teclado.nextLine();
                    } else { 
                             quartos[posicao].liberarQuarto();
                             System.out.println("=========== A T E N Ç Ã O ================");
                             System.out.println("O quarto " + numQuarto + " agora está DISPONÍVEL ");
                             System.out.println("===========================================");
                             System.out.println(" --- Pressione ENTER para continuar --- ");
                             teclado.nextLine();
                             teclado.nextLine(); }
                } else {
                         System.out.println("=========== A T E N Ç Ã O ================");
                         System.out.println("AVISO: Limpeza não finalizada! Quarto permanece EM LIMPEZA ");
                         System.out.println("===========================================");
                         System.out.println(" --- Pressione ENTER para continuar --- ");
                         teclado.nextLine();
                         teclado.nextLine(); }
                }                       
        }  else {
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
        
    inicializarQuartos(); 
     do {
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
            case 1: realizarCheckout(); break;
            case 2: arrumacaoQuarto(); break;
            case 3: realizarLimpeza(); break;
            case 4: realizarInspecao(); break;
            case 5: realizarCheckin(); break;
            case 6: realizarRevisao(); break;
            case 7: manutencaoTec(); break;
            case 8: manutencaoGer(); break;
            case 0: System.out.println("SISTEMA ENCERRADO"); break;
        }       
    } while (opcao != 0);
        
DAO dao = new DAO();

ArrayList<QuartoBean> quartosBanco = dao.listarQuartos();

for (QuartoBean q : quartosBanco) {
    System.out.println(
        q.getNumero() + " | " +
        q.getAndar() + " | " +
        q.getTamanho() + " | " +
        q.getIdTipo() + " | " +
        q.getIdModelo() + " | " +
        q.getIdStatus()
    );
}
    

    }
    
}
