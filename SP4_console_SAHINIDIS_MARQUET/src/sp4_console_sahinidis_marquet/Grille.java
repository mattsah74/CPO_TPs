/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_sahinidis_marquet;

/**
 *
 * @author matth
 */
public class Grille {
    Cellule[][] CellulesJeu = new Cellule [6][7];
    public Grille(){
        for(int i=0; i<=6; i++ ){
            for (int j=0; j<=5; j++){
                CellulesJeu[j][i] = new Cellule();
            }
        }
    } 
    
    public boolean ajouterJetonDansColonne1(Jeton jet, int c){
        int a = 1 ;
        int b=6;
        while(CellulesJeu[b][c].jetonCourant==null && b>=0){
            int d = b;
            b= d - a;
        }
        CellulesJeu[b][c].affecterJeton(jet);
        return true;
//        if(CellulesJeu[0][c].jetonCourant==null){
//            for(int i=5; i>=0; i--){
//                if(CellulesJeu[i][c].jetonCourant==null){
//                    a = i; 
//                }
//            }
//            CellulesJeu[a][c].affecterJeton(jet);
//            return true;
//        }
//        else{
//            System.out.println("Cette colonne est pleine");
//            return false;
//        }
    }
    
    public boolean ajouterJetonDansColonne(Jeton newJeton, int colonne){
        int i = 5;
        boolean rep = false;
        while (i>=0 && CellulesJeu[i][colonne].jetonCourant==null){
           i--;
        }
        
        CellulesJeu[i+1][colonne].jetonCourant = newJeton;
        return rep;
    }

