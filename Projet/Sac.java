import java.util.Random;

public class Sac {

    Tuiles [] tabDeTuilles; // Stockage des tuilles dans le sac
    Random random = new Random(); // Nombre de tuilles dans le sac
    private int nbDeTuilles = random.nextInt(9);

    Sac(){
        this.tabDeTuilles = generationDeTuille();
    }

    int getNbDeTuilles(){
        return this.nbDeTuilles;
    }

    Tuiles [] generationDeTuille(){
        Tuiles [] tab = new Tuiles[nbDeTuilles];
        for (int i = 0; i<tab.length; i++){
            tab[i] = new Tuiles();
        }
        return tab;
    }

    void affichageTuilles(){
        for (Tuiles a : this.tabDeTuilles){
            a.afficheTuile();
            System.out.println("-------");
        }
    }

    public static void main(String[] args) {
        Sac a = new Sac();
        a.affichageTuilles();
        System.out.println(a.getNbDeTuilles());
    }

}
