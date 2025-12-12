package ch03_연산자;

/**
 * 비교 연산자의 종류 
 * 		>
 * 		<
 *		>=
 *		<=
 *		==
 *		!=
 *		
 * 1.비교 연산의 결과는 boolean 타입(true,false)이다.
 * 2. -> 제어문에서 실행 흐름을 제어할 떄 주로 사용된다.
 *  
 */
public class Ex02_비교연산자 {

	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 10;
		boolean result1 = (num1 == num2);
		boolean result2 = (num1 != num2);
		boolean result3 = (num1 <= num2);
		System.out.println("result1: " + result1);
		System.out.println("result2: " + result2);
		System.out.println("result3: " + result3);
			
		char char1 = 'A';
		char char2 = 'B';
		boolean result4 = (char1 < char2); //65 < 66
		System.out.println("result4: " + result4);
			
		int num3 = 1;
		double num4 = 1.0;
		boolean result5 = (num3 == num4);
		System.out.println("result5: " + result5);

		float num5 = 0.1f;
		double num6 = 0.1;
		boolean result6 = (num5 == num6);
		boolean result7 = (num5 == (float)num6);
		boolean result10 = ((double)num5 == num6);
		System.out.println("result6: " + result6); //false
		System.out.println("result7: " + result7); //true
		System.out.println("result10: " + result10); //false

		String str1 = "자바";
		String str2 = "Java";
		String str3 = new String("Java");
		// ==은 참조(reference, 주소) 비교
		// 문자열1.equals(문자열2)는 내용비교
		// 문자열 비교는 언제나 equals() 사용해야함
		System.out.println(str2 == str3); //false
		boolean result8 = (str1.equals(str2));
		boolean result9 = (! str1.equals(str2));
		System.out.println("result8: " + result8);
		System.out.println("result9: " + result9);

	}

}
