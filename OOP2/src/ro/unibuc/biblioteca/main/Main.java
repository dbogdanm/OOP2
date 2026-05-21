package ro.unibuc.biblioteca.main;

import ro.unibuc.biblioteca.models.*;
import ro.unibuc.biblioteca.services.BibliotecaService;

public class Main {
    public static void main(String[] args) {
        BibliotecaService service = new BibliotecaService();

        Autor autor1 = new Autor("A01", "Eminescu", "Mihai", "România");
        Autor autor2 = new Autor("A02", "Creangă", "Ion", "România");
        
        Editura editura = new Editura("E01", "Humanitas", "România");
        Sectiune sectiuneBeletristica = new Sectiune("S01", "Beletristică");
        Sectiune sectiunePoezie = new Sectiune("S02", "Poezie");

        Carte carte1 = new Carte("ISBN-111", "Poezii", autor1, editura, sectiunePoezie, 1883);
        Carte carte2 = new Carte("ISBN-222", "Amintiri din copilărie", autor2, editura, sectiuneBeletristica, 1892);
        Carte carte3 = new Carte("ISBN-333", "Luceafărul", autor1, editura, sectiunePoezie, 1883);
        Carte carte4 = new Carte("ISBN-444", "Basme", autor2, editura, sectiuneBeletristica, 1880);

        Cititor cititor1 = new Cititor("C01", "Popescu", "Andrei", "andrei@email.com");
        Cititor cititor2 = new Cititor("C02", "Ionescu", "Maria", "maria@email.com");

        System.out.println("=== TESTARE ACȚIUNI SISTEM BIBLIOTECA ===");

        service.adaugaAutor(autor1);
        service.adaugaAutor(autor2);
        
        service.adaugaCititor(cititor1);
        service.adaugaCititor(cititor2);
        
        service.adaugaCarte(carte1);
        service.adaugaCarte(carte2);
        service.adaugaCarte(carte3);
        service.adaugaCarte(carte4);

        service.afiseazaCarti();

        service.afiseazaCititori();

        System.out.println("\n--- Se efectueaza imprumuturi ---");
        service.creeazaImprumut("IMP-001", cititor1, carte1);
        service.creeazaImprumut("IMP-002", cititor2, carte2);
        service.creeazaImprumut("IMP-003", cititor1, carte3);

        service.afiseazaImprumuturiActive();

        System.out.println("\n--- Se returneaza o carte ---");
        service.returneazaCarte("IMP-001");

        service.afiseazaImprumuturiActive();

        service.afiseazaIstoricCititor(cititor1);

        service.cautaCarteDupaTitlu("Luceafarul");
    }
}