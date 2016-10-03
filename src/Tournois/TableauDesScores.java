package Tournois;

import Joueur.Joueur;

import java.util.Vector;

/**
 * Created by tearsyu on 16-9-19.
 * This class is used to manage assemble of Joueur.Score.
 * I use Vector to save each Joueur.Joueur then thier Joueur.Score.
 */
public class TableauDesScores {
    private int i, iTriche;
    private Vector tableScore, tableScoreTriche;


    public TableauDesScores(){
        this.tableScore = new Vector();
        this.tableScoreTriche = new Vector();
        i = 0;
        iTriche = 0;
    }

    /**
     * There a bug appears, when joueur points change in the next game, all the points will change.
     * Maybe i can use deepcopy to solv it.
     * And at exo 15 we need add a function : show the name of cheater at side.
     * */
    public void setScoreTable(Joueur joueur){
        if (joueur.isCheater() && !tableScoreTriche.contains(joueur)){
            tableScoreTriche.add(iTriche, joueur);
            iTriche++;
        } else if(tableScoreTriche.contains(joueur)) {
            tableScoreTriche.set(tableScoreTriche.indexOf(joueur), joueur);
        } else if (!tableScore.contains(joueur)){
            tableScore.add(i, joueur);
            i++;
        } else {
            tableScore.set(tableScore.indexOf(joueur), joueur);
        }
    }

    public void showTableScore(){
        Joueur joueur;
        System.out.print("[TableScore] {");
        for (int i = 0; i < tableScore.size(); ++i){
            joueur = (Joueur) tableScore.get(i);
            if (i == tableScore.size() - 1){
                System.out.print(joueur.getName() + " points : " + joueur.getScore() + "}");
                break;
            }
            System.out.print(joueur.getName() + " points : " + joueur.getScore() + " | ");
            if (i%25 == 24) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.print("[TricheurTabScore]{");
        for (int i = 0; i < tableScoreTriche.size(); i++){
            joueur = (Joueur)tableScoreTriche.get(i);
            if (i == tableScore.size() - 1){
                System.out.print(joueur.getName() + " points : " + joueur.getScore() + "}");
                break;
            } System.out.print(joueur.getName() + " points : " + joueur.getScore() + " | " );
            if (i%25 == 24){
                System.out.println();
            }
        }
    }

public Joueur findChampion(){
    Joueur champion = null, tmp;
    int max = 0;
    for (Object o : tableScore){
        tmp = (Joueur)o;
        if (tmp.getScore() > max){
            champion = tmp;
            max = champion.getScore();
        }
    }
    System.out.println("Cheater is not eligible to be champion.");
    return  champion;
}

}
