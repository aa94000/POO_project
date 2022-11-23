import java.util.Random;

public class Joueur {

    String nom;
    private int points;
    private Sac sac;
    private boolean isIA; // IA ou pas
    Tuile tuileEnMain;

    Joueur(String nom, boolean IA){
        this.nom = nom;
        this.points = 0;
        this.isIA = IA;
        this.tuileEnMain = null;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isIA() {
        return isIA;
    }

    public Tuile getTuileEnMain() {
        return tuileEnMain;
    }

    void afficheJoueur(){
        System.out.printf("- Joueur : %s \n- IA : %b \n- Nombre de points : %d \n",this.nom, this.isIA(), this.getPoints());
    }

    void piocherDansLeSac(Sac sac){
        Random random = new Random();
        int randMax = sac.nombreDeTuilesRestante();
        int i = random.nextInt(randMax);
        this.tuileEnMain = sac.piocherTuile(i);
    }

    void reposerTuile(Sac sac){
        sac.tuileNonJouer(this.tuileEnMain);
        this.tuileEnMain = null;
    }

    void afficherTuileEnMain(){
        if (this.tuileEnMain != null) this.tuileEnMain.afficheTuile();
        else System.out.println("Aucune tuile en main");
    }

    public static void main(String[] args) {
        Joueur a = new Joueur("Amar", false);
        a.afficheJoueur();
        Sac sac = new Sac();
        System.out.println(sac.nombreDeTuilesRestante());
        a.piocherDansLeSac(sac);
        a.afficherTuileEnMain();
        System.out.println(sac.nombreDeTuilesRestante());
        a.reposerTuile(sac);
        a.afficherTuileEnMain();
        System.out.println(sac.nombreDeTuilesRestante());
    }
}
