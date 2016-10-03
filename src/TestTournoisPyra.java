import Joueur.*;
import Tournois.TournoisPyramidal;
/**
 * Created by tearsyu on 16-10-3.
 */
public class TestTournoisPyra {
    public static void main(String[] args){
        Intervalle intervalle;
        Joueur joueur1, joueur2, joueur3, joueur4, joueur5;
        intervalle = new Intervalle(0, 10);
        joueur1 = new JoueurDichotomique("Linlin", intervalle);
        joueur2 = new TricheurNonIntelij("TrinonIntel", intervalle);
        joueur3 = new JoueurIntervalleAleatoire("Panda", intervalle);
        joueur4 = new JoueurIncremental("Xiqui");
        joueur5 = new TricheurIntelij("TriIntej", intervalle);

        TournoisPyramidal tp = new TournoisPyramidal();
        tp.addJoueur(joueur1);
        tp.addJoueur(joueur2);
        tp.addJoueur(joueur3);
        tp.addJoueur(joueur4);
        tp.addJoueur(joueur5);
        //tp.randomPos();

        //tp.rmJoueur(joueur1);
        //tp.rmJoueur(joueur3);

        tp.startGame(intervalle, 2);
        //tp.showTableScore();
        tp.randomPos();
    }

}
