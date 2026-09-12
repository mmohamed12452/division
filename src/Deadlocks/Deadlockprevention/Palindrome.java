package Deadlocks.Deadlockprevention;

import java.util.Scanner;

public class Palindrome {
    public static void checkPalindrome(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a word or phrase: ");

        String input = scanner.nextLine();

        // Remove all non-non-alphanumeric characters (spaces, punctuation) and convert to lowercase
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        // Reverse cleaned string
        String reversed = new StringBuilder(cleaned).reverse().toString();

        // Checks if the cleaned string is identical to its reverse string
        if (!cleaned.isEmpty() && cleaned.equals(reversed)){
            System.out.println(" " + input + " is a palindrome! ");
        }
        else
        {
            System.out.println(" " + input + " is NOT a palindrome ");
        }
    }
//    public static boolean isSimplePalindrome(String text)
//    {
//
//
//        // Check if the passed-in string is null (doesn't exist in memory).
//        if (text == null) {
//            // Return false immediately to prevent a NullPointerException when processing text.
//            return false;
//        }
//        // Clean up the string so punctuation, spaces, and character casing don't break the comparison:
//        // 1. text.replaceAll("[^a-zA-Z0-9]", ""): Uses regex to strip out anything that isn't a
//        // letter (a-z, A-Z) or digit (0-9). Spaces, commas, exclamation marks, etc., are removed.
//        // 2. .toLowerCase(): Converts all remaining characters to lowercase so 'M' and 'm' match.
//        // 3. Stores the cleaned result in a new String variable named "cleaned".
//        String cleaned = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
//
//        // Reverse the cleaned string:
//        // 1. new StringBuilder(cleaned): Loads the cleaned string into a mutable StringBuilder object.
//        // 2. .reverse(): Flips the order of characters in the StringBuilder.
//        // mom
//        // 3. .toString(): Converts the reversed StringBuilder back into a standard String.
//        //MOM
//        String reversed = new StringBuilder(cleaned).reverse().toString();
//
//        //mom
//        // Compare the original cleaned string to the reversed string.
//        // If they match character-for-character, .equals() returns true (it's a palindrome).
//        // mom
//        // Otherwise, it returns false.
//        return cleaned.equals(reversed);
//    }
    // The main method serves as the starting point where execution starts when the program runs.
    public static void main(String[] args) {

        checkPalindrome();
        // Call the isSimplePalindrome method using "mom" as the argument.
        // "mom" cleaned is "mom", and reversed is "mom",  it returns true.

        // mom cleaned version
        // and mom reversed version


//        boolean result = isSimplePalindrome("mom");
//        boolean results = isSimplePalindrome("racecar");
        // Print the message concatenated with the boolean value to the terminal.
        // The result (true) is saved in the variable named "result".
//        System.out.println("Is 'mom' a palindrome? " + result);
//        System.out.println("Is 'racecar' a palindrome? " + results);

        // Is 'racecar' a palindrome
        // racecar

        // Is 'mom' a palindrome? true
    }
}
