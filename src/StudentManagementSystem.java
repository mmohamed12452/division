public class StudentManagementSystem {
    // Question 1: Student Class
    static class Student {
        // Private attributes (Encapsulation)
        private String studentId;
        private String name;
        private String grade;
        private int[] marks;

        // Constructor
        public Student(String studentId, String name, int[] marks) {
            this.studentId = studentId;
            this.name = name;
            this.marks = marks;
        }

        // Getters and Setters
        public String getStudentId() {
            return studentId;
        }

        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int[] getMarks() {
            return marks;
        }

        public void setMarks(int[] marks) {
            this.marks = marks;
        }

        public String getStoredGrade() {
            return grade;
        }

        public void setStoredGrade(String grade) {
            this.grade = grade;
        }

        // Calculate average marks
        public double calculateAverage() {
            int sum = 0;
            for (int mark : marks) {
                sum += mark;
            }
            return (double) sum / marks.length;
        }

        // Determine grade based on average
        public String getGrade() {
            double average = calculateAverage();

            if (average >= 90) {
                return "A";
            } else if (average >= 75) {
                return "B";
            } else if (average >= 60) {
                return "C";
            } else if (average >= 40) {
                return "D";
            } else {
                return "F";
            }
        }

        // Display student information
        public void displayInfo() {
            System.out.println("Student ID: " + studentId);
            System.out.println("Name: " + name);

            System.out.print("Marks: [");
            for (int i = 0; i < marks.length; i++) {
                System.out.print(marks[i]);
                if (i < marks.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");

            System.out.printf("Average: %.1f%n", calculateAverage());
            System.out.println("Grade: " + getGrade());
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        // Create 3 student objects
        Student s1 = new Student(
                "S001",
                "Alice Johnson",
                new int[]{85, 90, 78, 92, 88});

        Student s2 = new Student(
                "S002",
                "Bob Smith",
                new int[]{45, 52, 48, 55, 50});

        Student s3 = new Student(
                "S003",
                "Charlie Brown",
                new int[]{95, 98, 92, 96, 94});


        // Display information
        s1.displayInfo();
        s2.displayInfo();
        s3.displayInfo();

        Student highest = s1;

        if (s2.calculateAverage() > highest.calculateAverage()) {
            highest = s2;
        }

        if (s3.calculateAverage() > highest.calculateAverage()) {
            highest = s3;
        }

        System.out.printf("Highest average student: %s with %.1f%%%n",
                highest.getName(),
                highest.calculateAverage());
    }
}
