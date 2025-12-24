package ch07_상속.ex01_클래스상속;

public class SmartPhoneMain {
	public static void main(String[] args) {
		//객체생성
		SmartPhone myPhone= new SmartPhone("갤럭시","은색");
		
		//Phone 클래슬부터 상속 받은 필드 읽기
		System.out.println("모델"+myPhone.model);
		System.out.println("색상"+myPhone.color);
		
		// SmartPhone 클래스의 필드 읽기
		System.out.println("와이파이상태:"+myPhone.wifi);
		
		// 상속 받은 메서드 호출
		myPhone.bell();
		myPhone.sendVoice("여보세요");
		myPhone.receiveVoice("안녕하세요 저는 박금맹인데요");
		myPhone.sendVoice("아 네 반갑습니다.");
		myPhone.hangUp();
		// 객체자신의 메서드 호출
		myPhone.setWifi(true);
		myPhone.internet();
	}

}
