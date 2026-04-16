package ro.unibuc.biblioteca.models;

public abstract class Persoana {
    protected String id;
    protected String nume;
    protected String prenume;

    public Persoana(String id, String nume, String prenume) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }

    public String getPrenume() { return prenume; }
    public void setPrenume(String prenume) { this.prenume = prenume; }

    @Override
    public String toString() {
        return nume + " " + prenume;
    }
}