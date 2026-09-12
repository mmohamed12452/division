package JavaFiles.Jogging;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Bodder {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("filename.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}
