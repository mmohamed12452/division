package Caring;

import java.util.Scanner;

public class Running {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("enter a number: ");
        int mynumbers = myObj.nextInt();


        if((mynumbers % 5) == 0){
            System.out.println("Tariq is going to a running marathon with his friend tiller");
        }
        else {
            System.out.println("Spencer James talks with his friend Olivia Baker");
        }


//        if(8 < 0){
//            System.out.println("hello john");
//        }
//
    }

}
