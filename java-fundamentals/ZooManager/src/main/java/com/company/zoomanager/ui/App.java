package main.java.com.company.zoomanager.ui;
import main.java.com.company.zoomanager.business.Animal;
import main.java.com.company.zoomanager.business.Zoo;

public class App {
    public static void main(String[] args) {
        Zoo zoo = new Zoo("Philadelphia Zoo");

        Animal lion = new Animal("Lion", 5, "Grrr");
        Animal tiger = new Animal("Tiger", 2, "Roar");
        Animal bear = new Animal("Bear", 2, "Growl-Splash");

        Animal [] population = new Animal[3];
        population[0] = lion;
        population[1] = tiger;
        population[2] = bear;

        zoo.setPopulation(population);

        zoo.printPopulationReport();
        zoo.printAnimalSounds();
    }
}
