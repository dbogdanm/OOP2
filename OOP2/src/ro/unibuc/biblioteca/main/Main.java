package ro.unibuc.biblioteca.main;

import ro.unibuc.biblioteca.models.*;
import ro.unibuc.biblioteca.services.BibliotecaService;

public class Main {
    public static void main(String[] args) {
        BibliotecaService service = new BibliotecaService();

        // 1. Instanțiem date de bază
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

        System.out.println("=== TESTARE ACȚIUNI SISTEM BIBLIOTECĂ ===");

        // Acțiunile 1, 2, 3: Adăugări
        service.adaugaAutor(autor1);
        service.adaugaAutor(autor2);
        
        service.adaugaCititor(cititor1);
        service.adaugaCititor(cititor2);
        
        service.adaugaCarte(carte1);
        service.adaugaCarte(carte2);
        service.adaugaCarte(carte3);
        service.adaugaCarte(carte4);

        // Acțiunea 6: Afișare cărți (vor apărea automat sortate alfabetic după titlu)
        service.afiseazaCarti();

        // Acțiunea 7: Afișare cititori
        service.afiseazaCititori();

        // Acțiunea 4: Creare împrumuturi
        System.out.println("\n--- Se efectuează împrumuturi ---");
        service.creeazaImprumut("IMP-001", cititor1, carte1);
        service.creeazaImprumut("IMP-002", cititor2, carte2);
        service.creeazaImprumut("IMP-003", cititor1, carte3);

        // Acțiunea 9: Afișare împrumuturi active
        service.afiseazaImprumuturiActive();

        // Acțiunea 5: Returnare carte
        System.out.println("\n--- Se returnează o carte ---");
        service.returneazaCarte("IMP-001");

        // Afișăm iar împrumuturile active să vedem că s-a actualizat statusul
        service.afiseazaImprumuturiActive();

        // Acțiunea 10: Istoric cititor
        service.afiseazaIstoricCititor(cititor1);

        // Acțiunea 8: Căutare
        service.cautaCarteDupaTitlu("Luceafărul");
    }
}