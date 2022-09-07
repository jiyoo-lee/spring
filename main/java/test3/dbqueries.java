package test3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	Connection con = null;
	PreparedStatement pr = null;

	@RequestMapping("/select.do")
	public String db_select (Model model){
		
		try {
			//database load 		
				try {
					con = dataSource.getConnection();
					
					String sql = "select * from test3";
					pr = con.prepareStatement(sql);
					ResultSet rs = pr.executeQuery();
					//DAO를 사용하지않고 배열 형태로 생성 후 VIEW에서 JSTL로 출력
					//DI로 객체에 직접 주입시켜 구현하는 방식
					List<Map<String,Object>> list = new ArrayList<>();
					while(rs.next()) {
						//DB에 있는 필드값을 MAP으로 이관하는 형태
						Map<String, Object> mp = new HashMap<>();
						mp.put("midx", rs.getString("id"));
						mp.put("mid", rs.getString("mid"));
						mp.put("mpw", rs.getString("mpw"));
						mp.put("usernm", rs.getString("usernm"));
						mp.put("tel", rs.getString("mtel"));
						mp.put("age", rs.getString("mage"));
						list.add(mp); //모든 데이터를 반복하면 ArrayList로 생성
					}
					model.addAttribute("list",list); //VIEW로 전송
					}catch (Exception e) {
						e.printStackTrace();
					}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "view/select";
}


	
		
	@RequestMapping("/insert.do")
	public String db_insert (Model model) throws Exception {
	
		try {
			con = dataSource.getConnection();
			String sql = "insert into test3(mid,mpw,usernm,mtel,mage) values(?,?,?,?,?)";
			pr = con.prepareStatement(sql);
			pr.setString(1, "kim");
			pr.setString(2, "kim123");
			pr.setString(3, "김민지");
			pr.setString(4, "01012341111");
			pr.setString(5, "20");
		
			int n = pr.executeUpdate();
			
			String result = "error";
			if(n > 0) {
				result = "success";
			}
			model.addAttribute("result",result);
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "view/insert";
		}
	
	
	
//	@RequestMapping("/update.do")
//	public String db_update(Model model) throws Exception {
//		
//		con = dataSource.getConnection();
//		String sql = "update test3 set mage = ? where id = ? ";
//		pr = con.prepareStatement(sql);
//		pr.setString(1, "21");
//		pr.setString(2, "2");
//		
//		int n = pr.executeUpdate();
//		
//		String result = "error";
//		
//		if(n > 0) {
//			result = "success";
//		}
//		model.addAttribute("result",result);
//		
//		return "view/update";
//	}	
}

