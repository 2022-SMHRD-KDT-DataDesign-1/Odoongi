package Main;

public class BabyDTO {

	private int tired;
	private int hungry;
	private int boring;
	private int knowledge;
	private double growth;

	private int age;

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

	public BabyDTO(String bName, int age, String id, int growth) {
		this.bName = bName;
		this.age = age;
		this.id = id;
		this.growth = growth;
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

	public BabyDTO(String id, String pwd, String bName) {
		this.id = id;
		this.pwd = pwd;
		this.bName = bName;
	}

	public double getGrowth() {
		return growth;
	}

	public void setGrowth(double growth) {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// for hansong
}
