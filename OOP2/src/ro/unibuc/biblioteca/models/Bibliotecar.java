package ro.unibuc.biblioteca.models;

public class Bibliotecar extends Persoana {
    private double salariu;

    public Bibliotecar(String id, String nume, String prenume, double salariu) {
        super(id, nume, prenume);
        this.salariu = salariu;
    }

    public double getSalariu() { return salariu; }
    public void setSalariu(double salariu) { this.salariu = salariu; }

    @Override
    public String toString() {
        return "Bibliotecar: " + super.toString();
    }
}