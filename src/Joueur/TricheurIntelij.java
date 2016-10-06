package Joueur;

/**
 * Created by tearsyu on 16-10-1.
 * TricheIntelij est un joueur Dichotomique et Tricheur, Joueur.Arbitre ne peut pas le detecter.
 * Le moyen quil triche, c'est qu'il donne pas le nb a trouver tout de suite.
 * Il attend que le 1er chiffre que l'autre joueur donne, et il setReponse une intervalle la plus grande.
 *
 * EX: joueurA devine 89 avec une intervalle 100. Le tricheur definir tout de suite son nbkey est 0 et il
 * va repondre plus petit car 0->89 est plus grande par rapport a 89->100.
 */
public class TricheurIntelij extends JoueurAvecIntervalle implements Joueur{
    private String name;
    private  int coup, nbkey;
    private Intervalle intervalle;
    private Score score;
    private boolean isCheater;
    private boolean isFirstGuess;

    public TricheurIntelij(String name, Intervalle intervalle) {
        super(name, intervalle);
        this.name = name;
        this.intervalle = intervalle;
        this.score = new Score();
        isFirstGuess = true;
    }

    @Override
    public void setNbkey() {
        nbkey = -1;
    }

    public int getNbkey(){
        return nbkey;
    }


    public int getCoup(){
        coup = intervalle.getMilieu();
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

    //On modifie juste la methode de testSecret, pour definir son nombre a trouver
    //en fonction de premier chiffre que lautre joueur devine.
    @Override
    public int testSecret(int essai) {
        int reponse;
        if (isFirstGuess) {
            if (essai > intervalle.getSup() - essai) {
                nbkey = intervalle.getInf()+1;
                System.out.println("[Cheater]Now he change:nbKey to : " + nbkey );
                isFirstGuess = false;
            } else {
                nbkey = intervalle.getSup()-1;
                isFirstGuess = false;
                System.out.println("[Cheater]Now he change:nbKey to : " + nbkey);
            }
        }
        if (essai == nbkey) {
            reponse = Arbitre.Reponse.FOUND.flag;
        } else if (essai < nbkey) {
            reponse = Arbitre.Reponse.BIGGER.flag;
        } else {
            reponse = Arbitre.Reponse.SMALLER.flag;
        }
        return reponse;

    }

    public String getName(){
        return name;
    }

    @Override
    public int retrunCoup() {
        return coup;
    }

    public void showInfo() {
        System.out.println("[GenerateNb]" + getName() + " Class : "
                + getClass().getName() + " give the number: " + nbkey);
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

    public void  setIntervalle(Intervalle intervalle){
        this.intervalle = intervalle;
    }
}
