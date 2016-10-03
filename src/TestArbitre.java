import Joueur.*;

/**
 * Created by tearsyu on 16-9-15.
 * This class is used to test Joueur.Arbitre and startGame(), debug etc.
 */
public class TestArbitre {

    private static void show(int[] data)
    {
        System.out.println("========================");
        for(int i = 0; i < data.length; i++)
        {
            System.out.print(data[i] + " ");
        }
        System.out.println();
        System.out.println("========================");
    }

    public static void main(String[] args){
        Arbitre arbitre;
        Intervalle intervalle;
        Joueur joueur1, joueur2, joueur3;

        intervalle = new Intervalle(0, 100);
        joueur1 = new JoueurDichotomique("Linlin", intervalle);
        joueur2 = new JoueurHumain("Sam");
        joueur3 = new JoueurIntervalleAleatoire("Panda", intervalle);
        arbitre = new Arbitre(intervalle,joueur1,joueur2);

        arbitre.startGame();

        arbitre.startGame2();

        //joueur2.calScore(Joueur.Score.ScoreFlag.LOOSER.flag);

    }
}
