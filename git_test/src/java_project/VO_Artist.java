package java_project;


public class VO_Artist {


	public VO_Artist(int goal, String start_d, String end_d, String funding_s, String funding_e) {
	
		this.goal = goal;
		this.start_d = start_d;
		this.end_d = end_d;
		this.funding_s = funding_s;
		this.funding_e = funding_e;
	}

	
	private int goal;
	private String start_d;
	private String end_d;
	private String funding_s;
	private String funding_e;


	public int getGoal() {
		return goal;
	}
	public void setGoal(int goal) {
		this.goal = goal;
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
	public String getFunding_s() {
		return funding_s;
	}
	public void setFunding_s(String funding_s) {
		this.funding_s = funding_s;
	}
	public String getFunding_e() {
		return funding_e;
	}
	public void setFunding_e(String funding_e) {
		this.funding_e = funding_e;
	}



}
