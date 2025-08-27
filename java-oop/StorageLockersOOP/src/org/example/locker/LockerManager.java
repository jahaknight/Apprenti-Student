package org.example.locker;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;

public class LockerManager {
    // List all lockers
    private ArrayList<Locker> lockers;

    // Constructor - empty list of lockers
    public LockerManager() {
        lockers = new ArrayList<>();
    }

    // Add new locker
    public void addLocker (String lockerId) {
        Locker newLocker = new Locker(lockerId);
        lockers.add(newLocker);
        System.out.println("Locker " + lockerId + " added.");
    }

    // Get locker ID (return null if not found)
    public Locker getLocker(String lockerID) {
        for (Locker l : lockers) {
            if(l.getLockerId().equals(lockerID)) {
                return l;
            }
        }
        return null; // if nothing found
    }

    // Remove a locker by ID
    public void removeLocker(String lockerId) {
        Locker locker = getLocker(lockerId);
        if (locker != null) {
            lockers.remove(locker);
            System.out.println("Locker " + lockerId + " removed.");
        } else {
            System.out.println("Locker " + lockerId + " not found.");
        }
    }

    // show all lockers
    public void displayAllLockers() {
        if (lockers.isEmpty()) {
            System.out.println("No lockers to display.");
        } else {
            for (Locker l : lockers) {
                System.out.println(l);
            }
        }
    }
}
