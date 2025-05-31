
import java.io.Console;

public class ConsolePractice {
    public static void main(String[] args) {
        Console cons = System.console();

        System.out.println("Enter your name: ");
        String name = cons.readLine();

        System.out.println("Enter Password: ");
        String password = cons.readLine();
        
        System.out.printf("Name :", name, "Password: ",password);
        System.out.println();

        if (name.equals("Mohak") && password.equals("1256")) {
            System.out.println("Welcome Mr Stark");
        }

    }
}
