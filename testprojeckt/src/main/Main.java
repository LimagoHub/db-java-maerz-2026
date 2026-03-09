package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // Beispiel für eine Datei-basierte Datenbank im User-Verzeichnis
        String url = "jdbc:h2:~/testdb";
        String user = "sa";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("Verbindung zur H2-Datenbank erfolgreich hergestellt!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}