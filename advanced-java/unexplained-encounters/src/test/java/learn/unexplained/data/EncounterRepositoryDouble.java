package learn.unexplained.data;

import learn.unexplained.models.Encounter;
import learn.unexplained.models.EncounterType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EncounterRepositoryDouble implements EncounterRepository {

    private final List<Encounter> store = new ArrayList<>();

    public EncounterRepositoryDouble() {
        // seed with one record
        store.add(new Encounter(2, EncounterType.CREATURE, "1/1/2015", "test description", 1));
    }

    @Override
    public List<Encounter> findAll() throws DataAccessException {
        // defensive copy
        return store.stream().map(this::copy).collect(Collectors.toList());
    }

    @Override
    public List<Encounter> findByType(EncounterType type) throws DataAccessException {
        if (type == null) return List.of();
        return store.stream()
                .filter(e -> e.getType() == type)
                .map(this::copy)
                .collect(Collectors.toList());
    }

    @Override
    public Encounter add(Encounter encounter) throws DataAccessException {
        if (encounter == null) return null;
        Encounter toAdd = copy(encounter);
        toAdd.setEncounterId(nextId());
        store.add(toAdd);
        return copy(toAdd);
    }

    @Override
    public boolean update(Encounter encounter) throws DataAccessException {
        if (encounter == null) return false;
        for (int i = 0; i < store.size(); i++) {
            if (store.get(i).getEncounterId() == encounter.getEncounterId()) {
                store.set(i, copy(encounter));
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteById(int encounterId) throws DataAccessException {
        return store.removeIf(e -> e.getEncounterId() == encounterId);
    }

    // ---- helpers ----
    private int nextId() {
        int max = 0;
        for (Encounter e : store) {
            if (e.getEncounterId() > max) max = e.getEncounterId();
        }
        return max + 1;
    }

    private Encounter copy(Encounter e) {
        return new Encounter(
                e.getEncounterId(),
                e.getType(),
                e.getWhen(),
                e.getDescription(),
                e.getOccurrences()
        );
    }
}

