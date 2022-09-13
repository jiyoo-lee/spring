package aop;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AopClass2 {

	//bean.xml에서 name값과 동일
	private String box1; 
	private String box2; 
	
	//setter : bean.xml에 value값을 받아서 처리
}
