package test3;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;	

@Controller
public class select4 {
	
	@Inject
//	private DataSource dataSource;
	private SqlSessionFactory sqlSessionFactory;
	
	Connection connection = null;
	PreparedStatement pr = null;
	
	@RequestMapping("/select4.do")
	public String homepage(Model model) {
		
		try {
			SqlSession session = sqlSessionFactory.openSession();
//			connection = dataSource.getConnection(); //기존
			System.out.println("DB접속 성공");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "view/select4";
	}
}
