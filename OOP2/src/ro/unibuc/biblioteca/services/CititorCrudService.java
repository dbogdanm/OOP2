package ro.unibuc.biblioteca.services;

import ro.unibuc.biblioteca.models.Cititor;
import java.util.List;

public class CititorCrudService {
    private static CititorCrudService instance;
    private GenericDbService dbService = GenericDbService.getInstance();

    private CititorCrudService() {
        createTableIfNotExists();
    }

    public static CititorCrudService getInstance() {
        if (instance == null) {
            instance = new CititorCrudService();
        }
        return instance;
    }

    private void createTableIfNotExists() {
        String sql = "CREATE TABLE IF NOT EXISTS cititori (" +
                "id VARCHAR(50) PRIMARY KEY, " +
                "nume VARCHAR(100), " +
                "prenume VARCHAR(100), " +
                "email VARCHAR(100))";
        dbService.executeUpdate(sql);
    }

    public void create(Cititor cititor) {
        String sql = "INSERT INTO cititori (id, nume, prenume, email) VALUES (?, ?, ?, ?)";
        dbService.executeUpdate(sql, cititor.getId(), cititor.getNume(), cititor.getPrenume(), cititor.getEmail());
    }

    public List<Cititor> readAll() {
        String sql = "SELECT * FROM cititori";
        return dbService.executeSelect(sql, rs -> new Cititor(
                rs.getString("id"),
                rs.getString("nume"),
                rs.getString("prenume"),
                rs.getString("email")
        ));
    }

    public void update(Cititor cititor) {
        String sql = "UPDATE cititori SET nume = ?, prenume = ?, email = ? WHERE id = ?";
        dbService.executeUpdate(sql, cititor.getNume(), cititor.getPrenume(), cititor.getEmail(), cititor.getId());
    }

    public void delete(String id) {
        String sql = "DELETE FROM cititori WHERE id = ?";
        dbService.executeUpdate(sql, id);
    }
}