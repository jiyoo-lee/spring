package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AOP1 {
	
	@RequestMapping("/aop1")
	public String aop(Model m) {
		
		//ApplicationContext : Spring container -> 
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		AopClass1 z = (AopClass1)ac.getBean("aa");
		// getBean : bean tag 조회시 사용함
		// getBean(bean id명, class명)
		String zresult = z.test() + "," + z.testbox();
		
		m.addAttribute("result",zresult);
		return "aop1";
	}

}
