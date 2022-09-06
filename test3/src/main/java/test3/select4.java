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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;	

@Controller
public class select4 {
	
	@Inject
	private SqlSessionFactory sqlSessionFactory;
	
	@Resource(name = "XmlJava")
	private XmlJava xmljava;
	
	Connection connection = null;
	PreparedStatement pr = null;
	
	
	@RequestMapping("/deleteuser")
	public String deleteInfo (Model model, String mid, String usernm, String mpw) {
		
		try {
			SqlSession session = sqlSessionFactory.openSession();
			System.out.println("접-성");
			
			String delete = xmljava.deleteInfo(mid,usernm,mpw);
			
			if(delete != "ok") {
				model.addAttribute("result", "delete denied");
			}
			else {
				model.addAttribute("result","delete success");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "view/delete2";
	}
	
	
	
	
	@RequestMapping("/member_update")
	public String updateInfo (Model model, String mid, String usernm, String mpw) {
		try {
			SqlSession session = sqlSessionFactory.openSession();
			System.out.println("DB 접속 성공");
			String update = xmljava.updateInfo(mid, usernm, mpw);
			
			if(update != "ok") {
				model.addAttribute("result", "update denied");
			}
			else {
				model.addAttribute("result", "update success");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "view/update2";
	}
	
	
	
	@RequestMapping("/select5.do")
	public String insertmb (Model model, String mid, String mname, String mpw, String mtel, String mage) {
		
		try {
			SqlSession session = sqlSessionFactory.openSession();
			System.out.println("db연결성공");
			String call = xmljava.userinsert(mid, mname, mpw, mtel, mage);
						
			if( call != "ok") {
				model.addAttribute("result", "insert denied");
			}
			else {
				model.addAttribute("result", "insert success");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "view/input";
	}
	

	
	@RequestMapping("/select4.do")
	public String homepage(Model model) {
		
		try {
			SqlSession session = sqlSessionFactory.openSession();
			System.out.println("db연결성공");
			List<uservo> datas = xmljava.selectall();
			
			System.out.println(datas.size()+"명 입니다.");
			
			List<uservo> test = xmljava.selectage(10);
			
			model.addAttribute("test",test);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "view/select4";
	}
}
