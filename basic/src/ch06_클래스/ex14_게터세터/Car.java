package ch06_클래스.ex14_게터세터;

import lombok.Getter;
import lombok.Setter;

/**
 * 28.Getter & Setter
 *  - 객체의 필드(데이터)를 외부에서 마음대로 읽고 변경할 경우 객체의 무결성(결점이 없는 성질)이 깨질 수 있다.
 *  -> 객체지향 프로그래밍에서는 외부 필드 접근을 막고(private),
 *  	메서드를 통해 필드에 접근하는 것을 선호한다.
 *  -> 메서드가 데이터를 검증해서 유효한 값만 필드에 저장할 수 있기 때문이다.
 *  -> 이러한 역할을 하는 메서드가 Setter이다.
 *  
 *  - 외부에서 객체의 필드를 읽을 때, 필드값이 객체 외부에서 사용하기에 부적절한 경우,
 *    메서드로 적절한 값으로 변환해서 리턴할 수 있다.
 *    -> 이러한 역할을 하는 메서드가 Getter이다.
 *   
 *   	[접근제한자] 반환타입 get필드명(){...}
 *   	[접근제한자] 반환타입 set필드명(){...}
 *   	[접근제한자] 반환타입 is필드명(){...}
 *   
 *  - 필드 타입이 boolean일 경우, Getter는 get으로 시작하지 않고 is로 시작하는 것이 관례이다.
 *  
 *  2. Getter/Setter 메서드 자동 생성
 *  	Source > Generate Getters and Setters...
 *  	단축키: alt+shift+s -> r
 *  
 *  3.롬복(Lombok) 라이브러리 - 외부 라이브러리
 *   - @애노테이션
 *   - @Getter
 *   - @Setter
 */

@Getter
@Setter
public class Car {
	// 필드
	private String company;
	private int speed;
	private boolean stop;
}
//	public int getSpeed() {
//		return speed;
//	}
//	public void setSpeed(int speed) {
//		this.speed = speed;
//	}
//	public boolean isStop() {
//		return stop;
//	}
//	public void setStop(boolean stop) {
//		this.stop = stop;
//	}
//	
	
	
//	// getter: 읽기 전용
//	public int getSpeed() {
//		return speed;
//	}
//	
//	public void setSpeed(int speed) {
//		// 무결성에 문제가 생길 수 있다.
//		if(speed<0) {
//			this.speed = 0;
//			return;
//		}else {
//			this.speed= speed;
//			
//		}
//	}
//
//	// getter - 반환값이 boolean 일 경우 
//	// 게터 메서드 이름은 is필드명으로 (관례)
//	public boolean isStop() {
//		return stop;
//	}
//	public void setStop(boolean stop) {
//		this.stop = stop;
//		if(stop==true) this.speed=0;
//	}
//}
