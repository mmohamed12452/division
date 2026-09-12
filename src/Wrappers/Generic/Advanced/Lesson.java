package Wrappers.Generic.Advanced;

public class Lesson {
    public static void main(String[] args) {
        Test<Integer> myObj1 = new Test<Integer>(30);
        System.out.println(myObj1.getMyObj());

        Test<String> myBarry = new Test<String>("Barry Allen went to listen to Clifford Devoe's college lecture on physics");
        System.out.println(myBarry.getMyObj());
    }
}
