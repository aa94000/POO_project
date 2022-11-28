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

    boolean joueurAUneTuileEnMain(){
        return getTuileEnMain() != null;
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

    void remettreTuileDansLeSac(Sac sac){
        sac.tuileNonJouer(this.tuileEnMain);
        this.tuileEnMain = null;
    }

    void poserTuileSurTable(){
        this.tuileEnMain = null;
    }

    void afficherTuileEnMain(){
        if (this.tuileEnMain != null) this.tuileEnMain.afficheTuile();
        else System.out.println("Aucune tuile en main");
    }

}
