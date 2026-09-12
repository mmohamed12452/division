package JavaFiles.Findings;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadingFile {
    public static void main(String[] args) {
        try (FileInputStream input = new FileInputStream("C:\\Users\\Mohamed\\Desktop\\images\\myimages.txt")){
            int i;  // variable to store each byte that is read

            // Read one byte at a time until end of file (-1 means "no more data")
            while ((i = input.read()) != -1) {
                // Convert the byte to a character and print it to the console
                System.out.print((char) i);

            }
            System.out.print("Done reading Stream");
        }catch (IOException errors){
            System.out.println("Error reading files");
        }
    }
}
