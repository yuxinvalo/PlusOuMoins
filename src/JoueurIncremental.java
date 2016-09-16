/**
 * Created by tearsyu on 16-9-10.
 */
public class JoueurIncremental implements Joueur {
    private String name;
    int coup = -1;
    public JoueurIncremental(String name){
        this.name = name;
    }

    public int getCoup(){
        coup = coup + 1;
        if (coup > 100)
            coup = 1;
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

    public String getName() {
        return name;
    }

    @Override
    public int retrunCoup() {
        return coup;
    }
}
