package Deadlocks.Deadlockprevention;

public class Numbering {
    public static int myNumbers(int num1, int num2, int num3, int num4){
        System.out.println("Hello there Mr.Bryson how is the going!");
        int sum = num1 + num2 + num3 + num4;
        System.out.println("The addition of the following: " + sum);
        return sum;

        // my.Numbers, my_Name, my-Cat, myCat
        // myCat(), myCat(int car1, int car2, int car3)
    }

    public static void main(String[] args) {
        myNumbers(20,30,100,200);
    }
}
