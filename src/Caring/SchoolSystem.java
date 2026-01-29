package Caring;

public class SchoolSystem{
    public static void main(String[] args) {
        Student student1 = new Student("Hardison", 10, "S13456",5);
        Teacher teacher1 = new Teacher("Smith", 42, "T987", "Mathematics");
        student1.introduce();
        teacher1.introduce();
    }
}
