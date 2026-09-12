package JavaFiles.Findings;

import java.io.FileWriter;
import java.io.IOException;

public class Writefiles {
    public static void main(String[] args) {
        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\Mohamed\\Desktop\\FilePractice\\notes.txt", true);
            myWriter.write("Barry allen will find Yorkin a metahuman who can cause rapid decay to the individual arms\n");
            myWriter.write("Wally west is trying be great\n");
            myWriter.write("Cisco Ramon found Gypsy who vibes\n");
            myWriter.write("Harry Osborn and Peter Parker are great friends\n");
            myWriter.write("Harry Potter meets his match the half blood prince\n");
            myWriter.close();  // must close manually
            System.out.println("Successfully wrote to the file.");
            myWriter.close();
        } catch (IOException erroring) {
            System.out.println("The file is having problems");
            erroring.printStackTrace();
        }
    }
}
