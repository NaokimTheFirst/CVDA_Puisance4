
package javaapplication3;
import java.util.*;

public class JavaApplication3 {
    static int[][] grille = new int[6][7];
    static boolean joueur;
    static boolean gameisover;
    
    public static void main(String[] args) {
        // TODO code application logic here
        init();
        while (gameisover != true){
            jouer();
            affiche();
            verification();
        }
    }
    
    public static void init(){
        int i,j;
        joueur = true;
        gameisover = false;
        for(i=0;i<grille.length;i++)
        {
            for(j=0;j<grille[i].length;j++)
            {
                grille[i][j]=0;
                
            }
        }
        affiche();
    }
    
    public static void affiche(){
        int i,j;
        System.out.println("\n1 2 3 4 5 6 7 \n");
        for(i=0;i<grille.length;i++)
        {
           
            for(j=0;j<grille[i].length;j++)
            {
                System.out.print(grille[i][j]+" ");
                
            }System.out.println("");
        }
        
        if (joueur == true){
            System.out.print("\nJoueur 1 : ");
        } else {
            System.out.print("\nJoueur 2 : ");
        }
    }
    
    public static void jouer(){
        int jeton;
        if (joueur == true){
            jeton=1;
        } else {
            jeton =2;
        }
        
        int colonne = -1;
        while (colonne < 0 || colonne > 6 ){
            System.out.print("Quel colonne ? ");
            Scanner input = new Scanner(System.in);
            colonne = input.nextInt();
            colonne --;
        }
        
        
        
        int i,j;
        outerloop:
        for(i=0;i<grille.length;i++)
        {
            for(j=0;j<grille[i].length;j++)
            {
                if(j==colonne){                         //Trouve la colonne
                    if(grille[i][j]== 0){               //Vérifie que la première case est vide
                        if((i+1)>grille.length-1) {       //Vérifie que la ligne suivante n'est pas dans le tableau
                            grille[i][j] = jeton;       //Met un jeton
                        } else {                   
                            if(grille[i+1][j]!= 0){     //Sinon vérifie que la case dessous est vide
                               grille[i][j] = jeton;
                            }
                        }
                    } else if (i==0){                               //Cas où la colonne est pleine
                        System.out.println("\nColonne pleine. Rejouez");
                        joueur = !joueur;
                        break outerloop;
                    }
                }    
            }
        }
        
        joueur = !joueur;
    }
    
    public static void verification(){
        int i,j;
        int somme=0;
       for(i=0;i<grille.length;i++)
        {
            for(j=0;j<grille[i].length;j++)
            {
                if(grille[i][j]!=0){    
                    somme ++; 
            }
        }                                                                 //Il faut vérifier toutes les cases
    }   
    }
}
