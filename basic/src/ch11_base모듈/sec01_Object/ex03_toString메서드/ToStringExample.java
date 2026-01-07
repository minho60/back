package ch11_base모듈.sec01_Object.ex03_toString메서드;

public class ToStringExample {
	public static void main(String[] args) {
		Object obj = new Object();
		System.out.println(obj.toString());
		// 전체 클래스 명@ 16진수 해시코드로 구성된 문자열을 리턴한다.
		// java.lang.Object@372f7a8d
		
		
		SmartPhone myPhone = new SmartPhone("삼성전자", "안드로이드");

		String strObj = myPhone.toString();
		System.out.println(strObj);
		// System.out.println() 메서드는
		// 매개값이 기본 타입(byte, short, int ...) 이거나 문자열일 경우 해당 값을 그대로 출력한다.
		// 그러나 매개값이 객체이면 객체의 toString() 메서드를 호출한다.
		// 따라서 매개값이 객체이면 toString() 메서드는 생략 가능
		System.out.println(myPhone);
	}
}