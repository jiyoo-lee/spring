package test3;

public class login {

	private String usernm;		//외부 접근을 어렵기하기 위해서 private (캡슐화,은닉)
	private String useremail;
	
	public login() {
	
	}
	
	public login(String usernm, String useremail) {
		super();
		this.usernm = usernm;
		this.useremail = useremail;
	}

	public String getUsernm() {
		return usernm;
	}

	public void setUsernm(String usernm) {
		this.usernm = usernm;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	
	
	
	
}
