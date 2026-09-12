// Specifies the package path where this Java file resides in the project structure
package Deadlocks.Deadlockprevention.trylock;

// Define a public class named Student to represent an individual student entity.
public class Student {

    // Declare a private field to store the student's full name, encapsulating the data.
    private String name;

    // Declare a private field to store the student's unique ID number.
    private String studentId;

    // Declare an array of doubles to hold multiple test or assignment grades for the student.
    private double[] grades;

    // Declare an integer to keep track of how many grades have been added so far.
    private int gradeCount;

    // Define a constructor that accepts the student's name, ID, and maximum capacity for grades.
    public Student(String name, String studentId, int maxGrades) {
        // Assign the name parameter to the class's name instance variable using the 'this' keyword.
        this.name = name;

        // Assign the studentId parameter to the instance variable to uniquely identify this student.
        this.studentId = studentId;

        // Initialize the grades array with a fixed size based on the maxGrades parameter.
        this.grades = new double[maxGrades];

        // Set the initial grade count to 0 because no grades have been recorded yet.
        this.gradeCount = 0;
    }

    // Define a method to add a new grade to the student's record.
    public void addGrade(double grade) {
        // Check if the input grade falls within the valid percentage range (0.0 to 100.0).
        if (grade >= 0.0 && grade <= 100.0) {

            // Check if there is still room left in the array to store another grade.
            if (gradeCount < grades.length) {

                // Store the grade at the current index and increment gradeCount afterwards.
                grades[gradeCount] = grade;
                gradeCount++;

                // Print a confirmation message to standard output indicating success.
                System.out.println("Successfully added grade: " + grade);
            } else {
                // Display an error message if the grades array has reached maximum capacity.
                System.out.println("Error: Grade capacity reached. Cannot add more grades.");
            }
        } else {
            // Display an error message if the provided grade value is out of bounds.
            System.out.println("Error: Grade must be between 0.0 and 100.0.");
        }
    }

    // Define a method to calculate and return the average score of all recorded grades.
    public double calculateAverage() {
        // If no grades have been entered yet, return 0.0 to avoid division by zero.
        if (gradeCount == 0) {
            return 0.0;
        }

        // Declare a variable to store the cumulative sum of all grades.
        double totalSum = 0.0;

        // Loop through only the valid entered grades up to the gradeCount index.
        for (int i = 0; i < gradeCount; i++) {

            // Add each individual grade to the running total.
            totalSum += grades[i];
        }

        // Divide the total sum by the number of recorded grades to get the arithmetic mean.
        return totalSum / gradeCount;
    }

    // Define a boolean method to check if the student meets the passing condition (50% or higher).
    public boolean hasPassed() {
        // Call calculateAverage() and check if the result is greater than or equal to 50.0.
        return calculateAverage() >= 50.0;
    }

    // Getter method to retrieve the student's name.
    public String getName() {
        return name;
    }

    // Getter method to retrieve the student's unique ID.
    public String getStudentId() {
        return studentId;
    }

    // Getter method to retrieve the current total number of grades recorded.
    public int getGradeCount() {
        return gradeCount;
    }

    // Main execution method to test and demonstrate the Student class functionality.
    public static void main(String[] args) {

        // Instantiate a new Student object named "Mohamed" with ID "S101" and capacity for 5 grades.
        Student student = new Student("Bryson", "S101", 8);

        // Print header information introducing the student record being processed.
        System.out.println("=== Student Grade Tracker ===");
        System.out.println("Student Name: " + student.getName());
        System.out.println("Student ID:   " + student.getStudentId());
        System.out.println("----------------------------------");

        // Add sample academic marks to the student's record using addGrade.
        student.addGrade(85.5);
        student.addGrade(92.0);
        student.addGrade(78.0);
        student.addGrade(88.5);

        student.addGrade(20.0);
        student.addGrade(10.0);
        student.addGrade(4.0);
        student.addGrade(2.0);


        // Compute the final average score by invoking calculateAverage().
        double average = student.calculateAverage();

        // Print the calculated average formatted nicely to the console.
        System.out.println("----------------------------------");
        System.out.println("Total Grades Entered: " + student.getGradeCount());
        System.out.println("Calculated Average:   " + average + "%");

        // Determine passing status using the hasPassed method and display the result.
        if (student.hasPassed()) {
            System.out.println("Academic Status:    PASSED");
        } else {
            System.out.println("Academic Status:    FAILED");
        }
    }
}