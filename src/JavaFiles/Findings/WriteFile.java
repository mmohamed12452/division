package JavaFiles.Findings;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public static void main(String[] args) {
        try{
            FileWriter myWriter = new FileWriter("C:\\Users\\Mohamed\\Desktop\\images\\myimages.txt",true);
            myWriter.write("Bryson Tiller will be backstage with Chris Breezy\n");
            myWriter.write("Kehlani will be backstage with Ayra Starr\n");
            myWriter.write("Bryson Minodi will be backstage with Davido\n");
            myWriter.write("Fridayy will be backstage with Tyla\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file");

        } catch (IOException erroring) {
            System.out.println("An error occurred writing into it");
            erroring.printStackTrace();
        }
    }
}
