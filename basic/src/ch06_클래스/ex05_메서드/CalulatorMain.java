package ch06_클래스.ex05_메서드;

/**
 * 15.메서드 호출
 *  - 클래스로부터 객체가 생성된 후에 메서드는 생성자와 다른 메서드 내부에서 호출될 수 있고,
 *    객체 외부에서도 호출될 수 있다.
 *		메서드명(인자,...);
 *
 *  - 객체 내부에서는 메서드명으로 호출
 *  - 외부 객체에서는 참조변수와 도트(.) 연산자를 이용해서 호출
 *  - 메서드가 매개변수를 가지고 있을 때는 호출할 때 매개변수의 타입과 수에 맞게 매개값을 제공해야 한다.
 *  -> 매개변수에 일치(개수, 순서, 타입)하는 인자를 제공해야한다.
 *  - 메서드가 리턴값이 있을 경우 대입 연산자를 사용해서 리턴값을 변수에 저장할 수 있다.
 *  - 이때, 변수 타입은 메서드의 리턴 타입과 동일하거나 자동 타입 변환될 수 있어야 한다.
 *  	타입 변수 = 메서드(인자,...); 
 */
public class CalulatorMain {
	public static void main(String[] args) {
		Calculator myCalc = new Calculator();
		
		//참조변수.메서드()
		myCalc.powerOn();
		
		// 리턴 값이 있는 메서드 호출
		// add 메서드 호출 시 5와 6의 인자를 전달
		// 메서드릐 실행 결과를 리턴 받아 result에 대입
		int result = myCalc.add(5, 6);
		System.out.println("덧셈:"+ result); //11
		
		int x =10;
		int y= 4;
		double result2 =  myCalc.divide(x, y);
		System.out.println("나눗셈:"+ result2);
		
		double result3 = myCalc.areaRectangle(10);
		double result4 = myCalc.areaRectangle(10,20);
		System.out.println("정사각형의 넓이:"+result3);
		System.out.println("직사각형의 넓이:"+result4);
		
	}

}
