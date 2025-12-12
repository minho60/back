package ch02_데이터와변수;
/**
 * 타입 변환
 * 1. 자동 타입 변환
 * 	 - 값의 허용 범위가 작은 타입이 허용 범위 큰 타입으로 대입 될 때 발생한다.
 * 		예) char(2) -> int(4) -> long(8) -> flaot(4) -> double(8)
 * 		예) byte(1) -> short(2)-> int(4) -> long(8) -> flaot(4) -> double(8)
 * 	   -형식:
 * 			큰타입 변수 = 작은 타입 변수
 * 			예) char var1 ='A';
 * 			예) int var2 = var1;		 
 * 
 * 2. 강제 타입 변환
 * 		- 큰 허용 범위 타입을 작은 헝ㅅㅇ 범위 타입으로 쪼개어서 저장하는 것 
 * 		- 형식: 
 * 				작은 타입 변수 = (작은타입)변수
 * 
 * 3. 연산식에서 자동 타입 변환
 * 		- byte, short, char는 연산시 int로 변환
 * 		- int 보다 큰 경우 더 큰 타입으로 자동 변환됩니다.
 * 
 */
public class Ex10_타입변환 {

	public static void main(String[] args) {
		// 자동타입 변환
		
		//byte->int
		byte byteValue =10;
		int intValue = byteValue;
		System.out.println("intValue:"+intValue);
		
		//char->int
		char charValue ='가';
		intValue = charValue;
		System.out.println("'가'의 유니코드:"+intValue);
		
		//int->long
		intValue =50;
		long longValue = intValue;
		System.out.println("longValue:"+longValue);
		
		//long->float
		longValue = 50;
		float floatValue = longValue;
		System.out.println("floatValue:"+floatValue);
		
		//float->double
		floatValue =100.5f;
		double doubleValue = floatValue;
		System.out.println("doubleValue:"+doubleValue);

		// 강제 타입 변환
		// int-> byte
		int var1 =10;
		// 타입 변수명=(타입)변수명;
		byte var2 = (byte) var1;
		System.out.println("var2:"+var2);

		//long->int
		long var3 =300;
		int var4 = (int) var3;
		System.out.println("var3:"+var3);
		
		// int-> char
		var1 =65;
		char var5 = (char) var1;
		System.out.println("var5:"+var5);
		
		//double-> int
		// 정수 부분만 출력
		double var6 =3.14;
		var1 = (int) var6;
		System.out.println("var1:"+var1);
		
		// 연산식에서 자동 타입 변환
		byte result1 = 10+20;
		System.out.println("result1:"+result1);
		
		// int 타입으로 변환 후 연산 그리고 할당된다.
		// byte+byte -> int
		byte v1 = 10;
		byte v2= 20;
		int result2 =  v1+v2;
		System.out.println("result2:"+ result2);
		
		byte v3 =10;
		int v4 =100;
		//long 타입은 리터럴 긑에 l이나 L 을 쓴다.
		long v5= 1000L;
		long result3= v3+v4+v5;
		System.out.println("result3:"+result3);
		
		//int 타입 보다 작은 타입의 연산은 int 타입으로 변환 되어 연산된다.
		char v6 ='A'; // int타입에서 'A' -> 65로 할당
		char v7='1'; // int 타입에서 '1' -> 49로 할당
		int result4 = v6+v7;
		System.out.println("result4:"+result4);
		
		// 정수 연산의 결과는 정수다.
		int v8 =10;
		int result5 = v8 / 4; //2
		System.out.println("result5:"+result5);
	
		// 연산 전에 double타입으로 변환 되어 연산된다.
		double result6 =  v8 / 4.0; //2.5
		System.out.println("result6:"+result6);
		
		int v10 =1;
		int v11=2;
		double result7= (double)v10 / v11; //0.5
		System.out.println("result7:"+result7);

	}

}
