package test3;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

@Controller
public class api {
	
//	//HttpServletResponse resp : 외부서버에 대한 값을 전달
//	@RequestMapping("/check_page.do")
//	public void postck (Model model, @ModelAttribute check ck, HttpServletResponse resp) throws IOException {
//		String result = "cancel";
//		System.out.println(ck.getSecurity());
//		if(ck.getSecurity().intern() == "a123456") {
//			result = "ok";
//		}
//		//allAttribute : Map<String,Object> 사용시에 씀
//		model.addAttribute("result",result);
//		String url = "http://192.168.214:8080/test3/result.jsp?result="+result;
//		resp.sendRedirect(url);
//	}
	
	//@RequestParam : 받는 변수값을 다른 변수명으로 변환 할때 사용하게 됩니다.
	@RequestMapping("/dataload.do")
	public String da(Model m, @RequestParam("users") String users2) {
		String callsign = users2;
		String call = "";
		if(callsign.equals("hong")) {
			call = "ok";
		}
		else {
			call = "no";
		}
		m.addAttribute("call",call);
		return "view/result";
	}
	
	
	
}
