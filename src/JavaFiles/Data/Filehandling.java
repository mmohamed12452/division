package JavaFiles.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Filehandling
{
    private static final String FOLDER = "Data";
    private static final String FILE_PATH = FOLDER + "/students.txt";

    // Ensure the Data folder exists
    public static void createDataFolder() {
        File folder = new File(FOLDER);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    // Read all students from the file and return as a list
    public static List<Student> readStudents() {
        List<Student> students = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) return students; // If file doesn't exist, return empty list

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    double grade = Double.parseDouble(parts[2]);
                    students.add(new Student(id, name, grade));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return students;
    }

    // Write the list of students back to the file (overwrite)
    public static void writeStudents(List<Student> students) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Student s : students) {
                bw.write(s.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Append a single student to the file
    public static void appendStudent(Student student) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            bw.write(student.toString());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }
}
