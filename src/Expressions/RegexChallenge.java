package Expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexChallenge {
    public static void main(String[] args) {
        String input = "Walking and running are fun";

        // The Regex Pattern
        String regex = "\\\\b(?![aeiouAEIOU])[a-zA-Z]{3}ing\\\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        System.out.println("Matches found: " + input);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
