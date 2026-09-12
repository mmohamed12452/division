package Deadlocks.Deadlockprevention;

// Defines a class called MostFrequentChar
public class MostFrequentChar {

    // Defines a method called getMostFrequentChar.
    // It takes a String called text as input
    // and returns a single character (char).
    public static char getMostFrequentChar(String text) {

        // Creates an integer array with 256 positions.
        // Each position will store how many times a particular ASCII character appears.
        int[] counts = new int[256];

        // LOOP 1:
        // This loop goes through every character in the string
        // to count how many times each character appears.
        for (int i = 0; i < text.length(); i++) {

            // Gets the character at position i in the string.
            char currentChar = text.charAt(i);

            // Uses the character's numeric value as an array index.
            // and increases its count by 1.
            counts[currentChar]++;
        }

        // Stores the highest frequency found so far.
        // We start with -1 so that the first character's count
        // will always be greater than maxCount.
        int maxCount = -1;

        // Stores the character that currently has the highest count.
        // We initially set it to a space character.
        char mostFrequent = ' ';

        // LOOP 2:
        // This loop goes through the string again.
        // Its purpose is to find the character with the highest count.
        for (int i = 0; i < text.length(); i++) {

            // Gets the character at position i.
            char currentChar = text.charAt(i);

            // Checks whether this character appears more times
            // than the character we currently consider most frequent.
            if (counts[currentChar] > maxCount) {

                // If its count is higher, update maxCount
                // to this character's frequency.
                maxCount = counts[currentChar];

                // Store this character as the new most frequent character.
                mostFrequent = currentChar;
            }
        }

        // Return the character that was found to have
        // the highest frequency.
        return mostFrequent;
    }

    // The main method is where the Java program starts running.
    public static void main(String[] args) {

        // Creates a String variable called input
        // and stores "hello world" inside it.
        String input = "hello world";

        // Calls the getMostFrequentChar method,
        // passing the input string to it.
        // The returned character is stored in result.
        char result = getMostFrequentChar(input);

        // Prints the original string to the console.
        System.out.println("Original string: " + input);

        // Prints the most frequent character to the console.
        System.out.println("Most frequent character: " + result);
    }
}
