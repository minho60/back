package ch03_연산자;

/**
 * 산술연산자
 * 		+ 덧셈, 부호(양수), 문자열 결합
 * 		- 뺄셈, 부호(음수)
 * 		/ 나눗셈
 * 		% 나머지
 * 		++ 1씩 증가
 * 		-- 1씩 감소
 *	
 */
public class Ex01_산술연산자 {

	public static void main(String[] args) {
		// 부호연산
		int x = -100;
		x = -x;
		
		byte  b = 100;
		// byte의 유효 범위: -127~127
		// 연산 시 int로 바뀐다. 
		byte y = (byte)-b;
		int y2= -b;
		
		System.out.println("x:"+ x);
		System.out.println("y:"+ y);
	}

}
