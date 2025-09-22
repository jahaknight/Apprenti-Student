package learn.unexplained.data;

import learn.unexplained.models.Encounter;
import learn.unexplained.models.EncounterType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.junit.jupiter.api.Assertions.*;

class EncounterFileRepositoryTest {

    // project root
    private static final Path SEED = Paths.get("data", "encounters-seed.csv");
    private static final Path TEST = Paths.get("data", "encounters-test.csv");

    private EncounterFileRepository repo;

    @BeforeEach
    void setup() throws Exception {
        // this is where we are running tests from
        System.out.println("Working dir: " + Paths.get("").toAbsolutePath());
        System.out.println("Seed path : " + SEED.toAbsolutePath());
        System.out.println("Test path : " + TEST.toAbsolutePath());

        // Ensure /data exists and seed is present
        Files.createDirectories(TEST.getParent());
        assertTrue(Files.exists(SEED),
                "Seed file not found at " + SEED.toAbsolutePath()
                        + " (Working dir likely not project root. "
                        + "Set Run → Edit Configurations → JUnit → Working directory = $MODULE_WORKING_DIR$)");

        // Reset the test file from the seed before each test
        Files.copy(SEED, TEST, REPLACE_EXISTING);
        assertTrue(Files.exists(TEST), "Failed to create test file at " + TEST.toAbsolutePath());

        // Point the repository at TEST file
        repo = new EncounterFileRepository(TEST.toString());
    }

    @Test
    void environmentSanity() throws Exception {
        // read first line to prove we can access the file
        var firstLine = Files.readAllLines(SEED).get(0);
        assertEquals("encounter_id,type,when,description,occurrences", firstLine,
                "Seed header mismatch (or wrong file).");
    }

    // -------- findAll --------
    @Test
    void shouldFindAll_fromSeed() throws Exception {
        List<Encounter> all = repo.findAll();
        assertEquals(5, all.size(), "Seed should have 5 rows.");

        // spot-check one known row
        assertTrue(all.stream().anyMatch(e ->
                e.getEncounterId() == 1 &&
                        e.getType() == EncounterType.UFO &&
                        "2023-10-01T20:05".equals(e.getWhen()) &&
                        "Disc over stadium".equals(e.getDescription()) &&
                        e.getOccurrences() == 1));
    }

    // -------- add --------
    @Test
    void shouldAdd_assignNextId() throws Exception {
        Encounter e = new Encounter(0, EncounterType.UFO, "2025-01-01T00:00", "Test addition", 2);
        Encounter added = repo.add(e);
        assertNotNull(added);
        assertEquals(6, added.getEncounterId(), "Seed ends at id 5, next should be 6.");
        assertTrue(repo.findAll().stream().anyMatch(x -> x.getEncounterId() == 6));
    }

    // -------- findByType --------
    @Test
    void findByType_shouldReturnUfos() throws Exception {
        var ufos = repo.findByType(EncounterType.UFO);
        assertEquals(2, ufos.size(), "Seed has 2 UFO rows (ids 1 and 4).");
        assertTrue(ufos.stream().allMatch(x -> x.getType() == EncounterType.UFO));
    }

    @Test
    void findByType_shouldReturnEmpty_whenTypeIsNull() throws Exception {
        var none = repo.findByType(null);
        assertNotNull(none);
        assertTrue(none.isEmpty());
    }

    // -------- update --------
    @Test
    void update_shouldReplace_whenIdExists() throws Exception {
        var current = repo.findAll().stream()
                .filter(e -> e.getEncounterId() == 3)
                .findFirst().orElseThrow();

        var edited = new Encounter(
                current.getEncounterId(),
                current.getType(),
                current.getWhen(),
                "Updated: persistent humming near river",
                current.getOccurrences() + 1
        );

        assertTrue(repo.update(edited));

        var after = repo.findAll().stream()
                .filter(e -> e.getEncounterId() == 3)
                .findFirst().orElseThrow();

        assertEquals("Updated: persistent humming near river", after.getDescription());
        assertEquals(current.getOccurrences() + 1, after.getOccurrences());
    }

    @Test
    void update_shouldReturnFalse_whenIdMissing() throws Exception {
        var phantom = new Encounter(9999, EncounterType.VOICE, "2020-01-01", "no-op", 1);
        assertFalse(repo.update(phantom));
    }

    // -------- deleteById --------
    @Test
    void deleteById_shouldDelete_whenFound() throws Exception {
        assertTrue(repo.deleteById(2));
        assertTrue(repo.findAll().stream().noneMatch(e -> e.getEncounterId() == 2));
    }

    @Test
    void deleteById_shouldReturnFalse_whenMissing() throws Exception {
        assertFalse(repo.deleteById(9999));
    }
}

