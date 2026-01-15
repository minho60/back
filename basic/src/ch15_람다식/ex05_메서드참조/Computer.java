package ch15_람다식.ex05_메서드참조;

public class Computer {
	public static double staticMethod(double x, double y) {
		return x + y;
	}

	public double instanceMethod(double x, double y) {
		return x * y;
	}
}