package test3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class getinfo {
	
	//RequestMapping url에 method를 연결 시켜주는 어노테이션
	@RequestMapping("/userinfo")
	//ModelAndView : 배열 키값이 있는 형태로 저장하는 방식
	//Model : 서버 메모리에 자료를 저장하는 방식 
	public String abc(Model model) {
		String user = "이순신";
		model.addAttribute("username",user);
		
		//admin이라는 디렉토리 안에 info2.jsp를 맵핑하라는 뜻
		return "admin/info2";
		//info : mapping.xml에 <view-resolvers>+경로를 적어주었기때문에 파일명만 작성하여 리턴한다.
	}
}

