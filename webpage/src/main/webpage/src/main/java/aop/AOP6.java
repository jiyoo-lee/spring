package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AOP6 {
	
	ApplicationContext ac = new ClassPathXmlApplicationContext("aop1.xml");
	
	@RequestMapping("/memberjoin")
	public void memberJoin() throws Exception{
		AopClass6 aop6 = ac.getBean("member",AopClass6.class);
		
		//처리 시간 계산
		long start = System.currentTimeMillis();	//메서드 지연시간을 확인 할때 사용하는 클래스
		Thread.sleep(3000);
		aop6.memberIn();
		long end = System.currentTimeMillis();
		long result = end - start;
		System.out.println(result);
		
		aop6.memberInfo();
		aop6.memberLogin();
		aop6.memberUpdate();
		aop6.memberDelete();
	}
}
