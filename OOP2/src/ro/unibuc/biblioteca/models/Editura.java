package ro.unibuc.biblioteca.models;

public class Editura {
    private String cod;
    private String nume;
    private String tara;

    public Editura(String cod, String nume, String tara) {
        this.cod = cod;
        this.nume = nume;
        this.tara = tara;
    }

    public String getCod() { return cod; }
    public void setCod(String cod) { this.cod = cod; }

    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }

    public String getTara() { return tara; }
    public void setTara(String tara) { this.tara = tara; }

    @Override
    public String toString() {
        return nume;
    }
}