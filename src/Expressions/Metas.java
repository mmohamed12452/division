package Expressions;

import java.util.regex.Pattern;

public class Metas {
    public static void main(String[] args) {
        // 1. Matches a single digit (\\d)
        System.out.println("Is '5' a digit" + Pattern.matches("\\d", "5"));

        // 2. Matches any character (.) followed by a digit (\\d)
        // This will match "a1", "B2", " 3", etc.
        System.out.println("Matches 'a1'? " + Pattern.matches(".\\d", "a1")); // true

        // 3. Matches a non-digit (\\D) followed by whitespace (\\s)
        System.out.println("Matches 'A '? " + Pattern.matches("\\D\\s", "A "));

        // 4. Using anchors: ^ (Start) and $ (End)
        // Matches "Java" only if the entire string is exactly "Java"
        System.out.println("Matches 'Java'? " + Pattern.matches("^Java$", "Java")); // true
    }
}
