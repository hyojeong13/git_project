package java_project;


public class VO_Review {

	public VO_Review(String ex_date, String ex_name, String ex_review) {
		
		this.ex_date = ex_date;
		this.ex_name = ex_name;
		this.ex_review = ex_review;
	}

	private String ex_date;
	private String ex_name;
	private String ex_review;

	public String getEx_date() {
		return ex_date;
	}
	public void setEx_date(String ex_date) {
		this.ex_date = ex_date;
	}
	public String getEx_name() {
		return ex_name;
	}
	public void setEx_name(String ex_name) {
		this.ex_name = ex_name;
	}
	public String getReview() {
		return ex_review;
	}
	public void setReview(String ex_review) {
		this.ex_review = ex_review;
	}




}
