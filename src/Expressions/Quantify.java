package Expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Quantify {
    public static void main(String[] args) {
        String regex = "n+";
        String input = "oranges and apples";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        boolean matchFound = matcher.find();

        System.out.println("Search for 'n+' in: " + input);
        while(matcher.find()){
            System.out.println("Found match: ' " + matcher.group() + " ' starting at index " + matcher.start());
        }
    }
}
