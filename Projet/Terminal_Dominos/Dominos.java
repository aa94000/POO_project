import java.util.Scanner;

public class Dominos {

    Scanner scanner = new Scanner(System.in);
    Joueur[] joueurs;
    Table table;
    Sac sac;

    Dominos(Joueur[] joueurs, Table table){
        this.joueurs = joueurs;
        this.table = table;
        this.sac = new Sac();
    }

    void affichageDeTousLesJoueurs(){
        for (Joueur j : this.joueurs){
            j.afficheJoueur();
            System.out.println("------");
        }
    }

    int choixDuJoueur(Joueur j){
        int choix = -1;
        j.piocherDansLeSac(this.sac);
        System.out.println("Voici le Dominos que vous avez en main : ");
        j.afficherTuileEnMain();
        System.out.println("Et voici l'état de la table : ");
        this.table.afficherTableResume();
        while (true){
            System.out.println("Faite votre choix : \n- 1 : Je joue\n- 2 : Je passe mon tour");
            choix = scanner.nextInt();
            if (choix == 1 || choix == 2 ) return choix;
        }
    }



    public static void main(String[] args) {
        Dominos dominos = AcceuilTest.acceuilDuJeu();
        dominos.affichageDeTousLesJoueurs();
        while (!dominos.sac.isSacVide()){
            if (dominos.choixDuJoueur(dominos.joueurs[0]) == 1){
                if (dominos.table.indicationSiDominosJouableEtCoordoneeBool(dominos.joueurs[0])){
                    dominos.table.indicationSiDominosJouableEtCoordonee(dominos.joueurs[0]);
                }else System.out.println("Vous ne pouvez pas jouer reposer la tuile");
            }else {
                dominos.joueurs[0].remettreTuileDansLeSac(dominos.sac);
            }
            System.out.println("Il reste : "+ dominos.sac.nombreDeTuilesRestante() +" tuiles dans le sac");
        }

    }

}
