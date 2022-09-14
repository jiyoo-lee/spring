package webpage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//view와 controller 형태를 같이 사용하는 사항

@Controller
@ResponseBody
public class controller1 {
	
	// @RestController : 모든 controller가 api와 같이 바로 출력 값이 나오는 역할만 한다면 이걸 class위에 적어준다.
	// @ResponseBody : 바로 받아서 open 되도록 하는 어노테이션 (java에서 웹페이지로 결과 값을 바로 출력)
	@GetMapping("/controller")
	public String test1 () {
		
		return "ok";
	}
	@GetMapping("/controller_web")
	public String test2 () {
		
		return "ok~~";
	}
}
