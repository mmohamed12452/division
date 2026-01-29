package Caring;

public class Teacher extends Person{
    String employeeNumber;
    String subject;

    Teacher(String name, int age, String employeeNumber, String subject) {
        super(name, age); // Calls the Person constructor
        this.employeeNumber = employeeNumber;
        this.subject = subject;
    }

    @Override
    void introduce() {
        System.out.println("Hello, I am Mr.Chris Brown/Ms.Hariett Tubman " + name + ". I teach " + subject +
                " and my employee ID is " + employeeNumber + ".");
    }
}
