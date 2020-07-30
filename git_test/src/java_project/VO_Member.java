package java_project;

public class VO_Member {

	//�ʵ�
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String address;
	private String category;
	
	//������
	public VO_Member(String id, String pw, String name, String phone, String address, String category) {
		
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.category = category;
		
	}
	
	//�α��� �� ������
	public VO_Member(String id, String pw) {
		
		this.id = id;
		this.pw = pw;
		
		
	}
	
	
	//getter, setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
}
