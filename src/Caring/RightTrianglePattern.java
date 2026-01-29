package Caring;

public class RightTrianglePattern {
    public static void main(String[] args) {
        int rows = 5; // the triangle will be five lines tall
        for (int i = 1; i <= rows; i++) // loop checks once
        {
            // outer loop for rows
            for (int j = 1; j <= i; j++) { // inner loop for columns (asterisks)
                System.out.print("*");
            }
            System.out.println(); // move to next line after each row
        }
    }
}


//*
//**
//***
//****
//*****



