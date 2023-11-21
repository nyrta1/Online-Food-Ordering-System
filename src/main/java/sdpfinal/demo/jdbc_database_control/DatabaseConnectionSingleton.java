// Class for testing the database and other methods

package sdpfinal.demo.jdbc_database_control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionSingleton {
    private static DatabaseConnectionSingleton INSTANCE;
    private static Connection connection;

    private DatabaseConnectionSingleton() {
        try {
            connection = DriverManager.getConnection(
                    DatabaseConstants.ACCESS_TO_JDBC,
                    DatabaseConstants.USERNAME,
                    DatabaseConstants.PASSWORD
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static DatabaseConnectionSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (DatabaseConnectionSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DatabaseConnectionSingleton();
                }
            }
        }
        return INSTANCE;
    }

    public Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(
                DatabaseConstants.ACCESS_TO_DB,
                DatabaseConstants.USERNAME,
                DatabaseConstants.PASSWORD
        );
        if (connection.isClosed()) {
            INSTANCE = new DatabaseConnectionSingleton();
        }
        return connection;
    }
}
