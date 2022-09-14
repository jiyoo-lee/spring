package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//bean3.xml 사용됨, scope 관련 설명
// 같은 xml에 있는 id를 사용하면 같은 주소값을 가진다.

@RestController
public class AOP5 {
	
	ApplicationContext ac = new ClassPathXmlApplicationContext("bean3.xml");
	
	@RequestMapping(value= "/aop5", produces="text/html; charset=UTF-8")
	public String aopTest() {
		
		//test1이라는 객체가 메모리에 등재
		AopClass5 ap1 = ac.getBean("test1",AopClass5.class);
		
		//test2라는 객체가 메모리에 등재
		AopClass5 ap2 = ac.getBean("test2",AopClass5.class);
		
		//test1이라는 객체를 메모리에서 로드
		AopClass5 ap3 = ac.getBean("test1",AopClass5.class);
		
		System.out.println(ap1);
		System.out.println(ap2);
		System.out.println(ap3);
		
		if(ap1 == ap3) {
			System.out.println("ap1과 ap3의 인스턴스 주소 값이 동일합니다.");
		}
		if(ap1 != ap2 ) {
			System.out.println("ap2는 새로운 주소 값입니다.");
		}
		else {
			System.out.println("ap1과 ap2에 있는 주소 값이 같습니다.");
		}
		
		return "결과는 console창을 확인하세요";
	}
}
