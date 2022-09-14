package aop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Webpage 실행부분

@RestController
public class AopMapping {

	ApplicationContext ac = new ClassPathXmlApplicationContext("aop_log.xml");
	
	@Autowired
	BasicDataSource dataSource;
	Connection con = null;
	PreparedStatement pstm = null;
	
	@RequestMapping("/memberin")
	public String memberIn() throws SQLException {
		
		this.con = dataSource.getConnection();
		String mid = "jung";
		String pass = "a123456";
		//MD5로 해당 값을 암호화로 변경함
		String mpw = DigestUtils.md5DigestAsHex(pass.getBytes());	
		String usernm = "정경호";
		String mtel = "01012341234";
		String mage = "37";
		
		String sql = "insert into test3 values('0',?,?,?,?,?)";
		this.pstm = con.prepareStatement(sql);
		this.pstm.setString(1, mid);
		this.pstm.setString(2, mpw);
		this.pstm.setString(3, usernm);
		this.pstm.setString(4, mtel);
		this.pstm.setString(5, mage);
		
		int result = this.pstm.executeUpdate();
		String message = "";
		
		if(result > 0) {
			System.out.println("회원 가입 완료");
			message = "success";
		}else {
			System.out.println("데이터 통신 오류");
			message = "fail";
		}
		return message;
	}
	
	
	@RequestMapping("/memberdelete")
	public String memberDelete() {
		
		
		return "member Delete page";
	}
}
