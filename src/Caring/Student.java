package Caring;

public class Student extends Person {
    String admissionNumber;
    int gradeLevel;

    Student(String name, int age, String admissionNumber, int gradeLevel){
        super(name, age); // Calls the Person constructor
        this.admissionNumber = admissionNumber;
        this.gradeLevel = gradeLevel;
    }

    @Override
    void introduce() {
        System.out.println("Hi, I'm " + name + " (Age: " + age + "). I am in grade " +
                gradeLevel + " and my ID is " + admissionNumber + ".");
    }
}
