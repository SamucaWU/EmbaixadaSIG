package conectDAO;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConectDAO {
    private static final String url = "jdbc:mysql://localhost:3306/embaixadaBrasil  ";
    private static final String user = "root";
    private static final String password = "Prof@dm1n";

    public static Connection connection() throws SQLException {
        try {
            // Registra o driver JDBC manualmente
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver JDBC não encontrado!", e);
        }
        return DriverManager.getConnection(url, user, password);
    }

    public static String testConnection() {
        try (Connection connection = connection()) {
            return "Conexão bem-sucedida!";
        } catch (SQLException e) {
            return "Erro de conexão: " + e.getMessage();
        }
    }


}
