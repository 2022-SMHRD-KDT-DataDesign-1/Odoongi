package Main;

public class BabyDTO {

	private int tired = 0;
	private int hungry = 100;
	private int boring = 0;
	private int knowledge = 0;
	private int growth = 0;
	
	
	private String bName;
	private String id;
	private String pwd;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	
	public BabyDTO(int tired, int hungry, int boring, int knowledge) {
		super();
		this.tired = tired;
		this.hungry = hungry;
		this.boring = boring;
		this.knowledge = knowledge;
	}

	public BabyDTO(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}

	public int getGrowth() {
		return growth;
	}

	public void setGrowth(int growth) {
		this.growth = growth;
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
