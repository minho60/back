package ch03_연산자;

/**
 * 산술연산자
 * 		+ 덧셈, 부호(양수), 문자열 결합
 * 		- 뺄셈, 부호(음수)
 * 		/ 나눗셈
 * 		% 나머지
 * 		++ 1씩 증가
 * 		-- 1씩 감소
 *  1. int 타입보다 작은 타입(byte, short, char)은
 *  	연산 시 int 타입으로 변환되어 연산
 *  2. 그 외는 연산에 사용된 가장 큰 타입으로 변환 되어 연산
 *	
 */
public class Ex01_산술연산자 {

	public static void main(String[] args) {
		System.out.println("부호연산---------------------------------");
		// 부호연산
		int x = -100;
		x = -x;
		
		byte  b = 100;
		// byte의 유효 범위: -128~127
		// 연산 시 int로 바뀐다. 
		byte y = (byte)-b;
		int y2= -b;
		
		System.out.println("x:"+ x);
		System.out.println("y:"+ y);
		System.out.println("y2:"+y2);
		System.out.println("부호연산---------------------------------");
		System.out.println();
		System.out.println("증감연산---------------------------------");
		// 재할당 가능, 재선언은 불가능
		 x = 10;
		int y3 = 10;
		int z;
		
		x++; // 후위 연산(postfix),11
		++x; // 전위 연산(prefix),12
		System.out.println("x=" + x);		

		
		y3--; // 후위연산,9
		--y3;// 전위연산,8
		System.out.println("y3=" + y3);		

		// z에 x를 먼저 대입하고, x를 1증가
		z = x++;
		System.out.println("z=" + z);
		System.out.println("x=" + x);
		
		//x 1증가 후, z에 할당
		z = ++x;
		System.out.println("z=" + z);
		System.out.println("x=" + x);
		
		
		// 1. x를 1증가 -> 15
		// 2. x와 y3을 더함 -> 15+8-> 23
		// 3. z에 할당 -> 23
		// 4. y3가 1증가
		  
		z = ++x + y3++;
		System.out.println("z=" + z);
		System.out.println("x=" + x);
		System.out.println("y3=" + y3);
		System.out.println("증감연산---------------------------------");
		System.out.println();
		System.out.println("산술 연산---------------------------------");
		byte v1 = 10;
		byte v2 = 4;
		int v3 = 5;
		long v4 = 10L;
		
		//byte, short, char 피연산자는 int 타입으로 자동 변환 후 연산
		int result1 = v1 + v2;			
		System.out.println("result1: " + result1);
		
		//모든 피연산자는 long 타입으로 자동 변환 후 연산
		long result2 = v1 + v2 - v4; 	
		System.out.println("result2: " + result2);
		
		//double 타입으로 강제 변환 후 연산
		double result3 = (double) v1 / v2;	
		System.out.println("result3: " + result3);
		
		int result4 = v1 % v2;
		System.out.println("result4: " + result4);
		System.out.println("산술 연산---------------------------------");
		
		
		System.out.println();
		System.out.println("오버플로우/ 언더플로우---------------------------------");
		// 오버플로우
		byte var1 = 125; // 128~127
		for(int i=0; i<5; i++) { //{ }를 5번 반복 실행
			//++ 연산은 var1의 값을 1 증가시킨다.
			var1++;  //126 127 128 129 130
			System.out.println("var1: " + var1);
		}

		System.out.println("-----------------------");
		// 언더플로우
		byte var2 = -125;
		for(int i=0; i<5; i++) { //{ }를 5번 반복 실행
			var2--; //-- 연산은 var2의 값을 1 감소시킨다.
			System.out.println("var2: " + var2);
		}
		// 오버플로우
		int a = 1000000; //+- 21억
		int b2 = 1000000;
		int c = a * b2; // 1,000,000,000,000
		System.out.println("c:"+c);
		
		//long 타입
		long a1 = 1000000;
		long b1 = 1000000;
		long c1 = a1*b1;
		System.out.println(c1);
		
		System.out.println("정확히 계산----------------------------");
		// 부동 소수점 방식을 사용하는 실수 타입에서는
		// 결과 값이 정확히 0.3이 되지 않는다.-> 정수 타입을 사용!
		int apple = 1;
		double pieceUnit = 0.1;
		int number = 7;
		
		double result = apple - number*pieceUnit;
		System.out.println("사과 1개에서 남은 양: " + result);
		
		System.out.println();
		
		int totalPieces = apple * 10;
		int result5 = totalPieces - number; 
		System.out.println("10조각에서 남은 조각: " + result5);
		System.out.println("사과 1개에서 남은 양: " + result5/10.0);
		
		System.out.println();
		System.out.println("Infinity&NaN-----------------------");
		int o = 5;
		double p = 0.0;
		double q = o / p;
		System.out.println(q); //Infinity
		System.out.println(q + 2);	//Infinity
		
		//double q = o % p;
		q = o % p;
		System.out.println(q); //NaN
		System.out.println(q + 2);	//NaN
		
		//잘못된 코드
		
		//알맞은 코드
		// Double.isInfinity(값)
		// -> 값이 Infinity이면 true, 아니면 false
		// Double.isNaN(값)
		// -> 값이 NaN이면 true, 아니면 false
		if(Double.isInfinite(q) || Double.isNaN(q)) { 
			System.out.println("값 산출 불가"); 
		} else { 
			System.out.println(q + 2); 
		}
	
	}

}
