package JavaFiles.Flyies;

import java.io.File;
import java.io.IOException;

public class Filing {
    File myObj = new File("bookname.txt");
    public static void main(String[] args) {
        try{
            File myObj = new File("C:\\Users\\Mohamed\\Desktop\\images\\myimages.txt");
            if (myObj.createNewFile()) {  // Try to create the file
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace(); // Print error details
        }
    }
}
