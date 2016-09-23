import java.util.Random;

/**
 * Created by tearsyu on 16-9-10.
 */
public class JoueurDichotomique extends JoueurAvecIntervalle implements Joueur{
    private String name;
    private  int coup, nbkey;
    private Intervalle intervalle;
    private Score score;

    public JoueurDichotomique(String name, Intervalle intervalle){
        super(name, intervalle);
        this.name = name;
        this.intervalle = intervalle;
        score = new Score();
    }
    public void setNbkey(){
        //Scanner scanner = new Scanner(System.in);
        //nbkey = scanner.nextInt();
        Random random = new Random();
        nbkey = random.nextInt(intervalle.getSup());
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
        if (essai == nbkey){
            reponse = 0;
        } else if(essai < nbkey) {
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
}
