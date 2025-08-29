package org.example;

public class Toaster implements Connectable {
    boolean state;

    public Toaster() {
        state = false; // default off
    }

    public void turnOn() {
        state = true; // Turns on
    }

    public void turnOff() {
        state = false; // Turns off
    }

    public boolean getState() {
        return state;
    }

    public String getName() {
        return "Mega Toaster 5000";
    }

}
