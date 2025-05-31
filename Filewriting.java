import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Filewriting {

public static void createAndinitializeFile(){
        // File file = new File("D:\\Personal_Projects\\Coding\\Java-HCF-and-LCM-finder\\operations.log");
        

        try (BufferedWriter filewriter = new BufferedWriter(new FileWriter(new File("D:\\Personal_Projects\\Coding\\Java-HCF-and-LCM-finder\\operations.log")))) {

            filewriter.write("I hear Jerusalem Bells ringing, ");
            
            filewriter.write("Roman cavalry choirs singing");
        }
         catch (IOException e) {
            // TODO Auto-generated catch block
        }
        //  catch (IOException e) {
        //     System.out.println("IO Exception: " + e.getMessage());
        // }
    }

    public static void main(String[] args) {
        createAndinitializeFile();
    }
}
