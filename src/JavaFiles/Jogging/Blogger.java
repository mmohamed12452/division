package JavaFiles.Jogging;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Blogger {
    public static void main(String[] args) {
        try {
            //Step 1 SETUP: Define paths and create the destination folder if it doesn't exist
            String DesktopPath = "C:\\Users\\Mohamed\\Desktop\\";
            String folderPath = DesktopPath + "\\MyFile";
            File folder = new File(folderPath);
            if (!folder.exists()){
                folder.mkdir();
                System.out.println("MyFiles folder has been created");
            }
            else {
                System.out.println("MyFiles folder already exists");
            }

            // 2. TEXT I/O: Create a text file and write a string to it
            String textfilePath = folderPath + "\\inputoutputfilepractice.txt";
            File textfile = new File(textfilePath);
            FileOutputStream fileOutputStream = new FileOutputStream(textfile);
            String text = "This program we are practicing to read and write images.";
            fileOutputStream.write(text.getBytes());
            fileOutputStream.close();
            System.out.println("Text written successfully.");

            // Step 3. READ TEXT: Read that same file back and print characters to console
            FileInputStream fileInputStream = new FileInputStream(textfile);
            int data;
            System.out.println("reading text from file.");
            while ((data = fileInputStream.read())!= -1){
                System.out.println((char) data);
            }
            fileInputStream.close();

            // Step 4. IMAGE 1: Initialize streams for the first image transfer
            String sourceimagesPath = "C:\\Users\\Mohamed\\Desktop\\Barbados.jpg";
            String destinationimagePath = folderPath + "\\copiedImage.jpg";
            FileInputStream imageInput = new FileInputStream(sourceimagesPath);
            FileOutputStream imageOutput = new FileOutputStream(destinationimagePath);

            // 5. IMAGE 2: Initialize streams for the second image transfer
            String sourceimage2 = "C:\\Users\\Mohamed\\Desktop\\Duppy.jpg";
            String destination2 = folderPath + "\\Duppy_copied.jpg";
            FileInputStream imageingInput = new FileInputStream(sourceimage2);
            FileOutputStream imagesOutput = new FileOutputStream(destination2);
            System.out.println("Second image copied successfully.");

            // Step 6. EXECUTION: Loop through Image 1 bytes and write to destination
            int byteData;
            while((byteData = imageInput.read())!=-1){
                imageOutput.write(byteData);
            }
            imageInput.close();
            imageOutput.close();
            System.out.println("image copied successfully to my files folder.");

            // 7. EXECUTION: Loop through Image 2 bytes and write to destination
            int byteData2;
            // This is the missing part that actually moves the data!
            while((byteData2 = imageingInput.read()) != -1){
                imagesOutput.write(byteData2);
            }
            //We must close them!
            imageingInput.close();
            imagesOutput.close();
        }
        catch (IOException myException){
            myException.printStackTrace();
        }
    }
}
