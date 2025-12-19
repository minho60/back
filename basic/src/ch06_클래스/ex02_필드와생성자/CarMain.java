package ch06_클래스.ex02_필드와생성자;

import javax.swing.plaf.synth.SynthOptionPaneUI;

/**
 * 08.필드 사용
 *  - 클래스로부터 객체가 생성된 후에 필드를 사용할 수 있다.
 *  - 필드는 객체 내부의 생성자와 메서드 내부에서 사용할 수 있고,
 *    객체 외부에서도 접근해서 사용할 수 있다.
 *  -> 객체 내부에서는 단순히 필드명으로 읽고 변경할 수 있지만,
 *     외부 객체에서는 참조 변수와 도트(.) 연산자를 이용해서 필드를 읽고 변경해야 한다.
 *  -> 도트(.)는 객체 접근 연산자로 객체가 가지고 있는 필드나 메서드에 접근하고자 할 때
 *     참조 변수 뒤에 붙인다.
 *    		참조변수.필드
 *    	 	참조변수.메서드() 
 */
public class CarMain {

	public static void main(String[] args) {
		// new 연산자는 객체 생성 후 생성자를 호출해서 객체를 초기화한다.
		
		// 객체 생성
		// 클래스 타입 인스턴스 변수 = new 생성자();
		Car myCar = new Car();
		Car myCar2 = new Car("소나타","흰색",250);
		
		// 2. 객체의 필드값 읽기
		// - 객체 외부에서도 접근해서 사용
		// - 도트(.)는 객체 접근 연산자
		// - 참조변수.필드
		System.out.println("제작회사?:"+ myCar.company);
		System.out.println("현재모델?:"+ myCar.model);
		System.out.println("색깔?:"+ myCar.color);
		System.out.println("최고속도:"+ myCar.maxSpeed);
		System.out.println("현재속도:"+ myCar.speed);
		System.out.println();
		
		myCar2.speed = 60;
		System.out.println("제작회사?:"+ myCar2.company);
		System.out.println("현재모델?:"+ myCar2.model);
		System.out.println("색깔?:"+ myCar2.color);
		System.out.println("최고속도:"+ myCar2.maxSpeed);
		System.out.println("현재속도:"+ myCar2.speed);
	
	}

}
