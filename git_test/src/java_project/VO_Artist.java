package java_project;


public class VO_Artist {


	private String id;
	private String name;
	private String category;
	private String title;
	private String start_d;
	private String end_d;
	
	
	
	
	public VO_Artist(String id, String name, String category, String title, String start_d, String end_d) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.title = title;
		this.start_d = start_d;
		this.end_d = end_d;
	}
	
	public VO_Artist(String id, String name, String title, String start_d, String end_d) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.start_d = start_d;
		this.end_d = end_d;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStart_d() {
		return start_d;
	}
	public void setStart_d(String start_d) {
		this.start_d = start_d;
	}
	public String getEnd_d() {
		return end_d;
	}
	public void setEnd_d(String end_d) {
		this.end_d = end_d;
	}


}
