package JavaFiles.FilePractice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWrite {
    public static void main(String[] args) {
        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\Mohamed\\Desktop\\FilePractice\\notes.txt");
            myWriter.write("Line 1: Hello, this is my first file.\n");
            myWriter.write("Line 2: Java file handling is fun.\n");
            myWriter.write("Line 3: I am learning to write to files.\n");
            myWriter.write("Line 4: This line is added later.\n");

            System.out.println("New line appended");
            myWriter.close();

            System.out.println("Content written");

        } catch (IOException handle) {
            System.out.println("Error occurred  in the file. Try again!");
            handle.printStackTrace();
        }
    }
}
