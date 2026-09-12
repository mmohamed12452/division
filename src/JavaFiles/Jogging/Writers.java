package JavaFiles.Jogging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writers {
    public static void main(String[] args) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("filename.txt"))) {
            bw.write("First line");
            bw.newLine();  // add line break
            bw.write("Second line");
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("Error writing file.");
        }
    }
}
