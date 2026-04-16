package ro.unibuc.biblioteca.services;

import ro.unibuc.biblioteca.models.*;

import java.time.LocalDate;
import java.util.*;

public class BibliotecaService {
    // Colecție sortată
    private Set<Carte> carti = new TreeSet<>();
    
    // Colecții de tip Set pentru unicitate
    private Set<Cititor> cititori = new HashSet<>();
    private Set<Autor> autori = new HashSet<>();
    
    // Listă pentru istoric (permite multiple împrumuturi, păstrează ordinea)
    private List<Imprumut> imprumuturi = new ArrayList<>();

    // 1. Adăugare carte
    public void adaugaCarte(Carte carte) {
        carti.add(carte);
        System.out.println("S-a adăugat cartea: " + carte.getTitlu());
    }

    // 2. Adăugare autor
    public void adaugaAutor(Autor autor) {
        autori.add(autor);
        System.out.println("S-a adăugat autorul: " + autor.getNume() + " " + autor.getPrenume());
    }

    // 3. Adăugare cititor
    public void adaugaCititor(Cititor cititor) {
        cititori.add(cititor);
        System.out.println("S-a adăugat cititorul: " + cititor.getNume() + " " + cititor.getPrenume());
    }

    // 4. Creare împrumut
    public void creeazaImprumut(String idImprumut, Cititor cititor, Carte carte) {
        Imprumut imprumut = new Imprumut(idImprumut, cititor, carte, LocalDate.now());
        imprumuturi.add(imprumut);
        System.out.println("Împrumut creat: " + cititor.getNume() + " a împrumutat cartea '" + carte.getTitlu() + "'");
    }

    // 5. Returnare carte
    public void returneazaCarte(String idImprumut) {
        for (Imprumut i : imprumuturi) {
            if (i.getIdImprumut().equals(idImprumut) && i.isActiv()) {
                i.returneaza(LocalDate.now());
                System.out.println("Cartea aferentă împrumutului [" + idImprumut + "] a fost returnată cu succes.");
                return;
            }
        }
        System.out.println("Eroare: Împrumutul [" + idImprumut + "] nu a fost găsit sau a fost deja returnat.");
    }

    // 6. Afișare toate cărțile (vor fi sortate alfabetic automat datorită TreeSet și Comparable)
    public void afiseazaCarti() {
        System.out.println("\n--- Lista Cărților (Sortate Alfabetic) ---");
        if (carti.isEmpty()) {
            System.out.println("Nu există cărți în bibliotecă.");
        } else {
            for (Carte c : carti) {
                System.out.println(c);
            }
        }
    }

    // 7. Afișare toți cititorii
    public void afiseazaCititori() {
        System.out.println("\n--- Lista Cititorilor ---");
        for (Cititor c : cititori) {
            System.out.println(c);
        }
    }

    // 8. Căutare carte după titlu
    public void cautaCarteDupaTitlu(String titlu) {
        System.out.println("\n--- Rezultate căutare pentru titlul: '" + titlu + "' ---");
        boolean gasit = false;
        for (Carte c : carti) {
            if (c.getTitlu().toLowerCase().contains(titlu.toLowerCase())) {
                System.out.println(c);
                gasit = true;
            }
        }
        if (!gasit) {
            System.out.println("Nu a fost găsită nicio carte care să conțină acest titlu.");
        }
    }

    // 9. Afișare împrumuturi active
    public void afiseazaImprumuturiActive() {
        System.out.println("\n--- Împrumuturi Active ---");
        boolean exista = false;
        for (Imprumut i : imprumuturi) {
            if (i.isActiv()) {
                System.out.println(i);
                exista = true;
            }
        }
        if (!exista) {
            System.out.println("Nu există împrumuturi active în acest moment.");
        }
    }

    // 10. Afișare istoric împrumuturi pentru un anumit cititor
    public void afiseazaIstoricCititor(Cititor cititor) {
        System.out.println("\n--- Istoric Împrumuturi pentru " + cititor.getNume() + " " + cititor.getPrenume() + " ---");
        boolean gasit = false;
        for (Imprumut i : imprumuturi) {
            if (i.getCititor().equals(cititor)) {
                System.out.println(i);
                gasit = true;
            }
        }
        if (!gasit) {
            System.out.println("Acest cititor nu are istoric de împrumuturi.");
        }
    }
}