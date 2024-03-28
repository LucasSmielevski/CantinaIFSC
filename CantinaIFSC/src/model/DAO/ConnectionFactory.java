package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author aluno
 */
//Bd local fora do ifsc : 127.0.0.1:3306/cantina
//Bd ifsc : localhost:3306/bdcantina
public class ConnectionFactory {

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String banco = "jdbc:mysql://localhost:3306/bd_cantina";
    private static final String usuario = "root";
    private static final String senha = "ifsc";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(banco + "?allowPublicKeyRetrieval=true"
                    + "&verifyServerCertificate=false"
                    + "&useSSL=false"
                    + "&requireSSL=false"
                    + "&user=" + usuario
                    + "&password=" + senha
                    + "&serverTimezone=UTC"
            );
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void closeConnection(Connection conexao) {

        try {
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public static void closeConnection(Connection conexao, Statement stm) {

        try {
            stm.close();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public static void closeConnection(Connection conexao, PreparedStatement pstm) {

        try {
            pstm.close();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void closeConnection(Connection conexao, PreparedStatement pstm, ResultSet rst) {

        try {
            pstm.close();
            rst.close();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
