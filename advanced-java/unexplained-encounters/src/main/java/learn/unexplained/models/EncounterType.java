package learn.unexplained.models;

public enum EncounterType {
    UFO,
    CREATURE,
    VOICE,
    SOUND,
    VISION;

    public static EncounterType fromString (String s) {
        if (s == null) return null;
        return EncounterType.valueOf(s.trim().toUpperCase());
    }
}
