package model;

import repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client extends Utilizator{
    protected List<Bilet> bilete = new ArrayList<Bilet>();
    protected double sold;  ///are o suma de bani in cont

    public Client(long id, String mail, String nume, String prenume, String parola, List<Bilet> bilete){
        super(id,mail,nume, prenume,parola);
        if (bilete != null){
            for (Bilet bilet: bilete){ //sau addAll
                if (bilet != null) {
                    this.bilete.add(bilet);
                }
            }
        }
    }

    public List<Bilet> getBilete() {
        return bilete;
    }

    public void setBilete(List<Bilet> bilete) {
        this.bilete.addAll(bilete);
    }

    public double getSold() {
        return sold;
    }

    public void setSold(double sold) {
        this.sold = sold;
    }


    @Override
    public String toString() {
        return "Client{" +
                "Id: " + id +
                ", Mail: " + mail +
                ", Nume: " + nume + " " + prenume +
                '\'' +
                '}';
    }

    public Bilet cumparaBilet(Eveniment e, float pret){
        if(e.getNrBileteRamase() == 0){
            return null;
        }
        if (this.getSold()<pret){
            return null;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("zona (A/B/C):");
        String zona = scanner.nextLine();
        Bilet b = new Bilet(e.numeEveniment,e.getNrBileteRamase(),zona,this.mail, pret);
        this.setSold(this.getSold()-pret);
        List<Bilet> l = this.getBilete();
        l.add(b);
        this.setBilete(l);
        ClientRepository clientRepository = new ClientRepository();
        clientRepository.cumparaBilet(b);
        return b;
    }

}
