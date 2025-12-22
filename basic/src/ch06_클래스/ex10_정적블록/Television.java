package ch06_클래스.ex10_정적블록;
/**
 * 22.정적 블록 
 *  - 복잡한 초기화 작업이 필요할 때
 *  - 정적 블록은 클래스가 메모리에 로딩될 때 자동으로 실행되며,
 *  - 클래스 내부에 여러 개 선언되어 있을 경우 선언된 순서대로 실행된다.
 *  
 *  	static { ... }
 */
public class Television {
	// 정적필드 선언
	static String company = "Mycompany";
	static String model = "LCD";
	static String info;
	
	// 정적블록
	static {
		info = company+"-"+model;
	}

}
