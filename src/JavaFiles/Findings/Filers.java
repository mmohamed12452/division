package JavaFiles.Findings;

import java.io.FileInputStream;

public class Filers {
    public static void main(String[] args) {
        try(FileInputStream input = new FileInputStream("C:\\Users\\Mohamed\\Desktop\\images\\myimages.txt")){

            int i;  // variable to store each byte that is read

            // Read one byte at a time until end of file (-1 means "no more data")
            while ((i = input.read()) != -1) {
                // Convert the byte to a character and print it to the console
                System.out.print((char) i);
            }
        } catch (Exception e) {
            System.out.println("Error reading file.");
        }

    }
}
