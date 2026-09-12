package JavaFiles.Findings;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        File myObj = new File("C:\\Users\\Mohamed\\Desktop\\images\\myimages.txt");
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
        }catch (FileNotFoundException errorhandling){
            System.out.println("An error occurred.");
            errorhandling.printStackTrace();
        }
    }
}
