package aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AOP4_ {

	@RequestMapping(value="/aop.do",produces="text/html; charset=UTF-8")
	public String data(HttpServletResponse resp,HttpServletRequest req) {
		String message ="";

		ApplicationContext ac = new ClassPathXmlApplicationContext("bean2.xml");
		AopPerson aopClass = ac.getBean("person",AopPerson.class);
		AopClass4 aop4 = ac.getBean("aop4_",AopClass4.class);
		message = " 결과 : 아이디 : " + aopClass.getId() 
						+ " 나이 : "+ aopClass.getAge() 
						+ " 이름: " + aopClass.getName() 
						+ " 레벨: " + aop4.getListdata().get(aopClass.getLevel());
		System.out.println(message);						

		return message;
	}
}
