package ro.unibuc.biblioteca.services;

import ro.unibuc.biblioteca.models.*;

import java.time.LocalDate;
import java.util.*;

public class BibliotecaService
{
    private Set<Carte> carti = new TreeSet<>();
    
    private Set<Cititor> cititori = new HashSet<>();
    private Set<Autor> autori = new HashSet<>();
    
    private List<Imprumut> imprumuturi = new ArrayList<>();
    
    private AuditService auditService = AuditService.getInstance();

    public void adaugaCarte(Carte carte)
    {
        carti.add(carte);
        auditService.logAction("adaugaCarte");
        System.out.println("S-a adaugat cartea: " + carte.getTitlu());
    }

    public void adaugaAutor(Autor autor)
    {
        autori.add(autor);
        auditService.logAction("adaugaAutor");
        System.out.println("S-a adaugat autorul: " + autor.getNume() + " " + autor.getPrenume());
    }

    public void adaugaCititor(Cititor cititor)
    {
        cititori.add(cititor);
        auditService.logAction("adaugaCititor");
        System.out.println("S-a adaugat cititorul: " + cititor.getNume() + " " + cititor.getPrenume());
    }

    public void creeazaImprumut(String idImprumut, Cititor cititor, Carte carte)
    {
        Imprumut imprumut = new Imprumut(idImprumut, cititor, carte, LocalDate.now());
        imprumuturi.add(imprumut);
        auditService.logAction("creeazaImprumut");
        System.out.println("Imprumut creat: " + cititor.getNume() + " a imprumutat cartea '" + carte.getTitlu() + "'");
    }

    public void returneazaCarte(String idImprumut)
    {
        auditService.logAction("returneazaCarte");
        for (Imprumut i : imprumuturi)
        {
            if (i.getIdImprumut().equals(idImprumut) && i.isActiv())
            {
                i.returneaza(LocalDate.now());
                System.out.println("Cartea aferenta imprumutului [" + idImprumut + "] a fost returnata cu succes.");
                return;
            }
        }
        System.out.println("Eroare: Imprumutul [" + idImprumut + "] nu a fost gasit sau a fost deja returnat.");
    }

    public void afiseazaCarti()
    {
        auditService.logAction("afiseazaCarti");
        System.out.println("\n--- Lista Cartilor (Sortate Alfabetic) ---");
        if (carti.isEmpty())
        {
            System.out.println("Nu exista carti in biblioteca.");
        }
        else
        {
            for (Carte c : carti)
            {
                System.out.println(c);
            }
        }
    }

    public void afiseazaCititori()
    {
        auditService.logAction("afiseazaCititori");
        System.out.println("\n--- Lista Cititorilor ---");
        for (Cititor c : cititori)
        {
            System.out.println(c);
        }
    }

    public void cautaCarteDupaTitlu(String titlu)
    {
        auditService.logAction("cautaCarteDupaTitlu");
        System.out.println("\n--- Rezultate cautare pentru titlul: '" + titlu + "' ---");
        boolean gasit = false;
        for (Carte c : carti)
        {
            if (c.getTitlu().toLowerCase().contains(titlu.toLowerCase()))
            {
                System.out.println(c);
                gasit = true;
            }
        }
        if (!gasit)
        {
            System.out.println("Nu a fost gasita nicio carte care sa contina acest titlu.");
        }
    }

    public void afiseazaImprumuturiActive()
    {
        auditService.logAction("afiseazaImprumuturiActive");
        System.out.println("\n--- Imprumuturi Active ---");
        boolean exista = false;
        for (Imprumut i : imprumuturi)
        {
            if (i.isActiv())
            {
                System.out.println(i);
                exista = true;
            }
        }
        if (!exista)
        {
            System.out.println("Nu exista imprumuturi active in acest moment.");
        }
    }

    public void afiseazaIstoricCititor(Cititor cititor)
    {
        auditService.logAction("afiseazaIstoricCititor");
        System.out.println("\n--- Istoric Imprumuturi pentru " + cititor.getNume() + " " + cititor.getPrenume() + " ---");
        boolean gasit = false;
        for (Imprumut i : imprumuturi)
        {
            if (i.getCititor().equals(cititor))
            {
                System.out.println(i);
                gasit = true;
            }
        }
        if (!gasit)
        {
            System.out.println("Acest cititor nu are istoric de imprumuturi.");
        }
    }
}