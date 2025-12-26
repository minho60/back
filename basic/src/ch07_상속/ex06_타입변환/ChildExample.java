package ch07_상속.ex06_타입변환;

/**
 * 클래스 타입 변환
 * 1. 자동 타입 변환
 *  - 부모타입으로 자동타입 변환된 이후에는 부모 클래스에 선언된 필드와 메서드만 접근 가능하다.
 *  - 단, 자식 클래스에서 재정의 된 메서드는 자식메서드가 호출된다.
 *  
 *    부모타입 변수  = 자식타입객체
 * 
 * 2.강제 타입 변환
 *  - 자식객체가 부모 타입으로 자동 변환된 후 
 *    다시 자식 타입으로 변환 될 때 강제 타입변환을 사용 할 수 있다.
 *    
 *       자식타입 변수 = (자식타입) 부모타입객체;
 */
public class ChildExample {
	public static void main(String[] args) {
		//자식 객체 생성
		//Child child = new Child();

		//자동 타입 변환
		//Parent parent = child;
		
		// 객체 생성 및 자동 타입 변환
		Parent parent = new Child();
		
	

		//메소드 호출
		parent.field1 = "data1";
		parent.method1();
		parent.method2();
		//parent.method3(); (호출 불가능)
		//Child.method2();
		//Child.method3();
		
		// 강제타입 변환
		// 자식 타입 변수 = (자식타입) 부모타입 객체;
		Child child = (Child) parent;
		
		
		child.method2();
		child.method3();
		
		
		
		
	}
}