package ch15_람다식.ex01_람다식이란;

@FunctionalInterface
public interface Calculable {
	//추상 메소드
	void calculate(int x, int y);
}