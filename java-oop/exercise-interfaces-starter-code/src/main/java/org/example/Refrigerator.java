package org.example;

public class Refrigerator implements Connectable {
    boolean state;

    public Refrigerator(){
        state = false;
    }

    public void turnOn() {
        this.state = true;
    }
    public void turnOff() {
        this.state = false;
    }
    public boolean getState() {
        return this.state;
    }
    public String getName() {
        return "LG Magic Internet Refrigerator with 5G Hoagie Transporter";

    }
}
