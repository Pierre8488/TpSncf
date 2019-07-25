package domain;

import java.util.Date;

public class Train {
	private long id;
	private long gareDepartId;
	private Date dateDepart;
	private String numTrain;
	private int nbPlaces;
	private String type;

	public Train(long gareDepartId, Date dateDepart, String numTrain, int nbPlaces, String type) {
		super();
		this.gareDepartId = gareDepartId;
		this.dateDepart = dateDepart;
		this.numTrain = numTrain;
		this.nbPlaces = nbPlaces;
		this.type = type;
	}

	public Train(long id, long gareDepartId, Date dateDepart, String numTrain, int nbPlaces, String type) {
		super();
		this.id = id;
		this.gareDepartId = gareDepartId;
		this.dateDepart = dateDepart;
		this.numTrain = numTrain;
		this.nbPlaces = nbPlaces;
		this.type = type;
	}

	public Train() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getGareDepartId() {
		return gareDepartId;
	}

	public void setGareDepartId(long gareDepartId) {
		this.gareDepartId = gareDepartId;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public String getNumTrain() {
		return numTrain;
	}

	public void setNumTrain(String numTrain) {
		this.numTrain = numTrain;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Train [id=" + id + ", gareDepartId=" + gareDepartId + ", dateDepart=" + dateDepart + ", numTrain="
				+ numTrain + ", nbPlaces=" + nbPlaces + ", type=" + type + "]";
	}

}
