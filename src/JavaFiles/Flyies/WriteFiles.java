package JavaFiles.Flyies;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFiles {
    public static void main(String[] args) {
        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\Mohamed\\Desktop\\images\\myimages.txt",true);
            myWriter.write("Line 1: Hello, this is my first file.\n");
            myWriter.write("Line 2: Java file handling is fun.\n");
            myWriter.write("Line 3: I am learning to write to files.\n");
            myWriter.write("Line 4: This line is added later.\n");
            System.out.println("Successfully wrote to the file.");
        } catch (IOException error) {
            System.out.println("Error has occured");
            error.printStackTrace();
        }
    }
}
