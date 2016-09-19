/**
 * Created by tearsyu on 16-9-19.
 * This class allows to keep the score. Every Score attach a joueur and note his game status.
 * The score has 3 types, vaiquer get 2 points, nul get 1 point, the defeat get 0 points.
 */
public class Score {
    private int histo = 0; //Noter ordre de partie.
    private Joueur joueur;
    private int points = 0; //Les points gagnes pour un joueur, on initie quil commence par 0 point.

    /**Jutilise la structure enum pour indiquer les points, c'est une idee de OOP pour readability et structure.
     * Vous pouvez chercher sur google et lire "enum java"
     * */
    public enum ScoreFlag{
        WINNER(2), NULL(1), LOOSER(0);
        public int flag;
        ScoreFlag(int flag){
            this.flag = flag;
        }
    }
    public Score(Joueur joueur){
        this.joueur = joueur;
    }

    public int getScore(){
        return points;
    }

    /** Comment utilise enum ScoreFlag? ex ->ScoreFlag.WINNER.flag = 2
     *
     * Chaque fois qu'on utilise cette methode, ca veut dire aussi une partie est fini,
     * donc on note a histo pour savoir ca fait combien de partie.
     * */
    public void calScore(int flag){
        histo++;
        if (flag == ScoreFlag.WINNER.flag){
            points = points + 2;
        } else if (flag == ScoreFlag.NULL.flag) {
            points += 1;
        } else if (flag == ScoreFlag.LOOSER.flag){
            System.out.println("Looser earn nothing.");
        }

    }

    /**showScore permette de afficher les info .
      */
    public void showScore(){
            System.out.println(joueur.getName() + " got points: " + getScore() + " at "
                    + getHisto() + " times." );
    }

    public int getHisto(){
        return histo;
    }
}
