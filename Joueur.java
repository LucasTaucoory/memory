public class Joueur{


	//Attributs
	private String pseudo;
	private int id;
	private int score;

	//constructeurs
	public Joueur() {
		this.pseudo = "";
    this.id = 0;
		this.score = 0;
	}

	public Joueur(String pseudo, int id, int score) {
		this.pseudo = pseudo;
    this.id = id;
		this.score = score;
	}

	//methodes
	public String getPseudo() {
		return this.pseudo;
	}


 	 public int getId() {
    		return this.id;
 	}

	public int getScore(){
		return this.score;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


  	public void setId(int id) {
   		 this.id = id;
	}

	public void setScore(int score){
		this.score = score;
	}

	public boolean equals(Object o) {
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}

		Joueur p = (Joueur) o;
		return p.getPseudo().equals(this.getPseudo());
	}

}
