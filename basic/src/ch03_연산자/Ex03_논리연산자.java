package ch03_연산자;

/**
 * 논리연산자 
 * 		&& 논리곱(and) 	
 * 			- 모두 true이면 true, 아니면 false
 * 			- 앞의 피연산 결과가 false 이면 뒤의 피연산자를 평가하지 않음!
 * 			-> 단축 평가(short circuit)
 * 		|| 논리합(or) 	모두 false이면, false, 아니면 true
 * 		!  논리부정(not) 	true이면 false, false이면 true
 * 
 * 		& 논리곱(and)		모두 true이면 true, 아니면 false 
 * 		| 논리합(or)		모두 false이면 false, 아니면 true
 * 		^ 배타적 논리합(xor)서로 다르면 true, 같으면 false  
 * 
 * 
 */
public class Ex03_논리연산자 {

	public static void main(String[] args) {
		int charCode = 'A';
		//int charCode = 'a';
		//int charCode = '5';

		if( (65<=charCode) & (charCode<=90) ) {
			System.out.println("대문자이군요.");
		}
			
		if( (97<=charCode) && (charCode<=122) ) {
			System.out.println("소문자이군요.");
		}

		if( (48<=charCode) && (charCode<=57) ) {
			System.out.println("0~9 숫자이군요.");
		}
		
		//----------------------------------------------------------

		int value = 6;
		//int value = 7;
			
		if( (value%2==0) | (value%3==0) ) {
			System.out.println("2 또는 3의 배수이군요.");
		}

		boolean result = (value%2==0) || (value%3==0);
		if( !result ) {
			System.out.println("2 또는 3의 배수가 아니군요.");
		}

	}

}
