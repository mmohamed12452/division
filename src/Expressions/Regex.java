package Expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("Google", Pattern.CASE_INSENSITIVE);
        // Creates a matcher
        Matcher matcher = pattern.matcher("Visit Google at the google website.");
        boolean matchFound = matcher.find();
        if(matchFound){
            System.out.println("Match found");
        }
        else {
            System.out.println("Match not found");
        }
    }
}
