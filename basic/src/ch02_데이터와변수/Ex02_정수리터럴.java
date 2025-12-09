package ch02_데이터와변수;
/**
 * 단위:bit(비트) - byte(바이트)
 * 데이터 용량: 
 * 1000byte = 1KB (킬로)
 * 1000KB = 1MB (메가)
 * 1000Mb = 1GB (기가)
 * 1000GB = 1TB (테라)
 * 
 * 
 * 정수의 타입
 * 1. byte 	1byte = 8bit -> 2의 8승 -> 256가지 숫자-> -128~ +127
 * 2. short 2byte = 16bit -> 2의 16승 -> 65536가지 숫자 -> -32768~32767
 * 3. int 	4byte = 32bit -> 2의 32승 -> 4,294,967,296 -> +-21억
 * 4. long 	8byte = 64bit -> 2의 64승 -> +-922경
 * 5. char 	2byte = 16bit -> 2의 16승 -> 65536가지 숫자 -> 0~65536(유니코드)
 */
public class Ex02_정수리터럴 {

	public static void main(String[] args) {
		// 리터럴(Literal)
		// - 프로그램 코드에서 직접 값으로 표현된 데이터
		// - 변수에 저장되는 실제 값

		// 정수형
		int var1 = 0b1011; // 0b___, 2진수 1011 
		int var2 = 0206; // 0___, 8진수 206
		int var3 = 365; // 10진수
		int var4 = 0xB3; // 0x___, 16진수
		
		//출력
		// 선택한 영역 복제: ctrl+alt+위아래방향키
		// 실행  ctrl+F11
		System.out.println("var1:"+var1); //11
		System.out.println("var2:"+var2); //134
		System.out.println("var3:"+var3); //365
		System.out.println("var4:"+var4); //179
	
	}

}
