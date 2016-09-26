import java.util.Collection;

/**
 * Created by tearsyu on 16-9-27.
 */
public interface Tournois {
    void addJoueur(Joueur joueur);
    void addJoueur(Collection collection);
    void rmJoueur(Joueur joueur);

    void showInfo();
    void startGame(Intervalle intervalle, int nbPartie);
}
