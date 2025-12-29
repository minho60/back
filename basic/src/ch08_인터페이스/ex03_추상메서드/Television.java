package ch08_인터페이스.ex03_추상메서드;

/**
 * 구현 클래스
 * 		
 * 		[접근제한자] class 클래스명 implements 인터페이스명{...} 
 */

// RemoteControl 인터페이스를 구현한 implements 클래스
public class Television implements RemoteControl {
	// 필드
	private int volume;

	// 메서드 재정의
	@Override
	public void turnOn() {
		System.out.println("Television를 킵니다.");
		
	}

	@Override
	public void turnOff() {
		System.out.println("Television를 끕니다.");
		
	}

	@Override
	public void setVolume(int volume) {
		if(volume> MAX_VOLUME) {
			this.volume = MAX_VOLUME;
		} else if(volume< MIN_VOLUME){
			this.volume = MIN_VOLUME;			
		}else{
			this.volume = volume;
		}
		System.out.println("현재볼륨은: "+ this.volume+"입니다.");
		
	}
	
	
	
}
