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

    // =========================================
    // MÓDULO DE CONEXÃO
    // =========================================
    private String driver = "org.mariadb.jdbc.Driver";
    private String url = "jdbc:mariadb://127.0.0.1:3306/hotel_governance_system";
    private String user = "root";
    private String password = "";

    // =========================================
    // conectar()
    // =========================================
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

    // =========================================
    // testeConexao()
    // =========================================
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

    // =========================================
    // LEITURA
    // =========================================
    // listarQuartos()
    // =========================================
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
                q.data_ultima_saida,     
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
                String dataUltimaSaida = rs.getString("data_ultima_saida");

                QuartoBean quarto = new QuartoBean(id, numero, andar, tamanho,
                        idStatus, idTipo, idModelo, idStatusAnterior,
                        idOrigemLimpeza, idOrigemManutencao);

                quarto.setStatusDescricao(status);
                quarto.setTipoDescricao(tipo);
                quarto.setModeloDescricao(modelo);
                quarto.setDataUltimaSaida(dataUltimaSaida);

                quartos.add(quarto);
            }

            con.close();
            return quartos;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    // =========================================
    // FLUXO DE HOSPEDAGEM
    // =========================================
    // - realizarCheckout()
    // - realizarCheckIn()
    // =========================================
    // realizarCheckout()
    // =========================================
    public void realizarCheckout(int idQuarto, int numeroQuarto) {

        String sql = """
        UPDATE quartos
        SET 
            id_status_anterior = id_status,
            id_status = 3,
            data_ultima_saida = NOW()
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

        registrarHistorico(idQuarto, numeroQuarto, 2, 3, "CHECKOUT");
    }

    // =========================================
    // realizarCheckIn()
    // =========================================
    public void realizarCheckIn(int idQuarto, int numeroQuarto) {

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

        registrarHistorico(idQuarto, numeroQuarto, 1, 2, "CHECKIN");
    }

    // =========================================
    // FLUXO DE LIMPEZA
    // =========================================
    // - arrumacaoQuarto()
    // - iniciarRevisao()
    // - iniciarLimpezaPosCheckout()
    // - iniciarLimpezaArrumacao()
    // - iniciarLimpezaRevisao()
    // - liberarQuarto()
    // =========================================
    // arrumacaoQuarto()
    // =========================================
    public void arrumacaoQuarto(int idQuarto, int numeroQuarto) {

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

        registrarHistorico(idQuarto, numeroQuarto, 2, 5, "ARRUMACAO");
    }

    // =========================================
    // iniciarRevisao()
    // =========================================
    public void iniciarRevisao(int idQuarto, int numeroQuarto) {

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

        registrarHistorico(idQuarto, numeroQuarto, 1, 6, "REVISAO_GERAL");
    }

    // =========================================
    // iniciarLimpezaPosCheckout()
    // =========================================
    public void iniciarLimpezaPosCheckout(int idQuarto, int numeroQuarto) {

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

        registrarHistorico(idQuarto, numeroQuarto, 3, 4, "LIMPEZA_POS_CHECKOUT");
    }

    // =========================================
    // iniciarLimpezaArrumacao()
    // =========================================
    public void iniciarLimpezaArrumacao(int idQuarto, int numeroQuarto) {

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

        registrarHistorico(idQuarto, numeroQuarto, 5, 4, "LIMPEZA_ARRUMACAO");
    }

    // =========================================
    // iniciarLimpezaRevisao()
    // =========================================
    public void iniciarLimpezaRevisao(int idQuarto, int numeroQuarto) {

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

        registrarHistorico(idQuarto, numeroQuarto, 6, 4, "LIMPEZA_REVISAO");
    }

    // =========================================
    // liberarQuarto()
    // =========================================
    public void liberarQuarto(int idQuarto, int numeroQuarto) {

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

        registrarHistorico(idQuarto, numeroQuarto, 0, 1, "LIBERACAO");
    }

    // =========================================
    // FLUXO DE MANUTENÇÃO
    // =========================================
    // - manutencaoTec()
    // - solicitarManutencaoUrgente()
    // - bloquearManutencao()
    // - concluirManutencao()
    // =========================================
    // manutencaoTec()
    // =========================================
    public void manutencaoTec(int idQuarto, int numeroQuarto, 
                              int statusAnterior) {

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

        registrarHistorico(idQuarto, numeroQuarto, statusAnterior, 7, "MANUTENCAO_TEC");
    }

    // =========================================
    // solicitarManutencaoUrgente()
    // =========================================
    public void solicitarManutencaoUrgente(int idQuarto, int numeroQuarto,
                                           int statusAnterior) {

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

        registrarHistorico(idQuarto, numeroQuarto, statusAnterior, 8, "MANUTENCAO_URGENTE");
    }

    // =========================================
    // bloquearManutencao()
    // =========================================
    public void bloquearManutencao(int idQuarto, int numeroQuarto, 
                                   int statusAnterior) {

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

        registrarHistorico(idQuarto, numeroQuarto, statusAnterior, 7, "BLOQUEIO_MANUTENCAO");
    }

    // =========================================
    // concluirManutencao()
    // =========================================
    public void concluirManutencao(int idQuarto, int numeroQuarto) {

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

        registrarHistorico(idQuarto, numeroQuarto, 0, 9, "CONCLUSAO_MANUTENCAO");
    }

    // =========================================
    // HISTÓRICO
    // =========================================
    // registrarHistorico()
    // =========================================
    public void registrarHistorico(int idQuarto, int numeroQuarto,
            int idStatusAnterior, int idStatusNovo, String tipoOperacao) {

        String sql = """
        INSERT INTO historico_operacoes 
        (id_quarto, numero_quarto, id_status_anterior, id_status_novo, tipo_operacao)
        VALUES (?, ?, ?, ?, ?)
    """;

        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idQuarto);
            pst.setInt(2, numeroQuarto);
            pst.setInt(3, idStatusAnterior);
            pst.setInt(4, idStatusNovo);
            pst.setString(5, tipoOperacao);
            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // =========================================
    // RELATÓRIOS
    // =========================================
    // relatorioOcupacaoPorAndar()
    // =========================================
    public void relatorioOcupacaoPorAndar() {

        String sql = """
        SELECT 
            q.andar,
            COUNT(*) AS total,
            SUM(CASE WHEN q.id_status = 2 THEN 1 ELSE 0 END) AS ocupados,
            SUM(CASE WHEN q.id_status = 1 THEN 1 ELSE 0 END) AS disponiveis,
            SUM(CASE WHEN q.id_status NOT IN (1, 2) THEN 1 ELSE 0 END) AS outros
        FROM quartos q
        GROUP BY q.andar
        ORDER BY q.andar
    """;

        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            System.out.println("=========================================");
            System.out.println("       OCUPAÇÃO ATUAL POR ANDAR          ");
            System.out.println("=========================================");

            while (rs.next()) {
                int andar = rs.getInt("andar");
                int total = rs.getInt("total");
                int ocupados = rs.getInt("ocupados");
                int disponiveis = rs.getInt("disponiveis");
                int outros = rs.getInt("outros");

                String nomeAndar = andar == 0 ? "Térreo" : andar + "º Andar";

                System.out.println(nomeAndar + ":");
                System.out.println("  Total de quartos : " + total);
                System.out.println("  Ocupados         : " + ocupados);
                System.out.println("  Disponíveis      : " + disponiveis);
                System.out.println("  Outros status    : " + outros);
                System.out.println("-----------------------------------------");
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // =========================================
    // relatorioQuartosEmManutencao()
    // =========================================
    public void relatorioQuartosEmManutencao() {

        String sql = """
        SELECT 
            q.numero,
            q.andar,
            s.descricao AS status,
            q.data_ultima_saida
        FROM quartos q
            INNER JOIN status s ON q.id_status = s.id_status
        WHERE q.id_status IN (7, 8, 9)
        ORDER BY q.andar, q.numero
    """;

        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            System.out.println("=========================================");
            System.out.println("        QUARTOS EM MANUTENÇÃO            ");
            System.out.println("=========================================");

            boolean encontrou = false;

            while (rs.next()) {
                encontrou = true;
                int numero = rs.getInt("numero");
                int andar = rs.getInt("andar");
                String status = rs.getString("status");
                String nomeAndar = andar == 0 ? "Térreo" : andar + "º Andar";

                System.out.println("Quarto " + numero + " (" + nomeAndar + "): " + status);
            }

            if (!encontrou) {
                System.out.println("Nenhum quarto em manutenção no momento.");
            }

            System.out.println("=========================================");
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // =========================================
    // relatorioHistoricoQuarto()
    // =========================================
    public void relatorioHistoricoQuarto(int numeroQuarto) {

        String sql = """
        SELECT 
            h.tipo_operacao,
            sa.descricao AS status_anterior,
            sn.descricao AS status_novo,
            h.data_hora
        FROM historico_operacoes h
            LEFT JOIN status sa ON h.id_status_anterior = sa.id_status
            LEFT JOIN status sn ON h.id_status_novo = sn.id_status
        WHERE h.numero_quarto = ?
        ORDER BY h.data_hora DESC
    """;

        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, numeroQuarto);
            ResultSet rs = pst.executeQuery();

            System.out.println("=========================================");
            System.out.println("   HISTÓRICO DO QUARTO " + numeroQuarto);
            System.out.println("=========================================");

            boolean encontrou = false;

            while (rs.next()) {
                encontrou = true;
                String operacao = rs.getString("tipo_operacao");
                String statusAnterior = rs.getString("status_anterior");
                String statusNovo = rs.getString("status_novo");
                String dataHora = rs.getString("data_hora");

                System.out.println("Data/Hora : " + dataHora);
                System.out.println("Operação  : " + operacao);
                System.out.println("De        : " + (statusAnterior != null ? statusAnterior : "—"));
                System.out.println("Para      : " + statusNovo);
                System.out.println("-----------------------------------------");
            }

            if (!encontrou) {
                System.out.println("Nenhum histórico encontrado para o quarto " + numeroQuarto);
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

} // Fechamento da classe DAO
