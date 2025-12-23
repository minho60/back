package ch06_클래스.ex13_접근제한자.package2;

// 서로 다른 패키지는 import 필요
import ch06_클래스.ex13_접근제한자.package1.B;

public class C {
	// B 는 public 으로 접근가능
	// public 생성자
	B b1 =  new B(false);
	// default 생성자 - 같은 패키지에서만 사용 가능
	// B b2 =  new B(10);
	// private 생성자
	// B b3 =  new B("문자열"); 에러
	
	public void method() {
		
		// public 필드
		//b.field1 = 1;
		// default 필드
		// b.field2 =2; 에러
		// private 필드
		// b.field3 =3; 에러

		// public 메서드
		//b.method1();
		// default 메서드
		// b.method2(); 에러
		// private 메서드
		// b.method3(); 에러
	}
}
