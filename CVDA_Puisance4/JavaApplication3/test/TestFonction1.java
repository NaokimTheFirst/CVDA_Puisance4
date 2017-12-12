/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static javaapplication3.JavaApplication3.*;                              //Toutes les fonctions du script sont reconnues sans écrire *JavaApplication3*

/**
 *
 * @author Moi
 */
public class TestFonction1 {
    public TestFonction1() {
        
    }
 
    @Test
    public void test1(){
        //Inititialisation
        int[][] grille = new int[6][7];
        int colonne = 0;
        //Appel
        boolean resultat = jouer(colonne,grille);
        //Test si le jeton est bien ajouté
        assertEquals(resultat,true);
    }
    
    @Test
    public void test2(){
        //Inititialisation
        int[][] grille = {{1,0,0,0,0,0,0},{1,0,0,0,0,0,0},{1,0,0,0,0,0,0},{1,0,0,0,0,0,0},{1,0,0,0,0,0,0},{1,0,0,0,0,0,0}};
        
        int colonne = 0;
        //Appel
        boolean resultat = jouer(colonne,grille);
        //Test d'ajout d'un jeton si la colonne est pleine
        assertEquals(resultat,false);
    }
    
    @Test
    public void test3(){
        //Inititialisation
        int[][] grille = {{1,0,0,0,0,0,0},{1,0,0,0,0,0,0},{1,0,0,0,0,0,0},{1,0,0,0,0,0,0},{1,0,0,0,0,0,0},{1,0,0,0,0,0,0}};
        
        int colonne = 112;
        //Appel
        boolean resultat = jouer(colonne,grille);
        //Test d'une case en dehors du tableau
        assertEquals(resultat,false);
    }

}
