package dto;

import java.io.Serializable;

public class HumanDto implements Serializable {

	private String name;
	private int age;
	
	public HumanDto() {
	}

	public HumanDto(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "HumanDto [name=" + name + ", age=" + age + "]";
	}
	
}
