import java.util.Random;

public class Tuile {

    private int [][] coteTuile;

    Tuile(int [][] coteTuile){
        this.coteTuile = coteTuile;
    }

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

    static int [][] constructionTuille(){
        int [][] tab = new int[5][5];
        int randMax = 5; // modifiable pour les chiffres sur la tuile
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
            tuileTourne[i][0] = -1;
            tuileTourne[i][4] = -1;
            tuileTourne[i][1] = -1;
            tuileTourne[i][2] = -1;
            tuileTourne[i][3] = -1;
        }

        //Gauche
        tuileTourne[1][0] = this.coteTuile[0][3];
        tuileTourne[2][0] = this.coteTuile[0][2];
        tuileTourne[3][0] = this.coteTuile[0][1];

        //Bas
        tuileTourne[4][1] = this.coteTuile[1][0];
        tuileTourne[4][2] = this.coteTuile[2][0];
        tuileTourne[4][3] = this.coteTuile[3][0];

        //Droit
        tuileTourne[1][4] = this.coteTuile[4][3];
        tuileTourne[2][4] = this.coteTuile[4][2];
        tuileTourne[3][4] = this.coteTuile[4][1];

        //Haut
        tuileTourne[0][1] = this.coteTuile[1][4];
        tuileTourne[0][2] = this.coteTuile[2][4];
        tuileTourne[0][3] = this.coteTuile[3][4];

        this.setCoteTuile(tuileTourne);
    }

    void tournerTuileDroite(){
        int [][] tuileTourne = new int[5][5];

        for (int i = 0; i<this.coteTuile.length; i++){
            tuileTourne[i][0] = -1;
            tuileTourne[i][4] = -1;
            tuileTourne[i][1] = -1;
            tuileTourne[i][2] = -1;
            tuileTourne[i][3] = -1;
        }

        //Haut
        tuileTourne[0][3] = this.coteTuile[1][0];
        tuileTourne[0][2] = this.coteTuile[2][0];
        tuileTourne[0][1] = this.coteTuile[3][0];

        //Droit
        tuileTourne[1][4] = this.coteTuile[0][1];
        tuileTourne[2][4] = this.coteTuile[0][2];
        tuileTourne[3][4] = this.coteTuile[0][3];

        //Bas
        tuileTourne[4][3] = this.coteTuile[1][4];
        tuileTourne[4][2] = this.coteTuile[2][4];
        tuileTourne[4][1] = this.coteTuile[3][4];

        //Gauche
        tuileTourne[1][0] = this.coteTuile[4][1];
        tuileTourne[2][0] = this.coteTuile[4][2];
        tuileTourne[3][0] = this.coteTuile[4][3];

        this.setCoteTuile(tuileTourne);
    }

    public static void main(String[] args) {
        Tuile a = new Tuile();
        a.afficheTuile();
        System.out.println("----------");
        a.tournerTuileDroite();
        a.afficheTuile();
        System.out.println("----------");
        a.tournerTuileDroite();
        a.afficheTuile();
    }


}
