package model;

import java.util.List;
import java.util.Scanner;

public class ClientPremium extends Client{

    protected int procentReducere; //are reducere la orice bilet
    protected int nrBileteReduse;

    public ClientPremium(long id,
                         String mail,
                         String nume,
                         String prenume,
                         String parola,
                         List<Bilet> bilete,
                         int procentReducere,
                         int nrBileteReduse){
        super(id, mail, nume, prenume,parola, bilete);
        this.procentReducere = procentReducere;
        this.nrBileteReduse = nrBileteReduse;
    }
    public int getNrBileteReduse() {
        return nrBileteReduse;
    }
    public void setNrBileteReduse(int nrBileteReduse) {
        this.nrBileteReduse = nrBileteReduse;
    }
    public int getProcentReducere() {
        return procentReducere;
    }
    public void setProcentReducere(int procentReducere) {
        this.procentReducere = procentReducere;
    }
    @Override
    public String toString() {
        return "Client{" +
                "Id: " + id +
                ", Mail: " + mail +
                ", Nume: " + nume + " " + prenume +
                ", Reducere: " + procentReducere + "%" +
                ", nr bilete cu reducere ramase: " + nrBileteReduse +
                '\'' +
                '}';
    }


    @Override
    public Bilet cumparaBilet(Eveniment e, float pret){
        if(e.getNrBileteRamase() == 0){
            return null;
        }
        double pretFinal = pret - (this.getProcentReducere()/100) * pret;
        if (this.getSold()<pretFinal){
            return null;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("zona (A/B/C):");
        String zona = scanner.nextLine();
        Bilet b = new Bilet(e.numeEveniment,e.getNrBileteRamase(),zona,this.mail, pretFinal);

        this.setSold(this.getSold()-pretFinal);
        return b;
    }
}
