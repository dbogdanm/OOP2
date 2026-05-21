package ro.unibuc.biblioteca.services;

import ro.unibuc.biblioteca.models.Autor;
import java.util.List;

public class AutorCrudService {
    private static AutorCrudService instance;
    private GenericDbService dbService = GenericDbService.getInstance();

    private AutorCrudService() {
        createTableIfNotExists();
    }

    public static AutorCrudService getInstance() {
        if (instance == null) {
            instance = new AutorCrudService();
        }
        return instance;
    }

    private void createTableIfNotExists() {
        String sql = "CREATE TABLE IF NOT EXISTS autori (" +
                "id VARCHAR(50) PRIMARY KEY, " +
                "nume VARCHAR(100), " +
                "prenume VARCHAR(100), " +
                "nationalitate VARCHAR(100))";
        dbService.executeUpdate(sql);
    }

    public void create(Autor autor) {
        String sql = "INSERT INTO autori (id, nume, prenume, nationalitate) VALUES (?, ?, ?, ?)";
        dbService.executeUpdate(sql, autor.getId(), autor.getNume(), autor.getPrenume(), autor.getNationalitate());
    }

    public List<Autor> readAll() {
        String sql = "SELECT * FROM autori";
        return dbService.executeSelect(sql, rs -> new Autor(
                rs.getString("id"),
                rs.getString("nume"),
                rs.getString("prenume"),
                rs.getString("nationalitate")
        ));
    }

    public void update(Autor autor) {
        String sql = "UPDATE autori SET nume = ?, prenume = ?, nationalitate = ? WHERE id = ?";
        dbService.executeUpdate(sql, autor.getNume(), autor.getPrenume(), autor.getNationalitate(), autor.getId());
    }

    public void delete(String id) {
        String sql = "DELETE FROM autori WHERE id = ?";
        dbService.executeUpdate(sql, id);
    }
}