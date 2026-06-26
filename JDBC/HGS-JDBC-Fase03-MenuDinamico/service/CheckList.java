package service;

import java.util.Scanner;

public class CheckList {

// Check-list para quarto comum    
    
    public static boolean executarCheckListPosCheckoutComum(Scanner teclado) {
        String cama, toalha, banheiro, enxoval, lixo, arCondicionado, televisao, frigobar;

        System.out.println("==========================================");
        System.out.println("          INSPEÇÃO DE GOVERNANÇA          ");
        System.out.println("  -  ARRUMAÇÃO DE QUARTO PÓS CHECK-OUT  - ");
        System.out.println("==========================================");

        do {
            System.out.print("[ ] Troca do Enxoval OK? (S/N) ....................: ");
            enxoval = teclado.next();
        } while (!enxoval.equalsIgnoreCase("S") && !enxoval.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] Arrumação da Cama OK? (S/N) ....................: ");
            cama = teclado.next();
        } while (!cama.equalsIgnoreCase("S") && !cama.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] Troca das Toalhas OK? (S/N) ....................: ");
            toalha = teclado.next();
        } while (!toalha.equalsIgnoreCase("S") && !toalha.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] Higienização do Banheiro OK? (S/N) ....................: ");
            banheiro = teclado.next();
        } while (!banheiro.equalsIgnoreCase("S") && !banheiro.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] Retirada do Lixo OK? (S/N) ....................: ");
            lixo = teclado.next();
        } while (!lixo.equalsIgnoreCase("S") && !lixo.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] Teste do Ar Condicionado OK? (S/N) ....................: ");
            arCondicionado = teclado.next();
        } while (!arCondicionado.equalsIgnoreCase("S") && !arCondicionado.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] Teste da Televisão OK? (S/N) ....................: ");
            televisao = teclado.next();
        } while (!televisao.equalsIgnoreCase("S") && !televisao.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] Teste do Frigobar OK? (S/N) ....................: ");
            frigobar = teclado.next();
        } while (!frigobar.equalsIgnoreCase("S") && !frigobar.equalsIgnoreCase("N"));

        System.out.println("==========================================");
        System.out.println("          CHECK LIST CONCLUÍDO!           ");
        System.out.println("==========================================");
        System.out.println(" --- Pressione ENTER para continuar --- ");
        teclado.nextLine();

        return arCondicionado.equalsIgnoreCase("N")
                || televisao.equalsIgnoreCase("N")
                || frigobar.equalsIgnoreCase("N");

    }

    public static boolean executarCheckListArrumacaoComum(Scanner teclado) {
        String cama, enxoval, toalha, banheiro, lixo, arCondicionado, televisao, frigobar;

        System.out.println("==========================================");
        System.out.println("          INSPEÇÃO DE GOVERNANÇA          ");
        System.out.println("      - ARRUMAÇÃO DE QUARTO OCUPADO -     ");
        System.out.println("==========================================");

        do {
            System.out.print("[ ] Arrumação da cama OK? (S/N) ....................: ");
            cama = teclado.next();
        } while (!cama.equalsIgnoreCase("S") && !cama.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] Troca de Enxoval OK? (S/N) ....................: ");
            enxoval = teclado.next();
        } while (!enxoval.equalsIgnoreCase("S") && !enxoval.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] Troca de Toalhas OK? (S/N) ....................: ");
            toalha = teclado.next();
        } while (!toalha.equalsIgnoreCase("S") && !toalha.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] Limpeza do Banheiro OK? (S/N) ....................: ");
            banheiro = teclado.next();
        } while (!banheiro.equalsIgnoreCase("S") && !banheiro.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] Retirada do Lixo OK? (S/N) ....................: ");
            lixo = teclado.next();
        } while (!lixo.equalsIgnoreCase("S") && !lixo.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] Ar Condicionado OK? (S/N) ....................: ");
            arCondicionado = teclado.next();
        } while (!arCondicionado.equalsIgnoreCase("S") && !arCondicionado.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] Televisão OK? (S/N) ....................: ");
            televisao = teclado.next();
        } while (!televisao.equalsIgnoreCase("S") && !televisao.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] Frigobar OK? (S/N) ....................: ");
            frigobar = teclado.next();
        } while (!frigobar.equalsIgnoreCase("S") && !frigobar.equalsIgnoreCase("N"));

        System.out.println("==========================================");
        System.out.println("          CHECK LIST CONCLUÍDO!           ");
        System.out.println("==========================================");
        System.out.println(" --- Pressione ENTER para continuar --- ");

        return arCondicionado.equalsIgnoreCase("N")
                || televisao.equalsIgnoreCase("N")
                || frigobar.equalsIgnoreCase("N");
    }

    public static boolean executarCheckListRevisaoGeralComum(Scanner teclado) {
        String cama, banheiro, cortina, lampada, arCondicionado, televisao, frigobar;

        System.out.println("==========================================");
        System.out.println("          INSPEÇÃO DE GOVERNANÇA          ");
        System.out.println("        - REVISÃO GERAL DETALHADA -       ");
        System.out.println("==========================================");

        do {
            System.out.print("[ ] JANELAS/CORTINA OK? (S/N) ....................: ");
            cortina = teclado.next();
        } while (!cortina.equalsIgnoreCase("S") && !cortina.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] HIGIENIZAÇÃO DO COLCHÃO OK? (S/N) ....................: ");
            cama = teclado.next();
        } while (!cama.equalsIgnoreCase("S") && !cama.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] TESTE DE LÂMPADAS/TOMADAS OK? (S/N) ....................: ");
            lampada = teclado.next();
        } while (!lampada.equalsIgnoreCase("S") && !lampada.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] HIGIENIZAÇÃO DO BANHEIRO OK? (S/N) ....................: ");
            banheiro = teclado.next();
        } while (!banheiro.equalsIgnoreCase("S") && !banheiro.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] TESTE DO AR CONDICIONADO OK? (S/N) ....................: ");
            arCondicionado = teclado.next();
        } while (!arCondicionado.equalsIgnoreCase("S") && !arCondicionado.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] TESTE DA TELEVISÃO OK? (S/N) ....................: ");
            televisao = teclado.next();
        } while (!televisao.equalsIgnoreCase("S") && !televisao.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] TESTE DO FRIGOBAR OK? (S/N) ....................: ");
            frigobar = teclado.next();
        } while (!frigobar.equalsIgnoreCase("S") && !frigobar.equalsIgnoreCase("N"));

        System.out.println("==========================================");
        System.out.println("          CHECK LIST CONCLUÍDO!           ");
        System.out.println("==========================================");
        System.out.println(" --- Pressione ENTER para continuar --- ");

        return arCondicionado.equalsIgnoreCase("N")
                || televisao.equalsIgnoreCase("N")
                || frigobar.equalsIgnoreCase("N");
    }
    
    // Check-list para quarto luxo         

    public static boolean executarCheckListPosCheckoutLuxo(Scanner teclado) {
        String cama, toalha, banheiro, enxoval, lixo, arCondicionado,
                televisao, frigobar, banheira, testeHidromassagem;

        System.out.println("==========================================");
        System.out.println("          INSPEÇÃO DE GOVERNANÇA          ");
        System.out.println("  -  ARRUMAÇÃO DE QUARTO PÓS CHECK-OUT  - ");
        System.out.println("==========================================");

        do {
            System.out.print("[ ] Troca do Enxoval OK? (S/N) ....................: ");
            enxoval = teclado.next();
        } while (!enxoval.equalsIgnoreCase("S") && !enxoval.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] Arrumação da Cama OK? (S/N) ....................: ");
            cama = teclado.next();
        } while (!cama.equalsIgnoreCase("S") && !cama.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] Troca das Toalhas OK? (S/N) ....................: ");
            toalha = teclado.next();
        } while (!toalha.equalsIgnoreCase("S") && !toalha.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] Higienização do Banheiro OK? (S/N) ....................: ");
            banheiro = teclado.next();
        } while (!banheiro.equalsIgnoreCase("S") && !banheiro.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] Retirada do Lixo OK? (S/N) ....................: ");
            lixo = teclado.next();
        } while (!lixo.equalsIgnoreCase("S") && !lixo.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] Higienização da Banheira OK? (S/N) ....................: ");
            banheira = teclado.next();
        } while (!banheira.equalsIgnoreCase("S") && !banheira.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] Teste do Ar Condicionado OK? (S/N) ....................: ");
            arCondicionado = teclado.next();
        } while (!arCondicionado.equalsIgnoreCase("S") && !arCondicionado.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] Teste da Televisão OK? (S/N) ....................: ");
            televisao = teclado.next();
        } while (!televisao.equalsIgnoreCase("S") && !televisao.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] Teste do Frigobar OK? (S/N) ....................: ");
            frigobar = teclado.next();
        } while (!frigobar.equalsIgnoreCase("S") && !frigobar.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] Teste da Hidromassagem OK? (S/N) ....................: ");
            testeHidromassagem = teclado.next();
        } while (!testeHidromassagem.equalsIgnoreCase("S") && !testeHidromassagem.equalsIgnoreCase("N"));

        System.out.println("==========================================");
        System.out.println("          CHECK LIST CONCLUÍDO!           ");
        System.out.println("==========================================");
        System.out.println(" --- Pressione ENTER para continuar --- ");

        return arCondicionado.equalsIgnoreCase("N")
                || televisao.equalsIgnoreCase("N")
                || frigobar.equalsIgnoreCase("N")
                || testeHidromassagem.equalsIgnoreCase("N");
    }

    public static boolean executarCheckListArrumacaoLuxo(Scanner teclado) {
        String cama, enxoval, toalha, banheiro, lixo, arCondicionado,
                televisao, frigobar, banheira, testeHidromassagem;

        System.out.println("==========================================");
        System.out.println("          INSPEÇÃO DE GOVERNANÇA          ");
        System.out.println("      - ARRUMAÇÃO DE QUARTO OCUPADO -     ");
        System.out.println("==========================================");

        do {
            System.out.print("[ ] Arrumação da cama OK? (S/N) ....................: ");
            cama = teclado.next();
        } while (!cama.equalsIgnoreCase("S") && !cama.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] Troca de Enxoval OK? (S/N) ....................: ");
            enxoval = teclado.next();
        } while (!enxoval.equalsIgnoreCase("S") && !enxoval.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] Troca de Toalhas OK? (S/N) ....................: ");
            toalha = teclado.next();
        } while (!toalha.equalsIgnoreCase("S") && !toalha.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] Limpeza do Banheiro OK? (S/N) ....................: ");
            banheiro = teclado.next();
        } while (!banheiro.equalsIgnoreCase("S") && !banheiro.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] Retirada do Lixo OK? (S/N) ....................: ");
            lixo = teclado.next();
        } while (!lixo.equalsIgnoreCase("S") && !lixo.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] Higienização da Banheira OK? (S/N) ....................: ");
            banheira = teclado.next();
        } while (!banheira.equalsIgnoreCase("S") && !banheira.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] Ar Condicionado OK? (S/N) ....................: ");
            arCondicionado = teclado.next();
        } while (!arCondicionado.equalsIgnoreCase("S") && !arCondicionado.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] Televisão OK? (S/N) ....................: ");
            televisao = teclado.next();
        } while (!televisao.equalsIgnoreCase("S") && !televisao.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] Frigobar OK? (S/N) ....................: ");
            frigobar = teclado.next();
        } while (!frigobar.equalsIgnoreCase("S") && !frigobar.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] Hidromassagem OK? (S/N) ....................: ");
            testeHidromassagem = teclado.next();
        } while (!testeHidromassagem.equalsIgnoreCase("S") && !testeHidromassagem.equalsIgnoreCase("N"));

        System.out.println("==========================================");
        System.out.println("          CHECK LIST CONCLUÍDO!           ");
        System.out.println("==========================================");
        System.out.println(" --- Pressione ENTER para continuar --- ");

        return arCondicionado.equalsIgnoreCase("N")
                || televisao.equalsIgnoreCase("N")
                || frigobar.equalsIgnoreCase("N")
                || testeHidromassagem.equalsIgnoreCase("N");

    }

    public static boolean executarCheckListRevisaoGeralLuxo(Scanner teclado) {
        String cama, banheiro, cortina, lampada, arCondicionado, televisao, 
                frigobar, banheira, testeHidromassagem;

        System.out.println("==========================================");
        System.out.println("          INSPEÇÃO DE GOVERNANÇA          ");
        System.out.println("        - REVISÃO GERAL DETALHADA -       ");
        System.out.println("==========================================");

        do {
            System.out.print("[ ] JANELAS/CORTINA OK? (S/N) ....................: ");
            cortina = teclado.next();
        } while (!cortina.equalsIgnoreCase("S") && !cortina.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] HIGIENIZAÇÃO DO COLCHÃO OK? (S/N) ....................: ");
            cama = teclado.next();
        } while (!cama.equalsIgnoreCase("S") && !cama.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] TESTE DE LÂMPADAS/TOMADAS OK? (S/N) ....................: ");
            lampada = teclado.next();
        } while (!lampada.equalsIgnoreCase("S") && !lampada.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] HIGIENIZAÇÃO DO BANHEIRO OK? (S/N) ....................: ");
            banheiro = teclado.next();
        } while (!banheiro.equalsIgnoreCase("S") && !banheiro.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] HIGIENIZAÇÃO DA BANHEIRA OK? (S/N) ....................: ");
            banheira = teclado.next();
        } while (!banheira.equalsIgnoreCase("S") && !banheira.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] TESTE DO AR CONDICIONADO OK? (S/N) ....................: ");
            arCondicionado = teclado.next();
        } while (!arCondicionado.equalsIgnoreCase("S") && !arCondicionado.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] TESTE DA TELEVISÃO OK? (S/N) ....................: ");
            televisao = teclado.next();
        } while (!televisao.equalsIgnoreCase("S") && !televisao.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] TESTE DO FRIGOBAR OK? (S/N) ....................: ");
            frigobar = teclado.next();
        } while (!frigobar.equalsIgnoreCase("S") && !frigobar.equalsIgnoreCase("N"));

        do {
            System.out.print("[ ] TESTE DA HIDROMASSAGEM OK? (S/N) ....................: ");
            testeHidromassagem = teclado.next();
        } while (!testeHidromassagem.equalsIgnoreCase("S") && !testeHidromassagem.equalsIgnoreCase("N"));

        System.out.println("==========================================");
        System.out.println("          CHECK LIST CONCLUÍDO!           ");
        System.out.println("==========================================");
        System.out.println(" --- Pressione ENTER para continuar --- ");

        return arCondicionado.equalsIgnoreCase("N")
                || televisao.equalsIgnoreCase("N")
                || frigobar.equalsIgnoreCase("N")
                || testeHidromassagem.equalsIgnoreCase("N");

    }

} // Fim da classe CheckList
