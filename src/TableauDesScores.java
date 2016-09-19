import java.util.Vector;

/**
 * Created by tearsyu on 16-9-19.
 * This class is used to manage assemble of Score.
 */
public class TableauDesScores {
    private int i = 0;
    private Vector tableScore;
    private Joueur joueur;
    private Tounois tounois;

    public TableauDesScores(){
        this.tableScore = new Vector();
    }


    public void setScoreTable(int Score){
        tableScore.add(i,Score);
        i++;
    }

    public void showTableScore(){
        System.out.print("[");
        for (int i = 0; i < tableScore.size(); i++){
            System.out.print(tableScore.get(i) + " | ");
            if (i%25 == 24)
            {System.out.println();}
        }
        System.out.print("]");
    }

    public Vector getTableScore(){
        return tableScore;
    }

    public static void main(String[] args){
        TableauDesScores t1 = new TableauDesScores();
        for (int i = 100; i >= 0; i = i - 2){
            t1.setScoreTable(i);
        }
        t1.showTableScore();
    }
}
