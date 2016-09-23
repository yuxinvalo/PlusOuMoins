import java.util.Vector;

/**
 * Created by tearsyu on 16-9-19.
 * This class is used to manage assemble of Score.
 * I use Vector to save each Joueur then thier Score.
 */
public class TableauDesScores {
    private int i = 0;
    private Vector tableScore;


    public TableauDesScores(){
        this.tableScore = new Vector();
    }

    /**
     * There a bug appears, when joueur points change in the next game, all the points will change.
     * Maybe i can use deepcopy to solv it.*/
    public void setScoreTable(Joueur joueur){
        tableScore.add(i,joueur);
        i++;
    }

    public void showTableScore(){
        Joueur joueur;
        System.out.print("[TableScore] {");
        for (int i = 0; i < tableScore.size(); i++){
            joueur = (Joueur) tableScore.get(i);
            if (i == tableScore.size() - 1){
                System.out.print(joueur.getName() + " points : " + joueur.getScore() + "}");
                break;
            }
            System.out.print(joueur.getName() + " points : " + joueur.getScore() + " | ");
            if (i%25 == 24)
            {System.out.println();}
        }
    }

    public int getTableScoreByIndex(int index){
        int scoreIndex;
        scoreIndex = (int)tableScore.get(index);
       // scoreIndex = score.getScore();
        return scoreIndex;
    }

}
