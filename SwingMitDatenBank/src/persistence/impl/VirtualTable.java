package persistence.impl;

import java.sql.*;
import java.util.Map;

public class VirtualTable implements AutoCloseable {

    private static final String DRIVER = "org.h2.Driver";
    private static final String CONNECTION_STRING = "jdbc:h2:c:/tmp/db/db;AUTO_SERVER=TRUE";
    private final String selectStament;

    private Map<String, String> zeilenCache = null;
    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;
    private ResultSetMetaData metaData = null;
    private long columnCount = -1;

    public VirtualTable(final String selectStament) {
        this.selectStament = selectStament;
    }

    public long getColumnCount()  throws Exception{
        if(columnCount < 0) {
            columnCount = getMetaData().getColumnCount();
        }
        return columnCount;
    }

    public String getColumnName(int column) throws Exception{ // 0-based
            return resultSet.getMetaData().getColumnName(column + 1);
    }

    public String getValue(int column) throws Exception{ // 0-based Soll mehrfach aufgerufen
        return getValue(getColumnName(column));
    }

    public String getValue(String  columnName ) throws Exception{ // 0-based Soll mehrfach aufgerufen (Nur eine Zeile cached)
        return getZeilenCache().get(columnName);
    }

    public boolean next() throws Exception{
        if(getResultSet().next()) {
            cacheZeile();
            return true;
        }
        return false;
    }

    private void cacheZeile() throws Exception{
        for(int column = 0; column < getColumnCount(); column ++ ){
            getZeilenCache().put(getColumnName(column), resultSet.getString(getColumnName(column)));
        }
    }


    @Override
    public void close() throws Exception {
        if (resultSet != null) resultSet.close();
        if (statement != null) statement.close();
        if (connection != null) connection.close();
    }

    private String getSelectStament()  throws Exception{
        return selectStament;
    }

    private Connection getConnection()  throws Exception{
        if( connection == null) {
            connection = DriverManager.getConnection(CONNECTION_STRING,"sa","");
        }
        return connection;
    }

    private PreparedStatement getStatement()  throws Exception{
        if( statement == null) {
            statement = getConnection().prepareStatement(getSelectStament());
        }
        return statement;
    }

    private ResultSet getResultSet()  throws Exception{
        if( resultSet == null) {
            resultSet = getStatement().executeQuery();
        }
        return resultSet;
    }

    private ResultSetMetaData getMetaData()  throws Exception{
        if( metaData == null) {
            metaData = getResultSet().getMetaData();
        }
        return metaData;
    }



    private Map<String, String> getZeilenCache() throws Exception{
        if(zeilenCache == null) {
            zeilenCache = new java.util.HashMap<>();
            // Mit leerdaten initialisieren
            for(int column = 0; column < getColumnCount(); column ++ ){
                zeilenCache.put(getColumnName(column), "--leer--");
            }
        }
        return zeilenCache;
    }
}
