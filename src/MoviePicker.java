import java.util.Arrays;      // Imports the Arrays class for easily creating lists of ratings
import java.util.HashMap;     // Imports HashMap for storing movie names and their ratings
import java.util.List;        // Imports List to hold ratings for each movie
import java.util.Map;         // Imports Map interface to map movies to ratings

public class MoviePicker {    // Main class definition
    public static void main(String[] args) {   // Program entry point (where execution starts)

        // Create a HashMap to store movie names and their list of ratings
        Map<String, List<Integer>> movieRatings = new HashMap<>();

        // Add movie names and corresponding ratings given by friends
        movieRatings.put("Cobra Kai", Arrays.asList(9, 8, 10, 7));
        movieRatings.put("Interstellar", Arrays.asList (8, 9, 9,9));
        movieRatings.put("Avatar", Arrays.asList(9, 9, 8, 9));
        movieRatings.put("The Strangers chapter 2", Arrays.asList(9, 9, 10, 8));

        // Variables to keep track of the best (chosen) movie
        String bestMovie = null;   // Stores the name of the current best movie
        double bestAvg = 0.0;      // Stores the highest average rating so far
        int bestMin = 0;           // Stores the highest minimum rating for tie-breaking

        // Loop through every movie and its ratings
        for (Map.Entry<String, List<Integer>> entry : movieRatings.entrySet()) {
            String movie = entry.getKey();      // Get movie name
            List<Integer> ratings = entry.getValue();   // Get the list of ratings

            // Calculate the average rating for this movie
            double avg = ratings.stream().mapToInt(Integer::intValue).average().orElse(0);

            // Find the minimum rating for this movie
            int min = ratings.stream().mapToInt(Integer::intValue).min().orElse(0);

            // Decide if this movie should become the new best movie:
            // - If it's the first movie checked, OR
            // - It has a higher average than the current best, OR
            // - It has the same average but a higher minimum rating
            if (bestMovie == null || avg > bestAvg || (avg == bestAvg && min > bestMin)) {
                bestMovie = movie;   // Update the best movie
                bestAvg = avg;       // Update the best average
                bestMin = min;       // Update the best minimum rating
            }
        }

        // Print the chosen movie and its average rating (rounded to 2 decimals)
        System.out.printf("Movie chosen: %s%nAverage rating: %.2f%n", bestMovie, bestAvg);
    }
}
