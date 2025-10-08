package main.java.assignment05;
import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> studentList;

    public StudentManager() {
        studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public boolean removeStudent(int studentId) {
        for (Student s : studentList) {
            if (s.getStudentId() == studentId) {
                studentList.remove(s);
                return true;
            }
        }
        return false;
    }

    public Student findStudent(int studentId) {
        for (Student s : studentList) {
            if (s.getStudentId() == studentId) {
                return s;
            }
        }
        return null;
    }

    public void printAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student s : studentList) {
                System.out.println(s.toString());
            }
        }
    }

    public double getAverageGpa() {
        if (studentList.isEmpty()) return 0.0;
        double total = 0;
        for (Student s : studentList) {
            total += s.getGpa();
        }
        return total / studentList.size();
    }

    public int getTotalStudents() {
        return studentList.size();
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }
}

