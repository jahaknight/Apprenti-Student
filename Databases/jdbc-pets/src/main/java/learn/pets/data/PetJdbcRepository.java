package learn.pets.data;

import com.mysql.cj.jdbc.MysqlDataSource;
import learn.pets.models.Pet;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  * PetJdbcRepository.java
 *
 *  * Responsibility:
 *  *   Encapsulate all database access for the `pet` table using JDBC.
 *  *
 *  * Why these choices:
 *  *   - DataSource from MysqlDataSource: stores connection settings in one place.
 *  *   - PreparedStatement for INSERT/UPDATE/DELETE: avoids SQL injection & handles parameters.
 */

public class PetJdbcRepository {
    // Single DataSource for the repository. All methods pull Connections from this.
    private final DataSource dataSource = initDataSource();

    /**
     * Configure a MySQL DataSource for our local database.
     */

    private DataSource initDataSource() {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/pet_management?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC");
        ds.setUser("root");
        ds.setPassword("");
        return ds;
    }

    /** connectivity probe for debugging. */

    public boolean canConnect() {
        try (Connection conn = dataSource.getConnection()) {
            return conn.isValid(2);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // CRUD (Create, Read, Update, Delete)

    /**
     * CREATE
     * Insert a new Pet. DB generates pet_id.
     * @param pet has name & type set. petId ignored on input.
     * @return same object with petId populated; null if insert failed.
     */

    public Pet add(Pet pet) {
        final String sql = "INSERT INTO pet (name, type) VALUES (?, ?);";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            // Bind parameters
            stmt.setString(1, pet.getName());
            stmt.setString(2, pet.getType());

            int rows = stmt.executeUpdate();
            if (rows <= 0) {
                return null;
            }

            // Grab the auto-generated primary key (pet_id)
            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    pet.setPetId(keys.getInt(1));
                    return pet;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * READ (all)
     * Fetch all pets from the table.
     * @return list (possibly empty, never null).
     */
    public List<Pet> findAll() {
        List<Pet> pets = new ArrayList<>();
        final String sql = "SELECT pet_id, name, type FROM pet;";

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Pet p = new Pet();
                p.setPetId(rs.getInt("pet_id"));
                p.setName(rs.getString("name"));
                p.setType(rs.getString("type"));
                pets.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pets;
    }

    /**
     * (Optional but useful) READ (by id)
     * @param petId primary key to look up
     * @return Pet or null if not found
     */

    public Pet findById(int petId) {
        final String sql = "SELECT pet_id, name, type FROM pet WHERE pet_id = ?;";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, petId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Pet p = new Pet();
                    p.setPetId(rs.getInt("pet_id"));
                    p.setName(rs.getString("name"));
                    p.setType(rs.getString("type"));
                    return p;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null; // not found
    }

    /**
     * UPDATE
     * Change name/type for an existing pet by id.
     * @param pet must have valid petId and new values.
     * @return true if a row was updated; false if not found or error.
     */

    public boolean update(Pet pet) {
        final String sql = "UPDATE pet SET name = ?, type = ? WHERE pet_id = ?;";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pet.getName());
            stmt.setString(2, pet.getType());
            stmt.setInt(3, pet.getPetId());

            return stmt.executeUpdate() > 0; // affected rows

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * DELETE
     * Remove a row by primary key.
     * @param petId id to delete
     * @return true if a row was deleted.
     */

    public boolean deleteById(int petId) {
        final String sql = "DELETE FROM pet WHERE pet_id = ?;";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, petId);
            return stmt.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}



