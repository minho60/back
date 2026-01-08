package ch11_base모듈.sec05_Math;
/**
 * Math 클래스
 *  - 수학 계산에 사용할 수 있는 메서드를 제공한다.
 *  - 모두 정적(static) 메서드이므로 Math 클래스로 바로 사용 가능하다.
 *  
 *   	Math.abs(-5)		절대값	5
 *   	Math.ceil(5.3)		올림값	6.0
 *   	Math.ceil(-5.3)				-5.0
 *   	Math.floor(5.3)		버림값	5.0
 *   	Math.floor(-5.3)			-6.0
 *   	Math.max(5,9)		최댓값	9
 *   	Math.min(5.3, 2.5)	최솟값	2.5
 *   	Math.random()		난수값	0.0<=x<1.0
 *   	Math.round(5.3)		반올림값	5
 *   	Math.round(5.7)				6
 *   
 */
public class ex01_Math {
	public static void main(String[] args) {
		//큰 정수 또는 작은 정수 얻기
		double v1 = Math.ceil(5.3);
		double v2 = Math.floor(5.3);
		System.out.println("v1=" + v1);
		System.out.println("v2=" + v2);

		//큰값 또는 작은값 얻기
		long v3 = Math.max(3, 7);
		long v4 = Math.min(3, 7);
		System.out.println("v3=" + v3);
		System.out.println("v4=" + v4);

		//소수 이하 두 자리 얻기
		double value = 12.3456;
		double temp1 = value * 100;
		long temp2 = Math.round(temp1);
		double v5 = temp2 / 100.0;
		System.out.println("v5=" + v5);
	}
}