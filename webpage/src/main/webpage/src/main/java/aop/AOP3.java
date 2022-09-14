package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AOP3 {
	
	@RequestMapping("/aop3")
	public void aop3Box() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		AopClass3 aop = ac.getBean("cc",AopClass3.class);
		
		System.out.println(aop.getName());
		System.out.println(aop.getAge());
		
	}
}
