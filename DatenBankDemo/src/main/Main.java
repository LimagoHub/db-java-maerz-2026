package main;

import java.sql.*;

public class Main {

    private static final String DRIVER = "org.h2.Driver";
    private static final String CONNECTION_STRING = "jdbc:h2:c:/tmp/db/db;AUTO_SERVER=TRUE";
    
    public static void main(String[] args) throws Exception{
       //Class.forName(DRIVER);
        try(Connection connection = DriverManager.getConnection(CONNECTION_STRING, "sa","")){
            try(Statement statement = connection.createStatement()){
               try(ResultSet rs = statement.executeQuery("SELECT * FROM PUBLIC.tbl_persons")){
                   ResultSetMetaData metaData = rs.getMetaData();
                   for (int column = 1, n = metaData.getColumnCount(); column <= n ; column++) {
                       System.out.printf("%-30s",metaData.getColumnName(column));
                   }
                   System.out.println();
                   while(rs.next()){
                       for (int column = 1, n = metaData.getColumnCount(); column <= n ; column++) {
                           System.out.printf("%-30s",rs.getString(column));
                       }
                       System.out.println();
                   }
               }
            }


        }


    }
}
