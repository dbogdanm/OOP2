# Sistem de Gestiune Bibliotecă

Această aplicație este un sistem de management pentru o bibliotecă, dezvoltată în Java. Proiectul permite gestionarea cărților, autorilor, cititorilor și a procesului de împrumut, oferind atât o implementare în memorie, cât și persistență într-o bază de date relațională prin JDBC.

## Caracteristici principale

- **Gestiune Entități:** CRUD (Create, Read, Update, Delete) pentru Autori, Cititori, Edituri și Secțiuni.
- **Logică de Business:** 
    - Adăugare și listare cărți (sortate alfabetic).
    - Creare împrumuturi și gestionare returnări.
    - Căutare cărți după titlu.
    - Vizualizare istoric împrumuturi per cititor.
- **Persistență:** Integrare JDBC pentru salvarea datelor în tabele SQL.
- **Audit:** Înregistrarea automată a acțiunilor efectuate într-un fișier extern (`audit.csv`) cu timestamp.
- **Design Patterns:** Utilizarea pattern-urilor Singleton și Repository (prin `GenericDbService`).

## Tehnologii utilizate

- **Limbaj:** Java 17+
- **Build Tool:** Gradle
- **Bază de date:** JDBC (suport pentru baze de date SQL)
- **Stocare:** CSV (pentru audit)

## Structura Proiectului

- `models/`: Conține clasele de date (Autor, Carte, Cititor, etc.).
- `services/`: Conține logica de business și serviciile de acces la date.
    - `BibliotecaService`: Logica principală a bibliotecii (in-memory).
    - `GenericDbService`: Utilitar pentru execuția interogărilor SQL.
    - `AuditService`: Serviciu pentru logging-ul acțiunilor.
- `main/`: Clasa `Main` pentru testarea funcționalităților.

## Cum se rulează

1. Asigură-te că ai Java și Gradle instalate.
2. Clonează repository-ul.
3. Rulează aplicația folosind comanda:
   ```bash
   ./gradlew run
   ```
   sau din IDE-ul preferat (IntelliJ IDEA/Eclipse) prin rularea clasei `Main.java`.
