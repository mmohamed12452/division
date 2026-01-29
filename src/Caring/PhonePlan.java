package Caring;

import java.util.Scanner;

public class PhonePlan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Asking the usage in GB: ");

        int usage = scanner.nextInt();

        if(usage < 5){
            System.out.println("Suggest Lite Plan");
        } else if (usage >= 5 && usage < 20) {
            System.out.println("if activity is video suggest: Streamer Plan ");
        } else if (usage >= 20) {
            System.out.println("if activity is video suggest: Unlimited Max ");
        } else if (usage <=100) {
            System.out.println("suggesting: Standard Plan");
        } else if (usage <=50) {
            System.out.println("if activity is social suggest: Unlimited Social+");
        }
        else {
            System.out.println("Unlimited Pro");
        }
    }
}
