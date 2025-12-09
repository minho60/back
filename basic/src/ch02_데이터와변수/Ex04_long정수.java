package ch02_데이터와변수;

/**
 * 단위:bit(비트) - byte(바이트) 데이터 용량: 1000byte = 1KB (킬로) 1000KB = 1MB (메가) 1000Mb =
 * 1GB (기가) 1000GB = 1TB (테라)
 * 
 * 
 * 정수의 타입
 *  1. byte 1byte = 8bit -> 2의 8승 -> 256가지 숫자-> -128~ +127 
 *  2. short 2byte = 16bit -> 2의 16승 -> 65536가지 숫자 -> -32768~32767 
 *  3. int 4byte = 32bit -> 2의 32승 -> 4,294,967,296 -> +-21억 
 *  4. long 8byte = 64bit -> 2의 64승 -> +-922경 
 *  5. char 2byte = 16bit -> 2의 16승 -> 65536가지 숫자 -> 0~65536(유니코드)
 */

// 다른이름으로 저장하면 Refactoring 안됨.
public class Ex04_long정수 {

	public static void main(String[] args) {
		
		// 찾기/바꾸기: ctrl+F
		// alt+shift+a -> 다중 커서 편집 상태에서 Shift+방향키로 다중커서 생성 후 수정
		long var1 = -128;
		long var2 = -30;
		long var3 = 0;
		long var4 = 30;


		// 출력
		// 선택한 영역 복제: ctrl+alt+위아래방향키
		// 실행 ctrl+F11
		System.out.println("var1:" + var1); 
		System.out.println("var2:" + var2);
		System.out.println("var3:" + var3);
		System.out.println("var4:" + var4); 


	}

}
