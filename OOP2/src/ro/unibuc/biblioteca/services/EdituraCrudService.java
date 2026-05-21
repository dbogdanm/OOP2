package ro.unibuc.biblioteca.services;

import ro.unibuc.biblioteca.models.Editura;
import java.util.List;

public class EdituraCrudService {
    private static EdituraCrudService instance;
    private GenericDbService dbService = GenericDbService.getInstance();

    private EdituraCrudService() {
        createTableIfNotExists();
    }

    public static EdituraCrudService getInstance() {
        if (instance == null) {
            instance = new EdituraCrudService();
        }
        return instance;
    }

    private void createTableIfNotExists() {
        String sql = "CREATE TABLE IF NOT EXISTS edituri (" +
                "cod VARCHAR(50) PRIMARY KEY, " +
                "nume VARCHAR(100), " +
                "tara VARCHAR(100))";
        dbService.executeUpdate(sql);
    }

    public void create(Editura editura) {
        String sql = "INSERT INTO edituri (cod, nume, tara) VALUES (?, ?, ?)";
        dbService.executeUpdate(sql, editura.getCod(), editura.getNume(), editura.getTara());
    }

    public List<Editura> readAll() {
        String sql = "SELECT * FROM edituri";
        return dbService.executeSelect(sql, rs -> new Editura(
                rs.getString("cod"),
                rs.getString("nume"),
                rs.getString("tara")
        ));
    }

    public void update(Editura editura) {
        String sql = "UPDATE edituri SET nume = ?, tara = ? WHERE cod = ?";
        dbService.executeUpdate(sql, editura.getNume(), editura.getTara(), editura.getCod());
    }

    public void delete(String cod) {
        String sql = "DELETE FROM edituri WHERE cod = ?";
        dbService.executeUpdate(sql, cod);
    }
}