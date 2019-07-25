package domain;

public class CarteReduction {
	private String nom;
	private String descriptionAvantage;
	private int pourcentageReduction;
	
	public CarteReduction(String nom, String descriptionAvantage, int pourcentageReduction) {
		super();
		this.nom = nom;
		this.descriptionAvantage = descriptionAvantage;
		this.pourcentageReduction = pourcentageReduction;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescriptionAvantage() {
		return descriptionAvantage;
	}

	public void setDescriptionAvantage(String descriptionAvantage) {
		this.descriptionAvantage = descriptionAvantage;
	}

	public int getPourcentageReduction() {
		return pourcentageReduction;
	}

	public void setPourcentageReduction(int pourcentageReduction) {
		this.pourcentageReduction = pourcentageReduction;
	}


}
