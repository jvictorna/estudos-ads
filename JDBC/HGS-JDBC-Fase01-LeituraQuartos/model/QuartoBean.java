package model;

/**
 *
 * @author João Adôrno
 */

public class QuartoBean {

    private int id;
    private int numero;
    private int andar;
    private String tamanho;

    private int idStatus;
    private int idTipo;
    private int idModelo;
    private int idStatusAnterior;

    public QuartoBean() {
    }

    public QuartoBean(int id, int numero, int andar, String tamanho, 
            int idStatus, int idTipo, int idModelo, int idStatusAnterior) {
        this.id = id;
        this.numero = numero;
        this.andar = andar;
        this.tamanho = tamanho;
        this.idStatus = idStatus;
        this.idTipo = idTipo; 
        this.idModelo = idModelo;
        this.idStatusAnterior = idStatusAnterior; 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public int getIdStatusAnterior() {
        return idStatusAnterior;
    }

    public void setIdStatusAnterior(int idStatusAnterior) {
        this.idStatusAnterior = idStatusAnterior;
    }
    
    
} // Fechamento da classe model
