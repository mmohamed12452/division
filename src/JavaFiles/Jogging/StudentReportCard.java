package JavaFiles.Jogging;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentReportCard {
    static final String FILE_NAME = "grades.csv";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ensure file exists
        createFileIfNotExists();

        while (true) {
            System.out.println("\n--- Student Report Card System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Update Grade");
            System.out.println("3. Calculate Average");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    updateGrade(sc);
                    break;
                case 3:
                    calculateAverage();
                    break;
                case 4:
                    generateReport();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Create file if it doesn't exist
    static void createFileIfNotExists() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            try (FileWriter fw = new FileWriter(file)) {
                fw.write("StudentID,Name,Grade\n");
                System.out.println("File created: " + FILE_NAME);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Add student
    static void addStudent(Scanner sc) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            System.out.print("Enter Student ID: ");
            String id = sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Grade: ");
            double grade = sc.nextDouble();
            sc.nextLine();

            fw.write(id + "," + name + "," + grade + "\n");
            System.out.println("Student added successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Update grade
    static void updateGrade(Scanner sc) {
        List<String> lines = new ArrayList<>();

        System.out.print("Enter Student ID to update: ");
        String targetId = sc.nextLine();

        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.startsWith("StudentID")) {
                    lines.add(line);
                    continue;
                }

                String[] parts = line.split(",");
                if (parts[0].equals(targetId)) {
                    System.out.print("Enter new grade: ");
                    double newGrade = sc.nextDouble();
                    sc.nextLine();

                    line = parts[0] + "," + parts[1] + "," + newGrade;
                    found = true;
                }
                lines.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!found) {
            System.out.println("Student not found!");
            return;
        }

        // Write back (overwrite)
        try (FileWriter fw = new FileWriter(FILE_NAME)) {
            for (String l : lines) {
                fw.write(l + "\n");
            }
            System.out.println("Grade updated successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Calculate average
    static void calculateAverage() {
        double sum = 0;
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                sum += Double.parseDouble(parts[2]);
                count++;
            }

            if (count > 0) {
                System.out.println("Class Average: " + (sum / count));
            } else {
                System.out.println("No student records found.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Generate report
    static void generateReport() {
        try (
                BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
                FileWriter fw = new FileWriter("report.txt")
        ) {
            String line;
            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0];
                String name = parts[1];
                double grade = Double.parseDouble(parts[2]);

                String remark;
                if (grade >= 85) {
                    remark = "Excellent";
                } else if (grade >= 70) {
                    remark = "Good";
                } else {
                    remark = "Needs improvement";
                }

                fw.write(id + " - " + name + " - " + grade + " - " + remark + "\n");
            }

            System.out.println("Report generated: report.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
