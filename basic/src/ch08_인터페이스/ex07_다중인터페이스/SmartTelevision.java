package ch08_인터페이스.ex07_다중인터페이스;

/**
 * 클래스의 다중 상속 없음
 * 
 * 다중 인터페이스는 존재
 *  - 둘 이상의 인터페이스를 가지고 구현할 수 있다.
 *  
 *    	[접근제한자] class 클래스명 implements 인터페이스1, 인터페이스2,...{...}
 */
public class SmartTelevision implements RemoteControl, Searchable {
	//turnOn() 추상 메소드 오버라이딩
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}
		
	//turnoff() 추상 메소드 오버라이딩
	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
	}
	
	//search() 추상 메소드 오버라이딩
	@Override
	public void search(String url) {
		System.out.println(url + "을 검색합니다.");
	}
}		