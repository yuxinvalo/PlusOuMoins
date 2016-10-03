package Tournois;

import Joueur.*;
import java.util.*;

/**
 * Created by tearsyu on 16-9-16.
 */
public class TounoisGlobal implements Tournois {
    private Vector vectJoueur;
    private TableauDesScores tableauDesScores;
    private ArrayList aListJoueur;
    private Iterator ite;

    /**
     * Vector c'est un type de container, il est simple a utiliser.
     * On peut ajouter tout les types des elements dans Vector avec une index.
     * Et il propose les methode differentes pour quon puisse manipule les elements dedans.
     * */

    public TounoisGlobal(){
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
    public void addJoueurInAList(Joueur joueur){
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


    /**C‘est un probleme de conbinaison, n conbinaison m
     * Par ex, joueurs A, B, C, D. Combat: A->B, A->C, A->D, B->C, B->D, C->D
     * Soit patient, cet exo est difficile et faire attention les etapes de tournois.
     * Et je vous conseille de comprendre d'abord startTournois se trouvant dans
     * la classe TournoisChallenger.
     * */
    int begin = 0;
    Joueur joueurBegin = null, joueurAccpt = null;
    public void startGame(Intervalle intervalle, int nbPartie){
        Arbitre arbitre;
        //mot cle 'try{...}catch(Exception e){...}' cest pour saisir les erreurs au cas ou il y a un bug.
        try {
            //Condition de finir c'est begin = joueur C
            if (begin == vectJoueur.size() - 1) {
                System.out.println("[Champion] The winner is born : " + tableauDesScores.findChampion().getName());
                return;
            }

            for (int i = begin; i < vectJoueur.size() - 1; i++) {

                //Init joueurBegin selon variable 'begin'
                joueurBegin = (Joueur) vectJoueur.get(begin);
                //Init joueur who accepte le jeu selon variable i, i commence tjrs par la suite de 'begin'
                joueurAccpt = (Joueur) vectJoueur.get(i + 1);

                for (int j = 0; j < nbPartie; j++) {
                    if (j < nbPartie / 2) {
                        System.out.println("[Order] Joueur.Joueur " + joueurBegin.getName() + " firstly");
                        arbitre = new Arbitre(intervalle, joueurBegin, joueurAccpt);
                        arbitre.startGame2();
                    } else {
                        System.out.println("[Order] Joueur.Joueur " + joueurAccpt.getName() + " firstly");
                        arbitre = new Arbitre(intervalle, joueurAccpt, joueurBegin);
                        arbitre.startGame2();
                    }
                }
                tableauDesScores.setScoreTable(joueurBegin);
                tableauDesScores.setScoreTable(joueurAccpt);
            }
            //begin auto add 1, et recursive
            begin++;
           startGame(intervalle, nbPartie);
        }catch (Exception e){
           // System.out.println("[Error]: 'out of range': I dont want to deal it, so I just discard it.");
            e.printStackTrace();
        }
    }


    public void showTableScore(){
        tableauDesScores.showTableScore();
    }


}
