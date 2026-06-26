
package hgs.jdbc.fase03.menudinamico;

import java.util.Scanner;

/**
 *
 * @author João Adôrno
 */

public abstract class Quarto {

    private int numero;
    private int andar;
    private int status;
    private int statusAnterior;
    private String tipo;
    private String modelo;
    private String tamanho;

    public Quarto(int numero, int andar, String tipo, String modelo, String tamanho) {

        this.numero = numero;
        this.andar = andar;

        this.tipo = tipo;
        this.modelo = modelo;
        this.tamanho = tamanho;

        this.status = 1;

        this.statusAnterior = 0;
    }

    public int getNumero() {
        return numero;
    }

    public int getAndar() {
        return andar;
    }

    public int getStatus() {
        return status;
    }

    public int getStatusAnterior() {
        return statusAnterior;
    }

    public String getTipo() {
        return tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public void setStatus(int novoStatus) {
        this.status = novoStatus;
    }

    public void setStatusComMemoria(int novoStatus) {
        this.statusAnterior = this.status;
        this.status = novoStatus;
    }

    public String getDescricaoStatus() {

        switch (status) {

            case 1:
                return "DISPONÍVEL";

            case 2:
                return "SUJO - Aguardando limpeza (II)";

            case 3:
                return "EM LIMPEZA - Aguardando finalização";

            case 4:
                return "OCUPADO - Não incomodar";

            case 5:
                return "ARRUMAÇÃO PENDENTE - Aguardando limpeza (I)";

            case 6:
                return "REVISÃO DE LONGA DATA - Aguardando limpeza (III)";

            case 7:
                return "EM MANUTENÇÃO - Aguardando liberação técnica";

            case 8:
                return "MANUTENÇÃO URGENTE - Acionar equipe";

            case 9:
                return "REVISÃO PÓS MANUTENÇÃO - Aguardando inspeção";

            default:
                return "STATUS DESCONHECIDO";
        }
    }
    
    public abstract boolean executarCheckListPosCheckout(Scanner teclado);
    
    public abstract boolean executarCheckListArrumacao(Scanner teclado);
    
    public abstract boolean executarCheckListRevisaoGeral(Scanner teclado);
    
    public void realizarCheckin() {
        setStatus(4);
}

    public void realizarCheckout() {
        setStatus(2);
}

    public void iniciarLimpeza() {
        setStatusComMemoria(3);
}

    public void solicitarArrumacao() {
        setStatus(5);
}

    public void solicitarRevisaoGeral() {
        setStatusComMemoria(6);
}

    public void bloquearManutencao() {
        setStatus(7);
}

    public void solicitarManutencaoUrgente() {
        setStatus(8);
}

    public void solicitarRevisaoPosManutencao() {
        setStatusComMemoria(9);
}

    public void liberarQuarto() {
        setStatus(1);
}
    


}