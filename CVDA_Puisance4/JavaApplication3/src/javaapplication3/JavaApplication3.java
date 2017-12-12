
package javaapplication3;
import java.util.*;

public class JavaApplication3 {
    static int[][] grille = new int[6][7];
    static boolean joueur;
    static int jeton;
    static boolean gameisover;
    
    public static void main(String[] args) {
        // TODO code application logic here
        int tour = 0;
        init();
        while (gameisover != true){
            boolean done = jouer();
            affiche();
            if (done == true){                                                  // Ajoute un tour si un jeton a été ajouté
                tour ++;
            }
            if (tour >= 7){                                                     // On ne vérifie que si au moins 4 jetons sont en jeu pour le joueur 1 (tour 7)
                verification(tour);
            }
        }
    }
    
    private static void init(){
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
    
    private static void affiche(){
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
    
    private static boolean jouer(){
        if (joueur == true){
            jeton = 1;
        } else {
            jeton = 2;
        }
        
        int colonne = -1;                                                       //Vérifie que la colonne est dans le tableau
        while (colonne < 0 || colonne > 6 ){
            System.out.print("Quel colonne ? ");
            Scanner input = new Scanner(System.in);
            colonne = input.nextInt();
            colonne --;
        }
        
        int i,j;
        for(i=0;i<grille.length;i++)
        {
            for(j=0;j<grille[i].length;j++)
            {
                if(j==colonne){                                                 //Trouve la colonne
                    if(grille[i][j]== 0){                                       //Vérifie que la première case est vide
                        if((i+1)>grille.length-1) {                             //Vérifie que la ligne suivante n'est pas dans le tableau
                            grille[i][j] = jeton;                               //Met un jeton
                        } else {                   
                            if(grille[i+1][j]!= 0){                             //Sinon vérifie que la case dessous est vide
                               grille[i][j] = jeton;
                            }
                        }
                    } else if (i==0){                                           //Cas où la colonne est pleine
                        System.out.println("\nColonne pleine. Rejouez");
                        return false;
                    }
                }    
            }
        }
        joueur = !joueur;
        return true;
    }
    
    private static void verification(int tour){
        boolean v1,v2,v3,v4;
        v1 = verificationHorizontale();
        v2 = verificationVerticale();
        v3 = false;
        v4 = false;
        if (tour >= 10){
            v3 = verificationDiagonaleDroite();                                 // On ne verifie les diagonales que si au moins 10 jetons on été joués
        }
        if (v1 == true || v2 == true || v3 == true /*|| v4 == true*/)
        {
            System.out.println("Joueur "+jeton+" a gagné !");
            gameisover = true;
        }
    }
    
    private static boolean verificationHorizontale(){
       int i,j;
       int somme = 0;
        
       for(i=0;i<grille.length;i++)
        {
            for(j=0;j<grille[i].length;j++)
            {
                if(grille[i][j] == jeton){    
                    somme ++; 
                } else {
                    somme = 0;
                }
                
                if(somme == 4){
                    return true;
                }               
            } 
            somme = 0;                                                           //On remet la somme à 0 entre chaque ligne
        }
       return false;
    }
    
    private static boolean verificationVerticale(){
       int i,j;
       int somme = 0;
       for(j=0;j<grille[0].length;j++)                                          // grille[0].length = 7 colonne
        {
            for(i=0;i<grille.length;i++)                                        // grille.length = 6 lignes
            {
                if(grille[i][j] == jeton){    
                    somme ++; 
                } else {
                    somme = 0;
                }
                
                if(somme == 4){                                                 //Si 4 sont alignés fin de la partie
                    return true;
                }               
            }
            somme = 0 ;                                                         //On remet la somme à 0 entre chaque colonne
        }
       return false;
    }
    
    private static boolean verificationDiagonaleDroite(){
       int i,j;
       int somme = 0;
       /*
       for(i=;i<grille.length;i++)
        {
            for(j=0;j<grille[i].length;j++)
            {
                if(grille[i][j] == jeton){    
                    somme ++; 
                } else {
                    somme = 0;
                }
                
                if(somme == 4){
                    return true;
                }               
            } 
            somme = 0;                                                          
        }*/
       
       return false;
    }
}
