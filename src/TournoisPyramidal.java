import java.util.*;

/**
 * Created by tearsyu on 16-9-22.
 */
public class TournoisPyramidal {
    private Vector vectJoueur;
    private TableauDesScores tableauDesScores;
    private ArrayList aListJoueur;
    private Iterator iterator;

    public TournoisPyramidal(){
        vectJoueur = new Vector();
        tableauDesScores = new TableauDesScores();
        aListJoueur = new ArrayList<>();
    }

    public void addJoueur(Joueur joueur){
        vectJoueur.add(joueur);
    }

    public void addJoueur(Collection collection){
        vectJoueur.addAll(collection);
    }

    public void setIterator(Joueur joueur){
        aListJoueur.add(joueur);
        iterator = aListJoueur.iterator();
    }

    public void rmJoueur(Joueur joueur){
        int i = vectJoueur.indexOf(joueur);
        vectJoueur.remove(joueur);
        System.out.println("[RemoveJoueur] " + joueur.getName() + "has been remove from Vector at " + i);
    }

    public void showInfo(){
        Joueur joueur;

        System.out.println("[ShowInfoVector]Now vector length is: " + vectJoueur.size());
        System.out.print("They are: ");
        for (int i = 0; i < vectJoueur.size(); i++){
            joueur = (Joueur) vectJoueur.get(i);
            System.out.println("[" + joueur.getName() + "] at " + vectJoueur.indexOf(vectJoueur.get(i)));
        }
    }

    public void startGame(Intervalle intervalle, int nbPartie){
        int a, b;

        Random random = new Random();
        a = random.nextInt(vectJoueur.size() - 1);
        while (a == (b = random.nextInt(vectJoueur.size() - 1))){
            b = random.nextInt(vectJoueur.size() - 1);
        }


    }


}
