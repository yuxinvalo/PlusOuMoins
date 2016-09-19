import java.util.Random;
import java.util.Scanner;

/**
 * Created by tearsyu on 16-9-15.
 */
public class JoueurIntervalleAleatoire extends JoueurAvecIntervalle implements Joueur{

    private Intervalle intervalle;
    private String name;
    private int coup, nbkey;

    public JoueurIntervalleAleatoire(String name, Intervalle intervalle) {
        super(name, intervalle);
        this.name = name;
        this.intervalle = intervalle;
    }

    public void setNbkey(){
       // Scanner scanner = new Scanner(System.in);
        //nbkey = scanner.nextInt();
        Random random = new Random();
        nbkey = random.nextInt(intervalle.getSup());
    }

    public int getNbkey(){
        return nbkey;
    }


    //This method used to generate a random number at [min, max]
    public static int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    @Override
    public int getCoup() {
        //System.out.println(intervalle.getNumMin()+ intervalle.getNumMax());
        coup = randInt(intervalle.getNumMin(), intervalle.getNumMax());
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

    @Override
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
