package ro.unibuc.biblioteca.models;

import java.time.LocalDate;

public class Imprumut
{
    private String idImprumut;
    private Cititor cititor;
    private Carte carte;
    private LocalDate dataImprumut;
    private LocalDate dataReturnare;

    public Imprumut(String idImprumut, Cititor cititor, Carte carte, LocalDate dataImprumut)
    {
        this.idImprumut = idImprumut;
        this.cititor = cititor;
        this.carte = carte;
        this.dataImprumut = dataImprumut;
        this.dataReturnare = null;
    }

    public String getIdImprumut() { return idImprumut; }
    
    public Cititor getCititor() { return cititor; }
    
    public Carte getCarte() { return carte; }
    
    public LocalDate getDataImprumut() { return dataImprumut; }

    public LocalDate getDataReturnare() { return dataReturnare; }


    public void returneaza(LocalDate data) {
        this.dataReturnare = data;
    }

    public boolean isActiv() {
        return dataReturnare == null;
    }

    @Override
    public String toString()
    {
        String stare = isActiv() ? "ACTIV" : "RETURNAT pe " + dataReturnare;
        return "Imprumut [" + idImprumut + "] - Cititor: " + cititor.getNume() + 
               " | Carte: " + carte.getTitlu() + " | Stare: " + stare;
    }
}