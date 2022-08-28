package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectareBazaDeDate {
    private static Connection conectare;

    private ConectareBazaDeDate() {

    }

    public static Connection getInstance() throws SQLException {
        if(conectare== null) {
            String url = "jdbc:mysql://localhost:3306/eTicket";
            String userName = "root";
            String parola = "parola123";

            conectare = DriverManager.getConnection(url, userName, parola);
        }
        return conectare;
    }
}
