package repository;

import config.ConectareBazaDeDate;
import model.Bilet;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientRepository {
    public void cumparaBilet(Bilet b){
        String query = "insert into bilete values (0, ?,?,?,?,?)";
        try (PreparedStatement statement = ConectareBazaDeDate.getInstance().prepareStatement(query)){
            statement.setString(1,b.getNumeEveniment());
            statement.setLong(2, b.getNumar());
            statement.setString(3,b.getZona());
            statement.setString(4,b.getProprietar());
            statement.setDouble(5,b.getPret());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
