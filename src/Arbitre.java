import java.util.Random;

/**
 * Created by tearsyu on 16-9-11.
 * The class Arbitre is a detector of the game.
 * jouer() is used to detect the cheater between two players;
 * startGame() is used to hold a game with two players, this method is a little complexe.
 * Because we need to deal with the joueur intervalle.
 */
public class Arbitre extends JoueurAvecSecret{
    private Intervalle intervalle;
    private int max, coup;
    private Joueur joueur1, joueur2;
    public enum Reponse {BIGGER(1), SMALLER (2), FOUND (0);
        public int flag;
        Reponse(int falg){
            this.flag = falg;
        }
    }

    public Arbitre(Intervalle intervalle, Joueur joueur1, Joueur joueur2){
        max = intervalle.getSup();
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.intervalle = intervalle;
    }
    public void jouer(){
        if (joueur1.retrunCoup() > max){
            System.out.println(joueur1.getName() + " roll " + joueur1.retrunCoup() + " overring " + max + ". Go out!");
        }
        if (joueur2.retrunCoup() > max){
            System.out.println(joueur2.getName() + " roll " + joueur2.retrunCoup() + " overring " + max + ". Go out!");
        }
    }

    public int getCoup(){
        Random random = new Random();
        coup = random.nextInt(max);
        return coup;
    }


