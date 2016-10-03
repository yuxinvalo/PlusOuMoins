package Joueur;

import java.util.Random;

/**
 * Created by tearsyu on 16-9-10.
 * Cette classe est identique a la classe Joueur.JoueurHumain, juste change la facon de
 * generer le nombre. Ce joueur genere les nombres incrementals.
 */
public class JoueurIncremental extends JoueurAvecSecret implements Joueur {
    private String name;
    int coup = -1, nbkey;
    private Score score;
    boolean isCheater;
    public JoueurIncremental(String name){
        this.name = name;
        score = new Score();
        isCheater = false;
    }

    public void setNbkey(){
        //Scanner scanner = new Scanner(System.in);
        //nbkey = scanner.nextInt();
        Random random = new Random();
        nbkey = random.nextInt(10);
    }

    public int getNbkey(){
        return nbkey;
    }

    public int getCoup(){
        coup = coup + 1;
        if (coup > 10)
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
        if (essai == nbkey){
            reponse = Arbitre.Reponse.FOUND.flag;
        } else if(essai < nbkey) {
            reponse = Arbitre.Reponse.BIGGER.flag;
        } else {
            reponse = Arbitre.Reponse.SMALLER.flag;
        }
        return reponse;
    }

    public String getName() {
        return name;
    }

    @Override
    public int retrunCoup() {
        return coup;
    }

    public void showInfo() {
        System.out.println("[GenerateNb]" + getName() + " Class : " +
                getClass().getName() + " give the number: " + nbkey);
    }

    public int getScore(){
        return score.getScore();
    }

    public void calScore(int flag){
        score.calScore(flag);
    }

    @Override
    public boolean isCheater() {
        return isCheater;
    }
    public void setCheater(boolean b){
        this.isCheater = b;
    }
}
