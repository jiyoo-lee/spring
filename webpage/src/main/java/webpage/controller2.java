package webpage;

import org.json.simple.JSONObject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Rest :  배열이 각종 정보를 출력하는 아키텍쳐 형태로 구현하는 웹 서비스
@RestController
public class controller2 {
	
	// produces = "application/json; charset=utf-8" : return 값을 UTF-8로 변환하여 출력하라는 뜻
	@RequestMapping(value = "/controller2", produces = "application/json; charset=utf-8")
	public String confirm (Model model) {
		JSONObject jb = new JSONObject();
		jb.put("idx", 1);
		jb.put("name", "한산");
		jb.put("person", "이순신");
		jb.put("person2", "거북선");
		
		String json_parsing = jb.toJSONString();
		model.addAttribute("data",json_parsing);
		
		return json_parsing;
	}
}
