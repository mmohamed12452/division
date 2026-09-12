package JavaFiles.Findings;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadingFiles {
    public static void main(String[] args) {
        try (FileInputStream input = new FileInputStream("C:\\Users\\Mohamed\\Desktop\\FilePractice\\notes.txt")){
            int numbers;  // variable to store each byte that is read

            // Read one byte at a time until end of file (-1 means "no more data")
            while ((numbers = input.read()) != -1) {
                // Convert the byte to a character and print it to the console
                System.out.print((char) numbers);

            }
            System.out.print("Done reading Stream");
        }
        catch (IOException errors){
            System.out.println("Error reading files");
        }
    }
}
