package kr.ayukawa.reflect;

import kr.ayukawa.reflect.test.Student;
import kr.ayukawa.reflect.test.enums.Gender;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class EntryPoint {
	public static void main(String[] args) throws Exception {
		// Student 클래스의 정보를 가져온다
		// Class claz = Student.class;
		Class claz = Class.forName("kr.ayukawa.reflect.test.Student");

		// 클래스의 구성요소 목록을 조회한다
		// 메서드 목록을 가져온다
		Method[] methods = claz.getMethods();
		System.out.println("*** methods");
		for(Method method : methods) {
			System.out.println(method);
		}
		System.out.println("\n");

		Method[] declareMethods = claz.getDeclaredMethods();
		System.out.println("*** declare methods");
		for(Method method : declareMethods) {
			System.out.println(method);
		}
		System.out.println("\n");

		// 필드 목록을 가져온다
		Field[] fields = claz.getFields();
		System.out.println("*** fields");
		for(Field field : fields) {
			System.out.println(field);
		}
		System.out.println("\n");

		Field[] declareFields = claz.getDeclaredFields();
		System.out.println("*** declare fields");
		for(Field field : declareFields) {
			System.out.println(field);
		}
		System.out.println("\n");

		// 생성자 목록을 가져온다
		Constructor[] constructors = claz.getConstructors();
		System.out.println("*** constructors");
		for(Constructor constructor : constructors) {
			System.out.println(constructor);
		}
		System.out.println("\n");

		Constructor[] declareConstructors = claz.getDeclaredConstructors();
		System.out.println("*** declare constructors");
		for(Constructor constructor : declareConstructors) {
			System.out.println(constructor);
		}
		System.out.println("\n");

		// 구현한 인터페이스 목록을 가져온다
		Class[] interfaces = claz.getInterfaces();
		System.out.println("*** implementation interfaces");
		for(Class intfce : interfaces) {
			System.out.println(intfce);
		}
		System.out.println("\n");

		// 상속한 상위 클래스를 가져온다
		Class superClaz = claz.getSuperclass();
		System.out.println("*** inheritence super class");
		System.out.println(superClaz);

		////////////////////////////////////////////////////////
		// 일반적인 메서드를 실행한다
		try {
			Student student = new Student("Tom", 18, Gender.MALE, 1, 2);
			Method toJsonMethod = claz.getMethod("getGrade");
			Object retVal = toJsonMethod.invoke(student);
			String json = String.valueOf(retVal);
			System.out.println(json);
		} catch(Exception e) {
			e.printStackTrace();
		}

		// 접근자가 private인 메서드를 실행한다
		try {
			Student student = new Student("Anna", 18, Gender.FEMALE, 2, 2);
			Method getHiddenMsgMethod = claz.getDeclaredMethod("getHiddenMessage"); //claz.getMethod("getHiddenMessage");
			getHiddenMsgMethod.setAccessible(true);
			Object msg = getHiddenMsgMethod.invoke(student);
			String message = String.valueOf(msg);
			System.out.println(message);
		} catch(Exception e) {
			e.printStackTrace();
		}

		// 파라미터를 요구하는 메서드를 실행한다
		try {
			Student student = new Student("Alice", 18, Gender.FEMALE, 2, 2);
			Method setGradeMethod = claz.getDeclaredMethod("setGrade", int.class);
			setGradeMethod.invoke(student, 20);
			System.out.println(student);
		} catch(Exception e) {
			e.printStackTrace();
		}

		// 접근자가 private인 생성자를 실행해서 객체를 생성한다
		try {
			Constructor constructor = claz.getDeclaredConstructor();
			constructor.setAccessible(true);
			Student student = (Student)constructor.newInstance();
			System.out.println(student);
		} catch(Exception e) {
			e.printStackTrace();
		}

		// 필드의 데이터를 수정한다
		try {
			// 일단 예시로, 접근자가 private인 생성자를 실행해서 빈 객체를 생성한다
			Constructor constructor = claz.getDeclaredConstructor();
			constructor.setAccessible(true);
			Student student = (Student)constructor.newInstance();

			Field nameField = claz.getDeclaredField("grade");
			nameField.setAccessible(true);
			nameField.set(student, 10);

			System.out.println(student);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
