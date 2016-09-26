import java.util.Date;
import java.util.Random;

/**
 * Created by tearsyu on 16-9-15.
 * This class is used to test Arbitre and startGame(), debug etc.
 */
public class TestArbitre {

    private static void randomizeInPlace(int[] data)
    {
        Date dt=new Date();
        Random random=new Random(dt.getSeconds());
        int len=data.length;
        for(int i=0; i<len; i++)
        {
            int pos=(int)(random.nextDouble()*(len-i+1)+i)-1;
            int temp=data[i];
            data[i]=data[pos];
            data[pos]=temp;
        }
    }

    private static void show(int[] data)
    {
        System.out.println("========================");
        for(int i = 0; i < data.length; i++)
        {
            System.out.print(data[i] + " ");
        }
        System.out.println();
        System.out.println("========================");
    }

    public static void main(String[] args){
        Arbitre arbitre;
        Intervalle intervalle;
        Joueur joueur1, joueur2, joueur3;

        intervalle = new Intervalle(0, 100);
        joueur1 = new JoueurDichotomique("Linlin", intervalle);
        joueur2 = new JoueurHumain("Sam");
        joueur3 = new JoueurIntervalleAleatoire("Panda", intervalle);
        arbitre = new Arbitre(intervalle,joueur1,joueur2);

        //arbitre.startGame();

       // arbitre.startGame2();

        //joueur2.calScore(Score.ScoreFlag.LOOSER.flag);

        int data[]=new int[]{1,42,51,62,8,94,23,13,40,5};
        show(data);
        randomizeInPlace(data);
        show(data);
    }
}
