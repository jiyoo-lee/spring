package test3;

//DTO
public class dbservice {
	public String mid;
	public String mpw;
	public String usernm;
	public String tel;
	public String age;
	
	public dbservice() {
		super();
	}

	public dbservice(String mid, String mpw, String usernm, String tel, String age) {
		super();
		this.mid = mid;
		this.mpw = mpw;
		this.usernm = usernm;
		this.tel = tel;
		this.age = age;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpw() {
		return mpw;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

	public String getUsernm() {
		return usernm;
	}

	public void setUsernm(String usernm) {
		this.usernm = usernm;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
}
