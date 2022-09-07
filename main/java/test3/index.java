package test3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class index implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		dbservice ds = new dbservice("hong", "a123456", "홍길동", "01023456789", "30");
		listdb ld = new listdb();
		String msg = ld.insert(ds);

		ModelAndView mv = new ModelAndView();
		mv.addObject("msg",msg);
		mv.setViewName("WEB-INF/view/index.jsp");
		return mv;
	}
}
