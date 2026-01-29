package Caring;

public class Johnny {
    public static int addNumbers(int a, int b){
        return  a + b;
    }
    public static float addNumbers(int a, float b){
        return a + b;
    }

    public static double addNumbers(int a, double b){
        return a + b;
    }

    public static String addNumbers(String a, double b){
        return a + b;
    }


    public static void postiveNumber(int number){
        if(number < 0){
            System.out.println(number + " is negative ");
            return;
        }
        System.out.println(number + "is positive");
    }

    public static void main(String[] args) {
//        int x = 10;
//        float y = 20.2f;
//        float sum = addNumbers(x,y);
//        System.out.println(sum);
//        postiveNumber(-10);

        addNumbers("Ojo",3);
        String s = addNumbers(" papa ", 2.4);
        System.out.println(s);

    }

}
