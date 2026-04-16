package ro.unibuc.biblioteca.models;

import java.util.Objects;

public class Carte implements Comparable<Carte> {
    private String isbn;
    private String titlu;
    private Autor autor;
    private Editura editura;
    private Sectiune sectiune;
    private int anPublicare;

    public Carte(String isbn, String titlu, Autor autor, Editura editura, Sectiune sectiune, int anPublicare) {
        this.isbn = isbn;
        this.titlu = titlu;
        this.autor = autor;
        this.editura = editura;
        this.sectiune = sectiune;
        this.anPublicare = anPublicare;
    }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getTitlu() { return titlu; }
    public void setTitlu(String titlu) { this.titlu = titlu; }

    public Autor getAutor() { return autor; }
    public void setAutor(Autor autor) { this.autor = autor; }

    public Editura getEditura() { return editura; }
    public void setEditura(Editura editura) { this.editura = editura; }

    public Sectiune getSectiune() { return sectiune; }
    public void setSectiune(Sectiune sectiune) { this.sectiune = sectiune; }

    public int getAnPublicare() { return anPublicare; }
    public void setAnPublicare(int anPublicare) { this.anPublicare = anPublicare; }

    // Suprascriem compareTo pentru a fi sortate alfabetic după titlu în TreeSet
    @Override
    public int compareTo(Carte o) {
        return this.titlu.compareToIgnoreCase(o.titlu);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carte carte = (Carte) o;
        return Objects.equals(isbn, carte.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return "Carte: '" + titlu + "' | Autor: " + autor.getNume() + " " + autor.getPrenume() + " | An: " + anPublicare;
    }
}