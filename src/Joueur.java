/**
 * Created by tearsyu on 16-9-11.
 */
public interface Joueur {
    int getCoup();
    void setReponse(int reponse);
    int testSecret(int essai);
    String getName();
    int retrunCoup();
}
