package learn.unexplained.domain;

import learn.unexplained.data.DataAccessException;
import learn.unexplained.data.EncounterRepository;
import learn.unexplained.models.Encounter;
import learn.unexplained.models.EncounterType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EncounterService {

    private final EncounterRepository repository;

    public EncounterService(EncounterRepository repository) {
        this.repository = repository;
    }

    // queries
    public List<Encounter> findAll() throws DataAccessException {
        return repository.findAll();
    }

    public List<Encounter> findByType(EncounterType type) throws DataAccessException {
        if (type == null) return List.of();
        return repository.findByType(type);
    }


    public EncounterResult add(Encounter encounter) throws DataAccessException {
        EncounterResult result = validate(encounter, false);
        if (!result.isSuccess()) {
            return result;
        }

        // check for duplicate
        for (Encounter e : repository.findAll()) {
            if (Objects.equals(encounter.getWhen(), e.getWhen())
                    && Objects.equals(encounter.getType(), e.getType())
                    && Objects.equals(encounter.getDescription(), e.getDescription())) {
                result.addErrorMessage("duplicate encounter is not allowed");
                return result;
            }
        }

        encounter = repository.add(encounter);
        result.setPayload(encounter);
        return result;
    }

    public EncounterResult update(Encounter encounter) throws DataAccessException {
        // require ID to update
        EncounterResult result = validate(encounter, true);
        if (!result.isSuccess()) {
            return result;
        }

        // prevents duplicates (ignore current record with same ID)
        for (Encounter e : repository.findAll()) {
            if (e.getEncounterId() != encounter.getEncounterId()
                    && Objects.equals(encounter.getWhen(), e.getWhen())
                    && Objects.equals(encounter.getType(), e.getType())
                    && Objects.equals(encounter.getDescription(), e.getDescription())) {
                result.addErrorMessage("duplicate encounter is not allowed");
                return result;
            }
        }

        boolean updated = repository.update(encounter);
        if (!updated) {
            result.addErrorMessage("encounter id " + encounter.getEncounterId() + " not found");
            return result;
        }

        result.setPayload(encounter);
        return result;

    }

    // delete
    public boolean deleteById(int encounterId) throws DataAccessException {
        return repository.deleteById(encounterId);
    }

    // validation
    private EncounterResult validate(Encounter encounter, boolean requireId) {
        EncounterResult result = new EncounterResult();
        if (encounter == null) {
            result.addErrorMessage("encounter cannot be null");
            return result;
        }

        if (requireId && encounter.getEncounterId() <= 0) {
            result.addErrorMessage("encounter id is required");
        }

        if (encounter.getWhen() == null || encounter.getWhen().trim().isEmpty()) {
            result.addErrorMessage("when is required");
        }

        if (encounter.getDescription() == null || encounter.getDescription().trim().isEmpty()) {
            result.addErrorMessage("description is required");
        }

        if (encounter.getOccurrences() <= 0) {
            result.addErrorMessage("occurrences must be greater than 0");
        }

        if (encounter.getType() == null) {
            result.addErrorMessage("type is required");
        }

        return result;
    }
}
