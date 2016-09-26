import java.util.*;

/**
 * Created by tearsyu on 16-9-22.
 * Cette classe permet de faire le concour pyramidal, sachant que tous les deux joueurs faire le tournois dans le meme
 * temps, jusquil reste que un champion.
 */
public class TournoisPyramidal implements Tournois{
    private Vector vectJoueur;
    private TableauDesScores tableauDesScores;
    private ArrayList aListJoueur;
    private Iterator iterator;

    public TournoisPyramidal(){
        vectJoueur = new Vector();
        tableauDesScores = new TableauDesScores();
        aListJoueur = new ArrayList<>();
    }

    public void addJoueur(Joueur joueur){
        vectJoueur.add(joueur);
    }

    public void addJoueur(Collection collection){
        vectJoueur.addAll(collection);
    }

    public void setIterator(Joueur joueur){
        aListJoueur.add(joueur);
        iterator = aListJoueur.iterator();
    }

    //Cette classe permet deliminer les joueurs qui ont perdues.
    public void rmJoueur(Joueur joueur){
        int i = vectJoueur.indexOf(joueur);
        vectJoueur.remove(joueur);
        System.out.println("[RemoveJoueur] " + joueur.getName() + " has been remove from Vector at " + i);
    }

    public void showInfo(){
        Joueur joueur;

        System.out.println("[ShowInfoVector]Now vector length is: " + vectJoueur.size());
        System.out.print("They are: ");
        for (int i = 0; i < vectJoueur.size(); i++){
            joueur = (Joueur) vectJoueur.get(i);
            System.out.println("[" + joueur.getName() + "] at " + vectJoueur.indexOf(vectJoueur.get(i)));
        }
    }

    /**
     * La methode ramdonPos() permet de melanger 'la position' des joueurs,
     * fait attention, la position c'est important!!
     * Et dans la methode startGame(), on va l'utiliser pour configurer la
     * position des joueurs.
     * EX 6joueurs entrent dans ce tournois, on les distribue la position[0,1,2,3,4,5],
     * et on fait le concours aleatoire, et on applique cette methode, elle me renvoye
     * une position melange comme[2, 4, 5, 1, 0, 3]==>cest a dire:
     * le joueur2 contre jouer4, le joueur5 contre le joueur1, etc..
     * */
    public ArrayList randomPos(){
        //J'utilise ArrayList parce que cest un type de liste avec la longueur changeable.
        //randomPosA cest un array de position d'entree, randomPosB cest un array de position d'sortie.
        ArrayList randomPosA = new ArrayList();
        ArrayList randomPosB = new ArrayList();
        int len = vectJoueur.size();
        Random random = new Random();

        //Dabord, on les distribue la position
        for (int ir = 0; ir < len; ir++){
            randomPosA.add(ir,ir);
            System.out.print("[RandomPosition]:" + randomPosA.get(ir) + " | ");
        }
        System.out.println();

        //Dans cette boucle, on les melange.
        for(int ir = 0; ir < len; ir++){
            //On prend une position aleatoire.
            int pos = random.nextInt(len - i);
            //On met cette position dans randomPosB
            randomPosB.add(ir, randomPosA.get(pos));
            //On remplit la position qui est pris a une position qu'on utilise jamais
            randomPosA.set(pos, randomPosA.get(len - i - 1));
        }
        for (int ir = 0; ir < len; ir++) {
            System.out.print("[RandomPosition]:" + randomPosB.get(ir) + " | ");
        }
        System.out.println();
        return randomPosB;
    }


