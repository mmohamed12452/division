package JavaFiles.Data;

public class Student {
    private int id;         // Student ID
    private String name;    // Student Name
    private double grade;   // Student Grade

    // Constructor to initialize a student
    public Student(int id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    // Getters and setters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getGrade() { return grade; }
    public void setGrade(double grade) { this.grade = grade; }

    // Convert student object to a string suitable for saving in a file
    @Override
    public String toString() {
        return id + "," + name + "," + grade;
    }
}
