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

    public ArrayList<QuartoBean> listarQuartos() {

        ArrayList<QuartoBean> quartos = new ArrayList<>();

        String sql = "select * from quartos order by numero";

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

                quartos.add(new QuartoBean(id, numero, andar, tamanho, idStatus,
                        idTipo, idModelo, idStatusAnterior));
            }

            con.close();
            return quartos;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

} // Fechamento da classe DAO
