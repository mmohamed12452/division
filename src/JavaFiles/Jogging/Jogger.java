package JavaFiles.Jogging;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Jogger {
    public static void main(String[] args) {
        // 1. Define the path
        String path = "C:\\Users\\Mohamed\\Documents\\myFiles\\myfile.txt";
        File file = new File(path);

        // 2. Ensure the directory exists
        File directory = file.getParentFile();
        if (directory != null && !directory.exists()) {
            directory.mkdirs();
        }

        // 3. Check if file exists
        if (file.exists()) {
            System.out.println("File exists: File already exists.");
        } else {
            System.out.println("File does not exist error: File does not exist. Creating it now...");
        }

        // 4. WRITE into the file (FileOutputStream)
        try (FileOutputStream fos = new FileOutputStream(file)) {
            String content = "Hello! Writing to myFiles/myfile.txt using Streams.";
            fos.write(content.getBytes()); // Convert String to bytes
            System.out.println("Write: Success.");
        } catch (IOException e) {
            System.err.println("Write Error: " + e.getMessage());
        }

        // 5. READ from the file (FileInputStream)
        try (FileInputStream fis = new FileInputStream(file)) {
            System.out.print("Read Content: ");
            int data;
            while ((data = fis.read()) != -1) {
                System.out.print((char) data); // Cast byte back to character
            }
            System.out.println();
        } catch (IOException e) {
            System.err.println("Read Error: " + e.getMessage());
        }
    }
}
