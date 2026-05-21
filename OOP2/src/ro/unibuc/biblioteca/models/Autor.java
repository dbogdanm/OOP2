package ro.unibuc.biblioteca.models;

public class Autor extends Persoana {
    private String nationalitate;

    public Autor(String id, String nume, String prenume, String nationalitate) {
        super(id, nume, prenume);
        this.nationalitate = nationalitate;
    }

    public String getNationalitate() { return nationalitate; }
    public void setNationalitate(String nationalitate) { this.nationalitate = nationalitate; }

    @Override
    public String toString() {
        return "Autor: " + super.toString() + " (" + nationalitate + ")";
    }
}