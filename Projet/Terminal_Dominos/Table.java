public class Table {

    Tuile [][] table;
    Joueur [] joueurs;
    int lon, larg;

    Table(int lon, int larg){
        this.lon = lon;
        this.larg = larg;
        this.table = generationTable(lon,larg);
        this.ajouterTuileDebut(new Tuile());
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

    void ajouterTuileDebut(Tuile tuile) {
        int longueur = 0, largeur = 0;

        if (this.lon % 2 == 0) longueur = this.lon / 2;
        else longueur = (this.lon/2);
        if (this.larg % 2 == 0) largeur = this.larg / 2;
        else largeur = (this.larg/2);

        this.table[longueur][largeur] = tuile;
    }

    // Finir et afficher de maniere plus "belle"//-----
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

    void testeAffiche(){
        for (int i = 0; i<this.table.length; i++){
            for (int y = 0; y<this.table[i].length; y++){

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

    void ajouterUneTuile(Joueur j, int x, int y){
        if (j.joueurAUneTuileEnMain()){
            if (x < this.lon && x > -1 && y < this.larg && y > -1){
                if (this.table[x][y] == null){
                    if (j.tuileEnMain.tuileCompatible(this.table[x][y+1])){
                        this.table[x][y] = j.getTuileEnMain();
                        j.poserTuileSurTable();
                        System.out.println("Tuile ajouter avec succée !");
                    }else {
                        System.out.println("La tuile ");
                    }
                }else {
                    System.out.println("Une tuile est déja à cet endroit !");
                }
            }else {
                System.out.println("Vos coordonnée sont hors-jeu !");
            }
        }else {
            System.out.println("Le joueur n'a pas de tuile en main");
        }
    }

    /*boolean peuPoserTuileSurTable(Joueur j, int x, int y){
        if (this.ta)
        if (j.tuileEnMain.tuileCompatible())
    }*/

   // Nous permet de savoir si la tuile que le joueur à dans les mains est posable sur la table
    void indicationSiDominosJouableEtCoordonee(Joueur j){
       for (int i = 0; i<this.table.length; i++){
           for (int y = 0; y<this.table[i].length; y++){
               if (this.table[i][y] != null){
                   if (j.getTuileEnMain().tuileCompatible(this.table[i][y])){
                       System.out.println("Vous pouvez jouer en : ("+ i + " , " + y + ")");
                   }
               }
           }
       }
    }

    boolean indicationSiDominosJouableEtCoordoneeBool(Joueur j){
        for (int i = 0; i<this.table.length; i++){
            for (int y = 0; y<this.table[i].length; y++){
                if (this.table[i][y] != null){
                    if (j.getTuileEnMain().tuileCompatible(this.table[i][y])){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Joueur j = new Joueur("amar", false);
        j.piocherDansLeSac(new Sac());
        Tuile t = new Tuile();
        Table table = new Table(3,3);
        //table.ajouterUneTuile(j,0,0);
        table.afficherTableResume();
        table.indicationSiDominosJouableEtCoordonee(j);
        table.afficherTableDetail();
        j.afficherTuileEnMain();
        table.ajouterUneTuile(j,1,0);
        table.afficherTableResume();
        table.afficherTableDetail();
    }


}
