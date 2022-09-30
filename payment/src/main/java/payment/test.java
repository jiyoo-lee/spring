package payment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class test {
	
	@RequestMapping("/test")
	public String login(HttpServletRequest req,Model model) throws Exception {
		HttpSession session = req.getSession();
		String mid = "kim";
		String mname = "김유신";
		
		//해당 값을 session으로 등록
		session.setAttribute("mid", mid);
		session.setAttribute("mname", mname);
		
		return "test";
	}

}
