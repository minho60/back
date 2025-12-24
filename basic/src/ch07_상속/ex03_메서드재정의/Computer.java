package ch07_상속.ex03_메서드재정의;

/**
 * 메서드 재정의(Overriding)
 *  - 상속된 메서드를 자식 클래스에서 재정의하는 것
 *  - 재정의된 자식 메서드가 우선 적용된다.
 *
 * 메서드 재정의 규칙
 *  1. 부모 메서드의 선언부(리턴 타입, 메서드 이름, 매개변수)와 동일해야 한다.
 *  2. 접근 제한을 더 강하게 오버라이딩할 수 없다.(public -> private으로 변경 불가)
 *  3. 새로운 예외를 throws할 수 없다.
 *
 * 애노테이션(Annotation)
 *  - 자바 코드에 부가적인 정보를 제공하는 메타데이터(Metadata)
 * 	- 코드 실행에는 영향을 주지 않지만 검증, 자동 처리, 문서화 등에 활용
 * 	- @Override는 컴파일 단계에서 정확히 오버라이딩 되었는지 체크하고,
 *    문제가 있다면 컴파일 에러를 출력한다.
 *    
 * 메타데이터(Metadata)는 
 * -'데이터에 대한 데이터'로
 * 다른 데이터를 설명하고 구조화하는 정보입니다.    
 * 데이터를 쉽게 찾고 관리하며, 검색하고, 이해하도록 돕는 역할
 * 
 */

/**
 * 자식클래스: Computer
 * 부모클래스: Calculator
 */
public class Computer extends Calculator {
	// 메서드 오버라이딩
	// @애노테이션
	@Override
	public double areaCircle(double r) {
		System.out.println("Computer 객체의 areaCircle() 실행");
		return Math.PI * r * r;
	}
}