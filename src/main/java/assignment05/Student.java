package main.java.assignment05;

public class Student {
    // Variables
    private int studentId;
    private String firstName;
    private String lastName;
    private double gpa;
    private boolean isEnrolled;

    public Student(int studentId, String firstName, String lastName, double gpa) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gpa = gpa;
        this.isEnrolled = true;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getGpa() {
        return gpa;
    }

    public boolean isEnrolled() {
        return isEnrolled;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void setEnrolled(boolean enrolled) {
        this.isEnrolled = enrolled;
    }

    public String getStudentFullName() {
        return firstName + " " + lastName;
    }

    public String toString() {
        return "[ID: " + studentId + "] Name: " + getStudentFullName() +
                " | GPA: " +  gpa +
                " | Enrolled: " + isEnrolled;
    }
}

