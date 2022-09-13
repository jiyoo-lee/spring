package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AOP2 {
	
	@RequestMapping("/aop2.do")
	public void aopbox() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		AopClass2 ac2 = ac.getBean("bb",AopClass2.class);
		
		//getter 메서드를 로드하여 결과값을 출력하는 부분
		System.out.println(ac2.getBox1());
		System.out.println(ac2.getBox2());
	}
}
