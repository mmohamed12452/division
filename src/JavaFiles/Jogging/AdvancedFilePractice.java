package JavaFiles.Jogging;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class AdvancedFilePractice {
    public static void main(String[] args) {
        try {
            String documentsPath = "C:\\Users\\Mohamed\\Documents\\";
            String folderPath = documentsPath + "\\MyFiles";
            File folder = new File(folderPath);
            if (!folder.exists()){
                folder.mkdir();
                System.out.println("MyFiles folder has been created");
            }
            else {
                System.out.println("MyFiles folder already exists");
            }
            String textfilePath = folderPath + "\\inputoutputfilepractice.txt";
            File textfile = new File(textfilePath);
            FileOutputStream fileOutputStream = new FileOutputStream(textfile);
            String text = "This program we are practicing to read and write images.";
            fileOutputStream.write(text.getBytes());
            fileOutputStream.close();
            System.out.println("Text written successfully.");
            FileInputStream fileInputStream = new FileInputStream(textfile);
            int data;
            System.out.println("reading text from file.");
            while ((data = fileInputStream.read())!= -1){
                System.out.println((char) data);
            }
            fileInputStream.close();
            String sourceimagePath = "C:\\Users\\Mohamed\\Pictures\\Swagger.jpg";
            String destinationimagePath = folderPath + "\\copiedImage.jpg";
            FileInputStream imageInput = new FileInputStream(sourceimagePath);
            FileOutputStream imageOutput = new FileOutputStream(destinationimagePath);


            int byteData;
            while((byteData = imageInput.read())!=-1){
                imageOutput.write(byteData);
            }
            imageInput.close();
            imageOutput.close();
            System.out.println("image copied successfully to my files folder.");
        }
        catch (IOException myException){
            myException.printStackTrace();
        }
    }
}
