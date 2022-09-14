package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*연습문제ㅋㅋㅋ5분안에 풀어야됨ㅋㅋㅋㅠㅠ
 * AOP 의존성 여부에 대한사항을 프로세서로 구현하시오
 * bean에서는 class만 로드를 해야하며 Controller에서 값이 이입 되어 출력되어야합니다.
 * 결과 출력은 다음과 같습니다.
 * 김옥자님의 포인트는 2500 입니다.
 * */

@RestController
public class AOP4 {
	
	@RequestMapping("/aop4")
	public void aoptest() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("test.xml");
		AopTest a = ac.getBean("test",AopTest.class);
		String result = a.message("김옥자","2500");
		
		System.out.println(result);
	}
}
