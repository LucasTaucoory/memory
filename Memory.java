import java.util.*;

public class Memory {
  //attributs
  private Grille grille = new Grille(10);
  private int nbJoueurs;
  private ArrayList<Joueur> j;
  private IA ia;

  enum Mode{solo, multi, ia};
  private Mode mode;


  //constructeurs
  Memory(){
    this.grille = new Grille(10);
    this.nbJoueurs = 1;
    this.j=new ArrayList<Joueur>();
    this.ia=new IA();
    this.mode = Mode.solo;
  }

  Memory(int nbPaires, Mode mode, int nbJoueurs, int difficulteIA){
    this.grille = new Grille(nbPaires);
    this.mode = mode;
    this.nbJoueurs = nbJoueurs;
    this.j = new ArrayList<Joueur>();
    this.ia = new IA(difficulteIA);
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
    }while((c.getVisible()==true)||((x<1)||(x>lon))||((y<1)||(y>larg)));

    c = this.grille.getCarte(x,y);
    return c;
  }


  public Joueur jouerJoueur(Joueur joueur){
    System.out.println(joueur.getPseudo()+",  a toi de jouer !");
    Carte c1,c2;
    this.grille.afficherGrille();
    System.out.println("Choix de la première carte");
    c1 = choix_carte();

    do{
      System.out.println("Choix de la deuxième carte");
      c2 = choix_carte();
    }
    while(c1.equals(c2) == true);

    grille.getCarte(c1.getX(), c1.getY()).setVisible(true);
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

  public void jouerIA(){

  }

  public void initPartie(){
    Scanner sc = new Scanner(System.in);

    //choix du mode et initialisation
    System.out.println("Que voulez vous faire?");
    System.out.println("1 : joueur une partie solo");
    System.out.println("2 : joueur une partie à plusieurs");
    System.out.println("3 : joueur une partie contre l'ia");
    int m;
    do {
      m = sc.nextInt();
    } while ((m<1)||(m>3));

    switch(m){
      case 1: this.mode = Mode.solo; break;
      case 2: this.mode = Mode.multi; break;
      case 3: this.mode = Mode.ia; break;
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

      case ia:
      int difficulte;
      do {
        System.out.println("entrer la difficulté de l'ordi (entre 1 et 10)");
        difficulte = sc.nextInt();
      } while ((difficulte<1)&&(difficulte>10));
      this.ia = new IA(difficulte);
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
      if ((mode == Mode.solo)||(mode == Mode.multi)){
        for (Joueur joueur : j){
          if (nbPairesRetournee != this.grille.getNbPaires()){
            clearScreen();
            afficherScores();
            scoreJoueur = joueur.getScore();
            joueur = jouerJoueur(joueur);

            //met a jour le nombre de carte retournee
            nbPairesRetournee = nbPairesRetournee + joueur.getScore()-scoreJoueur;
            System.out.println(nbPairesRetournee);
          }
        }
      }


    }
  }


  public static void main(String[] args){
    Memory m = new Memory();
    //m.grille.afficherGrille();
    /*Carte c = m.choix_carte();

    System.out.println(m.grille.getCarte(1,1).getVisible());
    m.grille.getCarte(1,1).setVisible(true);
    System.out.println(m.grille.getCarte(1,1).getVisible());
    */
    /*int score = 0;
    for(int i=0;i<5;i++){
      score =m.jouerJoueur(score);
    }
    System.out.println(score);
    */

    m.partie();

    /*
    System.out.println(m.grille.getCarte(5,1).getX());
    System.out.println(m.grille.getCarte(5,1).getY());

    for(int i=1;i<m.grille.getLargeur()+1;i++){
      for(int j=1;j<m.grille.getLongueur()+1;j++){
        System.out.println(m.grille.getCarte(j,i).getX());
        System.out.println(m.grille.getCarte(j,i).getY());
      }
    }
    */
  }
}
