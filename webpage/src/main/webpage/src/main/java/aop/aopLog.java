package aop;

public class aopLog {
	
	//AOP에서 before 및 after 사용시 발동되는 메서드
	public void logs () {
		System.out.println("로그 기록 처리 시작...loading...");
		System.out.println("*************");
		System.out.println("로그 기록 완료");
	}
}
