package org.example;

public class Television implements Connectable {
    boolean state;

    public Television() {
        this.state = false; //Off
    }

    public void turnOn() {
        this.state = false;
    }

    public void turnOff() {
        this.state = false;
    }

    public boolean getState() {
        return state;
    }

    public String getName()  {
        return "SAMSUNGXG9-4K-5G-OLED";
    }

}
