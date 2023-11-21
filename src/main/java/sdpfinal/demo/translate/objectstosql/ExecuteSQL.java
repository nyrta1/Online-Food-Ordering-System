package sdpfinal.demo.translate.objectstosql;

import sdpfinal.demo.jdbc_database_control.DatabaseConnectionSingleton;

import java.sql.*;

public class ExecuteSQL {
    private Connection connection = DatabaseConnectionSingleton.getInstance().getConnection();

    public ExecuteSQL() throws SQLException {
    }

    protected void select(String query) {
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Print separator row
            for (int i = 1; i <= columnCount; i++) {
                System.out.print("+-----------------");
            }
            System.out.println("+");

            // Print column names
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                System.out.printf("| %-15.15s ", columnName);
            }
            System.out.println("|");

            // Print separator row
            for (int i = 1; i <= columnCount; i++) {
                System.out.print("+-----------------");
            }
            System.out.println("+");

            // Print rows
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnValue = resultSet.getString(i);
                    System.out.printf("| %-15.15s ", columnValue);
                }
                System.out.println("|");
            }

            // Print separator row
            for (int i = 1; i <= columnCount; i++) {
                System.out.print("+-----------------");
            }
            System.out.println("+");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
