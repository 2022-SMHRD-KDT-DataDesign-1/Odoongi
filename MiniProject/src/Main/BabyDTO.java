package Main;

public class BabyDTO {

	private int tired = 0;
	private int hungry = 100;
	private int boring = 0;
	private int knowledge = 0;
	private int growth = 0;

	public int getGrowth() {
		return growth;
	}

	public void setGrowth(int growth) {
		this.growth = growth;
	}

	private String bName;

	public BabyDTO(String bName) {
		this.bName = bName;
	}

	public int getTired() {
		return tired;
	}

	public void setTired(int tired) {
		this.tired = tired;
	}

	public int getHungry() {
		return hungry;
	}

	public void setHungry(int hungry) {
		this.hungry = hungry;
	}

	public int getBoring() {
		return boring;
	}

	public void setBoring(int boring) {
		this.boring = boring;
	}

	public int getKnowledge() {
		return knowledge;
	}

	public void setKnowledge(int knowledge) {
		this.knowledge = knowledge;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

}
