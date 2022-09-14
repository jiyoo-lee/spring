package aop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;

//각종 Query class
@Controller
public class AopQuery {
	
	@Autowired
	BasicDataSource dataSource;
	Connection con = null;
	PreparedStatement pstm = null;
	
	//회원가입
	public String insert() throws SQLException{

		return "";
	}
	
	
	public String delete()throws Exception{
		
		System.out.println("사용자 삭제");
		
		return "a";
	}

}
