package org.example;

public class Student {
    private String firstName;
    private String lastName;
    private double GPA;
    private Teacher homeroom; // replaces homeroomTeacherFirstName/LastName

    // Homeroom (Teacher)
    public Teacher getHomeroom() {
        return homeroom;
    }

    public void setHomeroom(Teacher homeroom) {
        this.homeroom = homeroom;
    }

    // GPA
    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    // Last name
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName =lastName;
    }

    // First name
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // helper for printing
    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }
}
