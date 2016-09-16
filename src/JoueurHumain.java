import java.util.Random;

/**
 * Created by tearsyu on 16-9-9.
 */
public class JoueurHumain implements Joueur {

    private String name;
    int coup;

    public JoueurHumain(String name){
        this.name = name;

    }

    public int getCoup(){
        Random random = new Random();
        coup = random.nextInt(100);
        return coup;
    }

    public void setReponse(int reponse){
        if (reponse == 0){
            System.out.println("You find it.");
        } else if (reponse == 1){
            System.out.println("It should be bigger.");
        } else if (reponse == 2){
            System.out.println("It should be smaller.");
        }
    }

    public int testSecret(int essai){
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

    ///================Generate auto==============================
    public String getName() {
        return name;
    }

    @Override
    public int retrunCoup() {
        return coup;
    }

    public void setName(String name) {
        this.name = name;
    }

}
