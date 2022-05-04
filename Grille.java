import java.util.ArrayList;
import java.lang.Math;
public class Grille extends Carte{

  //attributs
  private int nbPaires;
  private int longueur;
  private int largeur ;
  private ArrayList<Carte> tab;

  //constructeurs
  Grille(){
    this.nbPaires = 0;
    this.longueur = 0;
    this.largeur = 0;
    this.tab = new ArrayList<Carte>();
  }

  Grille(int nbPaires){
    this.nbPaires = nbPaires;
    int nbCartes = nbPaires*2;
    int i = (int)Math.floor(Math.sqrt(nbCartes));

    while(i!=1 && (nbCartes%i)!=0){
      i--;
    }
    this.largeur = i;
    this.longueur = nbCartes/i;

    //creer un tableau temporaire avec toutes les valeurs possibles des cartes
    ArrayList tab_tmp = new ArrayList<Integer>();
    for(i=0;i<nbPaires;i++){
      for(int j=0;j<2;j++){
        tab_tmp.add(i);
      }
    }

    //repartit aléatoirement ces valeurs dans le tab de la grile
    this.tab = new ArrayList<Carte>();
    int c = nbCartes;
    for(i=0;i<nbCartes;i++){
      //genere un entier aleatoire entre 0 et nbCartes-1
      int a = (int)Math.floor(Math.random()*c);
      if(a==c) a--;
      Carte b = new Carte((int)tab_tmp.remove(a), false);
      this.tab.add(b);
      c--;
    }
  }


  //methodes
  public int getNbPaires(){
      return this.nbPaires;
  }

  public int getLongueur(){
    return this.longueur;
  }

  public int getLargeur(){
    return this.largeur;
  }


  public Carte getCarte(int x, int y){
    if ((0<x && x<this.longueur) && (0<y && y<this.largeur)){
      return tab.get(this.longueur*(y-1)+x-1);
    }
    else {
      return new Carte(-1, false);
    }
  }

  public Carte getCarte1D(int x){
    if (0<x && x<(this.nbPaires*2)){
        return tab.get(x);
    }
    else
      return new Carte(-1, false);
  }


  public void afficherGrille(){
    for(int j=1;j<this.largeur+1;j++){
      for(int i=1;i<this.longueur+1;i++){
        System.out.print(tab.get(this.longueur*(j-1)+i-1).getVal() + " ");
      }
      System.out.println();
    }
  }


  //test
  public static void main(String args[]){
    //variables a changer
    int nbPaires = 4;
    int x = 1;
    int y = 4;

    Grille a = new Grille(nbPaires);

    System.out.println("nbPaires = "+a.nbPaires);
    System.out.println("longueur = "+a.longueur);
    System.out.println("largeur = "+a.largeur);

    a.afficherGrille();
    System.out.println("la valeur en x= "+x+" et y= "+y+" est : " + a.getCarte(x,y).getVal());
    System.out.println("la valeur en x= "+x+" avec le tab en 1D est : " + a.getCarte1D(x).getVal());
  }
}
