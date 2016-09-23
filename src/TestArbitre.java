/**
 * Created by tearsyu on 16-9-15.
 * This class is used to test Arbitre and startGame(), debug etc.
 */
public class TestArbitre {

    public static void main(String[] args){
        Arbitre arbitre;
        Intervalle intervalle;
        Joueur joueur1, joueur2, joueur3;

        intervalle = new Intervalle(0, 100);
        joueur1 = new JoueurDichotomique("Linlin", intervalle);
        joueur2 = new JoueurHumain("Sam");
        joueur3 = new JoueurIntervalleAleatoire("Panda", intervalle);
        arbitre = new Arbitre(intervalle,joueur1,joueur2);

        //arbitre.startGame();

       // arbitre.startGame2();

        joueur2.calScore(Score.ScoreFlag.LOOSER.flag);

    }
}
