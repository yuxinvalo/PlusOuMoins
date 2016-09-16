import java.util.Random;

/**
 * Created by tearsyu on 16-9-10.
 */
public class JoueurDichotomique implements Joueur{
    private String name;
    private  int coup;
    private Intervalle intervalle;

    public JoueurDichotomique(String name, Intervalle intervalle){
        this.name = name;
        this.intervalle = intervalle;
    }


    public int getCoup(){
        coup = intervalle.getMilieu();
        return coup;
    }

    @Override
    public void setReponse(int reponse) {
        if (reponse == 0){
            System.out.println("You find it.");
        } else if (reponse == 1){
            System.out.println("It should be bigger.");
        } else if (reponse == 2){
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

    public String getName(){
        return name;
    }

    @Override
    public int retrunCoup() {
        return coup;
    }

}
