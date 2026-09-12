package Deadlocks.Deadlockprevention;

public class Mains {

    // public static void calculateTotalScore this is correct way of writing methods.

    // Method Naming Convention:
    // camelCase (Lower camel case) method names.
    // verb or Verb-Noun phrases
    // naming conventions is a rule or guideline for naming.
    // naming conventions only do a specif ic task only when called.
    // Lower Camel Case Rule: Starts with a lowercase letter, and the first letter of each subsequent concatenated word is capitalized.
    // calculateTotal()
    // mohamedMohamed() mohamed(),

//    public static int addNumbers(int number1, int number2, int number4){
//          int sum = number1 + number2 + number4;
//          System.out.println(sum);
//          return sum;
//    }

    public static int multiplyNumbers(int num1, int num2, int num3, int num4,int num5){
        int multiply = num1 * num2 * num3 * num4 * num5;
        System.out.println(multiply);
        return multiply;
    }

    public static int multiplyNumbers(int num1, int num2, int num3, int num4){
        int multiply = num1 * num2 * num3 * num4;
        System.out.println(multiply);
        return multiply;
    }




    public static void main(String[] args) {
//        addNumbers(20,40,30);
//        System.out.println(addNumbers(10,5,3));
          multiplyNumbers(10,20,30,45,70);
//          multiplyNumbers(20,30,40,50,60);
//        System.out.println(multiplyNumbers(5,20,10,17,25,56));
    }
}