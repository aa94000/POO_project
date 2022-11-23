public class Table {

    Tuile [][] table;
    Joueur [] joueurs;
    int lon, larg;

    Table(int lon, int larg){
        this.lon = lon;
        this.larg = larg;
        this.table = generationTable(lon,larg);
    }

    Tuile [][] generationTable(int lon, int larg){
        return new Tuile [lon][larg];
    }

    public int getLarg() {
        return larg;
    }

    public int getLon() {
        return lon;
    }

    void afficherTableDetail(){
        for (int i = 0; i<this.table.length; i++){
            for (int y = 0; y<this.table[i].length; y++){
                if (this.table[i][y] == null) System.out.print(".");
                else {
                    this.table[i][y].afficheTuile();
                }
            }
            System.out.println("");
        }
    }

    void afficherTableResume(){
        for (int i = 0; i<this.table.length; i++){
            for (int y = 0; y<this.table[i].length; y++){
                if (this.table[i][y] == null) System.out.print(".");
                else {
                    System.out.print("#");
                }
            }
            System.out.println("");
        }
    }

    void ajouterTuile(Tuile tuile) {
        int longueur = 0, largeur = 0;

        if (this.lon % 2 == 0) longueur = this.lon / 2;
        else longueur = (this.lon/2);
        if (this.larg % 2 == 0) largeur = this.larg / 2;
        else largeur = (this.larg/2);

        this.table[longueur][largeur] = tuile;
    }

    public static void main(String[] args) {
       Tuile t = new Tuile();
       Table table = new Table(2,3);
       //table.afficherTable();
        table.ajouterTuile(t);
        table.afficherTableResume();
    }


}
