/**
 * Created by tearsyu on 16-9-9.
 * This class is a test to the other class.
 * On va tester les joueurs sils ont bien jouer.
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

        //a is the number which need to be found.
        a = player1.getCoup();
        System.out.println("Player 1 "+ player1.getName() + " number is: " + a);

        System.out.println("Players  please entry a number to quess it.");

        /**
         * Ici j'utilise la boucle 'do{A;}while(B)' structure, parce que dans cette structure 'A'
         * sera effectue au moins une fois n'importe B est vrai ou fault. L'avantage ici par rapport
         * a la structure 'while(B){A;}' c'est que si B est fault, A sera jamais effectue, cest a dire
         * A cest le processus du jeux, ca sera jamais effectue.
         * */
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
