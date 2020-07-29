package java_project;

public class VO_funding {

	
	private int funding_num;
	private int sum_done;
	private int funding_s;
	
	
	public VO_funding(int funding_num, int sum_done, int funding_s) {
		super();
		this.funding_num = funding_num;
		this.sum_done = sum_done;
		this.funding_s = funding_s;
	}
	
	
	
	public int getFunding_num() {
		return funding_num;
	}
	public void setFunding_num(int funding_num) {
		this.funding_num = funding_num;
	}
	public int getSum_done() {
		return sum_done;
	}
	public void setSum_done(int sum_done) {
		this.sum_done = sum_done;
	}
	public int getFunding_s() {
		return funding_s;
	}
	public void setFunding_s(int funding_s) {
		this.funding_s = funding_s;
	}


	
	
	
	
	
}
