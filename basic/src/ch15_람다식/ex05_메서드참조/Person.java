package ch15_람다식.ex05_메서드참조;

public class Person {
	public void action(Calcuable calcuable) {
		double result = calcuable.calc(10, 4);
		System.out.println("결과: " + result);
	}
}