package ro.unibuc.biblioteca.models;

public class Cititor extends Persoana {
    private String email;

    public Cititor(String id, String nume, String prenume, String email) {
        super(id, nume, prenume);
        this.email = email;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Cititor: " + super.toString() + " - " + email;
    }
}