package Expressions;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class UserIdValidator {
    public static void main(String[] args) {
        // The list of IDs of our test
        String[] testIds = {"ABC12", "XYZ99", "JAVA00", "ab123", "A1234", "ABC123"};

        // The Regex:
        // ^          : Start of string
        // [A-Z]{3}   : Exactly 3 uppercase letters
        // \\p{Digit} : POSIX character class for digits (0-9)
        // {2}        : Exactly 2 repetitions
        // $          : End of string

        String regex = "^[A-Z]{3}\\p{Digit}{2}$";
        try {
            Pattern pattern = Pattern.compile(regex);
            System.out.println("Validating User IDs:");
            System.out.println("---------------------------");

            for (String id : testIds) {
                Matcher matcher = pattern.matcher(id);
                if (matcher.matches()) {
                    System.out.println(id + " -> VALID");
                } else {
                    System.out.println(id + " -> INVALID");
                }
            }
        } catch (PatternSyntaxException e) {
            System.err.println("Regex Error: " + e.getMessage());
        }
    }
}
