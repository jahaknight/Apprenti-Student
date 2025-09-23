package learn.unexplained.ui;

import learn.unexplained.data.DataAccessException;
import learn.unexplained.domain.EncounterResult;
import learn.unexplained.domain.EncounterService;
import learn.unexplained.models.Encounter;
import learn.unexplained.models.EncounterType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Controller {

    private final EncounterService service;
    private final View view;

    public Controller(EncounterService service, View view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        view.printHeader("Welcome To Unexplained Encounters.");

        try {
            runMenuLoop();
        } catch (DataAccessException ex) {
            view.printHeader("CRITICAL ERROR: " + ex.getMessage());
        }

        view.printHeader("Goodbye");
    }

    private void runMenuLoop() throws DataAccessException {
        while (true) {
            MenuOption option = view.displayMenuGetOption();
            switch (option) {
                case DISPLAY_BY_TYPE:
                    displayByType();
                    break;
                case ADD:
                    addEncounter();
                    break;
                case UPDATE:
                    updateEncounter();
                    break;
                case DELETE:
                    deleteEncounter();
                    break;
                case EXIT:
                default:
                    return;
                }
            }
        }

    // Display By Type
    private void displayByType() throws DataAccessException {
        EncounterType type = view.readType();
        List<Encounter> list = service.findByType(type);
        view.showEncounters(list);
    }

    // Add
    private void addEncounter() throws DataAccessException {
        Encounter toAdd = view.makeEncounter();
        EncounterResult result = service.add(toAdd);
        view.printAddResult(result);
    }

    // Update
    private void updateEncounter() throws DataAccessException {
        EncounterType type = view.readType();
        List<Encounter> candidates = service.findByType(type);
        if (candidates.isEmpty()) {
            view.say("No encounters of that type.");
            return;
        }

        Encounter selected = view.chooseFrom(candidates);
        if (selected == null) return;

        Encounter edited = view.editEncounter(selected);
        EncounterResult result = service.update(edited);
        view.printUpdateResult(result);
    }

    // Delete
    private void deleteEncounter() throws DataAccessException {
        int id = view.readEncounterId();
        boolean deleted = service.deleteById(id);
        view.say(deleted ? "Deleted." : "Not found.");
    }
}

