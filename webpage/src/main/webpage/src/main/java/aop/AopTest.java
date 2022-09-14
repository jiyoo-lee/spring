package aop;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AopTest {

	private String name;
	private String point;
	
	
	public String message(String name, String point) {
		
		this.name = name;
		this.point = point;
		
		String msg = this.name + "님의 포인트는" + this.point + "입니다.";
		
		return msg;
	}
}
