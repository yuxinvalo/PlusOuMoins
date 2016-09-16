import java.util.Random;

/**
 * Created by tearsyu on 16-9-15.
 */
public abstract class JoueurAvecIntervalle {
    private Intervalle  intervalle;
    private Joueur joueur;
    private String name;
    private int coup;

    public JoueurAvecIntervalle(String name, Intervalle intervalle){
        this.name = name;
        this.intervalle = intervalle;
    }

}
