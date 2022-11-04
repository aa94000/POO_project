public class Joueur {

    private final boolean humain;
    private boolean abbandon;
    private int nbPoints;

    Joueur(boolean humain){
        this.humain = humain;
        this.abbandon = false;
        this.nbPoints = 0;
    }

    boolean getAbbandon(){
        return this.abbandon;
    }

    void setAbbandon(boolean abbandon){
        this.abbandon = abbandon;
    }

    boolean getHumain(){
        return this.humain;
    }

    int getNbPoints(){
        return this.nbPoints;
    }

    void setNbPoints(int nbPoints){
        this.nbPoints = nbPoints;
    }



}
