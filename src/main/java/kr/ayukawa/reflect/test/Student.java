package kr.ayukawa.reflect.test;

import kr.ayukawa.reflect.test.anno.ChildClass;
import kr.ayukawa.reflect.test.enums.Gender;

import java.io.Serializable;

@ChildClass
public class Student extends Person implements Serializable {
	private static long serialVersionUID = 1L;

	private int grade;
	private int semester;

	public void setGrade(int grade) { this.grade = grade; }
	public int getGrade() {  return this.grade; }

	public void setSemester(int semester) { this.semester = semester; }
	public int getSemester() { return this.semester; }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Student [");
		sb.append("name=" + this.getName() + ", ");
		sb.append("age=" + this.getAge() + ", ");
		sb.append("gender=" + this.getGender() + ", ");
		sb.append("grade=" + this.grade + ", ");
		sb.append("semester=" + this.semester);
		sb.append("]");

		return sb.toString();
	}

	@Override
	public String toJson() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("name: \"" + this.getName() + "\", ");
		sb.append("age: " + this.getAge() + ", ");
		sb.append("gender: \"" + this.getGender() + "\", ");
		sb.append("grade: " + this.grade + ", ");
		sb.append("semester: " + this.semester);
		sb.append("}");

		return sb.toString();
	}

	private String getHiddenMessage() {
		return "this is hidden message :-p";
	}

	private Student() { super(); }
	public Student(String name, int age, Gender gender, int grade, int semester) {
		super(name, age, gender);
		this.grade = grade;
		this.semester = semester;
	}

}
