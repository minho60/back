package ch02_데이터와변수;
/**
 * 실수(부동소수점, floating point) 타입
 * 1. float		4byte -> 32bit -> 1.4×10의-45승 ~ 3.4×10의 38승 -> 7자리
 * 2. double	8byte -> 64bit -> 4.9×10-324승 ~ 1.8×10의 308승 -> 15자리
 * 
 * 형식: 부호(signed: +,-) +지수(exponent) + 가수(mantissa) 
 * 		1bit				8bit			23bit
 * 		1bit				11bit			52bit
 * 		0 -> +
 * 		1 -> -
 */
public class Ex06_실수 {
	

	//main 쓰고 ctrl+spacebar
	public static void main(String[] args) {
		// 정밀도 확인
		// float 리터럴은 끝에 f또는 F을 붙힌다.
		float var1 = 0.1234567890123456789f; // 소수점 이하 8자리
		double var2 = 0.1234567890123456789; // 소수점 이하 17자리
		
		//10의 거듭제곱 리터럴
		double var3 = 3e6; // e6는 10의 6승 
		float var4 = 3e6F;
		double var5 = 2e-3;
		
		System.out.println("var1:"+var1);
		System.out.println("var2:"+var2);
		System.out.println("var3:"+var3);
		System.out.println("var4:"+var4);
		System.out.println("var5:"+var5);
	}
}
