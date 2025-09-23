package learn.unexplained.ui;

import learn.unexplained.domain.EncounterResult;
import learn.unexplained.models.Encounter;
import learn.unexplained.models.EncounterType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class View {

    private final Scanner console = new Scanner(System.in);

    // Menu
    public MenuOption displayMenuGetOption() {
        printHeader("Main Menu");
        for (MenuOption m : MenuOption.values()) {
            System.out.printf("%d. %s%n", m.getValue(), m.getMessage());
        }

        int choice = readInt("Choose option: ");
        MenuOption opt = MenuOption.fromValue(choice);
        if (opt == null) opt = MenuOption.EXIT;
        return opt;

    }

    // Display by Type
    public EncounterType readType() {
        System.out.println("Encounter Types:");
        int idx = 1;
        for (EncounterType t : EncounterType.values()) {
            System.out.printf("%d. %s%n", idx++, t.name());
        }
        int pick = readInt("Select type [1-" + (idx - 1) + "]: ", 1, idx - 1);
        return EncounterType.values()[pick - 1];
    }

    public void showEncounters(List<Encounter> encounters) {
        if (encounters == null || encounters.isEmpty()) {
            System.out.println("(none)");
            return;
        }
        for (Encounter e : encounters) {
            System.out.printf("Id:%d | %s | when:%s | occ:%d | %s%n",
                    e.getEncounterId(), e.getType(),
                    nz(e.getWhen()), e.getOccurrences(), nz(e.getDescription()));
        }
    }

    // Add
    public Encounter makeEncounter() {
        printHeader(MenuOption.ADD.getMessage());
        Encounter e = new Encounter();
        e.setType(readType());
        e.setOccurrences(readInt("Occurrences: "));
        e.setWhen(readRequiredString("When (YYYY-MM-DD or YYYY-MM-DDTHH:MM): "));
        e.setDescription(readRequiredString("Description: "));
        return e;
    }

    public void printAddResult(EncounterResult result) {
        if (result.isSuccess() && result.getPayload() != null) {
            System.out.printf("Encounter Id %d added.%n", result.getPayload().getEncounterId());
        } else {
            showMessages(result.getMessages());
        }
    }

    // update
    // show list with numbers and return encounter
    public Encounter chooseFrom(List<Encounter> list) {
        if (list == null || list.isEmpty()) return null;
        for (int i = 0; i < list.size(); i++) {
            Encounter e = list.get(i);
            System.out.printf("%d) Id:%d %s %s%n",
                    i + 1, e.getEncounterId(), e.getType(), nz(e.getDescription()));
        }
        int idx = readInt("Choose [1-" + list.size() + "] or 0 to cancel: ");
                        if (idx == 0 || idx < 1 || idx > list.size()) return null;
                        return list.get(idx - 1);
    }

    public Encounter editEncounter(Encounter original) {
        System.out.println("Press Enter to keep the current value.");
        Encounter edited = new Encounter();
        edited.setEncounterId(original.getEncounterId());

        String typeIn = readLine("Type (" + original.getType() + "): ").trim();
        if (typeIn.isEmpty()) {
            edited.setType(original.getType());
        } else {
            try {
                edited.setType(EncounterType.valueOf(typeIn.toUpperCase()));
            } catch (Exception ex) {
                System.out.println("Invalid type. Keeping original.");
                edited.setType(original.getType());
            }
        }

        String whenIn = readLine("When (" + nz(original.getWhen()) + "): ").trim();
        edited.setWhen(whenIn.isEmpty() ? original.getWhen() : whenIn);

        String descIn = readLine("Description (" + nz(original.getDescription()) + "): ").trim();
        edited.setDescription(descIn.isEmpty() ? original.getDescription() : descIn);

        String occIn = readLine("Occurrences (" + original.getOccurrences() + "): ").trim();
        int occ = original.getOccurrences();
        if (!occIn.isEmpty()) {
            try { occ = Integer.parseInt(occIn); } catch (Exception ignored) { }
        }
        edited.setOccurrences(occ);

        return edited;
    }

    public void printUpdateResult(EncounterResult result) {
        if (result.isSuccess()) {
            System.out.println("Updated");
        } else {
            showMessages(result.getMessages());
        }
    }

    // Delete
    public int readEncounterId() {
        return readInt("Enter encounter id: ");
    }

    // UTIL
    public void printHeader(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println("=".repeat(message.length()));
    }

    public void showMessages(List<String> messages) {
        if (messages == null || messages.isEmpty()) return;
        printHeader("Errors");
        for (String m : messages) System.out.println("- " + m);
    }

    public void say(String msg) { System.out.println(msg); }
    public void error(String msg) { System.out.println("[ERROR] " + msg); }

    // input helpers
    private String readLine(String prompt) {
        System.out.print(prompt);
        return console.nextLine();
    }

    private String readRequiredString(String message) {
        while (true) {
            String s = readLine(message);
            if (s != null && !s.trim().isEmpty()) return s.trim();
            System.out.println("Value is required.");
        }
    }

    private int readInt(String message) {
        while (true) {
            String s = readRequiredString(message);
            try { return Integer.parseInt(s); }
            catch (NumberFormatException ex) { System.out.printf("%s is not a valid number.%n", s); }
        }
    }

    private int readInt(String message, int min, int max) {
        while (true) {
            int val = readInt(message);
            if (val >= min && val <= max) return val;
            System.out.printf("Value must be between %d and %d.%n", min, max);
        }
    }

    private String nz(String s) { return s == null ? "" : s; }
}