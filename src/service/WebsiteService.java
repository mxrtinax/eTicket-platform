package service;

import com.mysql.cj.util.Util;
import model.*;
import repository.EvenimentRepository;
import repository.LocatieRepository;
import repository.UtilizatorRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WebsiteService {

    protected EvenimentRepository evenimentRepository = new EvenimentRepository();
    protected LocatieRepository locatieRepository = new LocatieRepository();
    protected UtilizatorRepository utilizatorRepository = new UtilizatorRepository();
    protected Audit audit = new Audit();

    public Eveniment adaugaEveniment() throws IOException {

        String numeEveniment;
        List<String> artisti = new ArrayList<String>();
        String dataEveniment; //aaaa-ll-zz
        String oraEveniment; //oo:mm:ss
        long nrBileteRamase;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nume eveniment: ");
        numeEveniment = scanner.nextLine();
        int n;
        System.out.println("numar invitati: ");
        n = scanner.nextByte();
        System.out.println("introduceti invitatii cu enter dupa fiecare");
        for(int i=0;i<=n;i++){
            artisti.add(scanner.nextLine());
        }
        System.out.println("data eveniment (aaaa-ll-zz): ");
        dataEveniment = scanner.nextLine();
        System.out.println("ora eveniment (hh:mm:ss): ");
        oraEveniment = scanner.nextLine();

        Locatie loc = this.adaugaLocatie();

        System.out.println("nr bilete disponibile: ");
        nrBileteRamase = scanner.nextLong();
        Eveniment e = new Eveniment(0l, numeEveniment,artisti,dataEveniment,oraEveniment,loc,nrBileteRamase);
        evenimentRepository.adaugaEveniment(e);
        audit.insereazaComanda("inserare eveniment");
        return e;
    }
    public void afiseazaEvenimentDupaId(long id) throws IOException {
        Eveniment eveniment = evenimentRepository.getEvenimentById(id);
        System.out.println(eveniment.toString());
        audit.insereazaComanda("afiseaza locatie dupa id");
    }


    public void afiseazaToateEvenimentele() throws IOException {
        evenimentRepository.afiseazaEvenimente();
        audit.insereazaComanda("afiseaza toate evenimentele");
    }

    public void stergeEveniment(long id) throws IOException {
        evenimentRepository.stergeEvenimentById(id);
        audit.insereazaComanda("sterge eveniment");
    }
    public Locatie adaugaLocatie() throws IOException {

        Scanner scanner = new Scanner(System.in);
        String oras, strada, nr, cladire;
        System.out.println("locatie\nOras: ");
        oras = scanner.nextLine();
        System.out.println("strada: ");
        strada = scanner.nextLine();
        System.out.println("nr: ");
        nr = scanner.nextLine();
        System.out.println("cladire: ");
        cladire = scanner.nextLine();
        Locatie loc = new Locatie(2,oras, strada,nr,cladire);
        locatieRepository.adaugaLocatie(loc);
        audit.insereazaComanda("inserare locatie");
        return loc;
    }

    public void afiseazaLocatieDupaId(long id) throws IOException {
        Locatie locatie = locatieRepository.getLocatieById(id);
        System.out.println(locatie.toString());
        audit.insereazaComanda("afiseaza locatie dupa id");
    }

    public void afiseazaToateLocatiile() throws IOException {
        locatieRepository.afiseazaLocatii();
        audit.insereazaComanda("afiseaza toate locatiile");
    }
    public void stergeLocatie(long id) throws IOException {
        locatieRepository.stergeLocatieById(id);
        audit.insereazaComanda("sterge locatie");
    }
    public Utilizator adaugaUtilizator(){
        System.out.println("introduceti tipul utilizatorului (Client/Admin/ClientPremium):");
        Scanner scanner = new Scanner(System.in);
        String utilizator = scanner.nextLine();
        String nume, prenume, mail, parola;
        int procentReducere, nrBileteReduse, drepturi;
        System.out.println("Nume: ");
        nume = scanner.nextLine();
        System.out.println("Prenume: ");
        prenume = scanner.nextLine();
        System.out.println("Mail: ");
        mail = scanner.nextLine();
        System.out.println("Parola: ");
        parola = scanner.nextLine();
        switch (utilizator){
            case "Client":
                Utilizator c = new Client(0l,mail,nume,prenume,parola,null);
                utilizatorRepository.adaugaUtilizator(c);
                return c;
            case "ClientPremium":
                System.out.println("Procent Reducere: ");
                procentReducere = scanner.nextByte();
                System.out.println("Nr bilete reduse: ");
                nrBileteReduse = scanner.nextByte();
                Utilizator cp = new ClientPremium(0l,mail,nume,prenume,parola,null,procentReducere,nrBileteReduse);
                utilizatorRepository.adaugaUtilizator(cp);
                return cp;
            case "Admin":
                System.out.println("Drepturi: ");
                drepturi = scanner.nextByte();
                Utilizator a = new Admin(0l,mail,nume,prenume,parola,drepturi);
                utilizatorRepository.adaugaUtilizator(a);
                return a;
        }
      return null;
    }
    public void afiseazaUtilizatorDupaId(long id) throws IOException {
        Utilizator utilizator = utilizatorRepository.getUtilizatorById(id);
        System.out.println(utilizator.toString());
        audit.insereazaComanda("afiseaza locatie dupa id");
    }

    public void afiseazaTotiUtilizatorii() throws IOException {
        utilizatorRepository.afiseazaUtilizatori();
        audit.insereazaComanda("afiseaza toate locatiile");
    }
    public void stergeUtilizator(long id) throws IOException {
        utilizatorRepository.stergeUtilizatorById(id);
        audit.insereazaComanda("sterge locatie");
    }
    public void cumparaBilet(){
        System.out.println("mailul dvs: ");
        Scanner scanner = new Scanner(System.in);
        String mail = scanner.nextLine();
        System.out.println("parola: ");
        String parola = scanner.nextLine();
        Utilizator u =utilizatorRepository.logIn(mail,parola);
        if(u!=null && u instanceof Client){

            System.out.println("bun venit, " + u.getNume());
            System.out.println("id eveniment: ");
            Long ideveniment = scanner.nextLong();
            Eveniment e = evenimentRepository.getEvenimentById(ideveniment);
            ((Client) u).cumparaBilet(e,10);
        }
    }
}
