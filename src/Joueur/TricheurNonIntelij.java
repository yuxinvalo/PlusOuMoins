package Joueur;

import java.util.Random;


/**
 * Created by tearsyu on 16-9-30.
 * Cette classe est un type de joueur mais il triche par une moyen non intelligente.
 * Il donne un chiffre a trouver temps en temps superieur a l'intervalle ou inferieur a l'intervalle.
 * Parce quil n'est pas intelligent, donc j'imagine cest un joueur incremental et tricheur.
 */
public class TricheurNonIntelij implements Joueur{
    private String name;
    private int coup, nbkey;
    private Score score;
    private Intervalle intervalle;
    private boolean isCheater;

    public TricheurNonIntelij (String name, Intervalle intervalle){
        this.name = name;
        this.intervalle = intervalle;
        this.score = new Score();
        this.coup = 0;
    }

    @Override
    public int getCoup() {
        coup = coup + 1;
        if (coup > intervalle.getSup())
            coup = 0;
        return coup;
    }

    @Override
    public void setReponse(int reponse) {
        if (reponse == Arbitre.Reponse.FOUND.flag){
            System.out.println("You find it.");
        } else if (reponse == Arbitre.Reponse.BIGGER.flag){
            System.out.println("It should be bigger.");
        } else if (reponse == Arbitre.Reponse.SMALLER.flag){
            System.out.println("It should be smaller.");
        }
    }

    @Override
    public int testSecret(int essai) {
        int reponse;
        if (essai == coup){
            reponse = 0;
        } else if(essai < coup) {
            reponse = 1;
        } else {
            reponse = 2;
        }
        return reponse;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int retrunCoup() {
        return coup;
    }

    @Override
    public int getNbkey() {
        return nbkey;
    }

    @Override
    public void setNbkey() {
        Random random = new Random();
        nbkey = random.nextInt(intervalle.getSup() * 2);
    }

    @Override
    public void showInfo() {
        System.out.println("[GenerateNb]" + getName() + " Class : "
                + getClass().getName() + " give the number: " + nbkey);
    }

    @Override
    public int getScore() {
        return score.getScore();
    }

    @Override
    public void calScore(int flag) {
        showInfo();
        score.calScore(flag);
    }

    @Override
    public boolean isCheater() {
        return isCheater;
    }

    @Override
    public void setIntervalle(Intervalle intervalle) {

    }

    public void setCheater(boolean b){
        this.isCheater = b;
    }
}
