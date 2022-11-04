import java.util.Random;
import java.util.Scanner;

public class Tuiles {

    int [][] tuille;

    Tuiles(){
        this.tuille = constructionTuille();
    }

    static int [][] constructionTuille(){
        int [][] tab = new int[5][5];
        Random random = new Random();
        for (int i = 0; i<tab.length; i++){
            for (int y = 0; y<tab[i].length; y++){
                if (i == 0 || i == tab.length-1){
                    tab[i][1] = random.nextInt(9);
                    tab[i][2] = random.nextInt(9);
                    tab[i][3] = random.nextInt(9);
                }
                if (i>0 && i<tab.length-1){
                    tab[i][0] = random.nextInt(9);
                    tab[i][4] = random.nextInt(9);
                }
            }
        }
        return tab;
    }

    static void afficheTuile(int [][] tab){
        for (int i = 0; i<tab.length; i++){
            for (int y = 0; y<tab[i].length; y++){
                System.out.print(tab[i][y]);
            }
            System.out.println("");
        }
    }

     void afficheTuile(){
        for (int i = 0; i<this.tuille.length; i++){
            for (int y = 0; y<this.tuille[i].length; y++){
                System.out.print(this.tuille[i][y]);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int [][] tab = constructionTuille();
        afficheTuile(tab);
    }


}
