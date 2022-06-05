import java.util.*;

public class Memory {
  //attributs
  private Grille grille = new Grille(10);
  private int nbJoueurs;
  private ArrayList<Joueur> j;

  enum Mode{solo, multi};
  private Mode mode;


  //constructeurs
  Memory(){
    this.grille = new Grille(10);
    this.nbJoueurs = 1;
    this.j=new ArrayList<Joueur>();
    this.mode = Mode.solo;
  }

  Memory(int nbPaires, Mode mode, int nbJoueurs){
    this.grille = new Grille(nbPaires);
    this.mode = mode;
    this.nbJoueurs = nbJoueurs;
    this.j = new ArrayList<Joueur>();
  }

  //méthodes
  public void clearScreen(){
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  public void afficherScores(){
    System.out.println("Tableau des scores :");
    for (Joueur i : j){
      System.out.println(i.getPseudo()+" : "+i.getScore());
    }
    System.out.println();
  }

  public Carte choix_carte(){
    Scanner sc = new Scanner(System.in);
    int x,y;
    int lon = this.grille.getLongueur();
    int larg = this.grille.getLargeur();
    Carte c = new Carte();
    do {
      System.out.println("Entrer la position x (1 et "+ lon+ ") puis la position de y (1 et "+ larg+ ")");
      x= sc.nextInt();
      y= sc.nextInt();
      c = this.grille.getCarte(x,y);
    }while((c.getVisible()==true)||((x<1)||(x>lon))||((y<1)||(y>larg)));

    return c;
  }


  public Joueur jouerJoueur(Joueur joueur){
    System.out.println(joueur.getPseudo()+",  a toi de jouer !");
    Carte c1,c2;
    this.grille.afficherGrille();
    System.out.println("Choix de la première carte");
    c1 = choix_carte();

    grille.getCarte(c1.getX(), c1.getY()).setVisible(true);
    System.out.println();
    this.grille.afficherGrille();

    do{
      System.out.println("Choix de la deuxième carte");
      c2 = choix_carte();
    }
    while(c1.equals(c2) == true);


    grille.getCarte(c2.getX(), c2.getY()).setVisible(true);

    System.out.println();
    this.grille.afficherGrille();
    System.out.println("appuyer sur entree");
    Scanner sc = new Scanner(System.in);
    sc.nextLine();

    if (c1.getVal() != c2.getVal()) {
      grille.getCarte(c1.getX(), c1.getY()).setVisible(false);
      grille.getCarte(c2.getX(), c2.getY()).setVisible(false);
    }
    else joueur.setScore(joueur.getScore()+1);

    return joueur;
  }

  public void initPartie(){
    Scanner sc = new Scanner(System.in);

    //choix du mode et initialisation
    System.out.println("Que voulez vous faire?");
    System.out.println("1 : joueur une partie solo");
    System.out.println("2 : joueur une partie à plusieurs");
    int m;
    do {
      m = sc.nextInt();
    } while ((m<1)||(m>2));

    switch(m){
      case 1: this.mode = Mode.solo; break;
      case 2: this.mode = Mode.multi; break;
    }

    sc.nextLine();
    System.out.println("entrer le pseudo du joueur 1");
    String pseudo = sc.nextLine();
    j.add(new Joueur(pseudo, 1, 0));


    switch(mode){
      case solo:
      this.nbJoueurs =1;
      break;

      case multi:
      do {
        System.out.println("Combien de joueurs serez vous ? (max 10)");
        this.nbJoueurs = sc.nextInt();
      } while ((nbJoueurs<2)&&(nbJoueurs>10));

      sc.nextLine();
      for(int i=2; i<nbJoueurs+1;i++){
        System.out.println("entrer le pseudo du joueur "+i);
        pseudo = sc.nextLine();
        j.add(new Joueur(pseudo, i, 0));
      }
      break;
    }

    int nbPaires;
    do {
      System.out.println("entrer le nb de paires du plateau");
      nbPaires=sc.nextInt();
    } while ((nbPaires<1)&&(nbPaires>100));

    this.grille = new Grille(nbPaires);
  }



  public void partie(){
    clearScreen();
    initPartie();


    int nbPairesRetournee = 0;
    int scoreJoueur;
    while(nbPairesRetournee != this.grille.getNbPaires()){
        for (Joueur joueur : j){
          if (nbPairesRetournee != this.grille.getNbPaires()){
            clearScreen();
            afficherScores();
            scoreJoueur = joueur.getScore();
            joueur = jouerJoueur(joueur);

            //met a jour le nombre de carte retournee
            nbPairesRetournee = nbPairesRetournee + joueur.getScore()-scoreJoueur;
        }
      }
    }
    clearScreen();
    this.grille.afficherGrille();
    System.out.println();
    System.out.println("Bravo vous avez gagné !");
    System.out.println();
    afficherScores();
  }


  public static void main(String[] args){
    Memory m = new Memory();
    m.partie();
  }
}
