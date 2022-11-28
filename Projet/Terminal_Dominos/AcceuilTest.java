import java.util.Scanner;

public class AcceuilTest {

    Scanner scanner = new Scanner(System.in);

    static void affichageDeTousLesJoueurs(Joueur [] joueurs){
        for (Joueur joueur : joueurs){
            joueur.afficheJoueur();
        }
    }

    // nombre de joueurs, IA, ainsi que les nom de chaques joueurs
    static Dominos acceuilDuJeu(){
        Scanner scanner = new Scanner(System.in);
        int nombreDeJoueurs = -1, nombreDIA = -1;
        Joueur[] joueurs;

        while (true){
            System.out.println("Veuillez saisir le nombre de joueurs (entre 2 et 4)");
            nombreDeJoueurs = scanner.nextInt();
            if (nombreDeJoueurs > 1 && nombreDeJoueurs < 5) break;
        }
        while (true){
            System.out.println("Veuillez saisir le nombre d'IA joueurs (doit etre plus petit que le nombre de joueurs)");
            nombreDIA = scanner.nextInt();
            if (nombreDIA < nombreDeJoueurs) break;
        }
        joueurs = new Joueur[nombreDeJoueurs];
        for (int i = 0; i<nombreDIA; i++){
            System.out.println("Entre le nom du joueur n° " + (i+1) + " (IA) ");
            String nom = scanner.next();
            joueurs[i] = new Joueur(nom,true);
        }
        for (int y = joueurs.length-1; y >= nombreDIA; y--){
            System.out.println("Entre le nom du joueur n° " + (y+1));
            String nom = scanner.next();
            joueurs[y] = new Joueur(nom,false);
        }

        return new Dominos(joueurs, new Table(10,10));
    }

}
