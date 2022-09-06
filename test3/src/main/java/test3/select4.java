package test3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.annotation.Resource;
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
	private SqlSessionFactory sqlSessionFactory;
	
	@Resource(name = "Xmljava")
	private XmlJava xmljava;
	
	Connection connection = null;
	PreparedStatement pr = null;
	
	@RequestMapping("/select4.do")
	public String homepage(Model model) {
		
		try {
			SqlSession session = sqlSessionFactory.openSession();
			List<uservo> datas = xmljava.selectAll();
			System.out.println(datas.size()+"명 입니다.");
			
			uservo uv = xmljava.selectId("hong");
			System.out.println("사용자 이름" + uv.getUsernm());
			System.out.println("사용자 아아디" + uv.getMid());
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "view/select4";
	}
}
