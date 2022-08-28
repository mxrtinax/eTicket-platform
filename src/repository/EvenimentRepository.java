package repository;

import config.ConectareBazaDeDate;
import model.Eveniment;
import model.Locatie;
import model.Utilizator;
import service.WebsiteService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EvenimentRepository {
    protected LocatieRepository locatieRepository = new LocatieRepository();
    public void adaugaEveniment(Eveniment eveniment){
        String query = "insert into evenimente values (null, ?,?,?,?,?,?)";
        try (PreparedStatement statement = ConectareBazaDeDate.getInstance().prepareStatement(query)){
            statement.setString(1,eveniment.getNumeEveniment());
            statement.setString(2,eveniment.getArtisti().toString());
            statement.setString(3,eveniment.getDataEveniment());
            statement.setString(4,eveniment.getOraEveniment());
            statement.setString(5,eveniment.getLocatie().getId()+ "");
            statement.setString(6,eveniment.getNrBileteRamase()+"");
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Eveniment getEvenimentById(long id) {

        String query = "select * from evenimente where idlocatie = ?;";
        try (PreparedStatement statement = ConectareBazaDeDate.getInstance().prepareStatement(query)){
            statement.setLong(1,id);
            ResultSet result = statement.executeQuery();

            while (result.next()){
                long idEveniment = result.getLong("ideveniment");
                String numeEveniment = result.getString("numeeveniment");
                String[] artisti = result.getString("artisti").split(" ");
                String data = result.getString("dataeveniment");
                String ora = result.getString("oraeveniment");
                Long nrBileteRamase = result.getLong("nrbileteramase");
                Long idlocatie = result.getLong("idlocatie");
                Locatie locatie = locatieRepository.getLocatieById(idlocatie);
                Eveniment e = new Eveniment(idEveniment,numeEveniment, List.of(artisti),data,ora,locatie,nrBileteRamase);
                return e;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void afiseazaEvenimente() {
        String query = "select * from evenimente;";
        try (PreparedStatement statement = ConectareBazaDeDate.getInstance().prepareStatement(query)){
            ResultSet result = statement.executeQuery();

            while (result.next()){
                System.out.print(result.getLong("ideveniment") + ". " +
                        result.getString("numeeveniment") + ", " +
                        result.getString("dataeveniment") + ", " +
                        result.getString("oraeveniment") + ", " +
                        result.getLong("nrbileteramase") + " bilete, ");
                Locatie l = locatieRepository.getLocatieById(result.getLong("idlocatie"));
                System.out.println(l.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void stergeEvenimentById(long id) {
        String query = "delete from evenimente where idlocatie = ?;";
        try (PreparedStatement statement = ConectareBazaDeDate.getInstance().prepareStatement(query)){
            statement.setLong(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
