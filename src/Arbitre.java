import java.util.Random;

/**
 * Created by tearsyu on 16-9-11.
 * The class Arbitre is a detector of the game.
 * jouer() is used to detect the cheater between two players;
 * startGame() is used to hold a game with two players
 */
public class Arbitre {
    //private Intervalle intervalle;
    private int max, coup;
    private Joueur joueur1, joueur2;

    public Arbitre(Intervalle intervalle, Joueur joueur1, Joueur joueur2){
        max = intervalle.getSup();
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
    }
    public void jouer(){
        if (joueur1.retrunCoup() > max){
            System.out.println(joueur1.getName() + " roll " + joueur1.retrunCoup() + " overring " + max + ". Go out!");
        }
        if (joueur2.retrunCoup() > max){
            System.out.println(joueur2.getName() + " roll " + joueur2.retrunCoup() + " overring " + max + ". Go out!");
        }
    }

    public int getCoup(){
        Random random = new Random();
        coup = random.nextInt(max);
        return coup;
    }


    public void setReponse(int reponse, Joueur joueur){
        if (reponse == 0){
            System.out.println("You "+ joueur.getName() + " find it.");
        } else if (reponse == 1){
            System.out.println("It should be bigger.");
        } else if (reponse == 2){
            System.out.println("It should be smaller.");
        }
    }

    public int testSecret(int essai){
        int reponse;
        if (essai == coup){
            reponse = 0;
        } else if(essai < coup) {
            reponse = 1;
        } else {
            reponse = 2;
        }
        return reponse;
    }

    public void startGame(){
        int a, b;
        System.out.println("We start , nb secret is : " + getCoup());
        do {
            a = joueur1.getCoup();
            b = joueur2.getCoup();

            //joueur 1 tour
            System.out.println(joueur1.getName() + " guess it is: " + a );
            setReponse(testSecret(a), joueur1);

            //joueur 2 tour
            System.out.println(joueur2.getName() + " guess it is: " + b);
            setReponse(testSecret(b), joueur2);

        } while ((testSecret(a) != 0) && (testSecret(b) != 0));
    }
}
