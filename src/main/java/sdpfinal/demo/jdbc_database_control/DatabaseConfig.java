package sdpfinal.demo.jdbc_database_control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class DatabaseConfig {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseConfig.class);
    private static Connection connection;
    public static void testingTheDatabase() {
        try(Connection connection = DatabaseConnectionSingleton.getInstance().getConnection()) {
            if (!checkTheDatabaseExists(connection)) {
                logger.error("The database does not exist!");
                logger.error("Attempt to create a database and a table...");

                createDatabase(connection);
                logger.info("Database 'sdp' created successfully.");
                return;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        logger.info("There's nothing wrong with the database");
    }

    private static boolean checkTheDatabaseExists(Connection connection) {
        String query = "SELECT datname FROM pg_database WHERE datname = 'sdp'";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createDatabase(Connection connection) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE DATABASE sdp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
