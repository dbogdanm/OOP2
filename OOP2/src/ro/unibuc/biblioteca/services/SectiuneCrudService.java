package ro.unibuc.biblioteca.services;

import ro.unibuc.biblioteca.models.Sectiune;
import java.util.List;

public class SectiuneCrudService {
    private static SectiuneCrudService instance;
    private GenericDbService dbService = GenericDbService.getInstance();

    private SectiuneCrudService() {
        createTableIfNotExists();
    }

    public static SectiuneCrudService getInstance() {
        if (instance == null) {
            instance = new SectiuneCrudService();
        }
        return instance;
    }

    private void createTableIfNotExists() {
        String sql = "CREATE TABLE IF NOT EXISTS sectiuni (" +
                "id_sectiune VARCHAR(50) PRIMARY KEY, " +
                "denumire VARCHAR(100))";
        dbService.executeUpdate(sql);
    }

    public void create(Sectiune sectiune) {
        String sql = "INSERT INTO sectiuni (id_sectiune, denumire) VALUES (?, ?)";
        dbService.executeUpdate(sql, sectiune.getIdSectiune(), sectiune.getDenumire());
    }

    public List<Sectiune> readAll() {
        String sql = "SELECT * FROM sectiuni";
        return dbService.executeSelect(sql, rs -> new Sectiune(
                rs.getString("id_sectiune"),
                rs.getString("denumire")
        ));
    }

    public void update(Sectiune sectiune) {
        String sql = "UPDATE sectiuni SET denumire = ? WHERE id_sectiune = ?";
        dbService.executeUpdate(sql, sectiune.getDenumire(), sectiune.getIdSectiune());
    }

    public void delete(String idSectiune) {
        String sql = "DELETE FROM sectiuni WHERE id_sectiune = ?";
        dbService.executeUpdate(sql, idSectiune);
    }
}