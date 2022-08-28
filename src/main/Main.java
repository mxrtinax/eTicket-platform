package main;

import config.ConectareBazaDeDate;
import model.*;
import repository.*;
import service.WebsiteService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        WebsiteService websiteService = new WebsiteService();
        ClientRepository clientRepository = new ClientRepository();
        int raspuns;
        while (true){
            System.out.println("Alegeti o actiune:");
            Scanner scanner = new Scanner(System.in);
            variante();

            raspuns = scanner.nextByte();

            switch (raspuns){
                case 0:
                    return;
                case 1:
                    System.out.println("--1--");
                    websiteService.adaugaUtilizator();
                    break;
                case 2:
                    System.out.println("--2--");
                    System.out.print("Id: ");
                    websiteService.afiseazaUtilizatorDupaId(scanner.nextLong());
                    break;
                case 3:
                    System.out.println("--3--");
                    websiteService.afiseazaTotiUtilizatorii();
                    break;
                case 4:
                    System.out.print("Id: ");
                    websiteService.stergeUtilizator(scanner.nextLong());
                    break;
                case 5:
                    websiteService.adaugaLocatie();
                    break;
                case 6:
                    System.out.print("Id: ");
                    websiteService.afiseazaLocatieDupaId(scanner.nextLong());
                    break;
                case 7:
                    websiteService.afiseazaToateLocatiile();
                    break;
                case 8:
                    System.out.println("Id: ");
                    websiteService.stergeLocatie(scanner.nextLong());
                    break;
                case 9:
                    websiteService.adaugaEveniment();
                    break;
                case 10:
                    System.out.println("Id: ");
                    websiteService.afiseazaEvenimentDupaId(scanner.nextLong());
                    break;
                case 11:
                    websiteService.afiseazaToateEvenimentele();
                    break;
                case 12:
                    System.out.println("Id: ");
                    websiteService.stergeEveniment(scanner.nextLong());
                    break;
                case 13:
                    websiteService.cumparaBilet();
                    break;

            }

        }
    }
    public static void variante(){
            System.out.println("1. Adauga utilizator");
            System.out.println("2. Afiseaza utilizator dupa id");
            System.out.println("3. Afiseaza toti utilizatorii");
            System.out.println("4. Sterge utilizator");
            System.out.println("5. Adauga locatie");
            System.out.println("6. Afiseaza locatie dupa id");
            System.out.println("7. Afiseaza toate locatiile");
            System.out.println("8. Sterge locatie");
            System.out.println("9. Adauga eveniment");
            System.out.println("10. Afiseaza eveniment dupa id");
            System.out.println("11. Afiseaza toate evnimentele");
            System.out.println("12. Sterge eveniment");
            System.out.println("13. Cumpara bilet");
            System.out.println("0. Exit");
        }
}
