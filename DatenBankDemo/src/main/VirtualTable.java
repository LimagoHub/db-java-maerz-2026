package main;

public class VirtualTable implements AutoCloseable {

    private static final String DRIVER = "org.h2.Driver";
    private static final String CONNECTION_STRING = "jdbc:h2:c:/tmp/db/db;AUTO_SERVER=TRUE";
    private final String selectStament;

    public VirtualTable(final String selectStament) {
        this.selectStament = selectStament;
    }

    public long getColumnCount()  throws Exception{
        return 0;
    }

    public String getColumnName(int column) throws Exception{ // 0-based
            return null;
    }

    public String getValue(int column) throws Exception{ // 0-based Soll mehrfach aufgerufen
        return null;
    }

    public String getValue(String  columnName ) throws Exception{ // 0-based Soll mehrfach aufgerufen (Nur eine Zeile cached)
        return null;
    }

    public boolean next() throws Exception{
        return false;
    }


    @Override
    public void close() throws Exception {

    }
}
