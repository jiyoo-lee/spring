package webpage;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testweb {
	
	@Inject
	private SqlSessionFactory sqlSessionFactory;

	@Resource(name = "dataRepo")
	private DataRepo repo;
	
	Connection con = null;
	PreparedStatement pr = null;
	
	@RequestMapping("/test.do")
	public String abc (Model model) {
		
		try {
			SqlSession session = sqlSessionFactory.openSession();
			System.out.println("접속 성공");
			
			dataDTO data = repo.selectNow();
			dataDTO datas = repo.selectOne("kim");
			
			model.addAttribute("datetime",data.getNow());
			model.addAttribute("name",datas.getMid());
			model.addAttribute("pw",datas.getMpw());
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("오류");
		}
		
		return "test";
	}
}
