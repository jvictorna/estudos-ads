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

    private String statusDescricao;
    private String tipoDescricao;
    private String modeloDescricao;

    private int idStatus;
    private int idTipo;
    private int idModelo;
    private int idStatusAnterior;
    private int idOrigemLimpeza;
    private int idOrigemManutencao;

    public QuartoBean() {
    }

    public QuartoBean(int id, int numero, int andar, String tamanho,
            int idStatus, int idTipo, int idModelo, int idStatusAnterior, 
            int idOrigemLimpeza, int idOrigemManutencao) {
        this.id = id;
        this.numero = numero;
        this.andar = andar;
        this.tamanho = tamanho;
        this.idStatus = idStatus;
        this.idTipo = idTipo;
        this.idModelo = idModelo;
        this.idStatusAnterior = idStatusAnterior;
        this.idOrigemLimpeza = idOrigemLimpeza;
        this.idOrigemManutencao = idOrigemManutencao;
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

    public String getStatusDescricao() {
        return statusDescricao;
    }

    public void setStatusDescricao(String statusDescricao) {
        this.statusDescricao = statusDescricao;
    }

    public String getTipoDescricao() {
        return tipoDescricao;
    }

    public void setTipoDescricao(String tipoDescricao) {
        this.tipoDescricao = tipoDescricao;
    }

    public String getModeloDescricao() {
        return modeloDescricao;
    }

    public void setModeloDescricao(String modeloDescricao) {
        this.modeloDescricao = modeloDescricao;
    }

    public int getIdStatusAnterior() {
        return idStatusAnterior;
    }

    public void setIdStatusAnterior(int idStatusAnterior) {
        this.idStatusAnterior = idStatusAnterior;
    }

    public int getIdOrigemLimpeza() {
        return idOrigemLimpeza;
    }

    public void setIdOrigemLimpeza(int idOrigemLimpeza) {
        this.idOrigemLimpeza = idOrigemLimpeza;
    }

    public int getIdOrigemManutencao() {
        return idOrigemManutencao;
    }

    public void setIdOrigemManutencao(int idOrigemManutencao) {
        this.idOrigemManutencao = idOrigemManutencao;
    }

} // Fechamento da classe QuartoBean