    /**
     * Je pense cette methode est plus sophistique dans les exos.
     * L'idee c'est d'utiliser une methode recursive pour faire le tournois jusquil reste que 2 joueurs.
     * looserList cest une liste en sauvegardant les objets joueurs qui ont perdue apres le concour.
     * rdJoueur c'est une liste de position melangee qui est appliquee pour faire le concour.
     * * */
    Arbitre arbitre;
    Joueur joueur1, joueur2;
    ArrayList looserList ;
    ArrayList rdJoueur;
    int i = 0, n = 0;
    public void startGame(Intervalle intervalle, int nbPartie){
        i = 0;
        n = 0;
        looserList = new ArrayList();

        if (vectJoueur.size() == 2){
            joueur1 = (Joueur) vectJoueur.get(0);
            joueur2 = (Joueur) vectJoueur.get(1);
            for (int j = 0; j < nbPartie; j++) {
                if (j < nbPartie / 2) {
                    System.out.println("[Order] Joueur " + joueur1.getName() + " firstly");
                    arbitre = new Arbitre(intervalle, joueur1, joueur2);
                    arbitre.startGame2();
                } else {
                    System.out.println("[Order] Joueur " + joueur2.getName() + " firstly");
                    arbitre = new Arbitre(intervalle, joueur2, joueur1);
                    arbitre.startGame2();
                }
            }
            tableauDesScores.setScoreTable(joueur1);
            tableauDesScores.setScoreTable(joueur2);
            if (joueur1.getScore() > joueur2.getScore()){
                System.out.println("[Champion] The champion is born: " + joueur1.getName());
                return;
            } else if (joueur1.getScore() < joueur2.getScore()){
                System.out.println("[Champion] The champion is born: " + joueur2.getName());
                return;
            } else {
                startGame(intervalle, nbPartie);
            }
        }

        /**
         * Ici les codes que jai commente fonctionne aussi et elle sont plus simple
         * L'idee est de faire la methode recursive jusquil reste une personne cest le champion, la
         * methode s'arrete.
         * */

//        if (vectJoueur.size() == 1){
//            Joueur champion = (Joueur) vectJoueur.get(0);
//            System.out.println("[Champion] The champion is born: " + champion.getName());
//            return;
//        }

        rdJoueur = randomPos();

        while (true){
            if(i + 1 >= rdJoueur.size()){
                break;
            }
            joueur1 = (Joueur) vectJoueur.get(i);
            joueur2 = (Joueur) vectJoueur.get(i + 1);
            i += 2;


            for (int j = 0; j < nbPartie; j++) {
                if (j < nbPartie / 2) {
                    System.out.println("[Order] Joueur " + joueur1.getName() + " firstly");
                    arbitre = new Arbitre(intervalle, joueur1, joueur2);
                    arbitre.startGame2();
                } else {
                    System.out.println("[Order] Joueur " + joueur2.getName() + " firstly");
                    arbitre = new Arbitre(intervalle, joueur2, joueur1);
                    arbitre.startGame2();
                }
            }
            tableauDesScores.setScoreTable(joueur1);
            tableauDesScores.setScoreTable(joueur2);
            System.out.println("[FinGame]joueur1 points:" + joueur1.getScore() + " | joueur2 points: " + joueur2.getScore());

            looserList.add(n, (joueur1.getScore() < joueur2.getScore() ? joueur1 : joueur2));
            Joueur looser = (Joueur)looserList.get(n);
            System.out.println("[InfoLooser] joueur1: " + joueur1.getScore() + " | joueur2: " + joueur2.getScore() +
                    " | looser info: (" + n + " , " + looser.getName() + ")");
            n++;
        }

        //On supprime les loosers depuis la liste des joueurs, sachant quil fait auto ;'ordre
        // quand on supprime un element dans un Vector
        //EX un vector de position{1,2,3,4}, on supprime objet a la position 3, il devient {1,2,3} au lieu de {1,2,4}
        //Cest a dire, l'objet de position 4 va auto avancer et changer sa position en 3.
        for (Object o : looserList){
           // System.out.println("[RemoveLooser]");
            rmJoueur((Joueur) o);
        }
        //Apres un filtre quil doit rester moitier ou moitier + 1 joueur, on recommence un concour.
        startGame(intervalle, nbPartie);
    }

    public static void main(String[] args){
        Intervalle intervalle;
        Joueur joueur1, joueur2, joueur3, joueur4, joueur5;
        intervalle = new Intervalle(0, 10);
        joueur1 = new JoueurDichotomique("Linlin", intervalle);
        joueur2 = new JoueurIncremental("Sam");
        joueur3 = new JoueurIntervalleAleatoire("Panda", intervalle);
        joueur4 = new JoueurIncremental("Xiqui");
        joueur5 = new JoueurHumain("toto");

        TournoisPyramidal tp = new TournoisPyramidal();
        tp.addJoueur(joueur1);
        tp.addJoueur(joueur2);
        tp.addJoueur(joueur3);
        tp.addJoueur(joueur4);
        tp.addJoueur(joueur5);
        //tp.randomPos();

        //tp.rmJoueur(joueur1);
        //tp.rmJoueur(joueur3);
        //tp.showInfo();
        tp.startGame(intervalle, 1);

    }

}
