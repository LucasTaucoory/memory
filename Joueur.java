public class Joueur{


	//Attributs
	private String nom;
	private String prenom;
	private int id;

	//constructeurs
	public Joueur() {
		this.nom = "";
		this.prenom = "";
    		this.id = 0;
	}

	public Joueur(String nom, String prenom, int id) {
		this.nom = nom;
		this.prenom = prenom;
    this.id = id;
	}

	//methodes
	public String getNom() {
		return this.nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

 	 public int getId() {
    		return this.id;
 	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

  	public void setId(int id) {
   		 this.id = id;
	}

    	public String toString() {
		return prenom + "\t" + nom;
	}

	public boolean equals(Object o) {
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}

		Joueur p = (Joueur) o;
		return p.getNom().equals(this.getNom()) && p.getPrenom().equals(this.getPrenom());
	}

}
