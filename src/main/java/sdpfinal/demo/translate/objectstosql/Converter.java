package sdpfinal.demo.translate.objectstosql;

public interface Converter {
    Object[] translate(DatabaseMethods databaseMethods, Object[] information, String databaseTableName);
}
