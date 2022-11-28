import java.util.Random;

public class Tuile {

    private int [][] coteTuile;

    Tuile(){
        this.coteTuile = constructionTuille();
    }

    public void setCoteTuile(int[][] coteTuile) {
        this.coteTuile = coteTuile;
    }

    void afficheTuile(){
        for (int i = 0; i<this.coteTuile.length; i++){
            for (int y = 0; y<this.coteTuile[i].length; y++){
                if (this.coteTuile[i][y] == -1){
                    System.out.print(" ");
                }else {
                    System.out.print(this.coteTuile[i][y]);
                }
            }
            System.out.println("");
        }
    }

    void afficheTab(int [][] tab){
        for (int i = 0; i< tab.length; i++){
            for (int y = 0; y<tab[i].length; y++){
                System.out.print(tab[i][y]);
            }
            System.out.println("");
        }
    }

    static int [][] constructionTuille(){
        int [][] tab = new int[5][5];
        int randMax = 2; // modifiable pour les chiffres sur la tuile
        Random random = new Random();
        for (int i = 0; i<tab.length; i++){
            for (int y = 0; y<tab[i].length; y++){
                if (i == 0 || i == tab.length-1){
                    tab[i][1] = random.nextInt(randMax);
                    tab[i][2] = random.nextInt(randMax);
                    tab[i][3] = random.nextInt(randMax);

                    tab[i][0] = -1;
                    tab[i][4] = -1;
                }
                if (i>0 && i<tab.length-1){
                    tab[i][0] = random.nextInt(randMax);
                    tab[i][4] = random.nextInt(randMax);

                    tab[i][1] = -1;
                    tab[i][2] = -1;
                    tab[i][3] = -1;
                }
            }
        }
        return tab;
    }

    void tournerTuileGauche(){
        int [][] tuileTourne = new int[5][5];

        for (int i = 0; i<this.coteTuile.length; i++){
            for (int a = 0; a<this.coteTuile.length; a++){
                tuileTourne[i][a] = -1;
            }
        }

        // Bas, Haut
        for (int y = 1; y<this.coteTuile.length-1; y++){
            tuileTourne[4][y] = this.coteTuile[y][0]; // Bas
            tuileTourne[0][y] = this.coteTuile[y][4]; // Haut
        }

        // Gauche, Droit
        int compteurDecr = this.coteTuile.length-2;
        for (int k = 1; k <this.coteTuile.length-1; k++){
            tuileTourne[k][0] = this.coteTuile[0][compteurDecr]; // gauche
            tuileTourne[k][4] = this.coteTuile[4][compteurDecr]; // droit
            compteurDecr--;
        }

        this.setCoteTuile(tuileTourne);
    }

    void tournerTuileDroite(){
        int [][] tuileTourne = new int[5][5];

        for (int i = 0; i<this.coteTuile.length; i++){
            for (int a = 0; a<this.coteTuile.length; a++){
                tuileTourne[i][a] = -1;
            }
        }

        // Gauche, Droit
        for (int y = 1; y<this.coteTuile.length; y++){
            tuileTourne[y][4] = this.coteTuile[0][y]; // droit
            tuileTourne[y][0] = this.coteTuile[4][y]; // gauche
        }

        // Bas, Haut
        int compteurDecr = this.coteTuile.length-2;
        for (int k = 1; k <this.coteTuile.length-1; k++){
            tuileTourne[0][compteurDecr] = this.coteTuile[k][0]; // haut
            tuileTourne[4][compteurDecr] = this.coteTuile[k][4]; // bas
            compteurDecr--;
        }

        this.setCoteTuile(tuileTourne);
    }

    boolean tuileCompatibleEtPosable(Tuile t){ // this = tuile que nous voulons poser; t étant la tuile à cote de lasquelle nous voulons la poser
        if (this.tuileCompatible(t)){
            if (this.coteTuile[1][4] == t.coteTuile[1][0] && this.coteTuile[2][4] == t.coteTuile[2][0] && this.coteTuile[3][4] == t.coteTuile[3][0]){ // Poser sur la gauche
                return true;
            }
            if (this.coteTuile[1][0] == t.coteTuile[1][4] && this.coteTuile[2][0] == t.coteTuile[2][4] && this.coteTuile[3][0] == t.coteTuile[3][4]){ // Poser sur la droite
                return true;
            }
            if (this.coteTuile[4][1] == t.coteTuile[0][1] && this.coteTuile[4][2] == t.coteTuile[0][2] && this.coteTuile[4][3] == t.coteTuile[0][3]){ // Poser sur le haut
                return true;
            }
            if (this.coteTuile[0][1] == t.coteTuile[4][1] && this.coteTuile[0][2] == t.coteTuile[4][2] && this.coteTuile[0][3] == t.coteTuile[4][3]){ // Poser sur le bas
                return true;
            }
        }
        if (t == null) return true;
        return false;
    }

    boolean tuileCompatible(Tuile t){
        int [][] premiereTuile = new int[4][3];
        int [][] tTuile = new int[4][3];


       for (int i = 0; i<premiereTuile.length; i++){ // Disposition des 3 numeros de chaques tuiles dans 2 tableaux de tableaux
            for (int y = 0; y<premiereTuile[i].length; y++){
                switch (i){
                    case 0 ->{
                        premiereTuile[i][y] = this.coteTuile[i][y+1];
                        tTuile[i][y] = t.coteTuile[i][y+1];
                    }
                    case 1 ->{
                        premiereTuile[i][y] = this.coteTuile[y+1][i-1];
                        tTuile[i][y] = t.coteTuile[y+1][i-1];
                    }
                    case 2 ->{
                        premiereTuile[i][y] = this.coteTuile[this.coteTuile.length-1][y+1];
                        tTuile[i][y] = t.coteTuile[this.coteTuile.length-1][y+1];
                    }
                    case 3 ->{
                        premiereTuile[i][y] = this.coteTuile[y+1][i+1];
                        tTuile[i][y] = t.coteTuile[y+1][i+1];
                    }
                }
            }
        }

       int compteur = 0; // Si le compteur arrive à 3 alors cela veut dire que les dominos son compatibles (en comptant également sur la possibilité de les tourné !)
        for (int j = 0; j< premiereTuile.length; j++){
            for (int a : premiereTuile[j]){
                for (int z = 0; z<tTuile.length; z++){
                    for (int p : tTuile[z]){
                        if (a == p) compteur++;
                        if (compteur == 3) return true;
                    }
                    compteur = 0;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Tuile a = new Tuile();
        Tuile b = new Tuile();
        a.afficheTuile();
        a.tournerTuileGauche();
        a.afficheTuile();

    }

}
