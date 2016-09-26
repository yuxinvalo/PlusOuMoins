import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by tearsyu on 16-9-16.
 * This class is a tounois avec mode challenger. Copy from TournoisGlobal, mais startGame() different.
 */
public class TounoisChallenger implements Tournois{
    private Vector vectJoueur;
    private TableauDesScores tableauDesScores;
    private ArrayList aListJoueur;
    private Iterator ite;

    /**
     * Vector c'est un type de container, il est simple a utiliser.
     * On peut ajouter tout les types des elements dans Vector avec une index.
     * Et il propose les methode differentes pour quon puisse manipule les elements dedans.
     * */

    public TounoisChallenger(){
        vectJoueur = new Vector();
        tableauDesScores = new TableauDesScores();
        aListJoueur = new ArrayList();
    }

    //Fait attention, l'index de vector commence par 0, puis 1, 2, 3...
    public void addJoueur(Joueur joueur){
        vectJoueur.add(joueur);
        System.out.println("[AddPlayer] add joueur " + joueur.getName() + " successfully at " + vectJoueur.indexOf(joueur));
    }

    /**
     * Cette classe a un nom identique avec celle en haut, c'est une caracteristique du language OOP
     * il s'appelle 'overloading'.  Vous pouvez googler est distinquer la difference entre
     * 'overloading' et 'overriding'
     * */
    public void addJoueur(Collection collection){
        vectJoueur.addAll(collection);
        System.out.println("[AddPlayer] add collection successfully. Size is " + vectJoueur.size());
        showInfo();
    }

    /**
     * ArrayList est une subclasse de collection, on l'utilise pour encapsuler les joueurs comme une collection.
     * */
    public void addJoueurInList(Joueur joueur){
        aListJoueur.add(joueur);

        //Cest pour iterater la collection.
        ite = aListJoueur.iterator();
    }

    /**Exo 12, on utilise iterateur pour y acceder.
     * La classe iterator nous propose bcp de methode pour manipuler les elements dans iterator.
     * Ici cest juste une example pour imprimer les info
     * */
    public void iteratorAccess(){
        while (ite.hasNext()) {
            Joueur joueur = (Joueur) ite.next();
            System.out.println(joueur.getName());
        }
    }

    public void rmJoueur(Joueur joueur){
        vectJoueur.remove(joueur);
        System.out.println("joueur " + joueur.getName() + " have been removed from vector.");
    }

    public void showInfo(){
        Joueur joueur;

        System.out.println("Now vector length is: " + vectJoueur.size());
        System.out.print("They are: ");
        for (int i = 0; i < vectJoueur.size(); i++){
            joueur = (Joueur) vectJoueur.get(i);
            System.out.println("[" + joueur.getName() + "] at " + vectJoueur.indexOf(vectJoueur.get(i)));
        }
    }


    /**C'est un mode du jeux : un challenger fait le tournois avec tous le monde en calculant la moyenne des points.
     * EX. joueur A, B, C, D, A->B, A->C. A->D, puis on calcule Apoints/3
     * */
    public void startGame(Intervalle intervalle, int nbPartie){
        Arbitre arbitre;
        Joueur joueurChallenger = null, joueurTmp = null;
        joueurChallenger = (Joueur) vectJoueur.get(0);
        //arbitre = new Arbitre(intervalle, joueurChallenger, joueurTmp);
        for (int i = vectJoueur.size() - 1; i > 0; i--){
            joueurTmp = (Joueur) vectJoueur.get(i);
            for(int j = 0; j < nbPartie; j++){
                if (j < nbPartie/2) {
                    System.out.println("[Order] Joueur " + joueurChallenger.getName() + " firstly");
                    arbitre = new Arbitre(intervalle, joueurChallenger, joueurTmp);
                    arbitre.startGame2();
                } else {
                    System.out.println("[OrderReverse] Joueur" + joueurTmp.getName() + " firstly");
                    arbitre = new Arbitre(intervalle, joueurTmp, joueurChallenger);
                    arbitre.startGame2();
                }
            }
            tableauDesScores.setScoreTable(joueurChallenger);
            tableauDesScores.setScoreTable(joueurTmp);
            System.out.println("[Score] Challenger "+ joueurChallenger.getName() + " score is : " +
                    joueurChallenger.getScore()/(vectJoueur.size() - 1));
            System.out.println("[Score] Player " + joueurTmp.getName() + " score is: " + joueurTmp.getScore());
        }
    }


    public static void main(String[] args){
        Joueur joueur1, joueur2, joueur3, joueur4, joueur5 ;
        joueur1 = new JoueurIncremental("1");
        joueur2 = new JoueurHumain("2");
        joueur3 = new JoueurIncremental("3");
        //joueur4 = new JoueurIncremental("4");
        //joueur5 = new JoueurIncremental("5");

        TounoisChallenger tounois = new TounoisChallenger();

        //Test addJoueur(Joueur joueur)
        tounois.addJoueur(joueur1);
        tounois.addJoueur(joueur2);
        tounois.addJoueur(joueur3);
       // tounois.addJoueur(joueur4);
        //tounois.addJoueur(joueur5);*/


        tounois.showInfo();
        //Intervalle intervalle = new Intervalle(0, 10);
       // tounois.startTournois(intervalle, 4);
        //tounois.showTableScore();
        int i = 3;
        System.out.println(i/2);
    }
}
