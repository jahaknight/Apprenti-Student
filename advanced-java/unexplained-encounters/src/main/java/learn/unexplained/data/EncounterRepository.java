package learn.unexplained.data;

import learn.unexplained.models.Encounter;
import learn.unexplained.models.EncounterType;

import java.util.List;

/**
 * Data access contract for Encounter records
 *
 * Note:
 * Adding two methods: findByType(...) and update(...)
 */

public interface EncounterRepository {
    // Return all encounters from data store
    List<Encounter> findAll() throws DataAccessException;

    /**
     * @return all encounters that match given type
     * Implementations should return an empty list (not null) if type is null
     */
    List<Encounter> findByType(EncounterType type) throws DataAccessException;

    /**
     * Add new encounter
     */

    Encounter add(Encounter encounter) throws DataAccessException;
    boolean update(Encounter encounter) throws DataAccessException;

    boolean deleteById(int encounterId) throws DataAccessException;
}
