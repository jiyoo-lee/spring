package test3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class dbqueries {
	
	//DI : Dependency Injection -web.xml
	//IOC : 객체에 따른 의존성 메서드 호출 - bean과 연계
	@Autowired 
	BasicDataSource dataSource;
	
	@RequestMapping("/select.do")
	public String db_select (Model model){

		Connection con = null;
		PreparedStatement pr = null;
		try {
			con = dataSource.getConnection();
			String sql = "select count(*) count from test3";
			pr = con.prepareStatement(sql);
			ResultSet rs = pr.executeQuery(sql);
			System.out.println(pr);
			while(rs.next()) {
				model.addAttribute("data_row",rs.getString("count"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pr != null) {
					pr.close();
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(con != null) {
					con.close();
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "view/select";
	}
	
	@RequestMapping("/insert.do")
	public String db_insert (Model model) {
		
		return "view/insert";
	}
	
}
