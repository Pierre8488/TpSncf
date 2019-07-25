package domain;

public class Gare {

	private long id;
	private String nom;
	private String ville;

	public Gare(String nom, String ville) {
		super();
		this.nom = nom;
		this.ville = ville;
	}

	public Gare() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Gare [id=" + id + ", nom=" + nom + ", ville=" + ville + "]";
	}

}
