package repository;

import config.ConectareBazaDeDate;
import model.Eveniment;
import model.Locatie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocatieRepository {


    public void adaugaLocatie(Locatie locatie){
        String query = "insert into locatii values (null, ?,?,?,?)";
        try (PreparedStatement statement = ConectareBazaDeDate.getInstance().prepareStatement(query)){
            statement.setString(1,locatie.getOras());
            statement.setString(2,locatie.getStrada());
            statement.setString(3,locatie.getNumar());
            statement.setString(4,locatie.getCladire());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Locatie getLocatieById(long id) {
        String query = "select * from locatii where idlocatie = ?;";
        try (PreparedStatement statement = ConectareBazaDeDate.getInstance().prepareStatement(query)){
            statement.setLong(1,id);
            ResultSet result = statement.executeQuery();

            while (result.next()){
                long idlocatie = result.getLong("idlocatie");
                String oras = result.getString("oras");
                String strada = result.getString("strada");
                String numar = result.getString("numar");
                String cladire = result.getString("cladire");
                Locatie loc = new Locatie(idlocatie,oras,strada,numar,cladire);

                return loc;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void afiseazaLocatii(){
        String query = "select * from locatii;";
        try (PreparedStatement statement = ConectareBazaDeDate.getInstance().prepareStatement(query)){
            ResultSet result = statement.executeQuery();

            while (result.next()){
                System.out.print(result.getLong("idlocatie") + ". " +
                        result.getString("oras") + ", " +
                        result.getString("strada") + ", " +
                        result.getString("numar") + ", " +
                        result.getString("cladire") + "\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void stergeLocatieById(long id) {
        String query = "delete from locatii where idlocatie = ?;";
        try (PreparedStatement statement = ConectareBazaDeDate.getInstance().prepareStatement(query)){
            statement.setLong(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
