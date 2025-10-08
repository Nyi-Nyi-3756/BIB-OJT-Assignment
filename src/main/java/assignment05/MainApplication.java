package main.java.assignment05;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        boolean running = true;

        while (running) {

            System.out.println(" STUDENT MANAGEMENT SYSTEM ");
            System.out.println(" 1. Add New Student");
            System.out.println(" 2. Remove Student by ID");
            System.out.println(" 3. Find Student by ID");
            System.out.println(" 4. Display All Students");
            System.out.println(" 5. Calculate Average GPA");
            System.out.println(" 6. Modify Student GPA/Enrollment");
            System.out.println(" 7. Exit");
            System.out.print("Enter your choice (1-7): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Add New Student
                    System.out.println(" ADD STUDENT ");
                    System.out.print("Enter Student ID (int): ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter First Name: ");
                    String first = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    String last = scanner.nextLine();
                    System.out.print("Enter GPA (double): ");
                    double gpa = scanner.nextDouble();
                    scanner.nextLine();

                    Student s = new Student(id, first, last, gpa);
                    manager.addStudent(s);
                    System.out.println("Student " + first + " " + last + " (ID: " + id + ") added successfully.");
                    break;

                case 2: // Remove Student
                    System.out.println(" REMOVE STUDENT ");
                    System.out.print("Enter Student ID to remove: ");
                    int removeId = scanner.nextInt();
                    Student removedStudent = manager.findStudent(removeId);
                    if (removedStudent != null && manager.removeStudent(removeId)) {
                        System.out.println("Student " + removedStudent.getStudentFullName() +
                                " (ID: " + removeId + ") removed successfully.");
                    } else {
                        System.out.println("Student Not Found!");
                    }
                    break;

                case 3: // Find Student
                    System.out.println(" FIND STUDENT ");
                    System.out.print("Enter Student ID to search: ");
                    int findId = scanner.nextInt();
                    Student found = manager.findStudent(findId);
                    if (found != null) {
                        System.out.println("Student Found:");
                        System.out.println(found);
                    } else {
                        System.out.println("Student Not Found!");
                    }
                    break;

                case 4: // All Students
                    System.out.println(" CURRENT STUDENT LIST ");
                    manager.printAllStudents();
                    System.out.println("Total Students:  " + manager.getTotalStudents());
                    break;

                case 5: // Average GPA
                    double avgGpa = manager.getAverageGpa();
                    System.out.println(" Average GPA: " + avgGpa + "\n");
                    break;

                case 6: // Modify GPA or Enrollment
                    System.out.println(" MODIFY STUDENT ");
                    System.out.print("Enter Student ID to modify: ");
                    int modId = scanner.nextInt();
                    Student modifyStudent = manager.findStudent(modId);
                    if (modifyStudent != null) {
                        System.out.println("1. Update GPA");
                        System.out.println("2. Change Enrollment Status");
                        System.out.print("Choose option: ");
                        int modChoice = scanner.nextInt();
                        scanner.nextLine();

                        if (modChoice == 1) {
                            System.out.print("Enter new GPA: ");
                            double newGpa = scanner.nextDouble();
                            modifyStudent.setGpa(newGpa);
                            System.out.println("GPA updated successfully.");
                        } else if (modChoice == 2) {
                            System.out.print("Is student enrolled? (true/false): ");
                            boolean status = scanner.nextBoolean();
                            modifyStudent.setEnrolled(status);
                            System.out.println("Enrollment status updated successfully.");
                        } else {
                            System.out.println("Invalid choice.");
                        }
                    } else {
                        System.out.println("Student Not Found!");
                    }
                    break;

                case 7: // Exit
                    System.out.println("Exiting Student Management System. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 1-7.");
            }
            System.out.println();
        }

        scanner.close();
    }
}
