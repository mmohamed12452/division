package JavaFiles;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DeleteFile {

    public static void main(String[] args) {
        File myObj = new File("C:\\Users\\Mohamed\\Desktop\\images\\myimages.txt");
        if (myObj.delete()){
            System.out.println("Deleted the file: " + myObj.getName());
        }else {
            System.out.println("Failed to delete the file.");
        }
    }
}