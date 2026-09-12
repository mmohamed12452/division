package JavaFiles.Findings;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public static void main(String[] args) {
        try
        {
            FileWriter myWriter = new FileWriter("C:\\Users\\Mohamed\\Desktop\\images\\myimages.txt",true);
            myWriter.write("Bryson Tiller will be backstage with Chris Breezy\n");
            myWriter.write("Bryson Tiller will be backstage with Tyla\n");
            myWriter.close();  // must close manually
            System.out.println("Successfully wrote to the file.");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
