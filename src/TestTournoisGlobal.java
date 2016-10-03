import Joueur.*;
import Tournois.TounoisGlobal;

/**
 * Created by tearsyu on 16-10-3.
 */

public class TestTournoisGlobal {
    public static void main(String[] args){
        Joueur joueur1, joueur2, joueur3, joueur4, joueur5 ;
        Intervalle intervalle = new Intervalle(0, 10);

        joueur1 = new JoueurIncremental("Incre");
        joueur2 = new JoueurHumain("Bete");
        joueur3 = new JoueurIncremental("IncreII");
        joueur4 = new TricheurNonIntelij("Tritri", intervalle);
        //joueur5 = new Joueur.JoueurIncremental("5");

        TounoisGlobal tounois = new TounoisGlobal();

        //Test addJoueur(Joueur.Joueur joueur)
        tounois.addJoueur(joueur1);
        tounois.addJoueur(joueur2);
        tounois.addJoueur(joueur3);
        tounois.addJoueur(joueur4);
        /*tounois.addJoueur(joueur5);*/


        tounois.showInfo();

        //tounois.startTournois(intervalle, 4);
        tounois.startGame(intervalle, 2);
        tounois.showTableScore();
    }
}
