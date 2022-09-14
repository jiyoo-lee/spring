package aop;
//log 관련 class 및 method에는 별도로 servlet 관련 정보 및 파라미터 값에 객체를 삽입하면
//aop 시작시 에러가 무조건 발생함

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//Log 기록 class

@Controller
public class AopInfo{
	
	String dbDriver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://umj7-009.cafe24.com/jeeyulee";
	String username = "jeeyulee";
	String password = "jeeyu9400";
	String uri ="";
	
	@Autowired
	BasicDataSource dataSource;
	Connection con = null;
	PreparedStatement pstm = null;
	
	//setter,getter가 없어서 오류가 나는거다~~^^(?)
	
	//강제 setter 역할
	public void aopInfo2(String uri) {
		this.uri = uri;
	}
	
	public void log_indata(){
		
		try {
			Class.forName(dbDriver);
			con = DriverManager.getConnection(url,username,password);
			String sql = "insert into logdata values('0',?)";
			this.pstm = con.prepareStatement(sql);
			aopInfo2(uri);
			this.pstm.setString(1, this.uri);
			System.out.println("로그실행");
			this.pstm.executeUpdate();
			System.out.println("log insert 성공");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
