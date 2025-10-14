package learn.pets;
import learn.pets.data.PetJdbcRepository;
import learn.pets.models.Pet;

/**
 * Minimal runner to verify JDBC wiring.
 * 1) Checks DB connectivity.
 * 2) Prints existing pets.
 * 3) Does a quick add → update → delete so you know CRUD works end-to-end.
 */

public class Main {
    public static void main(String[] args) {
        PetJdbcRepository repo = new PetJdbcRepository();

        // 1. Connectivity Check
        System.out.println("DB reachable?" + repo.canConnect());

        // 2. Read Existing Data
        System.out.println("\\n=== Pets (before) ===");
        repo.findAll().forEach(System.out::println);

        // 3. Quick CRUD test

        // CREATE
        Pet p = new Pet();
        p.setName("TempPet");
        p.setType("Dog");
        p = repo.add(p);
        System.out.println("\nAdded: " + p);

        // UPDATE
        p.setType("Super Dog");
        boolean updated = repo.update(p);
        System.out.println("Updated?" + updated);

        // READ (by id)
        Pet reloaded = repo.findById(p.getPetId());
        System.out.println("Reloaded: " + reloaded);

        // Final read
        System.out.println("\n=== Pets (after) ===");
        repo.findAll().forEach(System.out::println);
    }
}
