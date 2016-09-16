/**
 * Created by tearsyu on 16-9-9.
 * Compiler with JoueurHumain.java!
 */
public class PlusOuMoins3 {
    public static void main(String[] args){
        JoueurHumain player1, player2;
        JoueurIncremental player3;
        JoueurDichotomique player4;
        Arbitre arbitre;
        Intervalle intervalle = new Intervalle(0, 70);
        int a, b, c, d;

        System.out.println("Player 1 please type a number.");
        player1 = new JoueurHumain("Jaque");
        player2 = new JoueurHumain("Linda");
        player3 = new JoueurIncremental("TotoIcre");
        player4 = new JoueurDichotomique("TitiDichi", intervalle);
        arbitre = new Arbitre(intervalle, player2, player3);
        a = player1.getCoup();
        System.out.println("Player 1 "+ player1.getName() + " number is: " + a);

        System.out.println("Players  please entry a number to quess it.");
        do {
            b = player2.getCoup();
            c = player3.getCoup();
            d = player4.getCoup();

            arbitre.jouer();
            //b tour
            System.out.println("Player 2 " + player2.getName() + " guess it is: " + b);
            player1.setReponse(player1.testSecret(b));

            //c tour
            System.out.println("Player 3 " + player3.getName() + " guess it is: " + c);
            player1.setReponse(player1.testSecret(c));

            System.out.println("Player 4 " + player4.getName() + " guess it is: " + d);
            if (player1.testSecret(d)== 1){
                intervalle.setNumMin(d);
                player1.setReponse(player1.testSecret(d));
            } else {
                intervalle.setNumMax(d);
                player1.setReponse(player1.testSecret(d));
            }
        } while ((player1.testSecret(b) != 0) && (player1.testSecret(c)) != 0 && (player1.testSecret(d)) != 0);

    }
}
