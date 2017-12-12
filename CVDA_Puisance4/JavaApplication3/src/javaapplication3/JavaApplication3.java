
package javaapplication3;
import java.util.*;

public class JavaApplication3 {
    static boolean joueur;
    static int jeton;
    static boolean gameisover;
    
    public static void main(String[] args) {
        // TODO code application logic here
        int tour = 0;
        int grille[][] = init();
        while (gameisover != true){
            int choix = choisir();
            boolean done = jouer(choix,grille);
            affiche(grille);
            if (done == true){                                                  // Ajoute un tour si un jeton a été ajouté
                tour ++;
            }
            if (tour >= 7){                                                     // On ne vérifie que si au moins 4 jetons sont en jeu pour le joueur 1 (tour 7)
                verification(tour, grille);
            }
        }
    }
    
    public static int[][] init(){
        int i,j;
        int[][] grille = new int[6][7];
        joueur = true;
        gameisover = false;
        for(i=0;i<grille.length;i++)
        {
            for(j=0;j<grille[i].length;j++)
            {
                grille[i][j]=0;
                
            }
        }
        affiche(grille);
        return grille;
    }
    
    private static void affiche(int grille[][]){
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
    
    public static int choisir(){
        int colonne = -1;                                                       //Vérifie que la colonne est dans le tableau
        while (colonne < 0 || colonne > 6 ){
            System.out.print("Quel colonne ? ");
            Scanner input = new Scanner(System.in);
            colonne = input.nextInt();
            colonne --;
        }
        return colonne;
    }
    
    public static boolean jouer(int colonne, int grille[][]){
        if (joueur == true){
            jeton = 1;
        } else {
            jeton = 2;
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
    
    private static void verification(int tour, int grille[][]){
        boolean v1,v2,v3,v4;
        v1 = verificationHorizontale(grille);
        v2 = verificationVerticale(grille);
        v3 = false;
        v4 = false;
        if (tour >= 10){
            v3 = verificationDiagonaleDroite(grille);                           // On ne verifie les diagonales que si au moins 10 jetons on été joués
            v4 = verificationDiagonaleGauche(grille);
        }
        if (v1 == true || v2 == true || v3 == true || v4 == true)
        {
            System.out.println("Joueur "+jeton+" a gagné !");
            gameisover = true;
        }
    }
    
    private static boolean verificationHorizontale(int grille[][]){
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
    
    private static boolean verificationVerticale(int grille[][]){
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
    
    private static boolean verificationDiagonaleDroite(int grille[][]){
        int ligne,colonne,diagonaleParcourues,caseParcourues;
        int somme = 0;
        
        int limiteCase = 4;                                                     //Première diagonale à vérifier comporte 4 cases
        int ligneDepart = 2;
        int colDepart = 0;
        
        for(diagonaleParcourues=0;diagonaleParcourues<6;diagonaleParcourues++){ 
            ligne = ligneDepart;
            colonne = colDepart;
            for (caseParcourues=0;caseParcourues<limiteCase;caseParcourues++){  
                if(grille[ligne][colonne] == jeton){    
                   somme ++; 
                } else {
                   somme = 0;
                }
                
                if(somme == 4){                                                 //Si 4 sont alignés fin de la partie
                   return true;
                }  
                colonne++;
                ligne++;
            }
            somme = 0;
            if(ligneDepart >0)
            {
                ligneDepart--;
                limiteCase++;
            } else if (colDepart == 0 && limiteCase == 6){
                colDepart++;
            } else if (colDepart >  0) {
                colDepart++;
                limiteCase--;
            }
        }
        return false;
    }
    
    private static boolean verificationDiagonaleGauche(int grille[][]){
        int ligne,colonne,diagonaleParcourues,caseParcourues;
        int somme = 0;
        
        int limiteCase = 4;                                                     //Première diagonale à vérifier comporte 4 cases
        int ligneDepart = 0;
        int colDepart = 3;
        
        for(diagonaleParcourues=0;diagonaleParcourues<6;diagonaleParcourues++){ 
            ligne = ligneDepart;
            colonne = colDepart;
            for (caseParcourues=0;caseParcourues<limiteCase;caseParcourues++){  
                if(grille[ligne][colonne] == jeton){    
                   somme ++; 
                } else {
                   somme = 0;
                }
                
                if(somme == 4){                                                 //Si 4 sont alignés fin de la partie
                   return true;
                }  
                colonne--;
                ligne++;
            }
            somme = 0;
            if(colDepart < 5)
            {
                colDepart++;
                limiteCase++;
            } else if (colDepart == 5){
                colDepart++;
            } else if (colDepart == 6) {
                ligneDepart++;
                limiteCase--;
            }
        }
        return false;
    }
}
