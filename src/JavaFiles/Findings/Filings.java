package JavaFiles.Findings;

import java.io.File;
import java.io.IOException;

public class Filings {
    File myObj = new File("bookname.txt");
    public static void main(String[] args) {
        try {
            File myObj = new File("C:\\Users\\Mohamed\\Desktop\\images\\myimages.txt");
            if (myObj.createNewFile()){
                System.out.println("File created: " + myObj.getName());
            }else {
                System.out.println("File already existing");
            }
        }catch (IOException error)
        {
            System.out.println("An error has occurred in creating the file.");
            error.printStackTrace();
        }
    }
}
