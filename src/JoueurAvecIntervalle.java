
/**
 * Created by tearsyu on 16-9-15.
 * This is an abstract class for every Joueur who use intervalle should be extended
 * But I am not should the name and intervalle two prototypes are necessary, maybe not.
 */
public abstract class JoueurAvecIntervalle {
    private Intervalle  intervalle;
    private String name;

    public JoueurAvecIntervalle(String name, Intervalle intervalle){
        this.name = name;
        this.intervalle = intervalle;
    }

}
