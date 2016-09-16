import java.io.Console;
import java.util.Scanner;

/**
 * Created by tearsyu on 16-9-8.
 */
public class PlusOuMoins {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Console console = System.console();
        if (console == null)
            System.out.println("console is null");
        char[] str = console.readPassword("Player 1 Please type a number.");
        int a = Integer.parseInt(new String(str));
        System.out.println("Player 2 Please type a number to guess the number.");
        int b = in.nextInt();
        while (a != b) {
            if (a < b) {
                System.out.println("Plus petit! Please retry.");
            } else {
                System.out.println("Plus grand! Please retry");
            }
            b = in.nextInt();
        }
        System.out.println("Trouve!");
    }
}
