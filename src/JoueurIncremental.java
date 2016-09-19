import java.util.Random;
import java.util.Scanner;

/**
 * Created by tearsyu on 16-9-10.
 * Cette classe est identique a la classe JoueurHumain, juste change la facon de
 * generer le nombre. Ce joueur genere les nombres incrementals.
 */
public class JoueurIncremental extends JoueurAvecSecret implements Joueur {
    private String name;
    int coup = -1, nbkey;
    public JoueurIncremental(String name){
        this.name = name;
    }

    public void setNbkey(){
        //Scanner scanner = new Scanner(System.in);
        //nbkey = scanner.nextInt();
        Random random = new Random();
        nbkey = random.nextInt(100);
    }

    public int getNbkey(){
        return nbkey;
    }

    public int getCoup(){
        coup = coup + 1;
        if (coup > 100)
            coup = 1;
        return coup;
    }

    @Override
    public void setReponse(int reponse) {
        if (reponse == Arbitre.Reponse.FOUND.flag){
            System.out.println("You find it.");
        } else if (reponse == Arbitre.Reponse.BIGGER.flag){
            System.out.println("It should be bigger.");
        } else if (reponse == Arbitre.Reponse.SMALLER.flag){
            System.out.println("It should be smaller.");
        }
    }

    @Override
    public int testSecret(int essai) {
        int reponse;
        if (essai == nbkey){
            reponse = 0;
        } else if(essai < nbkey) {
            reponse = 1;
        } else {
            reponse = 2;
        }
        return reponse;
    }

    public String getName() {
        return name;
    }

    @Override
    public int retrunCoup() {
        return coup;
    }

    public void showInfo() {
        System.out.println(getName() + " Class : " + getClass().getName() + "give the number: " + nbkey);
    }
}
