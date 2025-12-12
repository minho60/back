package ch02_데이터와변수;

public class Ex12_변수사용범위 {

	public static void main(String[] args) {
		// 변수? v1, v2
		// v1은 main 메서드 블록에서 선언
		int v1 = 15;
		if(v1>10) {
			// v2눈 if 제어문 블록내에서 선언
			int v2 = v1-10;
		}
	}

}