    public void setReponse(int reponse, Joueur joueur){
        if (reponse == Reponse.FOUND.flag){
            System.out.println("You "+ joueur.getName() + " find it.");
        } else if (reponse == Reponse.BIGGER.flag){
            System.out.println("It should be bigger.");
        } else if (reponse == Reponse.SMALLER.flag){
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

    /**
     * Cette une methode faute pour les exo. J'ai mal compris.
     *
     * */
    public void startGame(){
        int a, b;
        //Joueur joueur = null;

        System.out.println("We start , nb secret is : " + getCoup());

        //if play use dichotomique, we need to change step of game here.
        //if joueur1 and joueur 2 are all ths joueur DichoIntervalle
        if ((joueur1.getClass().getName().equals("JoueurIntervalleAleatoire") &&
                joueur2.getClass().getName().equals("JoueurIntervalleAleatoire")) ||
                (joueur1.getClass().getName().equals("JoueurDichotomique")) &&
                        joueur2.getClass().getName().equals("JoueurDichotomique")) {

           //-----------------------------------
            do{
                a = joueur1.getCoup();
                b = joueur2.getCoup();

                Intervalle intervalleCopy = new Intervalle(intervalle.getInf(), intervalle.getSup());
                if (testSecret(a) == 1 || testSecret(b) == 1){
                    intervalle.setNumMin(a);
                    System.out.println(joueur1.getName() + " guess it is: " + a );
                    setReponse(testSecret(a), joueur1);

                    intervalleCopy.setNumMax(b);
                    System.out.println(joueur2.getName() + "guess it is " + b);
                    setReponse(testSecret(b), joueur2);
                }
                if (testSecret(a) == 2 || testSecret(b) == 2) {
                    intervalle.setNumMin(a);
                    System.out.println(joueur1.getName() + " guess it is: " + a );
                    setReponse(testSecret(a), joueur1);

                    intervalleCopy.setNumMax(b);
                    System.out.println(joueur2.getName() + "guess it is " + b);
                    setReponse(testSecret(b), joueur2);
                }

            } while((testSecret(a) != 0) && (testSecret(b) != 0));


            //if joueur2 is a joueur dichoIntervalle
        } else if (joueur2.getClass().getName().equals("JoueurDichotomique") ||
                joueur2.getClass().getName().equals("JoueurIntervalleAleatoire")) {

            do{
                b = joueur1.getCoup();
                a = joueur2.getCoup();

                if (testSecret(a) == 1){
                    intervalle.setNumMin(a);
                    System.out.println(joueur2.getName() + " guess it is: " + a );
                    setReponse(testSecret(a), joueur2);
                } else {
                    intervalle.setNumMax(a);
                    System.out.println(joueur2.getName() + " guess it is: " + a );
                    setReponse(testSecret(a), joueur2);
                }

                System.out.println(joueur1.getName() + " guess it is: " + b);
                setReponse(testSecret(b), joueur1);

            } while((testSecret(a) != 0) && (testSecret(b) != 0));

            //if joueur 1 is ...
        } else if (joueur1.getClass().getName().equals("JoueurDichotomique") ||
                    joueur1.getClass().getName().equals("JoueurIntervalleAleatoire")) {

            do{
                a = joueur1.getCoup();
                b = joueur2.getCoup();

                if (testSecret(a) == 1){
                    intervalle.setNumMin(a);
                    System.out.println(joueur1.getName() + " guess it is: " + a );
                    setReponse(testSecret(a), joueur1);
                } else {
                    intervalle.setNumMax(a);
                    System.out.println(joueur1.getName() + " guess it is: " + a );
                    setReponse(testSecret(a), joueur1);
                }

                System.out.println(joueur2.getName() + " guess it is: " + b);
                setReponse(testSecret(b), joueur2);

            } while((testSecret(a) != 0) && (testSecret(b) != 0));

            //if joueur is a nomal joueur
        } else {

            do {
                a = joueur1.getCoup();
                b = joueur2.getCoup();

                //joueur 1 tour
                System.out.println(joueur1.getName() + " guess it is: " + a);
                setReponse(testSecret(a), joueur1);

                //joueur 2 tour
                System.out.println(joueur2.getName() + " guess it is: " + b);
                setReponse(testSecret(b), joueur2);

            } while ((testSecret(a) != 0) && (testSecret(b) != 0));
        }
    }

    /**
     * Donc cette methode sert a
     * */
    public void startGame2(){
        int a, b;
        joueur1.setNbkey();
        joueur2.setNbkey();

        joueur1.showInfo();
        joueur2.showInfo();


        if ((joueur1.getClass().getName().equals("JoueurIntervalleAleatoire") &&
                joueur2.getClass().getName().equals("JoueurIntervalleAleatoire")) ||
                (joueur1.getClass().getName().equals("JoueurDichotomique")) &&
                        joueur2.getClass().getName().equals("JoueurDichotomique")){

            do{
                //joueur 1 tour
                a = joueur1.getCoup();
                b = joueur2.getCoup();
                Intervalle intervalleCopy = new Intervalle(intervalle.getInf(), intervalle.getSup());

                if (joueur2.testSecret(a) == 1) {

                    intervalle.setNumMin(a);
                    System.out.println(joueur1.getName() + " guess it is: " + a);
                    joueur2.setReponse(joueur2.testSecret(a));
                }

                if (joueur1.testSecret(b) == 1 ){
                    intervalleCopy.setNumMin(b);
                    System.out.println(joueur2.getName() + "guess it is " + b);
                    joueur1.setReponse(joueur1.testSecret(b));
                }

                if(joueur2.testSecret(a) == 2){
                    intervalle.setNumMax(a);
                    System.out.println(joueur1.getName() + " guess it is: " + a);
                    joueur2.setReponse(joueur2.testSecret(a));
                }

                if(joueur1.testSecret(b) == 2) {
                    intervalleCopy.setNumMax(b);
                    System.out.println(joueur2.getName() + " guess it is: " + b);
                    joueur1.setReponse(joueur1.testSecret(b));
                }

                //Affiche les info de la fin de partie=======================================
                if (joueur1.testSecret(b) == 0 && joueur2.testSecret(a) == 0){
                    System.out.println( "[Winner]" + joueur1.getName() + " and " + joueur2.getName()
                           + " find it at the same time.");
                    joueur1.calScore(Score.ScoreFlag.NULL.flag);
                    joueur2.calScore(Score.ScoreFlag.NULL.flag);
                }

                if (joueur1.testSecret(b) == 0){
                    System.out.println("[Winner]" +joueur2.getName() + "Find it.");
                    joueur2.calScore(Score.ScoreFlag.WINNER.flag);
                    joueur1.calScore(Score.ScoreFlag.LOOSER.flag);
                }

                if (joueur2.testSecret(a) == 0){
                    System.out.println("[Winner]" + joueur1.getName() + "Find it.");
                    joueur1.calScore(Score.ScoreFlag.WINNER.flag);
                    joueur2.calScore(Score.ScoreFlag.LOOSER.flag);
                }
            }while ((joueur1.testSecret(b) != 0) && (joueur2.testSecret(a) != 0));

        } else if (joueur1.getClass().getName().equals("JoueurDichotomique") ||
                joueur1.getClass().getName().equals("JoueurIntervalleAleatoire")){
            do{
                //joueur1 is a special player, the intervalle need to be deal.
                a = joueur1.getCoup();
                b = joueur2.getCoup();

                if (joueur2.testSecret(a) == 1){
                    intervalle.setNumMin(a);
                    System.out.println(joueur1.getName() + " guess it is " + a);
                    joueur2.setReponse(joueur2.testSecret(a));
                }

                if (joueur2.testSecret(a) == 2){
                    intervalle.setNumMax(a);
                    System.out.println(joueur1.getName() + " guess it is " + a);
                    joueur2.setReponse(joueur2.testSecret(a));
                }

                System.out.println(joueur2.getName() + " guess it is " + b);
                joueur1.setReponse(joueur1.testSecret(a));


                //Info de la fin de partie calculer les points==============================
                if (joueur1.testSecret(b) == 0 && joueur2.testSecret(a) == 0){
                    System.out.println( "[Winner]" + joueur1.getName() + " and " + joueur2.getName()
                            + " find it at the same time.");
                    joueur1.calScore(Score.ScoreFlag.NULL.flag);
                    joueur2.calScore(Score.ScoreFlag.NULL.flag);
                }

                if (joueur1.testSecret(b) == 0){
                    System.out.println( "[Winner]" + joueur2.getName() + " find it.");
                    joueur1.calScore(Score.ScoreFlag.LOOSER.flag);
                    joueur2.calScore(Score.ScoreFlag.WINNER.flag);
                }

                if (joueur2.testSecret(a) == 0){
                    System.out.println("[Winner]" + joueur1.getName() + " find it.");
                    joueur1.calScore(Score.ScoreFlag.WINNER.flag);
                    joueur2.calScore(Score.ScoreFlag.LOOSER.flag);
                }

            }while((joueur1.testSecret(b) != 0) && (joueur2.testSecret(a) != 0));

        } else if (joueur2.getClass().getName().equals("JoueurDichotomique") ||
                    joueur2.getClass().getName().equals("JoueurIntervalleAleatoire")){

            do{
                //joueur 2, b need to deal.
                a = joueur1.getCoup();
                b = joueur2.getCoup();

                System.out.println(joueur1.getName() + " guess it is: " + a);
                joueur2.setReponse(joueur2.testSecret(a));

                if (joueur1.testSecret(b) == 1){
                    intervalle.setNumMin(b);
                    System.out.println(joueur2.getName() + " guess it is " + b);
                    joueur1.setReponse(joueur1.testSecret(b));
                }

                if (joueur1.testSecret(b) == 2){
                    intervalle.setNumMax(b);
                    System.out.println(joueur2.getName() + " guess it is " + b);
                    joueur1.setReponse(joueur1.testSecret(b));
                }


                //Info de la fin de partie================================
                if (joueur1.testSecret(b) == 0 && joueur2.testSecret(a) == 0){
                    System.out.println( "[Winner]" + joueur1.getName() + " and " + joueur2.getName()
                            + " find it at the same time.");
                    joueur1.calScore(Score.ScoreFlag.NULL.flag);
                    joueur2.calScore(Score.ScoreFlag.NULL.flag);
                }

                if (joueur1.testSecret(b) == 0){
                    System.out.println( "[Winner]"+ joueur2.getName() + " find it.");
                    joueur1.calScore(Score.ScoreFlag.LOOSER.flag);
                    joueur2.calScore(Score.ScoreFlag.WINNER.flag);
                }

                if (joueur2.testSecret(a) == 0){
                    System.out.println("[Winner] " + joueur1.getName() + " find it.");
                    joueur1.calScore(Score.ScoreFlag.WINNER.flag);
                    joueur2.calScore(Score.ScoreFlag.LOOSER.flag);

                }

            } while ((joueur1.testSecret(b) != 0) && (joueur2.testSecret(a) != 0));

        }else {
            do {

                //joueur 1 tour
                a = joueur1.getCoup();
                System.out.println(joueur1.getName() + " guess it is: " + a);
                joueur2.setReponse(joueur2.testSecret(a));

                //joueur 2 tour
                b = joueur2.getCoup();
                System.out.println(joueur2.getName() + " guess it is: " + b);
                joueur1.setReponse(joueur1.testSecret(b));


                //Info de la fin de partie==========================================
                if (joueur1.testSecret(b) == 0 && joueur2.testSecret(a) == 0){
                    System.out.println( "[Winner]" + joueur1.getName() + " and " + joueur2.getName()
                             + " find it at the same time.");
                    joueur1.calScore(Score.ScoreFlag.NULL.flag);
                    joueur2.calScore(Score.ScoreFlag.NULL.flag);
                }

                if (joueur1.testSecret(b) == 0){
                    System.out.println("[Winner]" + joueur2.getName() + " find it.");
                    joueur1.calScore(Score.ScoreFlag.LOOSER.flag);
                    joueur2.calScore(Score.ScoreFlag.WINNER.flag);
                }

                if (joueur2.testSecret(a) == 0){
                    System.out.println("[Winner]" + joueur1.getName() + " find it.");
                    joueur1.calScore(Score.ScoreFlag.WINNER.flag);
                    joueur2.calScore(Score.ScoreFlag.LOOSER.flag);
                }

            } while ((joueur1.testSecret(b) != 0) && (joueur2.testSecret(a) != 0));
        }

    }
}
