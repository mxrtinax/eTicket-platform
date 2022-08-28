package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin extends Utilizator{

    protected int drepturi;
    public Admin(long id, String mail, String nume, String prenume, String parola, int drepturi){
        super(id, mail, nume, prenume,parola);
        this.drepturi = drepturi;
    }


    public int getDrepturi() {
        return drepturi;
    }
    public void setDrepturi(int drepturi) {
        this.drepturi = drepturi;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "Id: " + id +
                ", Mail: " + mail +
                ", Nume: " + nume + " " + prenume +
                ", Privilegii: " + drepturi +
                '\'' +
                '}';
    }

}
