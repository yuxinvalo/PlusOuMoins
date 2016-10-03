package Joueur;

/**
 * Created by tearsyu on 16-9-11.
 * This is an interface, every joueur should implements this interface.
 * Other avantage: On peut declarer une varible de Joueur.Joueur sans precise lequelle joueur non abstraite,
 * on les precises quand on les crees dans la memoire(ex. Joueur.Joueur A ; A = new Joueur.JoueurHumain;)
 */
public interface Joueur {
    int getCoup();
    void setReponse(int reponse);
    int testSecret(int essai);
    String getName();
    int retrunCoup();

    int getNbkey();
    void setNbkey();

    void showInfo();

    int getScore();
    void calScore(int flag);

    //These methodes are used to set cheater and tell us if this player is a cheater or not.
    void setCheater(boolean b);
    boolean isCheater();
}