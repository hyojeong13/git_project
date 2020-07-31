package java_project;

public class VO_Funding {

	
	private int funding_num;
	private String id;
	private int goal;
	private int sum_done;
	private String funding_s;
	private String address;
	
	public VO_Funding(int funding_num, String id, int goal, int sum_done, String funding_s, String address) {
		super();
		this.funding_num = funding_num;
		this.id = id;
		this.goal = goal;
		this.sum_done = sum_done;
		this.funding_s = funding_s;
		this.address = address;
	}

	
	public int getFunding_num() {
		return funding_num;
	}

	public void setFunding_num(int funding_num) {
		this.funding_num = funding_num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	public int getSum_done() {
		return sum_done;
	}

	public void setSum_done(int sum_done) {
		this.sum_done = sum_done;
	}

	public String getFunding_s() {
		return funding_s;
	}

	public void setFunding_s(String funding_s) {
		this.funding_s = funding_s;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	
	
}
