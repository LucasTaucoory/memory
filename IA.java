import java.util.ArrayList;

public class IA extends Joueur{

  //la difficulté est lié au nombre de cases que l'ordi peut garder en memoire
  //le nombre de cartes est inversement proportionnelle à la difficulté

  private int difficulte;
  private ArrayList<Carte> memoire;

  public IA(){
    super();
    this.difficulte = 0;
    this.memoire = new ArrayList<Carte>();
  }

  public IA(int difficulte){
    super();
    this.difficulte=difficulte;
    this.memoire = new ArrayList<Carte>();
  }

  public void setDifficulte(int diff){
    this.difficulte = diff;
  }

  public void setMemoire(ArrayList<Carte> mem){
    this.memoire = mem;
  }

  public int getdifficulte(){
    return this.difficulte;
  }

  public void addCarte(Carte c){
    if (2*difficulte <= memoire.size()){
      memoire.remove(0);
    }
    memoire.add(c);
  }


  public Carte autreCarte(Carte c){
    for (Carte i : memoire){
      if ((i.getVal() == c.getVal())
      &&((i.getX() != c.getX())||(i.getY()!=i.getX()))){
        return i;
      }
    }
    return new Carte();
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
