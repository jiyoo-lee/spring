package test3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class select3 {
	
	@RequestMapping("/select3.do")
	public String lombok (Model m) {
		
		lombok_dao ld = new lombok_dao();
		ld.setUserAge("52");
		
		return "view/select3";
	}
}
