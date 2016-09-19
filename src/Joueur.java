/**
 * Created by tearsyu on 16-9-11.
 * This is an interface, every joueur should implements this interface.
 * Other avantage: On peut declarer une varible de Joueur sans precise lequelle joueur non abstraite,
 * on les precises quand on les crees dans la memoire(ex. Joueur A ; A = new JoueurHumain;)
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
}
