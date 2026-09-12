package JavaFiles.FilePractice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        File myObj = new File("C:\\Users\\Mohamed\\Desktop\\FilePractice\\notes.txt");

        // try-with-resources: Scanner will be closed automatically
        try (Scanner myReader = new Scanner(myObj)) {

            System.out.println("Reading file content:");

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }

        } catch (FileNotFoundException files) {
            System.out.println("The program is having issues with this file");
            files.printStackTrace();
        }
    }
}
