package dto;

import java.io.Serializable;
import java.util.Arrays;

public class ObjectDto implements Serializable {

	private String name;
	private int age;
	private String fluit[];
	
	public ObjectDto() {
	}

	public ObjectDto(String name, int age, String[] fluit) {
		super();
		this.name = name;
		this.age = age;
		this.fluit = fluit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String[] getFluit() {
		return fluit;
	}

	public void setFluit(String[] fluit) {
		this.fluit = fluit;
	}

	@Override
	public String toString() {
		return "ObjectDto [name=" + name + ", age=" + age + ", fluit=" + Arrays.toString(fluit) + "]";
	}
	
	
}
