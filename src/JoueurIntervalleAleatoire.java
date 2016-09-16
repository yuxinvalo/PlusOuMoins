import java.util.Random;

/**
 * Created by tearsyu on 16-9-15.
 */
public class JoueurIntervalleAleatoire extends JoueurAvecIntervalle implements Joueur{

    private Intervalle intervalle;
    private  int coup;

    public JoueurIntervalleAleatoire(String name, Intervalle intervalle) {
        super(name, intervalle);
    }

    @Override
    public int getCoup() {
        Random random = new Random();
        coup = random.nextInt(intervalle.getNumMax()) %
                (intervalle.getNumMax() - intervalle.getNumMin() + 1) + intervalle.getNumMin();
        return coup;
    }

    @Override
    public void setReponse(int reponse) {

    }

    @Override
    public int testSecret(int essai) {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int retrunCoup() {
        return 0;
    }
}
