/**
 * Created by tearsyu on 16-9-22.
 * Classe paire cest une classe 'generic pair'(googlez-vous), qui permet d'encapsuler une paire de data
 * elle est cree pour ramplacer la score Classe, parce que la classe Score cest une paire de (Score Joueur).
 *
 * Je n'utilise pas cette classe parce que la structure de mon projet ne permet pas que j'utilise Paire, sinon je dois
 * reconstribut bcp de chose. Ca vaut pas.
 */
public class Paire <J, S>{
    private Joueur joueur;
    private Integer score;
    //private int calS;

    public Paire(Joueur joueur, Integer score){
        this.joueur = joueur;
        this.score = score;
       // calS = 0;
    }

    public Integer getScore(){
        return score;
    }

    public Joueur getJoueur(){
        return joueur;
    }

    public void setScore(Integer score){
        this.score = score;
    }

    public void setJOueur(Joueur joueur){
        this.joueur = joueur;
    }

    public void calScore(int flag){
        if (flag == Score.ScoreFlag.NULL.flag){
            score += 0;
        } else if (flag == Score.ScoreFlag.WINNER.flag){
            score += 2;
        }
        else if (flag == Score.ScoreFlag.NULL.flag){
            score += 1;
        } else {
            System.out.println("[Error] Wrong flag input in Class Pair at calScore().");
        }
    }

    public void showInfo(){
        System.out.println("[PairInfo]Joueur " + joueur.getName() + " : Points " + getScore());
    }

    //EX. Utilisation:
    public  static void main(String[] args){
        JoueurHumain joueurHumain = new JoueurHumain("Linlin");
        Integer a = 0;
        Paire<Joueur, Integer> paire = new Paire<>(joueurHumain, a);

        for (int i = 0; i < 12; i++){
            paire.calScore(i%3);
        }
        paire.showInfo();
    }

}