    public boolean etreRemplie1(){
        int a=0;
        for(int i=0; i<=6; i++ ){
            for (int j=0; j<=5; j++){
                if (CellulesJeu[j][i].jetonCourant==null){
                    a+=1;
                }
            }
        } 
        if (a==0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean etreRemplie(){
        boolean x = true;
        for (int i=0;i<6;i++){
            for (int j=0;j<7; j++){
                 if (CellulesJeu[i][j].jetonCourant==null){
                     x = false;
                }
            }
        }
        return x;
   }
    
    public void viderGrille(){
        for(int i=0; i<=6; i++ ){
            for (int j=0; j<=5; j++){
                CellulesJeu[j][i].jetonCourant = null;
            }
        }  
    }
    
    public void afficherGrilleSurConsole1(){
        for(int j=0; j<=5; j++){
            for (int i=0; i<=6; i++ ){
                System.out.print(CellulesJeu[j][i].jetonCourant.Couleur + " ");
            }
        }  System.out.println(" ");
    }
    
    public void afficherGrilleSurConsole(){
        for (int i=0; i<6;i++){  
            for (int j=0; j<7; j++){
                if (CellulesJeu[5-i][j].jetonCourant==null){
                    System.out.print("o ");
                }
                else if (CellulesJeu[5-i][j].jetonCourant.Couleur == "jaune"){
                    System.out.print("J ");
                }
                else if (CellulesJeu[5-i][j].jetonCourant.Couleur== "rouge"){
                    System.out.print("R ");
                }   
            }
            System.out.println("");  // saute une ligne quand la ligne est finie d'afficher
        }
    }
    
    public boolean celluleOccupee(int l, int c){
        if(CellulesJeu[l][c].jetonCourant== null){
            return true;
        }
        else{
            return false;
        }
    }
   
    public String lireCouleurDuJeton(int l, int c){
        if (CellulesJeu[l][c].jetonCourant== null){
            String couleur = "";
            Jeton jet;     
            jet = CellulesJeu[l][c].jetonCourant;
            couleur = jet.lireCouleur();
            return couleur;
        }
        else{
            return ("Il n'y a pas de jeton ici") ;
        }
    }
    
    public boolean colonneRemplie(int c){
        int a =0;
        for(int i=0; i<=5; i++){
                if(CellulesJeu[i][c].jetonCourant==null){
                    a += 1; 
                }
        }
        if(a==0){
            System.out.println("La colonne est remplie");
            return true;
        }
        else{
            return false;
        }
        
    }
    
    public boolean colonneRemplie1(int colonne){
        for (int i=0; i<6; i++){
            if (CellulesJeu[i][colonne].jetonCourant==null){
                System.out.println("La colonne est remplie");
                return false;
            }
        }
        return true;
    } // colonne remplie 1ere version a garder pour au cas ou

    public boolean etreGagnantePourJoueur(Joueur j1){
        boolean x = false; //initialise un valeur de retour false qui changera si la partie est gagnée
        String coul;
        coul = j1.couleur; 
        /*verification de gauche à droite*/
        int verif = 0; /*variable intermediaire */
        for(int c=0; c<=3; c++ ){  
            for (int l=0; l<=5; l++){
                for(int k=0; k<4; k++){
                    if(CellulesJeu[l][c+k].lireCouleurDuJeton()==coul){
                        verif +=1; // si la case suivante est de la meme couleur verif est iteré
                    }   
                }
                if(verif ==4){
                    x =  true;
                }
                verif = 0;
            }
        } 
        /*verification de haut en bas*/
        int verif2 =0;/*variable intermediaire */
        for(int c=0; c<=6; c++ ){  
            for (int l=0; l<=2; l++){
                for(int k=0; k<4; k++){
                    if(CellulesJeu[l+k][c].lireCouleurDuJeton()==coul){
                        verif2 +=1;
                    }   
                }
                if(verif2 ==4){
                    x =  true;
                }
                verif2 = 0;
            }
        }
        /*verification de la diagonale montante*/
        int verif3 = 0; /*variable intermediaire */
        for(int c=0; c<=3; c++ ){  
            for (int l=0; l<=2; l++){
                for(int k=0; k<4; k++){
                    if(CellulesJeu[l+k][c+k].lireCouleurDuJeton()==coul){
                        verif3 +=1; // si la case suivante est de la meme couleur verif est iteré
                    }   
                }
                if(verif3 ==4){
                    x =  true;
                }
                verif3 = 0;
            }
        } 
        /*verification de la diagonale descendante*/
        int verif4 = 0; /*variable intermediaire */
        for(int c=0; c<=3; c++ ){  
            for (int l=3; l<=5; l++){
                for(int k=0; k<4; k++){
                    if(CellulesJeu[l-k][c-k].lireCouleurDuJeton()==coul){
                        verif4 +=1; // si la case suivante est de la meme couleur verif est iteré
                    }   
                }
                if(verif4 ==4){
                    x =  true;
                }
                verif4 = 0;
            }
        }
    return x;
    }
    
    public boolean etreGagnantePourJoueur2(Joueur joueur){
        for (int i=0; i<6; i++){
            for (int j=0; j<7;j++){
                if (CellulesJeu[i][j].lireCouleurDuJeton()==joueur.couleur){
                    if (i<3){
                        for (int k=0; k<4; k++){
                            if (CellulesJeu[i+k][j].lireCouleurDuJeton()!=joueur.couleur)
                                break;
                            if (k==3){
                                return true;
                            }
                        }
                    }
                    if (j<4){
                        for (int k=0; k<4; k++){
                            if (CellulesJeu[i][j+k].lireCouleurDuJeton()!=joueur.couleur)
                                break;
                            if (k==3){
                                return true;
                            }
                        }
                    }
                    if (i<3 && j<4){
                        for (int k=0; k<4; k++){
                            if (CellulesJeu[i+k][j+k].lireCouleurDuJeton()!=joueur.couleur)
                                break;
                            if (k==3){
                                return true;
                            }
                        }
                    }
                    if (i<3 && j>2){
                        for (int k=0; k<4; k++){
                            if (CellulesJeu[i+k][j+k].lireCouleurDuJeton()!=joueur.couleur)
                                break;
                            if (k==3){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }//  1ere version a garder pour au cas ou

}

