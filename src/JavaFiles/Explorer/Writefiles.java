package JavaFiles.Explorer;

import java.io.FileOutputStream;
import java.io.IOException;

public class Writefiles {
    public static void main(String[] args) {
        try (FileOutputStream output = new FileOutputStream("C:\\Users\\Mohamed\\Desktop\\FilePractice\\notes.txt")) {
            output.write("Barry allen will find Yorkin a metahuman who can cause rapid decay to the individual arms\n".getBytes());
            output.write("Wally west is trying be great\n".getBytes());
            output.write("Cisco Ramon found Gypsy who vibes\n".getBytes());
            output.write("Harry Osborn and Peter Parker are great friends\n".getBytes());
            output.write("Harry Potter meets his match the half blood prince\n".getBytes());
            output.close();  // must close manually
            System.out.println("Successfully wrote to the file.");
        } catch (IOException errored) {
            System.out.println("Error has occurred in this file");
            errored.printStackTrace();
        }
    }
}
