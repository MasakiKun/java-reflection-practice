package kr.ayukawa.reflect.test;

import kr.ayukawa.reflect.test.anno.ParentClass;
import kr.ayukawa.reflect.test.enums.Gender;

@ParentClass
public abstract class Person {
	private String name;
	private int age;
	private Gender gender;

	public void setName(String name) { this.name = name; }
	public String getName() { return this.name; }

	public void setAge(int age) { this.age = age; }
	public int getAge() { return this.age; }

	public void setGender(Gender gender) { this.gender = gender; }
	public Gender getGender() { return this.gender; }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Person [");
		sb.append("name=" + this.name + ", ");
		sb.append("age=" + this.age + ", ");
		sb.append("gender=" + this.gender);
		sb.append("]");

		return sb.toString();
	}

	public String toJson() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("name: \"" + this.name + "\", ");
		sb.append("age: " + this.age + ", ");
		sb.append("gender: \"" + this.gender + "\"");
		sb.append("}");

		return sb.toString();
	}

	protected Person() {}
	protected Person(String name, int age, Gender gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
}
