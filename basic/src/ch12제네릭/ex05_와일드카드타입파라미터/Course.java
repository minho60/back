package ch12제네릭.ex05_와일드카드타입파라미터;
/**
 * 와일드카드 타입 파라미터
 *  - 제네릭 타입을 매개값이나 리턴 타입으로 사용할 때 타입 파라미터로 ?(와일드카드)를 사용할 수 있다.
 *  - ?는 범위에 있는 모든 타입으로 대체할 수 있다는 표시이다.
 *  
 *  	// 상한 제한 (T 또는 그 하위 타입만)
 *   	리턴타입 메서드명(타입<? extends T> 변수) {...}
 *   
 *      // 하한 제한 (T 또는 그 상위 타입만)
 *   	리턴타입 메서드명(타입<? super T> 변수) {...}
 *   
 *   	// 제한 없음
 *   	리턴타입 메서드명(타입<?> 변수) {...}
 *   
 */
public class Course {
	//모든 사람이면 등록 가능
	public static void registerCourse1(Applicant<?> applicant) {
		System.out.println(applicant.kind.getClass().getSimpleName() +
				"이(가) Course1을 등록함");
	}
	
	//학생만 등록 가능
	public static void registerCourse2(Applicant<? extends Student> applicant) {
		System.out.println(applicant.kind.getClass().getSimpleName() + 
				"이(가) Course2를 등록함");
	}
	
	//직장인 및 일반인만 등록 가능
	public static void registerCourse3(Applicant<? super Worker> applicant) {
		System.out.println(applicant.kind.getClass().getSimpleName() +
				"이(가) Course3을 등록함");
	}
}