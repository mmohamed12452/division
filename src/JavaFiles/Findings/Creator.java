package JavaFiles.Findings;

import java.io.File;
import java.io.IOException;

public class Creator {
    File myObj = new File("notes.txt");
    public static void main(String[] args) {
        try {
            File myObj = new File("C:\\Users\\Mohamed\\Desktop\\FilePractice\\notes.txt");
            if (myObj.createNewFile()){
                System.out.println("File created: " + myObj.getName());
            }
            else {
                System.out.println("File is already exists");
            }
        } catch (IOException errors) {
            System.out.println("An error has occured");
            errors.printStackTrace();
        }
    }
}
