package JavaFiles.Jogging;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LogFileAnalyzer {
    public static void main(String[] args) {
        // 1. Setup file names
        String inputFilePath = "C:\\Users\\Mohamed\\Desktop\\Maths\\access.log.txt";
        String filteredPath = "filtered.log";
        String summaryPath = "summary.txt";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the date to filter (e.g., 25/Mar/2026): ");
        String targetDate = scanner.nextLine().trim();

        Map<String, Integer> ipCounts = new HashMap<>();

        // 2. Process the file
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(filteredPath)))
        {

            String line;
            while ((line = reader.readLine()) != null) {
                // Skip empty lines
                if (line.trim().isEmpty()) continue;

                // Extract IP (The part before the first space)
                String[] parts = line.split(" ");
                if (parts.length > 0) {
                    String ip = parts[0];
                    ipCounts.put(ip, ipCounts.getOrDefault(ip, 0) + 1);
                }

                // Filter by date
                if (line.contains(targetDate)) {
                    writer.write(line);
                    writer.newLine();
                }
            }

            // 3. Find Top 5 IPs
            List<Map.Entry<String, Integer>> topIps = ipCounts.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .limit(5)
                    .collect(Collectors.toList());


            // 4. Generate Summary Report
            generateSummary(summaryPath, ipCounts, topIps);

            System.out.println("\n✅ Success!");
            System.out.println("Filtered logs saved to: " + filteredPath);
            System.out.println("Summary report saved to: " + summaryPath);

        } catch (FileNotFoundException e) {
            System.err.println("\n❌ ERROR: File not found!");
            System.err.println("The program is looking here: " + System.getProperty("user.dir"));
            System.err.println("Please move 'access.log' into that folder.");
        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
        }
    }

    private static void generateSummary(String path, Map<String, Integer> allCounts,
                                        List<Map.Entry<String, Integer>> topIps) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            out.println("LOG ANALYSIS SUMMARY");
            out.println("====================");
            out.println("Total Unique IPs: " + allCounts.size());
            out.println("\nTOP 5 IP ADDRESSES:");
            for (Map.Entry<String, Integer> entry : topIps) {
                out.printf("%s -> %d requests%n", entry.getKey(), entry.getValue());
            }
        }
    }
}
