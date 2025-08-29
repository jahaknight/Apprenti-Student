package org.example.compositionexercise;
// Artifact COMPOSES two Person objects : discoverer and curator
public class Artifact {
    private final String name;
    private final int yearOfDiscovery;
    private final Person discoverer;
    private final Person curator;

    public Artifact(String name, int yearOfDiscovery, Person discoverer, Person curator) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("artifact name required");
        this.name = name.trim();
        this.yearOfDiscovery = yearOfDiscovery;
        if (discoverer == null) throw new IllegalArgumentException("discoverer required");
        if (curator == null) throw new IllegalArgumentException("curator required");
        this.discoverer = discoverer;
        this.curator = curator;
    }

    public String getName()         { return name; }
    public int getYearOfDiscovery() { return yearOfDiscovery; }
    public Person getDiscoverer()   { return discoverer; }
    public Person getCurator()      { return curator; }

    @Override
    public String toString() {
        // 3 line report
        return "Artifact:   " + name + " (" + yearOfDiscovery + ")\n" +
                "Discoverer: " + discoverer + "\n" +
                "Curator:    " + curator;
    }
}
