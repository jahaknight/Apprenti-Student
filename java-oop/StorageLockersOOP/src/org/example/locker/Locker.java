package org.example.locker;
// Represents one storage locker
// Fields will hold the data; methods will change/read the data

public class Locker {
    // Fields
    // Locker has unique ID since we are doing one
    private final String lockerId;

    // Is locker in use?
    private boolean isOccupied;

    // Anything inside?
    private String contents;

    //Constructor
    // Create a new locker w/ required ID
    // By default a new locker is empty and not occupied
    public Locker(String lockerId) {
        if (lockerId == null || lockerId.isBlank()) {
            throw new IllegalArgumentException("lockerId cannot be blank");
        }
        this.lockerId = lockerId;
        this.isOccupied = false;
        this.contents = "";
    }

    // Behavior
    // Store an item in locker and label occupied
    public void storeItem(String item) {
        if (item == null || item.isBlank()) {
            throw new IllegalArgumentException("Item cannot be empty");
        }
        this.contents = item;
        this.isOccupied = true;
    }

    // Remove what is in locker , mark as unoccupied
    // return what was moved
    public String removeItem() {
        String removed = this.contents;
        this.contents= "";
        this.isOccupied = false;
        return removed;
    }

    // Getters
    public String getLockerId() {
        return lockerId;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public String getContents() {
        return contents;
    }

    // Clean print
    // Use override
    public String toString() {
        String displayContents = isOccupied ? contents : "empty";
        return "Locker ID: " + lockerId
            + "| Occupied: " + isOccupied
            + "| Contents: " + displayContents;
    }
}
