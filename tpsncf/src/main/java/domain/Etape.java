package domain;

public class Etape {

	private long id;
	private long gareId;
	private boolean terminus;
	private long trainId;
	private int ordre;

	public Etape(long gareId, boolean terminus, long trainId, int ordre) {
		super();
		this.gareId = gareId;
		this.terminus = terminus;
		this.trainId = trainId;
		this.ordre = ordre;
	}

	public Etape() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getGareId() {
		return gareId;
	}

	public void setGareId(long gareId) {
		this.gareId = gareId;
	}

	public boolean isTerminus() {
		return terminus;
	}

	public void setTerminus(boolean terminus) {
		this.terminus = terminus;
	}

	public long getTrainId() {
		return trainId;
	}

	public void setTrainId(long trainId) {
		this.trainId = trainId;
	}

	public int getOrdre() {
		return ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	@Override
	public String toString() {
		return "Etape [id=" + id + ", gareId=" + gareId + ", terminus=" + terminus + ", trainId=" + trainId + ", ordre="
				+ ordre + "]";
	}

}
