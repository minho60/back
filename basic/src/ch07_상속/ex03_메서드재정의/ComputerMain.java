package ch07_상속.ex03_메서드재정의;

public class ComputerMain {
	public static void main(String[] args) {
		int r = 10;

		Calculator calculator = new Calculator();
		System.out.println("원 면적: " + calculator.areaCircle(r));
		System.out.println();

		Computer computer = new Computer();
		System.out.println("원 면적: " + computer.areaCircle(r));
	}
}