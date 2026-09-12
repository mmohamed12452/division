package JavaFiles.FilePractice;

import java.io.File;

public class DeleteFile {
    public static void main(String[] args) {
        try {
            File myObj = new File("C:\\Users\\Mohamed\\Desktop\\FilePractice\\notes.txt");
            if (myObj.delete()) {
                System.out.println("File deleted: " + myObj.getName());
            } else {
                System.out.println("Failed to delete the file.");
            }
        } catch (Exception error) {
            System.out.println("An error occurred while deleting the file.");
            error.printStackTrace();
        }
    }
}
