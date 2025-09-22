package learn.unexplained.ui;

public enum MenuOption {
    DISPLAY_BY_TYPE(1, "Display Encounters by Type"),
    ADD(2, "Add an Encounter"),
    UPDATE(3, "Update an Encounter"),
    DELETE(4, "Delete an Encounter"),
    EXIT(5, "Exit");

    private final int value;
    private final String message;

    MenuOption(int value, String message) {
        this.value = value;
        this.message = message;
    }

    public int getValue() {return value; }
    public String getMessage() {return message; }

    public static MenuOption fromValue(int value) {
        for (MenuOption m : values()) {
            if (m.value == value) return m;
        }
        return null;

    }
}
