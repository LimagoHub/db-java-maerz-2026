package main;

import java.sql.*;

public class Main {

    private static final String DRIVER = "org.h2.Driver";
    private static final String CONNECTION_STRING = "jdbc:h2:c:/tmp/db/db;AUTO_SERVER=TRUE";
    
    public static void main(String[] args) throws Exception{

        try(VirtualTable table = new VirtualTable("SELECT * FROM PUBLIC.tbl_persons")){
            for(int i = 0; i < table.getColumnCount(); i++){
                System.out.printf("%-30s", table.getColumnName(i));
            }
            while(table.next()){
                for(int i = 0; i < table.getColumnCount(); i++){
                    System.out.printf("%-30s", table.getValue(i));
                }
                System.out.println();
            }
        }

       //Class.forName(DRIVER);
         /*
        try(Connection connection = DriverManager.getConnection(CONNECTION_STRING, "sa","")){
            connection.setAutoCommit(true);
            try(PreparedStatement statement = connection.prepareStatement("insert into tbl_persons ( first_name, last_name) values ( ?, ?) ",Statement.RETURN_GENERATED_KEYS)){

                statement.setString(1, "John");
                statement.setString(2, "Doe");
                statement.executeUpdate();
                java.sql.ResultSet keys =statement.getGeneratedKeys();
                while(keys.next()) {
                    int key = keys.getInt(1);
                    System.out.println("Key: " + key);
                }

           try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM PUBLIC.tbl_persons where FIRST_NAME=?")){
                statement.setString(1, "Tommy");
               try(ResultSet rs = statement.executeQuery()){
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
                statement.setString(1, "Rennie");
                try(ResultSet rs = statement.executeQuery()){
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
                //connection.commit();


            }


        }

*/
    }
}
