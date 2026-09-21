package JavaFiles.Data;// StudentManager.java

import java.util.*;

// Main class to run the student management system
public class StudentManager {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Filehandling.createDataFolder(); // Ensure folder exists
        int choice;
        do {
            showMenu();
            choice = getIntInput();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> displayStudents();
                case 3 -> updateGrade();
                case 4 -> deleteStudent();
                case 5 -> System.out.println("Exiting program...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }

    // Show the menu options
    private static void showMenu() {
        System.out.println("\n=== Student Management Menu ===");
        System.out.println("1. Add a new student");
        System.out.println("2. Display all students");
        System.out.println("3. Update a student's grade");
        System.out.println("4. Delete a student");
        System.out.println("5. Exit");
    }

    // Add a new student
    private static void addStudent() {
        int id = getIntInput();
        String name = getStringInput("Enter student name: ");
        double grade = getDoubleInput("Enter student grade: ");

        Student student = new Student(id, name, grade);
        Filehandling.appendStudent(student); // Append to file
        System.out.println("Student added successfully!");
    }

    // Display all students in a table
    private static void displayStudents() {
        List<Student> students = Filehandling.readStudents();
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.printf("%-10s %-20s %-10s%n", "ID", "Name", "Grade");
        System.out.println("----------------------------------------");
        for (Student s : students) {
            System.out.printf("%-10d %-20s %-10.2f%n", s.getId(), s.getName(), s.getGrade());
        }
    }

    // Update a student's grade
    private static void updateGrade() {
        List<Student> students = Filehandling.readStudents();
        if (students.isEmpty()) {
            System.out.println("No students to update.");
            return;
        }

        int id = getIntInput();
        boolean found = false;

        for (Student s : students) {
            if (s.getId() == id) {
                double newGrade = getDoubleInput("Enter new grade: ");
                s.setGrade(newGrade);
                found = true;
                break;
            }
        }

        if (found) {
            Filehandling.writeStudents(students);
            System.out.println("Student grade updated successfully!");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Delete a student
    private static void deleteStudent() {
        List<Student> students = Filehandling.readStudents();
        if (students.isEmpty()) {
            System.out.println("No students to delete.");
            return;
        }

        int id = getIntInput();
        boolean removed = students.removeIf(s -> s.getId() == id);

        if (removed) {
            Filehandling.writeStudents(students);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Helper methods for input
    public static int getIntInput() {
        while (true) {
            boolean prompt = false;
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    private static double getDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid decimal number. Try again.");
            }
        }
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}