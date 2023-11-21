package sdpfinal.demo.translate.objectstosql;

import static sdpfinal.demo.translate.objectstosql.DatabaseMethods.*;

public class StringReaderAdapter implements Converter {
    private final ExecuteSQL executeSQL;

    public StringReaderAdapter(ExecuteSQL executeSQL) {
        this.executeSQL = executeSQL;
    }

    @Override
    public Object[] translate(DatabaseMethods databaseMethods, Object[] information, String databaseTableName) {
        switch (databaseMethods) {
            case SELECT -> {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("SELECT * FROM ")
                        .append(databaseTableName);
                executeSQL.select(stringBuilder.toString());
                return new Object[]{};
            }
            case INSERT -> {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("INSERT INTO ")
                        .append(databaseTableName)
                        .append(getField(databaseTableName))
                        .append(" VALUES (");

                for (int i = 0; i < information.length; i++) {
                    if (information[i] instanceof String) {
                        stringBuilder.append("'").append(information[i]).append("'");
                    } else {
                        stringBuilder.append(information[i]);
                    }
                    if (i < information.length - 1) {
                        stringBuilder.append(", ");
                    }
                }

                stringBuilder.append(")");
            }
            case DELETE -> {
                StringBuilder stringBuilder = new StringBuilder();
                if (information != null && information.length > 0) {
                    stringBuilder.append("DELETE FROM ").append(databaseTableName)
                            .append(" WHERE ").append("id").append(" = ");

                    if (information[0] instanceof Integer) {
                        stringBuilder.append(information[0]);
                    }
                } else {
                    System.err.println("No conditions provided for delete");
                }
                return new Object[]{};
            }
        }
        return new Object[]{};
    }

    public String getField(String tableName) {
        switch (tableName) {
            case "customer" -> {
                return " (firstName, lastName, username, phone, address, password, role) ";
            }
            default -> {
                return null;
            }
        }
    }
}
