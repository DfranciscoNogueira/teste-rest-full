package br.com.aprendendo.restfull.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 
 * @author Diego_Francisco
 * @since 11/09/2016
 *
 */
public class ConexaoUtil {

    // dados do banco
    private final String DRIVER = "org.postgresql.Driver";
    private final String URL = "jdbc:postgresql://localhost:5432/web-service-teste";
    private final String USUARIO = "postgres";
    private final String SENHA = "Java@5151";
    private Connection conexao = null;

    public Connection criarConexao() {
        try {
            Class.forName(DRIVER);
            this.conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (Exception e) {
            System.out.println("Erro ao se conectar com o banco : " + URL);
            e.printStackTrace();
        }
        return this.conexao;
    }

    public void fecharConexao(Connection connection, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (connection != null)
                connection.close();
            if (pstmt != null)
                pstmt.close();
            if (rs != null)
                rs.close();

        } catch (Exception e) {
            System.out.println("Erro ao fechar conexao com o banco : " + URL);
            e.printStackTrace();
        }
    }

}
