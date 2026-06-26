package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.QuartoBean;

/**
 *
 * @author João Adôrno
 */
public class DAO {

    /* Módulo de conexão */
    // Parâmetros de conexão
    private String driver = "org.mariadb.jdbc.Driver";
    private String url = "jdbc:mariadb://127.0.0.1:3306/hotel_governance_system";
    private String user = "root";
    private String password = "";

    // Método de conexão
    public Connection conectar() {
        Connection con = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    // Teste de conexão 
    public void testeConexao() {
        try {
            Connection con = conectar();

            if (con != null) {
                System.out.println("Conectado com sucesso!");
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Método para listar os quartos
    public ArrayList<QuartoBean> listarQuartos() {

        ArrayList<QuartoBean> quartos = new ArrayList<>();

        String sql = """
            SELECT
                q.id_quarto,
                q.numero,
                q.andar,
                q.tamanho,
                q.id_status,
                q.id_tipo,
                q.id_modelo,
                q.id_status_anterior,
                q.id_origem_limpeza, 
                q.id_origem_manutencao,     
                s.descricao AS status,
                t.descricao AS tipo,
                m.descricao AS modelo
            FROM quartos q
                INNER JOIN status s ON q.id_status = s.id_status
                INNER JOIN tipo_quarto t ON q.id_tipo = t.id_tipo
                INNER JOIN modelo_quarto m ON q.id_modelo = m.id_modelo
            ORDER BY q.numero
                       """;

        try {
            Connection con = conectar();

            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_quarto");
                int numero = rs.getInt("numero");
                int andar = rs.getInt("andar");
                String tamanho = rs.getString("tamanho");
                int idStatus = rs.getInt("id_status");
                int idTipo = rs.getInt("id_tipo");
                int idModelo = rs.getInt("id_modelo");
                int idStatusAnterior = rs.getInt("id_status_anterior");
                String status = rs.getString("status");
                String tipo = rs.getString("tipo");
                String modelo = rs.getString("modelo");
                int idOrigemLimpeza = rs.getInt("id_origem_limpeza");
                int idOrigemManutencao = rs.getInt("id_origem_manutencao");

                QuartoBean quarto = new QuartoBean(id, numero, andar, tamanho,
                        idStatus, idTipo, idModelo, idStatusAnterior, 
                        idOrigemLimpeza, idOrigemManutencao);

                quarto.setStatusDescricao(status);
                quarto.setTipoDescricao(tipo);
                quarto.setModeloDescricao(modelo);

                quartos.add(quarto);
            }

            con.close();
            return quartos;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    // Método para realizar check out
    public void realizarCheckout(int idQuarto) {

        String sql = """
        UPDATE quartos
        SET 
            id_status_anterior = id_status,
            id_status = 3
        WHERE id_quarto = ?
    """;

        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, idQuarto);

            pst.executeUpdate();

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Métodos para limpeza
// Limpeza pós check-out    
    public void iniciarLimpezaPosCheckout(int idQuarto) {

        String sql = """
        UPDATE quartos
        SET  
            id_status = 4,
            id_origem_limpeza = 3         
        WHERE id_quarto = ?
    """;

        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, idQuarto);

            pst.executeUpdate();

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

// Limpeza arrumação   
    public void iniciarLimpezaArrumacao(int idQuarto) {

        String sql = """
        UPDATE quartos
        SET  
            id_status = 4,
            id_origem_limpeza = 5         
        WHERE id_quarto = ?
    """;

        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, idQuarto);

            pst.executeUpdate();

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

// Limpeza revisão    
    public void iniciarLimpezaRevisao(int idQuarto) {

        String sql = """
        UPDATE quartos
        SET  
            id_status = 4,
            id_origem_limpeza = 6         
        WHERE id_quarto = ?
    """;

        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, idQuarto);

            pst.executeUpdate();

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Método para realizar check in
    public void realizarCheckIn(int idQuarto) {

        String sql = """
        UPDATE quartos
        SET 
            id_status_anterior = id_status,
            id_status = 2,
            id_origem_limpeza = NULL,
            id_origem_manutencao = NULL
        WHERE id_quarto = ?
    """;

        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, idQuarto);

            pst.executeUpdate();

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Método para arrumação
    public void arrumacaoQuarto(int idQuarto) {

        String sql = """
        UPDATE quartos
        SET 
            id_status_anterior = id_status,
            id_status = 5
        WHERE id_quarto = ?
    """;

        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, idQuarto);

            pst.executeUpdate();

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Método para arrumação
    public void iniciarRevisao(int idQuarto) {

        String sql = """
        UPDATE quartos
        SET 
            id_status_anterior = id_status,
            id_status = 6
        WHERE id_quarto = ?
    """;

        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, idQuarto);

            pst.executeUpdate();

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Método para manutenção técnica
    public void manutencaoTec(int idQuarto) {

        String sql = """
        UPDATE quartos
        SET 
            id_origem_manutencao = id_status,
            id_status_anterior = id_status,
            id_status = 7
        WHERE id_quarto = ?
    """;

        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, idQuarto);

            pst.executeUpdate();

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Bloqueio para manutenção
    public void bloquearManutencao(int idQuarto) {

        String sql = """
        UPDATE quartos
        SET 
            id_status_anterior = id_status,
            id_status = 7
        WHERE id_quarto = ?
    """;

        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, idQuarto);
            pst.executeUpdate();

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

// Concluir manutenção     
    public void concluirManutencao(int idQuarto) {

        String sql = """
        UPDATE quartos
        SET 
            id_status_anterior = id_status,
            id_status = 9
        WHERE id_quarto = ?
    """;

        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, idQuarto);
            pst.executeUpdate();

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

// Manutenção urgente (quarto com hóspede)
    public void solicitarManutencaoUrgente(int idQuarto) {

        String sql = """
        UPDATE quartos
        SET 
            id_origem_manutencao = id_status,
            id_status_anterior = id_status,
            id_status = 8
        WHERE id_quarto = ?
    """;

        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, idQuarto);
            pst.executeUpdate();

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Método para liberar quarto
    public void liberarQuarto(int idQuarto) {

        String sql = """
        UPDATE quartos
        SET 
            id_status_anterior = id_status,
            id_status = 1,
            id_origem_limpeza = NULL,
            id_origem_manutencao = NULL
        WHERE id_quarto = ?
    """;

        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, idQuarto);
            pst.executeUpdate();

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

} // Fechamento da classe DAO
