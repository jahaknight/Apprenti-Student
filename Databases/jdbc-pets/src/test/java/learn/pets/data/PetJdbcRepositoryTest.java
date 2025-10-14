package learn.pets.data;

import learn.pets.models.Pet;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * PetJdbcRepositoryTest
 * Purpose:
 *  Integration-style tests that hit the real MySQL DB created in Workbench.
 * Pre-req:
 *  - DB `pet_management` and table `pet` exist with seed rows.
 *  - Credentials in PetJdbcRepository are valid on this machine.
 * Notes:
 *  - For classroom simplicity we mutate real data. In production you'd use transactions/rollback.
 */

class PetJdbcRepositoryTest {
    private final PetJdbcRepository repo = new PetJdbcRepository();

    @Test
    void shouldConnect() {
        assertTrue(repo.canConnect(), "Repository should connect to the database");
    }

    @Test
    void shouldFindAll() {
        List<Pet> pets = repo.findAll();
        assertNotNull(pets, "findAll should not return null");
        assertTrue(pets.size() > 0, "Seed data ensured at least one row exists");
    }

    @Test
    void shouldAddPet() {
        Pet p = new Pet();
        p.setName("JUnitPet");
        p.setType("Lizard");

        Pet saved = repo.add(p);
        assertNotNull(saved, "add should return saved entity");
        assertTrue(saved.getPetId() > 0, "auto-generated ID should be > 0");

        // cleanup
        assertTrue(repo.deleteById(saved.getPetId()));
    }

    @Test
    void shouldUpdatePet() {
        // arrange
        Pet p = new Pet();
        p.setName("ToUpdate");
        p.setType("Dog");
        p = repo.add(p);
        assertNotNull(p);

        // act: update the type
        p.setType("Super Dog");
        assertTrue(repo.update(p), "update should return true");

        // assert : verify change
        Pet reloaded = repo.findById(p.getPetId());
        assertNotNull(reloaded);
        assertEquals("Super Dog", reloaded.getType());

        // cleanup
        repo.deleteById(p.getPetId());
    }

    @Test
    void shouldDeletePet() {
        Pet p = new Pet();
        p.setName("ToDelete");
        p.setType("Cat");
        p = repo.add(p);
        assertNotNull(p);

        assertTrue(repo.deleteById(p.getPetId()), "deleteById should return true");
        assertNull(repo.findById(p.getPetId()), "After delete, findById should return null");
    }
}