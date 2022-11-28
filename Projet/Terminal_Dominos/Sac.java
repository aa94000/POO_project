import java.util.ArrayList;
import java.util.List;

public class Sac {
    private List<Tuile> tuiles;
    boolean sacVide;

    Sac(){
        this.tuiles = generationTuiles();
        this.sacVide = false;
    }

    // Ci-dessous nombre de tuilles modifiable
    List<Tuile> generationTuiles(){
        List<Tuile> a = new ArrayList<Tuile>();
        for (int i = 0; i<7; i++){
            a.add(new Tuile());
        }
        return a;
    }

    public int nombreDeTuilesRestante() {
        return this.tuiles.size();
    }

    public boolean isSacVide() {
        return sacVide;
    }

    public void affichageSac(){
        for (Tuile t : this.tuiles){
            t.afficheTuile();
            System.out.println("--------------");
        }
    }

    void viderLeSac(){
        this.tuiles.removeAll(tuiles);
    }

    Tuile piocherTuile(int i){
        Tuile t = this.tuiles.get(i);
        this.tuiles.remove(i);
        return t;
    }

    void tuileNonJouer(Tuile tuile){
        this.tuiles.add(tuile);
    }

}
