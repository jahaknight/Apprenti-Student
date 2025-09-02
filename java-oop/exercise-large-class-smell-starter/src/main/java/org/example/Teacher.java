package org.example;

// Separated from Student
// Represents teacher identity
public class Teacher {

    private String firstName;
    private String lastName;

    // Constructors
    public Teacher(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("firstName cannot be null or blank");
        }
        this.firstName = firstName.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("lastName cannot be null or blank");
        }
        this.lastName = lastName.trim();
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    @Override
    public String toString() {
        return getFullName();
    }
}
