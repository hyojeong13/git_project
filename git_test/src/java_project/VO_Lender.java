package java_project;

public class VO_Lender {

	
	private String id;
	private String category;
	private String fav_id;
	private String address;
	private int goal;
	
	int djfis;
	
	public VO_Lender(String id, String category, String fav_id, String address, int goal) {
		super();
		this.id = id;
		this.category = category;
		this.fav_id = fav_id;
		this.address = address;
		this.goal = goal;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getFav_id() {
		return fav_id;
	}


	public void setFav_id(String fav_id) {
		this.fav_id = fav_id;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getGoal() {
		return goal;
	}


	public void setGoal(int goal) {
		this.goal = goal;
	}
	
	
	
	
}
