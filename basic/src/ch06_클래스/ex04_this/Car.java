package ch06_클래스.ex04_this;

/**
 * 생성자 오버로딩(overloading)이 많은 경우
 * 중복된 코드가 발생 할 수 있다.
 * -> 공통코드를 가진 생성자를 작성하고,
 * 	  다른 생성자는 this(...)를 사용하여 공통 생성자를 호출한다.
 * 
 * 오버로딩? 이름은 같고, 매개변수의 개수, 타입, 순서가 다른 경우
 * 1. 생성자 오버로딩
 * 2. 메서드 오버로딩: 
 * 		예) System.out.println(int x)
 * 
 * 
 * 생성자
 * this - 클래스(객체) 자기자신
 * this() - 공통 코드를 가진 생성자 호출
 */
public class Car {
		String company = "현대자동차";
		String model = "그랜져";
		String color = "검정";
		int maxSpeed = 350;
		int speed;
		
		Car(String model) {
			this(model, "흰색", 250);
//			this.model = model;
		}

		Car(String model, String color) {
			this(model, color, 350);
			// this.model = model;
			// this.color = color;
		}

		Car(String model, String color, int maxSpeed) {
			this.model = model;
			this.color = color;
			this.maxSpeed = maxSpeed;
		}

		
 
		
		
}
