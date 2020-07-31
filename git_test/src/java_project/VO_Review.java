package java_project;


public class VO_Review {

	private String id;
	private String ex_date;
	private String ex_review;
	
	
	public VO_Review(String id, String ex_date, String ex_review) {
		super();
		this.id = id;
		this.ex_date = ex_date;
		this.ex_review = ex_review;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getEx_date() {
		return ex_date;
	}


	public void setEx_date(String ex_date) {
		this.ex_date = ex_date;
	}


	public String getEx_review() {
		return ex_review;
	}


	public void setEx_review(String ex_review) {
		this.ex_review = ex_review;
	}
	
	

}
