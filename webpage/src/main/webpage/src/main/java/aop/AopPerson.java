package aop;

import lombok.Data;

@Data
public class AopPerson {
	
	private String name;
	private String id;
	private int age;
	private int level;
	
	public AopPerson() {
		
	}
	
	public AopPerson(String name, String id, int age, int level) {
		this.name = name;
		this.id = id;
		this.age = age;
		this.level = level;
	}
	
}
