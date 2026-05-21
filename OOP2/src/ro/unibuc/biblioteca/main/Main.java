package ro.unibuc.biblioteca.main;

import ro.unibuc.biblioteca.models.*;
import ro.unibuc.biblioteca.services.BibliotecaService;

public class Main {
    public static void main(String[] args) {
        BibliotecaService service = new BibliotecaService();

        Autor autor1 = new Autor("A01", "Eminescu", "Mihai", "Romania");
        Autor autor2 = new Autor("A02", "Creanga", "Ion", "Romania");
        
        Editura editura = new Editura("E01", "Humanitas", "Romania");
        Sectiune sectiuneBeletristica = new Sectiune("S01", "Beletristica");
        Sectiune sectiunePoezie = new Sectiune("S02", "Poezie");

        Carte carte1 = new Carte("ISBN-111", "Poezii", autor1, editura, sectiunePoezie, 1883);
        Carte carte2 = new Carte("ISBN-222", "Amintiri din copilarie", autor2, editura, sectiuneBeletristica, 1892);
        Carte carte3 = new Carte("ISBN-333", "Luceafarul", autor1, editura, sectiunePoezie, 1883);
        Carte carte4 = new Carte("ISBN-444", "Basme", autor2, editura, sectiuneBeletristica, 1880);

        Cititor cititor1 = new Cititor("C01", "Popescu", "Andrei", "andrei@email.com");
        Cititor cititor2 = new Cititor("C02", "Ionescu", "Maria", "maria@email.com");

        System.out.println("=== TESTARE ACTIUNI SISTEM BIBLIOTECA ===");

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

        System.out.println("\n=== TESTARE PERSISTENTA BAZA DE DATE (JDBC) ===");
        try {
            ro.unibuc.biblioteca.services.AutorCrudService autorService = ro.unibuc.biblioteca.services.AutorCrudService.getInstance();
            ro.unibuc.biblioteca.services.CititorCrudService cititorService = ro.unibuc.biblioteca.services.CititorCrudService.getInstance();
            ro.unibuc.biblioteca.services.EdituraCrudService edituraService = ro.unibuc.biblioteca.services.EdituraCrudService.getInstance();
            ro.unibuc.biblioteca.services.SectiuneCrudService sectiuneService = ro.unibuc.biblioteca.services.SectiuneCrudService.getInstance();
            
            System.out.println("Se populeaza baza de date cu datele din Etapa 1...");

            autorService.delete(autor1.getId());
            autorService.delete(autor2.getId());
            cititorService.delete(cititor1.getId());
            cititorService.delete(cititor2.getId());
            edituraService.delete(editura.getCod());
            sectiuneService.delete(sectiuneBeletristica.getIdSectiune());
            sectiuneService.delete(sectiunePoezie.getIdSectiune());

            autorService.create(autor1);
            autorService.create(autor2);
            
            cititorService.create(cititor1);
            cititorService.create(cititor2);
            
            edituraService.create(editura);
            
            sectiuneService.create(sectiuneBeletristica);
            sectiuneService.create(sectiunePoezie);

            System.out.println("Datele au fost salvate cu succes in tabelele: autori, cititori, edituri, sectiuni!");
            
        } catch (Exception e) {
            System.err.println("Eroare la testarea bazei de date. Verificati conexiunea! Detalii: " + e.getMessage());
        }
    }
}