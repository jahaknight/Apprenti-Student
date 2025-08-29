package org.example.compositionexercise;

// simple value object used by Artifact via composition (Artifact "has-a" Person)

public class Person {
    private final String firstName;
    private final String lastName;
    private final String primarySpecialty;

    public Person(String firstName, String lastName, String primarySpecialty) {
        // null/blank guards
        if (firstName == null || firstName.isBlank()) throw new IllegalArgumentException("first name required");
        if (lastName == null || lastName.isBlank()) throw new IllegalArgumentException("last name required");
        if (primarySpecialty == null || primarySpecialty.isBlank()) throw new IllegalArgumentException("primary specialty required");
        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
        this.primarySpecialty = primarySpecialty.trim();
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPrimarySpecialty() { return primarySpecialty; }

    @Override
    public String toString() {
        // to match exercise template
        return firstName + " " + lastName + ", " + primarySpecialty;
    }
}
