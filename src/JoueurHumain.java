import java.util.Random;

/**
 * Created by tearsyu on 16-9-9.
 * This class is a normal player who guess the number without logic.
 * Cette classe herite JoueurAvecSecret qui se trouve dans exo10, implemente l'interface de Joueur
 * dans l'exo 7.
 * Teste pour JoueurHuamin sera effectue dans la classe PlusOuMoins3.java.
 */
public class JoueurHumain extends JoueurAvecSecret implements Joueur {

    private String name;
    int coup, nbkey;

    /*Chaque fois on cree un joueurHumain, on lui donne un nom.*/
    public JoueurHumain(String name){
        this.name = name;
    }

    public void setNbkey(){
        nbkey = getCoup();
    }

    public int getNbkey(){
        return nbkey;
    }
    /**
     * Methode getCoup() c'est pour generer un nombre aleatoir
     * Ce nombre aleatoir est utilise pour 1.deviner 2.sauvegarder comme un nombre secret
     * Faire attention: Je sauvegarde ce nombre "coup" dans la classe, et j'utilise la method returnCoup()
     * se trouve en bas pour reprendre ce nombre.
     * */

    public int getCoup(){
        Random random = new Random();
        coup = random.nextInt(10);
        return coup;
    }


    /**
     * Methode:setReponse() est juste utilise pour afficher les info sur terminal en fonction de 'int reponse'.
     * Pour bien comprendre cette methode, je te conseille de modeliser le jeux avec la methode testSecret().
     * */
    public void setReponse(int reponse){
        if (reponse == Arbitre.Reponse.FOUND.flag){
            System.out.println("You find it.");
        } else if (reponse == Arbitre.Reponse.BIGGER.flag){
            System.out.println("It should be bigger.");
        } else if (reponse == Arbitre.Reponse.SMALLER.flag){
            System.out.println("It should be smaller.");
        }
    }

    /**
     * Methode: testSecret() est utilisee pour comparer le nombre deviner et le nombre secret.
     * Deux joueurs, joueur1 genere un nombre  secret A dans 'coup', joueur2 genere un nombre B dans 'coup'
     * joueur1 utilise B comme essai et fait la comparaison avec A qui est sauvegarde dans variable coup,
     * joueur1 renvoie le resultat a methode setReponse() pour afficher les info.
     * */
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

    ///================Generate auto==============================
    /**
     * Methode: getName() c'est une methode pour reprendre le nom de joueur qu'on definit quand on le cree.
     * C'est pratique si vous voulez afficher le nom du joueur.
     * */
    public String getName() {
        return name;
    }

    @Override
    public int retrunCoup() {
        return coup;
    }

    public void showInfo() {
        System.out.println(getName() + " Class : " + getClass().getName() + "give the number: " + nbkey);
    }
}
