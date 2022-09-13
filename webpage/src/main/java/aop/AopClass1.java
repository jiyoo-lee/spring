package aop;

import org.aspectj.lang.annotation.Aspect;

@Aspect	//aop 기본 annotation
public class AopClass1 {

	public String test() {
		String data = "홍길동";
		return data;
	}
	
	public int testbox() {
		
		int data = 10;
		return data;
	}
}
