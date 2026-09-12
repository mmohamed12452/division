package JavaFiles.FilePractice;
import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args) {
        try {
            // Create folder called FilePractice that will locate on my desktop.
            File folder = new File("C:\\Users\\Mohamed\\Desktop\\FilePractice");
            if (!folder.exists()) {
                folder.mkdir();
                System.out.println("File created.");
            } else {
                System.out.println("Folder already exists.");
            }
            // Create file
            File myObj = new File("C:\\Users\\Mohamed\\Desktop\\FilePractice\\notes.txt");

            if (myObj.createNewFile()) {
                System.out.println("File that has been made: " + myObj.getName());
                System.out.println("File created");
            } else {
                System.out.println("File is already existing.");
            }

        } catch (IOException error) {
            System.out.println("An error has occurred.");
            error.printStackTrace();
        }
    }
}
