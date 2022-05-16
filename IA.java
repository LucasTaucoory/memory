import java.util.ArrayList;

public class IA{

  private int difficulte;
  private ArrayList<CarteIA> memoire;

  public IA(){
    this.difficulte = 0;
    this.memoire = new ArrayList<CarteIA>();
  }

  public IA(int difficulte,ArrayList<CarteIA> memoire){
    this.difficulte=difficulte;
    this.memoire = memoire;
  }

  public void setDifficulte(int diff){
    this.difficulte = diff;
  }

  public void setMemoire(ArrayList<CarteIA> mem){
    this.memoire = mem;
  }

  public int getdifficulte(){
    return this.difficulte;
  }

  public ArrayList<CarteIA> getMemoire(){
    return this.memoire;
  }

  public void enregistrement (CarteIA carte){
    int n=this.memoire.size();
    int p = 2*this.difficulte;
    for (int i=Math.max(0,n-p);i<n;i++){
      if (!memoire[i].equals(carte)){
        memoire.add(carte);
      }
    }

  }

//besoin de connaitre la position des cartes dans la grille
//memoire doit stocker Cartes + position
//l'IA retourne une carte sur la grille de manière aléatoire
// elle regarde dans sa mémoire si elle a cette carte dans sa mémoire
// Si oui, (et que ce n'est pas déjà celle retournée) elle retourne l'autre
// sinon elle enregistre la carte et sa position dans sa getMemoire
// avec une certaine probablilité
//on retourne alors la deuxième aléatoirement.
//on l'enregistre avec la probabilité
}
