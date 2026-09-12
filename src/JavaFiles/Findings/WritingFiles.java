package JavaFiles.Findings;

import java.io.FileWriter;
import java.io.IOException;

public class WritingFiles {
    public static void main(String[] args) {
        try{
            FileWriter myWriter = new FileWriter("C:\\Users\\Mohamed\\Desktop\\images\\myimages.txt", true);
            myWriter.write("Tyler will be backstage with Chris Breezy\n");
            myWriter.write("Bryson will be backstage with Tyler sign\n");
            myWriter.write("Sharma will be backstage with Kenny g\n");
            myWriter.write("Harry osborn  will be backstage with kehlani\n");
            myWriter.write("Hanad bandz will be backstage with Sharma boy\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException erroring) {
            System.out.println("Errors have occured");
            erroring.printStackTrace();
        }
    }
}
