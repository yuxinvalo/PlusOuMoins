/**
 * Created by tearsyu on 16-9-15.
 * This class is used to test Arbitre and startGame()
 */
public class TestArbitre {

    public TestArbitre(){}

    public static void main(String[] args){
        Arbitre arbitre;
        Intervalle intervalle;
        Joueur joueur1, joueur2;

        intervalle = new Intervalle(0, 10);
        joueur1 = new JoueurIncremental("Linlin");
        joueur2 = new JoueurHumain("Sam");
        arbitre = new Arbitre(intervalle,joueur1,joueur2);

        arbitre.startGame();
    }
}
