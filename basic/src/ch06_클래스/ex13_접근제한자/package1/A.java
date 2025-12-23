package ch06_클래스.ex13_접근제한자.package1;

/**
 * 27.접근 제한자
 * 					제한 대상					제한 범위
 * 	1. public		필드, 생성자, 메서드, 클래스	없음
 *  2. protected	필드, 생성자, 메서드			같은 패키지, 자식 객체
 * 	3. default		필드, 생성자, 메서드, 클래스	같은 패키지
 *  4. private		필드, 생성자, 메서드			객체 내부
 *  
 *  지정하지 않으면 default
 *  
 *  클래스 접근 제한
 *  	[public] class 클래스명 {...}
 *  생성자 접근 제한
 *  	[public|private] 생성자명(...) {...}
 *  필드 접근 제한
 *  	[public|private] 타입 필드;
 *  메서드 접근 제한
 *  	[public|private] 리턴타입 메서드(...) {...}
 */

// A 클래스는 default 접근 제한자(한정자)가 사용됨
class A {
	// default 필드선언
	A a1 = new A(true);
	A a2 = new A(1);
	A a3 = new A("문자열 A");
	
	// public 생성자
	 public A(boolean a){
		
	}
	// default 생성자
	A(int b){}
	
	
	// private 생성자
	private A(String s) {
		
	}
	
	public void method() {
		A a1 = new A(true);
		A a2 = new A(1);
		A a3 = new A("문자열 A");
		
		// 같은 패키지 public 클래스
		// public 생성자
		B b1 =  new B(false);
		// default 생성자
		B b2 =  new B(10);
		// private 생성자
		// B b3 =  new B("문자열"); 에러
		
		// field1는 public 필드
		b2.field1 = 10;
		// field2는 default 필드
		b2.field2 = 20;
		// field3는 private 필드
		// b2.field3 = 30; 에러
		
		// public 메서드
		b2.method1();
		// default 메서드
		b2.method2();
		// private 메서드
		// b2.method3(); 에러
		
		
	}
	
}
