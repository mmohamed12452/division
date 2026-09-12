package Expressions;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DNAFinder {
    public static void main(String[] args) {
        String sequence = "ATGTAGTAGCTAGCTA";
        String regex = "ATG(?=.{3,}(TAG|TAA|TGA))";
        // Note: Using lookahead allows for easier overlap detection,
        // but manual index shifting is more explicit for all overlap types.

        Pattern pattern = Pattern.compile("ATG(?=(.{3,}(TAG|TAA|TGA)))");
        Matcher matcher = pattern.matcher(sequence);
        List<String> matches = new ArrayList<>();

        int start = 0;
        while(matcher.find(start)){
            // Group 1 contains the full sequence from the lookahead
            String fullMatch = "ATG" + matcher.group(1);
            matches.add(fullMatch);

            // Move the search pointer by only 1 to find overlaps
            start = matcher.start() + 1;
        }
        System.out.println("Matches found: " + matches);
    }
}
