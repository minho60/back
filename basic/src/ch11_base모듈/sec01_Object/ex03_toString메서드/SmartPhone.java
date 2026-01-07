package ch11_base모듈.sec01_Object.ex03_toString메서드;

public class SmartPhone {
	private String company;
	private String os;

	public SmartPhone(String company, String os) {
		this.company = company;
		this.os = os;
	}

	/*
	 * object의 toString()
	 *  - 객체의 문자정보를 리턴한다.
	 *  - 객체의 문자 정보? 객체를 문자열로 표현한 값
	 *  -> '클래스명@16진수해시코드'로 구성된 문자열
	 */
	@Override
	public String toString() {
		return company + ", " + os;
	}
}