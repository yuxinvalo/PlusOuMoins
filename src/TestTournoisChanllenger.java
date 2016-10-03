import Tournois.*;
import Joueur.*;
/**
 * Created by tearsyu on 16-10-3.
 * Cette classe cest comme le nom pour tester le tournois chanllenger.
 */
public class TestTournoisChanllenger {
    public static void main(String[] args){
        Joueur joueur1, joueur2, joueur3, joueur4, joueur5 ;
        Intervalle itv = new Intervalle(0, 10);
        joueur1 = new JoueurIncremental("IntreI");
        joueur2 = new JoueurHumain("Bete");
        joueur3 = new JoueurIncremental("IncreII");
        joueur4 = new TricheurNonIntelij("Tritri", itv);
        joueur5 = new JoueurDichotomique("Dicho", itv);

        TounoisChallenger tounois = new TounoisChallenger();

        //Test addJoueur(Joueur.Joueur joueur)
        tounois.addJoueur(joueur4);
        tounois.addJoueur(joueur2);
        tounois.addJoueur(joueur3);
        tounois.addJoueur(joueur1);
        tounois.addJoueur(joueur5);


        tounois.showInfo();
        tounois.startGame(itv, 4);
        tounois.showTableScore();
        //Joueur.Intervalle intervalle = new Joueur.Intervalle(0, 10);
        // tounois.startTournois(intervalle, 4);
        //tounois.showTableScore();

    }

}

