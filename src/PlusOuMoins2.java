import java.util.Random;
import java.util.Scanner;

/**
 * Created by tearsyu on 16-9-8.
 */
public class PlusOuMoins2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Player please entry a number from 0 to 100 I will guess it.");
        int a = in.nextInt();
        System.out.println("You have choose " + a +". ");

        Random ramdom = new Random();
        int i = ramdom.nextInt(100);
        int tmp = i;

        while (true){
            System.out.println("Is this number " + i + " right?");
            int b = in.nextInt();
            if (b == 0){
                System.out.println("Find it!");
                break;
            } else if (b == 1) {
                System.out.println("Smaller！");
                i = ramdom.nextInt(tmp);
                tmp = i;
            } else {
                System.out.println("Bigger !");
                i = tmp + ramdom.nextInt(100 - tmp);
                tmp = i;
            }
        }

    }
}
