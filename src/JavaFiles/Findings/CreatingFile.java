package JavaFiles.Findings;

import java.io.File;
import java.io.IOException;

public class CreatingFile {
    File myObj = new File("myimages.txt");
    public static void main(String[] args) {
        try
        {
            File myObj = new File("C:\\Users\\Mohamed\\Desktop\\images\\myimages.txt");
            if(myObj.createNewFile()){
                System.out.println("File created: " + myObj.getName());
            }
            else
            {
                System.out.println("File already exists.");
            }
        }
        catch (IOException errors){
            System.out.println("An error occurred.");
            errors.printStackTrace();
        }
    }
}
