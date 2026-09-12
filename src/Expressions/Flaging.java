package Expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Flaging {
    public static void main(String[] args) {
     String text = "java regex flag";
     Pattern pattern = Pattern.compile("henry", Pattern.CASE_INSENSITIVE);
     Matcher matcher = pattern.matcher(text);

     if (matcher.find()){
         System.out.println("Match found: " + matcher.group());
     }
     else{
         System.out.println("Match does not exist");
     }
    }
}
