package Tournois;

import Joueur.*;
import java.lang.Integer;
/**
 * Created by tearsyu on 16-9-22.
 * Classe paire cest une classe 'generic pair'(googlez-vous), qui permet d'encapsuler une paire de data
 * elle est cree pour ramplacer la score Classe, parce que la classe Joueur.Score cest une paire de (Joueur.Score Joueur.Joueur).
 *
 * Je n'utilise pas cette classe parce que la structure de mon projet ne permet pas que j'utilise Tournois.Paire, sinon je dois
 * reconstribut bcp de chose. Ca vaut pas.
 */
public class Paire <J, I>{
    private Joueur joueur;
    private Integer score;
    //private int calS;

    public Paire(Joueur joueur, Integer score){
        this.joueur = joueur;
        this.score = score;
       // calS = 0;
    }

    public Integer getScore(){
        return score;
    }

    public Joueur getJoueur(){
        return joueur;
    }

    public void setScore(Integer score){
        this.score = score;
    }

    public void setJoueur(Joueur joueur){
        this.joueur = joueur;
    }

    public void calScore(int flag){
        if (flag == Score.ScoreFlag.NULL.flag){
            score += 0;
        } else if (flag == Score.ScoreFlag.WINNER.flag){
            score += 2;
        }
        else if (flag == Score.ScoreFlag.NULL.flag){
            score += 1;
        } else {
            System.out.println("[Error] Wrong flag input in Class Pair at calScore().");
        }
    }

    public void showInfo(){
        System.out.println("[PairInfo]Joueur.Joueur " + joueur.getName() + " : Points " + getScore());
    }



}
