import java.util.Scanner;

public class Acceuil {

    final int choixDuJeu;
    final int nbJoueurs;
    final int nbIA;

    Acceuil(int choixDuJeu, int nbJoueurs, int nbIA){
        this.choixDuJeu = choixDuJeu;
        this.nbJoueurs = nbJoueurs;
        this.nbIA = nbIA;
    }

    /*
    * Si le nombre d'IA est supérieur ou égale au nombre de joueurs humain
    * la partie ne peut commencer
    * */

    private static boolean IATropNombreux(int nbJoueurs, int nbIA){
        return nbIA >= nbJoueurs; // si true jeu non possible
    }

    private static boolean jeuExistant(int choixDuJeu){
        return choixDuJeu == 1 || choixDuJeu == 2; // 2 jeu possible
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Acceuil acceuil;

        while (true){
            int jeu;
            while (true){
                System.out.println("Choisissez votre jeu en entrant son numéros:\n- 1 : Dominos\n- 2 : Caaa\n");
                jeu = scanner.nextInt();
                if(jeuExistant(jeu)) break;
                else System.out.println("Entrez un numeros entre 1 et 2 !");
            }
            System.out.println("Entrez le nombre de joueurs");
            int nbJoueurs = scanner.nextInt();
            int nbIA;
            while (true){
                System.out.println("Entrez le nombre d'IA");
                nbIA = scanner.nextInt();
                if (!IATropNombreux(nbJoueurs,nbIA)) break;
                else System.out.println("Il y a trop d'IA !");
            }
            System.out.println("Ok, que le jeu commence !");

            acceuil = new Acceuil(jeu, nbJoueurs, nbIA);
        }

    }

}
