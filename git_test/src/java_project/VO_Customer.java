package java_project;


public class VO_Customer {

	private String id;
	private String category;
	private String fav_id;
	private int done;
	
	
	public VO_Customer(String id, String category, String fav_id, int done) {
		super();
		this.id = id;
		this.category = category;
		this.fav_id = fav_id;
		this.done = done;
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
	public int getDone() {
		return done;
	}
	public void setDone(int done) {
		this.done = done;
	}
	
	
}
