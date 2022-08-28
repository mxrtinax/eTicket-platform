package repository;
import model.*;
import config.ConectareBazaDeDate;
import model.Utilizator;

import javax.sound.sampled.Clip;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilizatorRepository {

    public void adaugaUtilizator(Utilizator utilizator){
        String query;
        if (utilizator instanceof Client) {
            query = "insert into utilizatori values (null, ?,?,?,?, 0, 0, 0, 0)";

            try (PreparedStatement statement = ConectareBazaDeDate.getInstance().prepareStatement(query)) {
                statement.setString(1, utilizator.getMail());
                statement.setString(2, utilizator.getNume());
                statement.setString(3, utilizator.getPrenume());
                statement.setString(4, utilizator.getParola());
                statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (utilizator instanceof ClientPremium) {
            query = "insert into utilizatori values (null, ?,?,?,?, 0, ?, ?, 0)";

            try (PreparedStatement statement = ConectareBazaDeDate.getInstance().prepareStatement(query)) {
                statement.setString(1, utilizator.getMail());
                statement.setString(2, utilizator.getNume());
                statement.setString(3, utilizator.getPrenume());
                statement.setString(4, utilizator.getParola());
                statement.setInt(5, ((ClientPremium) utilizator).getProcentReducere());
                statement.setInt(6, ((ClientPremium) utilizator).getNrBileteReduse());
                statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (utilizator instanceof Admin) {
            query = "insert into utilizatori values (null, ?,?,?,?, 0, 0, 0,?)";

            try (PreparedStatement statement = ConectareBazaDeDate.getInstance().prepareStatement(query)) {
                statement.setString(1, utilizator.getMail());
                statement.setString(2, utilizator.getNume());
                statement.setString(3, utilizator.getPrenume());
                statement.setString(4, utilizator.getParola());
                statement.setInt(5, ((Admin) utilizator).getDrepturi());
                statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void stergeUtilizator(Utilizator utilizator){
        String query = "delete from utilizatori where idutilizator =  ?";
        try(PreparedStatement statement = ConectareBazaDeDate.getInstance().prepareStatement(query)){
            statement.setString(1,utilizator.getId().toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public Utilizator getUtilizatorById(long id) {
        String query = "select * from utilizatori where idutilizator = ?;";
        try (PreparedStatement statement = ConectareBazaDeDate.getInstance().prepareStatement(query)){
            statement.setLong(1,id);
            ResultSet result = statement.executeQuery();

            while (result.next()){
                long idutilizator = result.getLong("idutilizator");
                String mail = result.getString("mail");
                String nume = result.getString("nume");
                String prenume = result.getString("prenume");
                String parola = result.getString("parola");
                Float sold = result.getFloat("sold");
                int procentReducere = result.getInt("procentreducere");
                int nrBilete = result.getInt("nrbiletereduse");
                int drepturi = result.getInt("drepturi");
                if (drepturi!=0){
                    Utilizator u = new Admin(idutilizator,mail,nume,prenume,parola,drepturi);
                    return u;
                }
                else if(procentReducere!=0){
                    Utilizator u = new ClientPremium(idutilizator,mail,nume,prenume,parola,null,procentReducere,nrBilete);
                    return u;
                }
                else {
                    Utilizator u = new Client(idutilizator,mail,nume,prenume,parola,null);
                    return u;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void afiseazaUtilizatori() {
        String query = "select * from utilizatori;";
        try (PreparedStatement statement = ConectareBazaDeDate.getInstance().prepareStatement(query)){
            ResultSet result = statement.executeQuery();

            while (result.next()){
                System.out.print(result.getLong("idutilizator") + ". " +
                        result.getString("mail") + ", " +
                        result.getString("nume") + ", " +
                        result.getString("prenume") + ", " +
                        result.getString("sold") + "lei, " +
                        result.getString("procentreducere") + "%, " +
                        result.getString("nrbiletereduse") + " bilete, " +
                        result.getString("drepturi") + "\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void stergeUtilizatorById(long id) {
        String query = "delete from utilizatori where idutilizator = ?;";
        try (PreparedStatement statement = ConectareBazaDeDate.getInstance().prepareStatement(query)){
            statement.setLong(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Utilizator logIn(String mail, String parola) {
        String query = "select * from utilizatori where mail = ? and parola = ?;";
        try (PreparedStatement statement = ConectareBazaDeDate.getInstance().prepareStatement(query)){
            statement.setString(1,mail);
            statement.setString(2,parola);

            ResultSet result = statement.executeQuery();

            while (result.next()){
                String mailNou = result.getString("mail");
                String nume = result.getString("nume");
                String prenume = result.getString("prenume");
                String parolaNoua = result.getString("parola");
                Float sold = result.getFloat("sold");
                int procentReducere = result.getInt("procentreducere");
                int nrBilete = result.getInt("nrbiletereduse");
                int drepturi = result.getInt("drepturi");
                long idutilizator = result.getLong("idutilizator");
                if (!mail.equals(result.getString("mail")) ||
                        !parola.equals(result.getString("parola"))){
                    return null;
                }
                if (drepturi!=0){
                    Utilizator u = new Admin(idutilizator,mail,nume,prenume,parola,drepturi);
                    return u;
                }
                else if(procentReducere!=0){
                    Utilizator u = new ClientPremium(idutilizator,mail,nume,prenume,parola,null,procentReducere,nrBilete);
                    return u;
                }
                else {
                    Utilizator u = new Client(idutilizator,mail,nume,prenume,parola,null);
                    return u;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
