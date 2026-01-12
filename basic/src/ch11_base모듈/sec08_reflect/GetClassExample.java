package ch11_base모듈.sec08_reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 리플랙션(Reflection)
 *  - 자바는 클래스와 인터페이스의 메타 정보를 Class 객체로 관리한다.
 *  - 메타 정보란? 패키지 정보, 타입 정보, 멤버(생성자, 필드, 메서드) 정보 등을 말한다.
 *  - 리플랙션? 메타 정보를 프로그램에서 읽고 수정하는 행위
 *
 * java.lang.Class
 *  - 프로그램에서 Class 객체 얻기
 * 	1. 클래스로부터 얻는 방법
 * 		Class clazz = 클래스이름.class;
 * 		Class clazz = Class.forName("패키지...클래스이름");
 * 	2. 객체로부터 얻는 방법
 * 		Class clazz = 객체참조변수.getClass();
 *
 * 	패키지와 타입 정보 얻기
 * 		- Package getPackage(): 패키지 정보 읽기
 * 		- String getSimpleName(): 패키지를 제외한 타입 이름
 *  	- String getName(): 패키지를 포함한 전체 타입 이름
 *
 */
public class GetClassExample {
	public static void main(String[] args) throws Exception {
		//how1
		Class clazz = Car.class;
		
		//how2
		//Class clazz = Class.forName("ch12.sec11.exam01.Car");
		
		//how3
		//Car car = new Car();
		//Class clazz = car.getClass();
		
		System.out.println("패키지: " + clazz.getPackage().getName());
		System.out.println("클래스 간단 이름: " + clazz.getSimpleName());
		System.out.println("클래스 전체 이름: " + clazz.getName());
		System.out.println("[생성자 정보]");
		
		/**
		 * java.lang.Class
		 * 메서드는 Class 클래스의 멤버이며, 
		 * 타입은 java.lang.reflect 패키지의 각 클래스에 해당한다.
		 * 
		 * 멤버 정보 얻기
		 * 	- Constructor[] getDeclaredConstructors(): 생성자 정보 읽기
		 *  - Field[] getDeclaredFields(): 필드 정보 읽기
		 *  - Method[] getDeclaredMethods(): 메서드 정보 읽기
		 *  
		 * java.lang.reflect.Constructor
		 *  - 클래스의 “생성자 자체”를 객체로 표현한 리플렉션 클래스
		 *  - c.getName();// 클래스명
		 *	- c.getParameterTypes();// 파라미터 타입
		 * 
		 * java.lang.reflect.Field
		 *  - 클래스의 “필드(멤버 변수) 하나”를 객체로 표현한 리플렉션 클래스
		 *  - f.getName();// 필드명
		 *	- f.getType();// 타입
		 *
		 * java.lang.reflect.Method
		 *  - 클래스의 “메서드 하나”를 객체로 표현한 리플렉션 클래스
		 *  - m.getName();// 메서드명
		 * 	- m.getParameterTypes();// 파라미터 타입
		 *	
		 */
		Constructor[] constructors = clazz.getDeclaredConstructors();
		for(Constructor constructor : constructors) {
			System.out.print(constructor.getName() + "(");
			Class[] parameters = constructor.getParameterTypes();
			printParameters(parameters);
			System.out.println(")");
		 	}
		System.out.println();
		
		System.out.println("[필드 정보]");
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields) {
			System.out.println(field.getType().getName() + " " + field.getName());
		}
		System.out.println();
		
		System.out.println("[메소드 정보]");
		Method[] methods = clazz.getDeclaredMethods();
		for(Method method : methods) {
			System.out.print(method.getName() + "(");
			Class[] parameters = method.getParameterTypes();
			printParameters(parameters);
			System.out.println(")");}
		}
		private static void printParameters(Class[] parameters) {
			for(int i=0; i<parameters.length; i++) {
				System.out.print(parameters[i].getName());
				if(i<(parameters.length-1)) {
					System.out.print(",");
				}
			}
		
	}
}