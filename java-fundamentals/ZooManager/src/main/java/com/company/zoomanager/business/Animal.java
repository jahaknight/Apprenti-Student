package main.java.com.company.zoomanager.business;

public class Animal {
    // Member Variables
    private String name;
    private int populationCount;
    private String sound;

    //Constructor
    public Animal(String name, int populationCount, String sound){
        this.name = name;
        this.populationCount = populationCount;
        this.sound= sound;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulationCount() {
        return populationCount;
    }

    public void setPopulationCount(int populationCount) {
        this.populationCount = populationCount;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }


}

