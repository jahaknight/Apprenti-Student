package learn.unexplained.models;

import java.util.Objects;

public class Encounter {

    private int encounterId;
    private EncounterType type;
    private String when;
    private String description;
    private int occurrences;

    public Encounter() { }

    public Encounter(int encounterId, EncounterType type, String when, String description, int occurrences) {
        this.encounterId = encounterId;
        this.type = type;
        this.when = when;
        this.description = description;
        this.occurrences = occurrences;
    }

    public int getEncounterId() {
        return encounterId;
    }
    public void setEncounterId(int encounterId) {
        this.encounterId = encounterId;
    }

    public EncounterType getType() {
        return type;
    }
    public void setType(EncounterType type) {
        this.type = type;
    }

    public String getWhen() {
        return when;
    }
    public void setWhen(String when) {
        this.when = when;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getOccurrences() {
        return occurrences;
    }
    public void setOccurrences(int occurrences) {
        this.occurrences = occurrences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Encounter)) return false;
        Encounter that = (Encounter) o;
        return encounterId == that.encounterId
                && occurrences == that.occurrences
                && type == that.type
                && Objects.equals(when, that.when)
                && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(encounterId, type, when, description, occurrences);
    }
}
