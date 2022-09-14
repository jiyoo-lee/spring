package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Exercise {

	@GetMapping("/exercise")
	public String sendMesseage() {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("test.xml");
		ExerciseDTO exerciseDTO = ac.getBean("exercise",ExerciseDTO.class);
		exerciseDTO.setUser("d");
		exerciseDTO.setPoint(500);
		
		return exerciseDTO.getUser() + "," + exerciseDTO.getPoint();
	}
}
