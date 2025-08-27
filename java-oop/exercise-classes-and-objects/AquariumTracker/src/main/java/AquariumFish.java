import java.security.PublicKey;

public class AquariumFish {

    // Fields (state)
    private String species;
    private String commonName;
    private double maxTemp;
    private double minTemp;
    private String diet;

    // Constructors //
    public AquariumFish() {
        // fields can be set once we have setters
    }

    public AquariumFish(String species, String commonName, double maxTemp, double minTemp, String diet) {
        this.species = species;
        this.commonName = commonName;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.diet = diet;
    }

    // Behavior
    // Returns average of min and max temperatures
    public double getAverageTemp() {
        return (minTemp + maxTemp) / 2.0;
    }

    // Getters/ Setters
    public String getSpecies() { return species;}
    public void setSpecies(String species) {this.species =species;}

    public String getCommonName() { return species;}
    public void setCommonName(String commonName) {this.commonName = commonName;}

    public double getMaxTemp() { return  maxTemp;}
    public void setMaxTemp(double maxTemp) {this.maxTemp = maxTemp;}

    public double getMinTemp() {return  minTemp;}
    public void setMinTemp(double minTemp) {this.minTemp = minTemp;}

    public String getDiet() {return diet;}
    public void setDiet(String diet) {this.diet = diet;}

    // Clean Print so there are no weird decimals, can use override here
    @Override
    public String toString() {
        return "Species: " + species + "\n" +
                "Common Name: " + commonName + "\n" +
                "Maximum Temperature: " + maxTemp + "\n" +
                "Diet: " + diet;

    }
}
