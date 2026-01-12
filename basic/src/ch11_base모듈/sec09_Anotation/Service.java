package ch11_base모듈.sec09_Anotation;
/**
 * @애노테이션명(이름="값", ...);
 *	- 기본값이 있으면 ()안의 값은 생략 가능
 */
public class Service {
	@PrintAnnotation
	public void method1() {
		System.out.println("실행 내용1");
	}
	
	@PrintAnnotation("*")
	public void method2() {
		System.out.println("실행 내용2");
	}
	
	@PrintAnnotation(value="#", number=20)
	public void method3() {
		System.out.println("실행 내용3");
	}
}